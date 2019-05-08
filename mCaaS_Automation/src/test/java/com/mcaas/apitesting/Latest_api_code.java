package com.mcaas.apitesting;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
public class Latest_api_code {
	private final String USER_AGENT="Mozilla/5.0";
	public static void main(String[] args) throws ClientProtocolException, IOException {
		Latest_api_code test=new Latest_api_code();
		test.GetResponse();
	}
	public String GetResponse() throws ClientProtocolException, IOException
	{
		StringBuffer result=new StringBuffer();
		HttpClient client=new DefaultHttpClient();
	String url="https://api.us.apiconnect.ibmcloud.com/hmbmadminhappiestmindscom-prodccapi/sb/api/v1.0/fedSearch?index=uat.compucom.persona.v1&type=Sempra%20Energy&queryType=issue&queryStr=unable%20to%20see%20previous%20emails&client_id=abe234a5-643a-47ba-8d46-609708f17099&client_secret=Q7cT3pC8dB7xS7sP1lW2qT7rQ2dF7lJ3lY2xK4iI6pQ3nT2xI7";
		HttpGet request=new HttpGet(url);
		request.addHeader("User-Agent",USER_AGENT);
		HttpResponse response=client.execute(request);
		int responseCode=response.getStatusLine().getStatusCode();
		System.out.println("Response Code: " + responseCode);
		try{
		if(responseCode==200)
			
		{
			System.out.println("Get Response is Successfull");
			BufferedReader reader=new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
			String line="";
			while((line=reader.readLine())!=null)
			{
				result.append(line);
				System.out.println(result.toString());
			}
		}
		return result.toString();
		
	}
		catch(Exception ex)
	{
		result.append("Get Response Failed");
		return result.toString();
	}

}
}
