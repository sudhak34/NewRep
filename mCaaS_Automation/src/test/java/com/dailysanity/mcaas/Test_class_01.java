package com.dailysanity.mcaas;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.JSONException;
import org.json.JSONObject;

import com.google.common.collect.Maps;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.JsonElement;

public class Test_class_01 {
	 private static final int col = 0;
     
	 

		//to do json comparison
         public static boolean json_comparison(String hmJson,String clientJson) throws Exception{
	   
	 
    
      Gson gson = new Gson();
       
       JSONObject hmJSONObject = new JSONObject(hmJson); //creates json object
       hmJSONObject = hmJSONObject.getJSONObject("data"); //takes json object from data
       hmJSONObject=hmJSONObject.getJSONObject("content"); //takes json object from content
       hmJSONObject.remove("goLiveDate");
       hmJSONObject.remove("landingUrl");
       JsonElement hmJsonelement = gson.fromJson(hmJSONObject.toString(), JsonElement.class);
       JSONObject clientJSONObject = new JSONObject(clientJson);
       JsonElement clientJsonelement = gson.fromJson(clientJSONObject.toString(), JsonElement.class);

       Type mapType = new TypeToken<Map<JsonElement, Object>>(){}.getType();
         Map<JsonElement, Object> firstMap = gson.fromJson(hmJsonelement, mapType);
         Map<JsonElement, Object> secondMap = gson.fromJson(clientJsonelement, mapType);
         boolean flag=Maps.difference(firstMap, secondMap).areEqual();
         return flag;
}

//api call function
public static String GetResponse() throws IOException 
                         {
                                         try {
                                                         StringBuilder result = new StringBuilder();
                                                         HttpClient client = new DefaultHttpClient();
                                                         String url = "https://forrester-prod-reprints-api.mybluemix.net/api/v1.0/activereprints";
                                                         HttpGet request = new HttpGet(url);
                                                         HttpResponse response = client.execute(request);
                                                         int responseCode = response.getStatusLine().getStatusCode();
                                                         System.out.println("Response Code: " + responseCode);
                                                         if (responseCode == 200)
                                                         {
                                                                         BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
                                                                         String line = "";
                                                                         while ((line = reader.readLine()) != null) {
                                                                                         result.append(line);
                                                                                         // System.out.println(result.toString());
                                                                         }
                                                         }
                                                         return result.toString();
                                         } catch (IOException ex) {
                                                         System.out.println("IO Exception : " + ex.getMessage());
                                                         throw ex;
                                         }
                         }

public static String hmGetResponse(String userid,String assetkey) throws Exception 
{
            try{
       StringBuilder result=new StringBuilder();
       HttpClient client=new DefaultHttpClient();
       String url="https://forrester-prod-reprints-api.mybluemix.net/api/v1.0/broker";
       HttpGet request=new HttpGet(url);
       request.addHeader("tenantid","2");
       request.addHeader("userid", userid);
       request.addHeader("assetkey", assetkey);
       HttpResponse response=client.execute(request);
       int responseCode=response.getStatusLine().getStatusCode();
       System.out.println("HM Response Code: " + responseCode);
       
       if(responseCode==200)
              
       {
              BufferedReader reader=new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
              String line="";
              while((line=reader.readLine())!=null)
              {
                    result.append(line);
              }
       }
       return result.toString();
       
}
       catch(Exception ex)
{
       System.out.println("Exception "+ex.getMessage());
       throw ex;
}
}

//to get client json
public static String clientGetResponse(String assetkey) throws Exception
{
            try{
       StringBuilder result=new StringBuilder();
       HttpClient client=new DefaultHttpClient();
       String url="https://services.forrester.com/ForrREST/v2/reports/"+assetkey+"/full/json?encodedImage=true&appsource=reprint";
       HttpGet request=new HttpGet(url);
       request.addHeader("ForresterAuth","Ka+iDP+WsjQ=");
       HttpResponse response=client.execute(request);
       int responseCode=response.getStatusLine().getStatusCode();
       System.out.println("Client Response Code: " + responseCode);
              BufferedReader reader=new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
              String line="";
              while((line=reader.readLine())!=null)
              {
                    result.append(line);
              }
       return result.toString();
            }
            catch(Exception ex){
            System.out.println("Exception "+ex.getMessage());
    throw ex;
            }
}



public static boolean status_check(String json) throws JSONException{
       JSONObject json_obj=new JSONObject(json);
       int value=json_obj.optInt("code");
       if(value==200)
       {
              return true;
       }
       else{
          return false;
       }
}

public static boolean client_status_check(String json) throws JSONException{
    JSONObject json_obj=new JSONObject(json);
    String value=json_obj.optString("result");
    if(value=="true")
    {
           return true;
    }
    else{
    return false;
    }
    
}

public static boolean redirecturl_check(String json) throws JSONException{
       JSONObject json_obj=new JSONObject(json);
       if(json_obj.has("redirecturl")){
              return true;
       }
       else{
       return false;
       }
}

public static void setCellData(String sheet,int row_value, int column, String string) throws IOException {
	FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\configuration\\data1.xlsx");
	XSSFWorkbook wb=new XSSFWorkbook(fis);
	XSSFSheet sh=wb.getSheet(sheet);
	XSSFRow row=sh.createRow(row_value);
	XSSFCell cell5=row.createCell(col);
	cell5.setCellValue(string);
	FileOutputStream fos=new FileOutputStream(System.getProperty("user.dir")+"\\configuration\\data1.xlsx");
	wb.write(fos);
	fos.close();

}
}
