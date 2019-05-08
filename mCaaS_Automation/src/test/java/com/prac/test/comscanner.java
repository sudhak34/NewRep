package com.prac.test;

import java.util.Scanner;

public class comscanner {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		System.out.println("Enter the name:");
		String name=s.nextLine();
		System.out.println("Enter marks1");
		int M1=s.nextInt();
		System.out.println("Enter marks2");
		int M2=s.nextInt();
		int Total=M1+M2;
		System.out.println("Student name:"+ name);
		System.out.println("Marks" +Total);
	}

}
