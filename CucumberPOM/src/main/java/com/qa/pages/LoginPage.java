package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.qa.util.TestBase;

public class LoginPage extends TestBase{
	
	
	// Page factory
	@FindBy(name = "username")
	WebElement username; 
	
	@FindBy(name = "password")
	WebElement password;
	
	@FindBy(xpath = "//input[@class='btn btn-small']")
	WebElement loginButton;
	
	@FindBy(xpath = "//a[contains(text(),'Sign Up')]")
	WebElement signup;
	
	@FindBy(xpath = "//img[@class='img-responsive'][@src='https://classic.crmpro.com/img/logo.png']")
	WebElement logo;
	
	// initialization of the page object
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	//Actions
	
	public String validate_login_page_title() {
		return driver.getTitle();
	}
	
	public boolean validate_crm_image() {
		return logo.isDisplayed();
	}
	
	public HomePage login(String un, String pwd) throws Exception {
		username.sendKeys(un);
		password.sendKeys(pwd);
		Thread.sleep(3000);
		loginButton.click();
		
		return new HomePage();
	}

}
