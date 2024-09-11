package practice;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileInputReader {

//	@Test (priority=1)
	public void textFileInputReader() throws IOException {

		System.out.println("*********File Reading*************");
		File file = new File(System.getProperty("user.dir") + "\\testdata\\samplefile.txt");

		FileReader fr = new FileReader(file);

		BufferedReader br = new BufferedReader(fr);

		String data;

		while ((data = br.readLine()) != null) {

			System.out.println(data);
		}

		br.close();

	}

//	@Test (priority=2)
	public void excelFileInputReader() throws IOException {

		File file2 = new File(System.getProperty("user.dir") + "\\testdata\\Testdata.xlsx");

		FileInputStream fs = new FileInputStream(file2);

		XSSFWorkbook workbook = new XSSFWorkbook(fs);

		XSSFSheet sheet = workbook.getSheet("Courses");

		int rowCount = sheet.getLastRowNum();

		int cellCount = sheet.getRow(1).getLastCellNum();

		String[][] courseData = new String[rowCount][cellCount];

		for (int i = 1; i <= rowCount; i++) {

			XSSFRow row = sheet.getRow(i);

			for (int j = 0; j < cellCount; j++) {

				XSSFCell cell = row.getCell(j);

				CellType celltype = cell.getCellType();

				switch (celltype) {

				case STRING:
					System.out.print(cell.getStringCellValue());
					break;

				case NUMERIC:
					System.out.print(cell.getNumericCellValue());
					break;

				case BOOLEAN:
					System.out.print(cell.getBooleanCellValue());
					break;

				}

				System.out.print("  ||  ");
			}

			System.out.println();
		}

	}

//	@Test(priority = 3)
	public void csvFileReader() throws IOException {

		File path = new File(System.getProperty("user.dir") + "\\testData\\demo.csv");

		FileReader fr = new FileReader(path);

		BufferedReader br = new BufferedReader(fr);

		String csvdata;

		while ((csvdata = br.readLine()) != null) {

			String[] data = csvdata.split(",");

			for (String k : data) {

				System.out.print(k + "\t");
			}
			System.out.println();
		}

		br.close();
	}

//	@Test (priority = 4)
	public void pdfFileReader() throws IOException {

		File path = new File(System.getProperty("user.dir") + "\\testData\\SunilPawar_QA_0924_new.pdf");

		PDDocument pdducument = PDDocument.load(path);

		PDFTextStripper stripper = new PDFTextStripper();

		String pdfdata = stripper.getText(pdducument);

		System.out.println(pdfdata);

		pdducument.close();

	}
	
	@Test (priority = 5)
	public void pdfURLReader() throws IOException {
		
		WebDriver driver = new ChromeDriver();
		
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
		driver.get("https://file-examples.com/");
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		WebElement doc =driver.findElement(By.xpath("//h3[text()='Documents']/following-sibling::a"));
		
		js.executeScript("arguments[0].click();", doc);
		
		WebElement pdf= driver.findElement(By.xpath("//td[text()='PDF']/following-sibling::td/a"));
		js.executeScript("arguments[0].click();", pdf);
		
		WebElement pdfsize =driver.findElement(By.xpath("//td[text()='500 kB']/following-sibling::td/a"));
		
		js.executeScript("arguments[0].click();", pdfsize);
		
		String pdfurl = driver.getCurrentUrl();
		
		URL url = new URL(pdfurl);
		
		PDDocument pddocumnet =PDDocument.load(url.openStream());
		
//	    System.out.println(pddocumnet.getNumberOfPages());	
	    
	   PDFTextStripper stripper = new PDFTextStripper();
	   
	   String pdfdata= stripper.getText(pddocumnet);
	   
	   System.out.println("=================");
	   
	   System.out.println(stripper.getPageStart());
	   
	   System.out.println(stripper.getPageEnd());
	 
	   
	   
	   
	   System.out.println(pdfdata);
	   
	   
	   pddocumnet.close();
	   
	   
	   
	   driver.quit();
	   
		
		
		
	}

}
