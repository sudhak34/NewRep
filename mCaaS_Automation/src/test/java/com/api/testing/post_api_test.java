package com.api.testing;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import org.json.simple.JSONObject;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class post_api_test {

	private static final String USER_AGENT = "Mozilla/43.0.1";
	public static void main() throws Exception {
		//String url ="https://forrester-uat-email-notification-api.mybluemix.net/api/v1.0/emailnotification";
		RestAssured.baseURI ="https://forrester-uat-email-notification-api.mybluemix.net/api/v1.0/emailnotification";
		URL obj = new URL(RestAssured.baseURI);
		RequestSpecification request = RestAssured.given();
		HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();
        
		//add reuqest header
		con.setRequestMethod("POST");
		con.setRequestProperty("User-Agent", "Mozilla/43.0.1");
		con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
		con.setRequestProperty("Content-Type","application/json");
		JSONObject requestParams = new JSONObject();
		requestParams.put("status", "generic_email"); // Cast
		requestParams.put("subject", "JSON Comparosion Report");
		requestParams.put("message", "RES113466<br>RES129452");
		request.body(requestParams.toString());
		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		String actual = response.toString();
		System.out.println(actual);
}
}