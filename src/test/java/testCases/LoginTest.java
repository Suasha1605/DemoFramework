package testCases;

import static org.testng.Assert.ARRAY_MISMATCH_TEMPLATE;
import static org.testng.Assert.fail;

import org.testng.Assert;
import org.testng.annotations.*;

import pageObjects.LoginPage;
import testBase.BaseClass;

public class LoginTest extends BaseClass{
	
	
	LoginPage p;
	
	
	
	@Test  (groups={"Smoke","Regression"})
	public void loginSuccessful() {
		
		try {
		logger.info("****Starting loginSuccessful****");
		
		p= new LoginPage(driver); 
		
		logger.info("****Entening the credentials****");
		p.setUsername(pr.getProperty("Username")); //Reading url from config.properties file
		p.setPassword(pr.getProperty("Password")); //Reading url from config.properties file
		p.clickLogin();
		logger.info("****Checking Validations****");
		String actualTitle=driver.getTitle();
		
		if(actualTitle.equals("OrangeHRM")) {
			
			Assert.assertTrue(true);
		}
		else {
			logger.error("Test case failed");
			logger.debug("debug message");
			Assert.assertTrue(false);
		}
		
		
		
		}
		
		catch(Exception e){
			
			
			
			Assert.fail();
		}
		
		logger.info("****Ending loginSuccessful****");
		
	}
	
//	@Test (priority=2)
//	public void loginFailed() {
//		p= new LoginPage(driver); 
//		
//		p.setUsername(randomUsername().toUpperCase());
//		p.setPassword(randomPassword());
//		p.clickLogin();
//		
//		Assert.assertEquals(driver.getTitle(), "OrangeHRM");
//		
//		
//		
//	}
	
	
	

}
