package com.prac.test;

import java.util.Arrays;

public class Ascending_desecnding {

	public static void main(String[] args) {
		int[] arr={4,1,7,3,12,9};
		Arrays.sort(arr);
		for(int i=0;i<arr.length;i++){
		
		System.out.println(arr[i]);
		}
		System.out.println("----------------");
		for(int i=arr.length-1;i>=0;i--){
			System.out.println(arr[i]);
			}
		

	}

}
