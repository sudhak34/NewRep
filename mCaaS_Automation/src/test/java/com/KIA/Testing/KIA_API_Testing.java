package com.KIA.Testing;



import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.mcaas.genericlibraries.Xls_Reader;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class KIA_API_Testing {

	public static void main(String[] args) {
		try {
		       Xls_Reader xl=new Xls_Reader("D:\\Sudhakar_Data\\Backup\\E\\KIA\\KIA_Testing_20112017\\Latest\\FAQs.xlsx");
		       int rowCount = xl.getRowCount("Sheet1");
		       for(int j=2;j<=1018;j++){
		    	   System.out.println(j);
		       String question = xl.getCellData("Sheet1", "Question", j);
		       //String API = "https://api.us.apiconnect.ibmcloud.com/hmbmadminhappiestmindscom-prodcc/sb/api/v1.0/fedSearch?index=uat.compucom.sn.v1&type=Global Knowledge&queryType=issue&queryStr="+query+"&client_secret=yG1eB8dV8pX0mG6xD0iO2vV7uX0xN8aX4tD2vR1pI1uW4eF5uF&channel=Global External&wstate=published&Knumber&client_id=da6c04d5-6880-42c0-bf7a-778d3873925b";
		       String API="http://169.46.44.140:8082/kia_response?companyname=KIA&queryInput="+question+"&convId=354&emailId=ss@gmail.com&userId=2";
		       String expected = xl.getCellData("Sheet1", "Answer", j);
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
					Gson gson = new GsonBuilder().setPrettyPrinting().create();
					JsonParser jp = new JsonParser();
					JsonElement je = jp.parse(output);
					String prettyJsonString = gson.toJson(je);
					String s2 =prettyJsonString.substring(prettyJsonString.indexOf("Answer"));
					System.out.println(s2);
					xl.setCellData("Sheet1", "Actual_Response", j, s2);
					if(s2.contains(expected)){
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
