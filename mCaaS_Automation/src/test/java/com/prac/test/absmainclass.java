package com.prac.test;

public class absmainclass extends bike {
	public void brand(){
		 System.out.println("Honda");
	 }
	public static void main(String[] args) {
		bike obj=new absmainclass();
		obj.brakes();
		obj.accelerator();
		obj.gears();
		obj.concremethod();
		absmainclass obj1=new absmainclass();
		obj1.brand();
		
	}
	
			 public void brakes(){
				 System.out.println("Brakes");
			 }
			 public void accelerator(){
				 System.out.println("Acceleartor");
			 }
			 public void gears(){
				 System.out.println("Gears");
			 }
			 
			

	

}
