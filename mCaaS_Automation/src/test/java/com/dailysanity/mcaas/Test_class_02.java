package com.dailysanity.mcaas;

import java.util.Timer;
import java.util.TimerTask;
import java.io.IOException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.annotations.Test;
public class Test_class_02 extends Test_class_01 {
	public static void main(String[] args) {
		Timer timer = new Timer(); 
	    TimerTask task = new TimerTask(){
	   // @SuppressWarnings("static-access")
		
	     	 @Test
	     	public void run() {
	              try {
					String active_reprints=GetResponse();
					JSONArray jsonarray = new JSONArray(active_reprints);
					for(int i=0;i<jsonarray.length();i++){
						JSONObject jsonobject = jsonarray.getJSONObject(i);
		                  int userid = jsonobject.getInt("userid");
		                  String assetkey = jsonobject.getString("assetkey");
		                  String userid_key=String.valueOf(userid);
		                  System.out.println(userid_key+" "+assetkey);
		                  String hmJson=hmGetResponse(userid_key,assetkey);
		                  String clientJson=clientGetResponse(assetkey);
		                  Thread.sleep(5000);
		                  if(status_check(hmJson)&client_status_check(clientJson)){
		                	  boolean value=json_comparison(hmJson, clientJson);
                              if(value==true){
                         setCellData("Result", i+1, 2, assetkey+" Equal");
                         System.out.println("Equal");
                   }
                              else{
                                  setCellData("Result", i+1, 2, assetkey+" Not Equal");
                            }
                              
		                  }
		                  else if(redirecturl_check(hmJson)){
                              System.out.println("Redirecturl");
                   setCellData("Result", i+1, 2, assetkey+" redirecturl");
                   continue;
                }
                else{
                              setCellData("Result", i+1, 2, assetkey+" Reprints not available");
                              System.out.println("Reprints not available");
                }
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
	   
		    System.out.println("Test");
	   }	
	    
	 
		 
	 
	    };
	 
	      timer.schedule(task,0,60000);
	
	    
	    }
}