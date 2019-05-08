package com.pdf.extract;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.util.PDFTextStripper;

public class PDFReader {
	 public static void main(String args[]) {
		    PDFTextStripper pdfStripper = null;
	        PDDocument pdDoc = null;
	        COSDocument cosDoc = null;
	        File file = new File("C:\\Users\\sudhakar.koduri\\Desktop\\pdf_extract\\9AAF-00-38-00-00-1.pdf");
	        try {
	            PDFParser parser = new PDFParser(new FileInputStream(file));
	            parser.parse();
	            cosDoc = parser.getDocument();
	            pdfStripper = new PDFTextStripper();
	            pdDoc = new PDDocument(cosDoc);
	            pdfStripper.setStartPage(3);
	            pdfStripper.setEndPage(29);
	            String parsedText = pdfStripper.getText(pdDoc);
	            System.out.println(parsedText);
	        } catch (IOException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        } 
	    }
}
