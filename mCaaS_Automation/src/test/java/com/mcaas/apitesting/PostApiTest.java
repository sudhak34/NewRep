package com.mcaas.apitesting;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

//import org.apache.commons.httpclient.util.HttpURLConnection;

import javax.net.ssl.HttpsURLConnection;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.mcaas.genericlibraries.Xls_Reader;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;



public class PostApiTest {
	private static final String USER_AGENT = "Mozilla/43.0.1";
	public static void main() throws Exception {
	//public static void main(String[] args) throws Exception {

		/*//HttpURLConnectionExample http = new HttpURLConnectionExample();
		HttpURLConnectionExample http= new HttpURLConnectionExample();
		//System.out.println("Testing 1 - Send Http GET request");
		//sendGet();

		System.out.println("\nTesting 2 - Send Http POST request");
		http.sendPost();*/

	//}

	// HTTP GET request
	/*private static void sendGet() throws Exception {

		Xls_Reader xl=new Xls_Reader("D:\\Sudhakar_Data\\Backup\\E\\KIA\\KIA_Testing_25102017\\KIA_25102017.xlsx");
	    int rowCount = xl.getRowCount("Sheet1");
	    System.out.println(rowCount);
	    for(int i=2;i<=rowCount;i++){
	    	
			 	String input = xl.getCellData("Sheet1", "Question", i);
				String expected = xl.getCellData("Sheet1", "Expected", i);
				String expected_result = expected.replaceAll("\\s{2,}","");
				System.out.println(i+"----"+expected_result);

		//String url = "https://api.us.apiconnect.ibmcloud.com/hmbmadminhappiestmindscom-demo/demo-kia/api/v1.0/common/validatequs";
         String url =" http://169.46.44.140:8082/kia_response?companyname=KIA&queryInput="+input+"&convId=354&emailId=ss@gmail.com&userId=2";
		URL obj = new URL(url);
		//HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		// optional default is GET
		con.setRequestMethod("GET");

		//add request header
		con.setRequestProperty("User-Agent", USER_AGENT);

		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		//print result
		System.out.println(response.toString());
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		JsonParser jp = new JsonParser();
		JsonElement je = jp.parse(response.toString());
		String prettyJsonString = gson.toJson(je);
		System.out.println(prettyJsonString);
		String actual = response.toString().substring(response.toString().indexOf("Answer") + 8);
		System.out.println(actual);
		xl.setCellData("Sheet1", "Actual", i, actual);
		// if(actual.contains(expected_result)){
			 if(actual.replaceAll("\\s","").contains(expected_result.replaceAll("\\s",""))){
				xl.setCellData("Sheet1", "Result", i, "Pass");
				System.out.println("Pass");
			}
			else{
				xl.setCellData("Sheet1", "Result", i, "Fail");
			System.out.println("Fail");
			}
		}
	}*/
	// HTTP POST request
	//public static void main() throws Exception {
		/*Xls_Reader xl=new Xls_Reader("D:\\Sudhakar_Data\\Backup\\E\\KIA\\KIA_Testing_17102017\\Latest\\KIA_latest.xlsx");
	    int rowCount = xl.getRowCount("Sheet1");
	    System.out.println(rowCount);*/
	    /*for(int i=501;i<=rowCount;i++){
	    	
			 	String input = xl.getCellData("Sheet1", "Question", i);
				String expected = xl.getCellData("Sheet1", "Expected", i);
				String expected_result = expected.replaceAll("\\s{2,}","");
				System.out.println(i+"----"+expected_result);*/

		//String url = "https://api.us.apiconnect.ibmcloud.com/hmbmadminhappiestmindscom-demo/demo-kia/api/v1.0/common/validatequs";
       String url ="https://forrester-uat-email-notification-api.mybluemix.net/api/v1.0/emailnotification";
		URL obj = new URL(url);
		HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

		//add reuqest header
		con.setRequestMethod("POST");
		con.setRequestProperty("User-Agent", "Mozilla/43.0.1");
		con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
		
//		con.setH
		
        con.setRequestProperty("Content-Type","application/json");
       // con.setRequestProperty("X-IBM-Client-Id","263be4cc-4a9b-4df7-979a-26821bee96f6");
//        con.setRequestProperty("Content-Type","application/json");
		//String urlParameters = "queryInput="+input+"&userid=2";
        String urlParameters="";
		// Send post request
		con.setDoOutput(true);
		DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		wr.write(urlParameters.getBytes());
		wr.flush();
		wr.close();
		
		con.setDoOutput(true);
		OutputStream os = con.getOutputStream();
		os.write(urlParameters.getBytes());
		os.flush();
		os.close();
		
		int responseCode  =0;
//		System.out.println(con);
try {

	responseCode= con.getResponseCode();
	
} catch (Exception e) {
	// TODO: handle exception
	System.out.println(e);
	System.out.println("\nSending 'POST' request to URL : " + url);
	System.out.println("Post parameters : " + urlParameters);
	System.out.println("Response Code : " + responseCode);
}
		

		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		//print result
		//System.out.println(response.toString());
		//String actual = response.toString().substring(response.toString().indexOf("answer") + 8);
		String actual = response.toString();
		System.out.println(actual);
		//xl.setCellData("Sheet1", "Actual", i, actual);
		// if(actual.contains(expected_result)){
			/* if(actual.replaceAll("\\s","").contains(expected_result.replaceAll("\\s",""))){
				xl.setCellData("Sheet1", "Result", i, "Pass");
				System.out.println("Pass");
			}
			else{
				xl.setCellData("Sheet1", "Result", i, "Fail");
			System.out.println("Fail");
			}*/
	   // }
	    
	}
}

