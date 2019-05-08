package com.prac.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class readexdel {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		try{
		String FILE_PATH="C:\\Users\\sudhakar.koduri\\Desktop\\Test.xlsx";
		File excelFile = new File(FILE_PATH);
		FileInputStream fis=new FileInputStream(excelFile);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
	    // we get first sheet
	    XSSFSheet sheet = workbook.getSheetAt(0);
	   XSSFRow row2 = sheet.getRow(0);
          System.out.println(sheet.getLastRowNum()+1);
          System.out.println(row2.getLastCellNum());
          
	    // we iterate on rows
	    Iterator<Row> rowIt = sheet.iterator();

	    while(rowIt.hasNext()) {
	      Row row = rowIt.next();

	      // iterate on cells for the current row
	      Iterator<Cell> cellIterator = row.cellIterator();

	      while (cellIterator.hasNext()) {
	        Cell cell = cellIterator.next();
	        //System.out.println(cell.toString() + "\t");
	      }

				}
				
			fis.close();
			}
		catch (Exception e)
        {
            e.printStackTrace();
        }
}
}

	


