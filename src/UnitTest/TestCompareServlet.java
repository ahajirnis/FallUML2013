package UnitTest;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

import controller.Compare;

public class TestCompareServlet {
/*
	@Test
	public void testPDFToText() throws IOException {
		String filePath = "C:\\clubuml-ying\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\ClubUMLSpring2013\\reports\\Test1.ecore_Test2.ecore.pdf";
		String text = Compare.PDFToText(filePath);
		System.out.print(text);
		
		
		
		
	}
	
	
	/*public static String PDFToText(String pdfFilePath) {
		PDDocument pdf;
		String plainText = null; 
		try {
			pdf = PDDocument.load(new File(pdfFilePath));
			PDFTextStripper stripper = new PDFTextStripper();
			plainText = stripper.getText(pdf);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return plainText;
		
	}*/

}
