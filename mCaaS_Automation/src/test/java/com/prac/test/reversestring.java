package com.prac.test;

public class reversestring {

	public static void main(String[] args) {
		StringBuilder sb=new StringBuilder("Sudhakar");
		//sb.append("selenium");
		System.out.println(sb.length());
		for(int i=sb.length()-1;i>=0;--i){
			System.out.print(sb.charAt(i));
			
			}
		
        
	}

}
