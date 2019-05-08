package com.api.testing;




import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class apitestmethod {

	

	public static void main(String[] args) throws Exception {
		String api="";
		//String encodeQuery = URIUtil.encodeQuery(api);
		String encodeQuery = api; 
		Client client = Client.create();
		WebResource webResource = client.resource(encodeQuery);
		ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);
       if(response.getStatus()!=200){
    	   throw new RuntimeException(""+response.getStatus());
       }
       
	}

}
