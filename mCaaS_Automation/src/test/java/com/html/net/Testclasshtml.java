package com.html.net;

import org.testng.annotations.Test;

import net.fns.tcs.fns_sanity_suite;


public class Testclasshtml extends sendemailhtml {
	static String value1;
	static String value2;
	static String value3;
	static String value4;
	static String value5;
	static String value6;
	static String value7;
	static String value8;
	static String value9;
	static String value10;
	static String value11;
	static String value12;
	static String value13;
	static String value14;
	static String value15;
	static String value16;
	static String value17;
	@Test(priority = 1)
	public static void login() throws Throwable{
	
	 value1="KE";
	 value2="Global metal suppliers market";
	 value3="12";
	 value4="<span style=color:green>"+"Pass"+"</span>";
	 value5="Aug Search";
	 value6="Full Research Loading";
	 value7="PDF Download";
	 value8="Vault Image Capture";
	 value9="Vault PDF Download";
	 value10="A";
	 value11="A";
	 value12="A";
	 value13="A";
	 value14="A";
	 value15="A";
	 value16="A";
	 value17="A";
	}
	
	@Test(priority = 2)
	public static void sendemail(){
		Testclasshtml.sendemailtoteam(value1, value2, value3, value4, value5, value6, value7, value8, value9, value10, value11, value12, value13, value14, value15, value16, value17);
	}
	
}

