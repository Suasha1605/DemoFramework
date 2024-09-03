package testBase;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;


public class BaseClass {

	public  static WebDriver driver;
	
	public Logger logger;
	
	public Properties pr;

	@BeforeClass (groups={"Smoke","Regresstion"})
	@Parameters({"OS","browser"})
	public void setup(String os, String br) throws IOException {
		
//		Loading config.properties file
		
		FileReader file= new FileReader(".//src//test//resources//config.properties");
		pr= new Properties();
		pr.load(file);
		
//		Logging script exection details
		logger =LogManager.getLogger(this.getClass());
		
		switch(br.toLowerCase()) {
		
		case "chrome": driver = new ChromeDriver();
		break;
		case "firefox": driver = new FirefoxDriver();
		break;
		case "edge": driver = new EdgeDriver();
		break;
		
		default : System.out.println("Invalid browser name"); 
		return;
		}

		

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get(pr.getProperty("QAURL"));//Reading url from config.properties file
	}

	@AfterClass (groups={"Smoke","Regresstion"})
	public void logout() {

		driver.quit();

	}

	public String randomUsername() {

		String randomuser = RandomStringUtils.randomAlphabetic(5);
		return randomuser;
	}

	public String randomPassword() {

		String randomAplha = RandomStringUtils.randomAlphabetic(5);
		String randomNum = RandomStringUtils.randomNumeric(4);

		String pass = randomAplha + "@" + randomNum;

		return pass;

	}

}
