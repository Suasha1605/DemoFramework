package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage{

	

	public LoginPage(WebDriver driver) {

		super(driver);
	}

//	Action methods

	public void setUsername(String user) {

		userName.sendKeys("Admin");
	}

	public void setPassword(String pass) {

		password.sendKeys("admin123");
	}

	public void clickLogin() {

		loginButton.click();
	}


	
	@FindBy(xpath="//input[@name='username']")
	WebElement userName;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement password;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement loginButton;

}
