package com.KIA.Testing;

import com.mcaas.genericlibraries.Xls_Reader;

public class Post_API_data_comparison {

	public static void main(String[] args) {
		Xls_Reader xl=new Xls_Reader("D:\\Sudhakar_Data\\Backup\\E\\KIA\\KIA_Testing_20112017\\Latest\\Updated\\Generic_Chat_DataSet.xlsx");
	    int rowCount = xl.getRowCount("Sheet1");
	    System.out.println(rowCount);
	    for(int i=2;i<=rowCount;i++){
	    	    System.out.println(i);
			 	//String input = xl.getCellData("Sheet1", "Question", i);
				String expected = xl.getCellData("Sheet1", "Answer", i);
				String actual = xl.getCellData("Sheet1", "Actual_Response", i);
				String expected_result =expected.replaceAll("\\s{2,}","").replaceAll("\\s","");
				String actual_result = actual.replaceAll("\\s{2,}","").replaceAll("\\s","");
				//System.out.println(expected_result);
				//System.out.println(actual_result);
				if(actual_result.replaceAll("\\s","").replaceAll("\\s{2,}","").contains(expected_result.replaceAll("\\s",""))){
					xl.setCellData("Sheet1", "Result", i, "Pass");
					System.out.println("Pass");
				}
				else{
					xl.setCellData("Sheet1", "Result", i, "Fail");
				System.out.println("Fail");
				}
				if(i==413){
					break;
				}
				//System.out.println(i+"----"+expected_result);
				
	    }

	}

}
