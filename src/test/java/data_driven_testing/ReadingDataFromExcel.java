package data_driven_testing;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

//Excel File---->Workbook--->Sheets---->Rows--->Cells
public class ReadingDataFromExcel {
	public static void main(String[] args) {
		//"C:"+File.separator+"Users"+File.separator+"Nishat"+File.separator+"eclipse-workspace"+File.separator+"Automation"+File.separator+
		String path=System.getProperty("user.dir")+File.separator+"testdata"+File.separator+"random_data.xlsx";
		try {
			FileInputStream file=new FileInputStream(path);
			XSSFWorkbook workbook=new XSSFWorkbook(file);
			XSSFSheet sheet=workbook.getSheetAt(0);
			int totalRows=sheet.getLastRowNum();
			int totalCells=sheet.getRow(1).getLastCellNum();

			System.out.println("Total Rows :"+totalRows);
			System.out.println("Total Cells :"+totalCells);

			//cell counting from one
			//and row is counting from 0
//			for (int i = 0; i <=totalRows; i++) {
//				XSSFRow row=sheet.getRow(i);
//				for (int j = 0; j <totalCells; j++) {
//					XSSFCell cell =row.getCell(j);
//					System.out.print(cell.toString()+"\t");
//				}
//				System.out.println();
//			}

			for (int i = 0; i <= totalRows; i++) {
				XSSFRow row = sheet.getRow(i);
				if (row == null) {
					System.out.println("Empty row");
					continue;
				}

				for (int j = 0; j < totalCells; j++) {
					XSSFCell cell = row.getCell(j);
					String cellValue = (cell == null) ? "" : cell.toString(); // Handle null cells safely
					System.out.print(cellValue + "\t");
				}
				System.out.println();
			}

			workbook.close();
			file.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
