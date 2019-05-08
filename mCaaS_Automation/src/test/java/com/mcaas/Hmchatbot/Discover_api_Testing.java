package com.mcaas.Hmchatbot;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.mcaas.genericlibraries.Xls_Reader;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class Discover_api_Testing {

	public static void main(String[] args) {
		try {
		       Xls_Reader xl=new Xls_Reader("D:\\Sudhakar_Data\\Backup\\E\\Discover\\Testing\\Discover_Automation\\API_Discover_with_welfare.xlsx");
		       int rowCount = xl.getRowCount("Sheet1");
		       for(int j=2;j<=rowCount;j++){
		       //String API = xl.getCellData("Sheet1", "API", j);
		       String input = xl.getCellData("Sheet1", "Question", j);
		       String encodeQuery="";
		       //String encodeQuery = URIUtil.encodeQuery(API);
		        //String encodeQuery = URIUtil.encodeQuery("http://169.46.44.140:5014/response?companyname=Discover&queryInput="+input+"&userId=500223&typeOfRequest=plain_text");
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
					System.out.println(j);
					System.out.println(prettyJsonString);
					xl.setCellData("Sheet1", "Bot_resposne", j, prettyJsonString);

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
