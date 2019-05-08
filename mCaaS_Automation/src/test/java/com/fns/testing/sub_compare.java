package com.fns.testing;

import com.mcaas.genericlibraries.Xls_Reader;

public class sub_compare {

	public static void main(String[] args) {
		Xls_Reader xl=new Xls_Reader("D:\\Sudhakar_Data\\Backup\\E\\F&S\\Fns_Automation\\Quantum\\Quantum_count_latest.xlsx");
		int rowCount = xl.getRowCount("Sheet2");
		System.out.println(rowCount);
		for(int i=2;i<=411;i++){
		String exp = xl.getCellData("Sheet2", "Research_count_exp", i);
		int test_01 = Integer.parseInt(exp);
		String act = xl.getCellData("Sheet2", "Quantum_count", i);
		int test_02 = Integer.parseInt(act);
		System.out.println(i);
		if(test_01==test_02){
			xl.setCellData("Sheet2","Result", i,"Pass");
			System.out.println("pass");
		}
		else{
			xl.setCellData("Sheet2","Result", i,"Fail");
			System.out.println("fail");
		}
		}
	}

}
