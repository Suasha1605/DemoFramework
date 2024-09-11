package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomeSearch {
	
	
	
	public static void main(String[] art) {
//	 Implements later
	
//	WebDriverManager().Chromedriver().setup();
	
	
	WebDriver driver = new ChromeDriver();
	
	driver.manage().window().maximize();
	
	
	driver.get("https://www.amazon.in/");
	
	driver.findElement(By.xpath("//a[text()='Mobiles']")).click();
	
	driver.findElement(By.xpath("(//span[text()='Mobiles & Accessories'])[1]")).click();
	
	
	
	   driver.close();
	
	}

}
