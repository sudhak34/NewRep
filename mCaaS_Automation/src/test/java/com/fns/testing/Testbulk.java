package com.fns.testing;

import com.mcaas.genericlibraries.Xls_Reader;

public class Testbulk {

	public static void main(String[] args) {
		Xls_Reader xl=new Xls_Reader("C:\\Users\\sudhakar.koduri\\Desktop\\Bulk_load_Test_data.xlsx");
		int rowCount = xl.getRowCount("Sheet1");
		System.out.println(rowCount);
		for(int i=2;i<=2500;i++){
			String title="Testemail@"+i+i+".com";
			System.out.println(i+title);
			xl.setCellData("Sheet1", "Email ID",i, title);
		}

	}

}
