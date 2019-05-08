package com.newfns.testing;

import com.mcaas.genericlibraries.Xls_Reader;

public class pkw_title_copy {

	public static void main(String[] args) {
		Xls_Reader xl=new Xls_Reader("D:\\Sudhakar_Data\\Backup\\E\\F&S\\Fns_Automation\\PKW_Data_set\\300\\Test_data_01.xlsx");
		int rowCount = xl.getRowCount("Sheet1");
		System.out.println(rowCount);
		String title_01="Potential Investment in the Water Value Chain in South Africa";
		for(int i=2;i<=rowCount;i++){
			System.out.println(i);
		String assetid = xl.getCellData("Sheet1", "CATID", i);
		xl.setCellData("Sheet1", "Title", i, title_01);
		if(assetid.contains("-")){
			title_01 = xl.getCellData("Sheet1", "h3_headers", i);
			//xl.setCellData("Sheet1", "expected_slide", i, "Research Summary");
			xl.setCellData("Sheet1", "Title", i, title_01);
		}
	    }
		

	}

}
