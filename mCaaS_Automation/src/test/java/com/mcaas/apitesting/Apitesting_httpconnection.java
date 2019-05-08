package com.mcaas.apitesting;

import java.net.URL;
import java.util.regex.Matcher;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.mcaas.genericlibraries.Xls_Reader;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
public class Apitesting_httpconnection {
	public static void main(String[] args) {
		try {
			Xls_Reader xl=new Xls_Reader("D:\\Sudhakar_Data\\Backup\\E\\KIA\\KIA_Testing_25102017\\KIA_25102017.xlsx");
		    int rowCount = xl.getRowCount("Sheet1");
		    System.out.println(rowCount);
		    for(int i=691;i<=rowCount;i++){
		    	
			 	String input = xl.getCellData("Sheet1", "Question", i);
				String expected = xl.getCellData("Sheet1", "Expected", i);
				String expected_result = expected.replaceAll("\\s{2,}","");
				System.out.println(i+"----"+expected_result);
				 String API ="http://169.46.44.131:8080/kia_response?companyname=KIA&userId=2&emailId=ss@gmail.com&queryInput=What%20is%20wizely&convId=345";





					//URL obj = new URL(url);
	      // String encodeQuery = URIUtil.encodeQuery(API);
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

			System.out.println("Output from Server .... \n");
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			JsonParser jp = new JsonParser();
			JsonElement je = jp.parse(output);
			String prettyJsonString = gson.toJson(je);
			String actual = prettyJsonString.substring(response.toString().indexOf("Answer") + 16);
			//String actual_result = actual.replaceAll("\\s{2,}","");
			//System.out.println(j);
			//System.out.println(prettyJsonString);
			System.out.println(i+"----" +actual.replaceAll("\\s{2,}",""));
			xl.setCellData("Sheet1", "Actual", i, actual);
			// if(actual.contains(expected_result)){
				 if(actual.replaceAll("\\s{2,}","").replaceAll("\\s","").contains(expected_result.replaceAll("\\s{2,}","").replaceAll("\\s",""))){
					xl.setCellData("Sheet1", "Result", i, "Pass");
					System.out.println("Pass");
				}
				else{
					xl.setCellData("Sheet1", "Result", i, "Fail");
				System.out.println("Fail");
				}
			/*int i = 0;
			Pattern p = Pattern.compile("customerVisibility");
			Matcher m = p.matcher(prettyJsonString);
			while (m.find()) {
			    i++;
			    String recordcount = Integer.toString(i);
			    xl.setCellData("Sheet1", "Count", j, recordcount);
			}
			System.out.println(i);*/
			
		  } 
	       
		}
		catch (Exception e) {

			e.printStackTrace();

		  }
		finally{
			System.out.println("Sanity testing is completed");
		}
		
		}
}
