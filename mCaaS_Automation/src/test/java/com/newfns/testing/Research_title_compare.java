package com.newfns.testing;

import com.mcaas.genericlibraries.Xls_Reader;

public class Research_title_compare {

	public static void main(String[] args) {
		//Xls_Reader xl=new Xls_Reader("D:\\Sudhakar_Data\\Backup\\E\\F&S\\Fns_Automation\\7K\\KE_07092018\\Test.xlsx");
		Xls_Reader xl=new Xls_Reader("D:\\Sudhakar_Data\\Backup\\E\\F&S\\Fns_Automation\\KE_Latest_approach\\KE_290818\\PKW_set_01 - Copy.xlsx");
		int rowCount = xl.getRowCount("Sheet1");
		for(int i=2;i<=1102;i++){
			System.out.println(i);
		//String Title_portal = xl.getCellData("Sheet1", "Title", i);
			//String actual = xl.getCellData("Sheet1", "Title", i);
			//String expected = xl.getCellData("Sheet1", "Response_Title", i);
			String actual = xl.getCellData("Sheet1", "Expected_slide_heading", i);
			String expected = xl.getCellData("Sheet1", "Sub_heading_02", i);
		String Resp_01 = xl.getCellData("Sheet1", "Response", i);
		String Resut_11 = xl.getCellData("Sheet1", "Result_02_old", i);
		/*String Title_sub = xl.getCellData("Sheet1", "Sub_heading_02", i);
		String Title_expected = xl.getCellData("Sheet1", "Expected_slide_heading", i);*/
		/*System.out.println(Title_portal);
		System.out.println(Title_Research);*/
		//System.out.println(Resposne_01);
		/*if(Title_Research.contains(Title_portal)){
			xl.setCellData("Sheet1", "Result_title", i, "Pass");
			System.out.println("Pass");
		}*/
		
		if(Resut_11.contains("Fail")){
			//xl.setCellData("Sheet1", "Result_02", i, "Pass");
			//System.out.println("Pass");
			if(actual.toLowerCase().equals(expected.toLowerCase())){
				xl.setCellData("Sheet1", "Result_02", i,"Pass");
				System.out.println("Pass");
			}
else{
	xl.setCellData("Sheet1", "Result_02", i,"Fail");
	System.out.println("Fail");
}
		}
		if (Resp_01.contains("I was unable to find an exact match, however here are some results I found that may help you.")){
			xl.setCellData("Sheet1", "Result_02", i, "201 error");
			//System.out.println("Partial Pass_02");
	}
		if (Resp_01.contains("Sorry, I dont have that knowledge now, however will be with my next version.")){
			xl.setCellData("Sheet1", "Result_02", i, "400 error");
			//System.out.println("Partial Pass_02");
	}
		if(Resut_11.contains("Pass")){
			//xl.setCellData("Sheet1", "Result_02", i, "Pass");
			//System.out.println("Pass");
			//if(actual.toLowerCase().equals(expected.toLowerCase())){
				xl.setCellData("Sheet1", "Result_02", i,"Pass");
				System.out.println("Pass");
			}
		/*else{
			xl.setCellData("Sheet1", "Result_title", i, "Fail");
			System.out.println("Fail");
		}*/
		/*else if(Title_sub.contains(Title_expected)){
			xl.setCellData("Sheet1", "Result_02", i,"Pass");
			System.out.println("Partial Pass");*/
		}
		}
	}

//}
