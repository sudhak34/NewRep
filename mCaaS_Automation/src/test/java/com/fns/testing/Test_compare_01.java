package com.fns.testing;

import org.apache.xmlbeans.impl.values.XmlValueDisconnectedException;

import com.mcaas.genericlibraries.Xls_Reader;

public class Test_compare_01 {

	public static void main(String[] args) {
		Xls_Reader xl=new Xls_Reader("D:\\Sudhakar_Data\\Backup\\E\\F&S\\Fns_Automation\\Quantum\\results.xlsx");
		Xls_Reader xl01=new Xls_Reader("D:\\Sudhakar_Data\\Backup\\E\\F&S\\Fns_Automation\\Quantum\\results - Copy.xlsx");
		int rowCount = xl.getRowCount("Sheet1");
		int rowCount_01 = xl01.getRowCount("Sheet2");
		System.out.println(rowCount);
		System.out.println(rowCount_01);
		for(int i=2;i<=rowCount;i++){
			    String input = xl.getCellData("Sheet1","CATID", i);
				for(int j=2;j<=rowCount_01;j++){
				String input_01 = xl.getCellData("Sheet2", "ID", j);
				String count_01 = xl.getCellData("Sheet2", "Results found", j);
				try{
				if(input.equals(input_01)){
					System.out.println(input);
					xl.setCellData("Sheet1","Quan_Assetid", i,input);
					//xl.setCellData("Sheet1","Out_01", i,count);
					//System.out.println(count);
					xl.setCellData("Sheet1","Quantum_count", j,count_01);
					System.out.println(count_01);
					break;
				}
				}
				catch(XmlValueDisconnectedException e){
					System.out.println("xml error");
				}
				catch(Exception e){
					
				}
				continue;
				}
			
			}
		
		}

	}


