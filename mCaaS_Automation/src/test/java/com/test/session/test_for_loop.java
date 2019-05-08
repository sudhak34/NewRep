package com.test.session;

import javax.print.DocFlavor.STRING;

import com.mcaas.genericlibraries.Xls_Reader;

public class test_for_loop {

	public static void main(String[] args) {
		int counter=1;
		Xls_Reader xl=new Xls_Reader("D:\\Sudhakar_Data\\Backup\\E\\F&S\\Test.xlsx");
		for(int i=1;i<=10;i++){
			System.out.println(i);
			//System.out.println(counter+i);
			for(int j=2;j<=4;j++){
				System.out.println(j);
				String value = String.valueOf(j);
				xl.setCellData("Sheet1", "Heading", j, value);
			}
		}

	}

}
