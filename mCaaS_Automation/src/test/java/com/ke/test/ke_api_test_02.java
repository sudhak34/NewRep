package com.ke.test;



import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.mcaas.genericlibraries.Xls_Reader;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class ke_api_test_02 {
	public static void main(String[] args) {
		Xls_Reader xl=new Xls_Reader("D:\\Sudhakar_Data\\Backup\\E\\F&S\\Fns_Automation\\KE_Latest_approach\\PKW_set_03_04.xlsx");
		 int rowCount = xl.getRowCount("Sheet1");
	       for(int j=1600;j<=3177;j++){
		try {
		       /*Xls_Reader xl=new Xls_Reader("D:\\Sudhakar_Data\\Backup\\E\\F&S\\Fns_Automation\\7K\\KE_api_data\\PKW_set_02.xlsx");
		       int rowCount = xl.getRowCount("Sheet1");
		       for(int j=502;j<=2487;j++){*/
		       String question = xl.getCellData("Sheet1", "Input query", j);
		      // String Knumber = xl.getCellData("Sheet1", "Expected_slide_heading", j);
		      // String Title_01 = xl.getCellData("Sheet1", "Title", j);
		       //String API = "https://api.us.apiconnect.ibmcloud.com/hmbmadminhappiestmindscom-prodcc/sb/api/v1.0/fedSearch?index=uat.compucom.sn.v1&type=Global Knowledge&queryType=issue&queryStr="+query+"&client_secret=yG1eB8dV8pX0mG6xD0iO2vV7uX0xN8aX4tD2vR1pI1uW4eF5uF&channel=Global External&wstate=published&Knumber&client_id=da6c04d5-6880-42c0-bf7a-778d3873925b";
		      // String API_01="http://169.46.44.140:8085/response?queryInput="+question+"&enterpriseUserID=be7a1574-9884-11e790f8-3ed4ee2a58e9";
		       String API="http://169.46.44.137:8080/response?queryInput="+question+"&enterpriseUserID=8cff659e-9c71-11e7-9069-3ed4ee2a58e9";
		      // String expected = xl.getCellData("Sheet1", "keyword", j);
		       //String encodeQuery = URIUtil.encodeQuery(API);
		       String encodeQuery=API;
		       //String encodeQuery = URIUtil.encodeQuery("http://169.46.96.206:8080/chatbots?type=damac&queryInput="+input+"&companyname=");
				Client client = Client.create();
		        WebResource webResource = client
				   .resource(encodeQuery);
		        
				/*WebResource webResource = client
						   .resource("http://mcaas-demo-cog-api.mybluemix.net/api/v1.0/queryFederator?chanel=chatbot&tenant=dcob_Banking&tenantUser=dcob&type=GeneralKnowledge&companyname=dcob_Banking&queryInput=What%20is%20internet-banking?");*/
				ClientResponse response = webResource.accept("application/json")
		                   .get(ClientResponse.class);
		       

				if (response.getStatus() != 200) {
				   throw new RuntimeException("Failed : HTTP error code : "
					+ response.getStatus());
				   
				}

				String output = response.getEntity(String.class);

				//System.out.println("Output from Server .... \n");
				Gson gson = new GsonBuilder().setPrettyPrinting().create();
				JsonParser jp = new JsonParser();
				JsonElement je = jp.parse(output);
				String prettyJsonString = gson.toJson(je);
				System.out.println(j);
				//System.out.println(prettyJsonString);
				//xl.setCellData("Sheet1", "Response", j, prettyJsonString);
				String s2 =prettyJsonString.substring(prettyJsonString.indexOf("report_title"));
				String s3 =prettyJsonString.substring(prettyJsonString.indexOf("SildeTitle"));
				System.out.println(s2);
				System.out.println("======================");
				System.out.println(s3);
				
				xl.setCellData("Sheet1", "Response_Title", j, s2);
				xl.setCellData("Sheet1", "Sub_heading_02", j, s3);
				
			 				
				/*if(prettyJsonString.contains(Knumber)){
					//xl.setCellData("Sheet1", "Result", j, "Pass");
					System.out.println("Pass");
				}
				else{
					//xl.setCellData("Sheet1", "Result", j, "Fail");
				System.out.println("Fail");
				}
				int i = 0;
				Pattern p = Pattern.compile("customerVisibility");
				Matcher m = p.matcher(prettyJsonString);
				while (m.find()) {
				    i++;
				    String recordcount = Integer.toString(i);
				    xl.setCellData("Sheet1", "Count", j, recordcount);
				}*/
				//System.out.println(i);
				
			  } 
		       
			
		 catch (StringIndexOutOfBoundsException e) {

			e.printStackTrace();

		  }
			catch (Exception e) {

				e.printStackTrace();

			  }
		finally{
			//System.out.println("Sanity testing is completed");
		}
			
	       }
	       
}
}
