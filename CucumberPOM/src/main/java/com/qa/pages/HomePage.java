package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.util.TestBase;

public class HomePage extends TestBase {

	// Page factory

	@FindBy(xpath = "//td[contains(text(),'User: Debomalya Roy')]")
	WebElement usernamelebel;

	@FindBy(xpath = "//a[contains(text(),'Contacts')]")
	WebElement contactLink;
	
	@FindBy(xpath = "//a[contains(text(),'New Contact')]")
	WebElement newContactLink;


	// initialization of the page object

	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	// Actions

	public String verifyHomepageTitle() {
		return driver.getTitle();
	}
	
	public boolean verifyCorrectUserName() {
		return usernamelebel.isDisplayed();
	}

	public void clickOnNewContactLink() {
		
		Actions actions = new Actions(driver);
		actions.moveToElement(contactLink).build().perform();
		newContactLink.click();	
	}

}
