package data_driven_testing;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DynamicDataWritingInExcel {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        // File path setup
        String path = System.getProperty("user.dir") + File.separator + "testdata" + File.separator + "dynamic_data.xlsx";
        FileOutputStream file = new FileOutputStream(path);
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Data");

        // Header row
        XSSFRow headerRow = sheet.createRow(0);

        // Bold font for headers
        XSSFFont font = workbook.createFont();
        font.setBold(true);

        CellStyle style = workbook.createCellStyle();
        style.setFont(font);

        String[] headers = {"ID", "NAME", "ADDRESS"};
        for (int i = 0; i < headers.length; i++) {
            XSSFCell cell = headerRow.createCell(i);
            cell.setCellValue(headers[i]);
            cell.setCellStyle(style);
        }

        // Take number of records from user
        System.out.print("Enter number of records to insert: ");
        int recordCount = scanner.nextInt();
        scanner.nextLine(); // Consume leftover newline

        // Input loop for each row
        for (int i = 1; i <= recordCount; i++) {
            System.out.println("Enter details for record " + i + ":");

            System.out.print("ID: ");
            int id = scanner.nextInt();
            scanner.nextLine(); // consume newline

            System.out.print("NAME: ");
            String name = scanner.nextLine();

            System.out.print("ADDRESS: ");
            String address = scanner.nextLine();

            // Create new row and fill data
            XSSFRow row = sheet.createRow(i);
            row.createCell(0).setCellValue(id);
            row.createCell(1).setCellValue(name);
            row.createCell(2).setCellValue(address);
        }

        // Write to file
        workbook.write(file);
        workbook.close();
        file.close();
        scanner.close();

        System.out.println("Successfully Written to Excel...");
    }
}
