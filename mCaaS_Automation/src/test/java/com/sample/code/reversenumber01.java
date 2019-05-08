package com.sample.code;

import java.util.Scanner;

public class reversenumber01 {

	public static void main(String[] args) {
		System.out.println("Enter the number to be reversed:");
		int num=0;
		int numberreverse=0;
		
		Scanner s=new Scanner(System.in);
		 num = s.nextInt();
		
		while(num!=0){
			numberreverse=numberreverse*10;
			numberreverse=numberreverse+num%10;
			num=num/10;
		}
System.out.println(numberreverse);
	}

}
