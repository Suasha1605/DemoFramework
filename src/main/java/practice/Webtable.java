package practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Webtable {
	
	
	WebDriver driver;
	
	@BeforeClass
	public void setup() {
		
        driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://testautomationpractice.blogspot.com/");
	}
	
//	@Test
	public void testWebTable() {
		
		
		
		
		
		List<WebElement> rows=driver.findElements(By.xpath("//table [@name='BookTable']//tr//th"));
		
		for(WebElement k:rows) {
			
			String rowvalue = k.getText();
			
			System.out.println(rowvalue);
		}
	}
	

	
//	@Test
	public void getspecificWebTableValue() {
		
		
		List<WebElement> values=driver.findElements(By.xpath("//table [@name='BookTable']//tr//td"));
		
		for(int i=0; i<values.size(); i++) {
			
			
			String data= values.get(i).getText();
			
			
//			System.out.print(data+" | ");
			
			if(data.equals("Learn Java")) {
				
				
				
				String Price = values.get(i+3).getText();
				
				System.out.println(values.get(i).getText()+" : "+values.get(i+3).getText());
			}
		}
	}
	
	@Test
	public void getclickSpecificProductAndGetPrice() {
		
		String productName ="Product 16";
		WebElement selectProduct=driver.findElement(By.xpath("//table[@id='productTable']//td[text()='"+productName+"']/following-sibling::td//input"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", selectProduct);
		
		if(selectProduct.isSelected()) {
			
			
			System.out.println(productName+"is selected");
		}
		
			
		
	}
	
	
	
	
	
	
	
	@AfterClass
	public void tearDown() {
		
		driver.quit();
	}
	

}
