package com.newfns.testing;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Text_extractor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		{ 
	        String s1 = "Geeks for Geeks"; 
	        String s2 = "A Computer Science Portal for Geeks"; 
	        //s1.replaceAll
	          
	        Pattern p = Pattern.compile("[a-zA-Z]+"); 
	          
	        Matcher m1 = p.matcher(s1); 
	        Matcher m2 = p.matcher(s2); 
	          
	        System.out.println("Words from string \"" + s1 + "\" : "); 
	        while (m1.find()) { 
	            System.out.println(m1.group()); 
	        } 
	          
	        System.out.println("Words from string \"" + s2 + "\" : "); 
	        while (m2.find()) { 
	            System.out.println(m2.group()); 
	        } 
		}
	}

}
