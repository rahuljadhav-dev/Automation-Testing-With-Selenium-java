package data_driven_testing;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WritingDataInExcel {
	public static void main(String[] args) throws IOException {
		String path=System.getProperty("user.dir")+File.separator+"testdata"+File.separator+"sample_data2.xlsx";
		FileOutputStream file=new FileOutputStream(path);
		XSSFWorkbook workbook=new XSSFWorkbook();
		
		XSSFSheet sheet = workbook.createSheet("Data");

		// Create a row if it doesn't already exist
		XSSFRow row = sheet.createRow(0);  // Use createRow instead of getRow

		// Create a bold font
		XSSFFont font = workbook.createFont();
		font.setBold(true);

		// Create a cell style and attach the font
		CellStyle style = workbook.createCellStyle();
		style.setFont(font);

		// Now set values and apply the style
		XSSFCell cell0 = row.createCell(0);
		cell0.setCellValue("ID");
		cell0.setCellStyle(style);

		XSSFCell cell1 = row.createCell(1);
		cell1.setCellValue("NAME");
		cell1.setCellStyle(style);

		XSSFCell cell3 = row.createCell(2);
		cell3.setCellValue("ADDRESS");
		cell3.setCellStyle(style);
		
		XSSFRow row2=sheet.createRow(1);
		row2.createCell(0).setCellValue(6);
		row2.createCell(1).setCellValue("Ashu Jadhav");
		row2.createCell(2).setCellValue("Nanded");
		
		XSSFRow row3=sheet.createRow(2);
		row3.createCell(0).setCellValue(7);
		row3.createCell(1).setCellValue("Rahul Jadhav");
		row3.createCell(2).setCellValue("Nanded");
		
		XSSFRow row4=sheet.createRow(3);
		row4.createCell(0).setCellValue(8);
		row4.createCell(1).setCellValue("Ashu Jadhav");
		row4.createCell(2).setCellValue("Pune");
		
		XSSFRow row5=sheet.createRow(4);
		row5.createCell(0).setCellValue(9);
		row5.createCell(1).setCellValue("Shubham Rahtod");
		row5.createCell(2).setCellValue("Hingoli");
		
		workbook.write(file);
		workbook.close();
		file.close();
		
		System.out.println("Successfully Written...");
		
		

	}

}
