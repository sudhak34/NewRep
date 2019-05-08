package com.test.session;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.mcaas.genericlibraries.Xls_Reader;

public class Static_nonstaticmethods {
	
static int x =5;//global variable
int y;
		public static void staticmethod()
	       {
			
		System.out.println("This is a staticmethod");
			}

			public void nonstaticmethod()
	{
		 y=10;
		
	 	System.out.println("This is a nonstaticmethod");
	}
	
	//main method
public static void main(String[] args) {
		
	Static_nonstaticmethods object=new Static_nonstaticmethods();//object created 
	object.nonstaticmethod();                       //we need to create an object to call a non static method
	Static_nonstaticmethods.staticmethod();         //Object no required,static method can be called with ref to class name
	System.out.println(Static_nonstaticmethods.x);//calling static variable
	System.out.println(object.y);//calling non static variable
	

	}
	

}