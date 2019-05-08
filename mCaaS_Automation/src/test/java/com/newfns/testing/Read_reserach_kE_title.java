package com.newfns.testing;

import org.apache.commons.lang3.StringUtils;

import com.mcaas.genericlibraries.Xls_Reader;

public class Read_reserach_kE_title {

	public static void main(String[] args) {
		//Xls_Reader xl=new Xls_Reader("D:\\Sudhakar_Data\\Backup\\E\\F&S\\Fns_Automation\\7K\\KE_07092018\\Test.xlsx");
				Xls_Reader xl=new Xls_Reader("D:\\Sudhakar_Data\\Backup\\E\\F&S\\Fns_Automation\\PKW_Data_set\\300\\backup_300\\308_poc_KE_api.xlsx");
				int rowCount = xl.getRowCount("Sheet1");
				for(int i=2;i<=1801;i++){
					System.out.println(i);
				String Title_portal = xl.getCellData("Sheet1", "Expected_slide_heading", i);
				String filename = xl.getCellData("Sheet1", "Sub_heading_02", i);
				//filename.toLowerCase()
				//String start = StringUtils.substringBefore(filename, "confidence");
				//System.out.println(Title_portal);
				//System.out.println(start);
				//String Response_01 = xl.getCellData("Sheet1", "Response", i);*/
				//String Resp_01 = xl.getCellData("Sheet1", "Result_01", i);*/
				/*String Resut_11 = xl.getCellData("Sheet1", "Result_02", i);
				String Title_sub = xl.getCellData("Sheet1", "Sub_heading_02", i);
				String Title_expected = xl.getCellData("Sheet1", "Expected_slide_heading", i);*/
				/*System.out.println(Title_portal);
				System.out.println(Title_Research);*/
				//System.out.println(Resposne_01);
				if(filename.toLowerCase().contains(Title_portal.toLowerCase())){
					xl.setCellData("Sheet1", "Result_02", i, "Pass");
					System.out.println("Pass");
				}
				/*if(Resut_11.contains("Fail")){
					//xl.setCellData("Sheet1", "Result_02", i, "Pass");
					//System.out.println("Pass");
					if(Title_sub.contains(Title_expected)){
						xl.setCellData("Sheet1", "Result_02", i,"Pass");
						System.out.println("Partial Pass_01");
					}
				}*/
				/*if (Response_01.contains("I was unable to find an exact match, however here are some results I found that may help you.")){
					xl.setCellData("Sheet1", "Result_02", i, "201 error");
					System.out.println("Partial Pass_02");
				}*/
				else{
					xl.setCellData("Sheet1", "Result_02", i, "Fail");
					System.out.println("Fail");
				}
				/*else if(Title_sub.contains(Title_expected)){
					xl.setCellData("Sheet1", "Result_02", i,"Pass");
					System.out.println("Partial Pass");
				}*/
				}
			}

			

		}

