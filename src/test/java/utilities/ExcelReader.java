package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		FileInputStream file = new FileInputStream(System.getProperty("user.dir" + "\\testData\\LoginCredential.xlsx"));

		XSSFWorkbook workbook = new XSSFWorkbook(file);

		XSSFSheet sheet = workbook.getSheet("Sheet1");

		int Totalrows = sheet.getLastRowNum();

		int Totalcells = sheet.getRow(1).getLastCellNum();

		for (int i = 0; i < Totalrows; i++) {

			XSSFRow currentrow = sheet.getRow(i);

			for (int j = 0; j < Totalcells; j++) {

				XSSFCell cell = currentrow.getCell(j);

				System.out.println(cell.toString() + "\t");
			}

			System.out.println();
		}
		
		workbook.close();
		file.close();

	}

}
