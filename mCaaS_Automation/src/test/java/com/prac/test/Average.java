package com.prac.test;

public class Average {

	public static void main(String[] args) {
		int[] arr={2,3,4,5,6,7,8,9};
		double total=0;
		for(int i=0;i<arr.length;i++){
			total=total+arr[i];
		}
		System.out.println(total);
		System.out.println(total/arr.length);

	}

}
