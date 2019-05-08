package com.prac.test;

public class Interfacetestclass implements Testinterface {

	public static void main(String[] args) {
		Interfacetestclass obj=new Interfacetestclass();
		obj.method1();
		obj.method2();
		obj.method3();
		Testinterface obj1=new Interfacetestclass();
		obj1.method1();
		obj1.method2();
		obj.method3();
	}

	public void method1() {
		
		System.out.println("method1");
	}

	public void method2() {
		System.out.println("method2");
		
	}

	public void method3() {
		System.out.println("method3");
		
	}

}
