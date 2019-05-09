package com.api.testing;


import org.mortbay.util.URIUtil;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.mcaas.genericlibraries.Xls_Reader;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class api_testing_01 {
	public static void main(String[] args) {
		try {
		       Xls_Reader xl=new Xls_Reader("C:\\Users\\sudhakar.koduri\\Desktop\\Compucom_Sanity_Automation.xlsx");
		       int rowCount = xl.getRowCount("Sheet1");
		       for(int j=2;j<=rowCount;j++){
		    	   System.out.println(j);
		    	   System.out.println("");
		       String API = xl.getCellData("Sheet1","API", j);
		       String expected = xl.getCellData("Sheet1", "Keyword", j);
		       // Escape and encode a string regarded as the query component of an URI with the default protocol charset.scape and encode a string regarded as the query component of an URI with the default protocol charset.
		      // String encodeQuery = URIUtil.encodeQuery(API); 
		       String encodeQuery = API; 
		       //The Client class is the main configuration point for building a RESTful web service client. You use it to configure various client properties and features and indicate which resource providers to use.
		       Client client = Client.create();
		       //It means when a RESTful API is called, the server will transfer to the client a representation of the state of the requested resource. ... In fact, URL stands for Uniform Resource Locator. The operation you want the server to perform on that resource, in the form of an HTTP method, or verb
		        WebResource webResource = client.resource(encodeQuery);
		        
				/*WebResource webResource = client
						   .resource("https://api.us.apiconnect.ibmcloud.com/hmbmadminhappiestmindscom-prodccapi/sb/api/v1.0/fedSearch?index=uat.compucom.st.v1&type=all&queryType=issue&queryStr=Sempra Setting up Email on an Android phone&client_id=07283e44-87ea-4845-ae30-7b190ecfe155&client_secret=W4bR3sP7fX7kS6gV5gK8bK3tF8nF7wC5mR2jU8nA3bT1kB8aQ6&channel=&wstate");*/
				ClientResponse response = webResource.accept("application/json")
		                   .get(ClientResponse.class);
		       

				if (response.getStatus() != 200) {
				   throw new RuntimeException("Failed : HTTP error code : "
					+ response.getStatus());
				}
           //clientResponse.getEntity(String.class) returns JSON
				String output = response.getEntity(String.class);

				System.out.println("Output from Server .... \n");
				//Gson is a Java library that can be used to convert Java Objects into their JSON representation. It can also be used to convert a JSON string to an equivalent Java object. ... Gson can work with arbitrary Java objects including pre-existing objects that you do not have source-code of
				Gson gson = new GsonBuilder().setPrettyPrinting().create();
				JsonParser jp = new JsonParser();
				JsonElement je = jp.parse(output);
				String prettyJsonString = gson.toJson(je);
				//System.out.println(j);
				System.out.println(prettyJsonString);   
				xl.setCellData("Sheet1", "API_Response", j, prettyJsonString);
				if(prettyJsonString.contains(expected)){
					xl.setCellData("Sheet1", "Result", j, "Pass");
					System.out.println("Pass");
				}
				else{
					xl.setCellData("Sheet1", "Result", j, "Fail");
				System.out.println("Fail");
				}
			}
		}
			catch (Exception e) {

				e.printStackTrace();

			  }

	}
}
