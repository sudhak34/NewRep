package com.test.session;

public class Cars {

	String name;
	static int wheels=4;//global variable
	
	public void accelerator(){
		System.out.println("Car should start");
	}
	public  static String breaks(){
		String a="apply breaks";
		return a;
	}
	public static void fuel(){
		System.out.println("fill the fuel");
	}
	
	public static void main(String[] args) {
		Cars A=new Cars();
		A.accelerator();
		System.out.println(Cars.breaks());
		A.fuel();
		System.out.println(wheels);
		
		//Cars B=new Cars();
		
	}
	
	
	

}
