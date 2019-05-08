package com.mcaas.apitesting;



import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.mcaas.genericlibraries.Xls_Reader;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
public class APItesting_jersyclient {

	public static void main(String[] args) {
		try {
		       Xls_Reader xl=new Xls_Reader("D:\\Sudhakar_Data\\Backup\\E\\KIA\\KIA_Testing_29102017\\Second_Round\\KIA_Results.xlsx");
		       int rowCount = xl.getRowCount("Sheet1");
		       for(int j=2;j<=rowCount;j++){
		    	   System.out.println(j);
		       String Input = xl.getCellData("Sheet1", "Question", j);
		       String expected = xl.getCellData("Sheet1", "Expected", j);
//String encodeQuery=URIUtil.encodeQuery("http://169.46.44.131:8080/kia_response?companyname=KIA&userId=2&emailId=ss@gmail.com&queryInput="+Input+"&convId=345");
		       String encodeQuery="";
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
				//System.out.println(j);
				System.out.println(prettyJsonString);
				xl.setCellData("Sheet1", "Actual", j, prettyJsonString);
				if(prettyJsonString.contains(expected)){
					xl.setCellData("Sheet1", "Result", j, "Pass");
					System.out.println("Pass");
				}
				else{
					xl.setCellData("Sheet1", "Result", j, "Fail");
				System.out.println("Fail");
				}
				/*int i = 0;
				Pattern p = Pattern.compile("customerVisibility");
				Matcher m = p.matcher(prettyJsonString);
				while (m.find()) {
				    i++;
				    String recordcount = Integer.toString(i);
				    xl.setCellData("Sheet10", "Count", j, recordcount);
				}
				System.out.println(i);
				*/
			//  } 
		       
			}
		}
			catch (Exception e) {

				e.printStackTrace();

			  }

	}

}
