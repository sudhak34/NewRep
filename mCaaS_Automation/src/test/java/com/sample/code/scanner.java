package com.sample.code;

import java.util.Scanner;

import org.apache.cassandra.thrift.Cassandra.system_add_column_family_args;

public class scanner {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		System.out.println("Enter your first name:");
		String name = s.nextLine();
		System.out.println("Hello "+name);
		System.out.println("Enter your marks:");
		int Marks = s.nextInt();
		System.out.println("My Marks "+Marks);
		System.out.println("Enter your aggegate:");
        double per = s.nextDouble();
        System.out.println("My aggregate "+per);
	}

}
