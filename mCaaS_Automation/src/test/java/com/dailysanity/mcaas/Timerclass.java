package com.dailysanity.mcaas;

import java.util.Timer;
import java.util.TimerTask;

public class Timerclass {

	public static void main(String[] args) {
	   
		Timer timer = new Timer(); 
	    TimerTask task = new TimerTask(){
	    	int i=1;
	    	public void run(){
	    	   	 
	    	System.out.println("Iteration:"+i);
	    	i++;
	    	}

 };
	    
	   //timer.schedule(task,0,10800000);
	    timer.schedule(task,0,30000);

	}
	
}
