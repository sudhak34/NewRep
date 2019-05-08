package com.newfns.testing;

import org.apache.commons.lang3.StringUtils;

import com.mcaas.genericlibraries.Xls_Reader;

public class KE_api_title_extract {

	public static void main(String[] args) {
		//Xls_Reader xl=new Xls_Reader("D:\\Sudhakar_Data\\Backup\\E\\F&S\\Fns_Automation\\7K\\KE_07092018\\Test.xlsx");
		
				Xls_Reader xl=new Xls_Reader("D:\\Sudhakar_Data\\Backup\\E\\F&S\\Fns_Automation\\KE_Latest_approach\\PKW_set_03_01.xlsx");
				int rowCount = xl.getRowCount("Sheet1");
				for(int i=99;i<=3177;i++){
					System.out.println(i);
				//String Title_portal = xl.getCellData("Sheet1", "Title", i);
					try{
				String filename = xl.getCellData("Sheet1", "Response_Title", i);
				//String start = StringUtils.substringBefore(filename, "confidence");
				String s2 =filename.substring(filename.indexOf("Research_Name"));
				System.out.println(s2);
				//String Title_portal_01 = xl.getCellData("Sheet1", "Resp_title", i);
				xl.setCellData("Sheet1", "Resp_title", i, s2);
				//System.out.println(Title_portal_01);
				//System.out.println(start);
				}
				catch(StringIndexOutOfBoundsException e){
					
				}
}
}
}