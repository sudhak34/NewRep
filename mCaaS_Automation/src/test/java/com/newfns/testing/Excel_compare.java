package com.newfns.testing;

import org.apache.xmlbeans.impl.values.XmlValueDisconnectedException;

import com.mcaas.genericlibraries.Xls_Reader;

public class Excel_compare {

	public static void main(String[] args) {
		Xls_Reader xl=new Xls_Reader("D:\\Sudhakar_Data\\Backup\\E\\F&S\\Aug_search\\Aug_search_final_data\\New folder\\AUG_Search_MP_UAT_final_01.xlsx");
		Xls_Reader xl1=new Xls_Reader("D:\\Sudhakar_Data\\Backup\\E\\F&S\\Aug_search\\Aug_search_final_data\\New folder\\AUG_Search_MP_UAT_final_02.xlsx");
		int rowCount_01 = xl.getRowCount("Sheet1");
		int rowCount_02 = xl1.getRowCount("Sheet2");
		for(int j=2;j<=rowCount_01;j++){
			String james = xl.getCellData("Sheet1","Input_01",j);
			for(int i=2;i<=rowCount_02;i++){
			String query = xl1.getCellData("Sheet2","Input_02",i);
			if (query != null && !query.equals("")){
			if(james.equals(query)){
				System.out.println(j);
				System.out.println(james);
				System.out.println(query);
				String data = xl.getCellData("Sheet1","Old_index_Resposne_time in seconds",j);
				System.out.println(data);
				xl1.setCellData("Sheet2","Res_time_old_index", i, data);
				
			}
			}
			}
			
		}
	}

}
