package practice;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class BrokenLink {
	
	WebDriver driver;
	
	
	
	
	
	
	
	@Test
	public void testBrokenLinks() throws IOException, InterruptedException {
		
		
		driver= new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://demo.guru99.com/selenium/newtours/index.php");
		
		List<WebElement> webelement = driver.findElements(By.tagName("a"));
		
		System.out.println(webelement.size());
		
		for(int i=0; i<webelement.size(); i++) {
			
			String link= webelement.get(i).getAttribute("href");
			
			URL url = new URL(link);
			
			
			HttpURLConnection connect =(HttpURLConnection)url.openConnection();
			
			Thread.sleep(2000);
			connect.connect();
			
			if(connect.getResponseCode()>=400) {
				
				System.out.println(link+"  : is broken link");
			}
			
			else {
				
				System.out.println(link+"  : is valid link");
			}
			
			
		}
		
		driver.close();
		
	}

}
