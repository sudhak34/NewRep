package com.prac.test;

import java.util.Scanner;

public class Average_array {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		System.out.println("Enter average of numbers ");
		int n=s.nextInt();
        int[] arr= new int[n];
        int total=0;
        for(int i=0;i<arr.length;i++){
        	System.out.println("Enter the number:" +(i+1));  
        	arr[i]=s.nextInt();
        	total=total+arr[i];
        }
        System.out.println(total/arr.length);
	}

}
