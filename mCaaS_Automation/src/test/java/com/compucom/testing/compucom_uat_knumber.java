package com.compucom.testing;

import java.util.regex.Matcher;
import java.util.regex.Pattern;



import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.mcaas.genericlibraries.Xls_Reader;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class compucom_uat_knumber {

	public static void main(String[] args) {
		try {
		       Xls_Reader xl=new Xls_Reader("D:\\Sudhakar_Data\\Backup\\E\\Compucom_migration\\Automation_Persona\\Knumber_Automation.xlsx");
		       int rowCount = xl.getRowCount("Sheet1");
		       for(int j=414;j<=rowCount;j++){
		       String Company = xl.getCellData("Sheet1", "Company", j);
		       String Knumber = xl.getCellData("Sheet1", "Knumber", j);
		       //String API = "https://api.us.apiconnect.ibmcloud.com/hmbmadminhappiestmindscom-prodcc/sb/api/v1.0/fedSearch?index=uat.compucom.sn.v1&type=Global Knowledge&queryType=issue&queryStr="+query+"&client_secret=yG1eB8dV8pX0mG6xD0iO2vV7uX0xN8aX4tD2vR1pI1uW4eF5uF&channel=Global External&wstate=published&Knumber&client_id=da6c04d5-6880-42c0-bf7a-778d3873925b";
		       String API="https://api.us.apiconnect.ibmcloud.com/hmbmadminhappiestmindscom-prodcc/sb/api/v1.0/fedSearch?index=uat.compucom.clp.v1&type="+Company+"&queryType=uks&queryStr="+Knumber+"&client_id=8dc4cc53-1612-4fcb-a9f5-226a2f2a0794&client_secret=Q0uR1yB7bS2lH8iA6gH2iI3jG3uY0jX5hE8bV8hW6xI3mG3hC7";
		       String expected = xl.getCellData("Sheet1", "keyword", j);
		       //String encodeQuery = URIUtil.encodeQuery(API);
		       String encodeQuery =API;
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
				xl.setCellData("Sheet1", "Response", j, prettyJsonString);
				//String s2 =prettyJsonString.substring(prettyJsonString.indexOf("shortDesc"));
				//System.out.println(s2);
				if(prettyJsonString.contains(Knumber)){
					xl.setCellData("Sheet1", "Result", j, "Pass");
					System.out.println("Pass");
				}
				else{
					xl.setCellData("Sheet1", "Result", j, "Fail");
				System.out.println("Fail");
				}
				int i = 0;
				Pattern p = Pattern.compile("customerVisibility");
				Matcher m = p.matcher(prettyJsonString);
				while (m.find()) {
				    i++;
				    String recordcount = Integer.toString(i);
				    xl.setCellData("Sheet1", "Count", j, recordcount);
				}
				System.out.println(i);
				
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
