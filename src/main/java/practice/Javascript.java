package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Javascript {
	
	@Test
	public void testJavascriptMethod() throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		
		
		driver.manage().window().maximize();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		driver.get("https://testautomationpractice.blogspot.com/");
		
		WebElement checkbox= driver.findElement(By.xpath("//td[text()='Product 1']/following-sibling::td/input[@type='checkbox']"));
//		checkbox.click();
		
		
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		js.executeScript("arguments[0].scrollIntoView();", checkbox);
		checkbox.click();
//		js.executeScript("arguments[0].click();", checkbox);
		System.out.println(checkbox.isSelected());
//		
		Thread.sleep(4000);
		driver.close();
	}

}
