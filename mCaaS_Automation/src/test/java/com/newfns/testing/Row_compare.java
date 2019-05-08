package com.newfns.testing;

import com.mcaas.genericlibraries.Xls_Reader;

public class Row_compare {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Xls_Reader xl=new Xls_Reader("D:\\Sudhakar_Data\\Backup\\E\\F&S\\Aug_search\\Aug_search_final_data\\AUG_Search_MP_UAT_final.xlsx");
		 int rowCount = xl.getRowCount("Sheet4");
		 String ind="Automotive & Transportation";
		 for(int j=2;j<=rowCount;j++){
			 System.out.println(j);
			 xl.setCellData("Sheet4","Industry_type", j,ind);
			 String james = xl.getCellData("Sheet4","CATID",j);
			 if(james.contains("-")){
			 /*String actual = xl.getCellData("Sheet1", "Expected_slide_heading", j);
			 String james = xl.getCellData("Sheet1","CATID",j);
			 System.out.println(james);*/
			  for(int i=2;i<=309;i++){
			 	 System.out.println(james);
			 	 String data = xl.getCellData("Sheet5","CATID_data",i);
				 if(james.equals(data)){
					 System.out.println(i);
					 ind = xl.getCellData("Sheet5","Industry",i);
					 xl.setCellData("Sheet4","Industry_type", j, ind);
					 System.out.println(ind);
				 }
			  }
	}
	}
}
	}
