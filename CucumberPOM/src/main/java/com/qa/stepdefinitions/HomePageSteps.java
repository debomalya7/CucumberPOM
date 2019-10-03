package com.qa.stepdefinitions;

import org.junit.Assert;

import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.util.TestBase;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class HomePageSteps extends TestBase {
	
	LoginPage loginpage;
	HomePage homepage;
	
	@Given("^user opens browser$")
	public void user_opens_browser() throws Throwable {
		TestBase.initialization();
	}

	@Then("^user is on login page$")
	public void user_is_on_login_page() throws Throwable {
		loginpage = new LoginPage();
		String title =loginpage.validate_login_page_title();
		Assert.assertEquals("CRMPRO - CRM software for customer relationship management, sales, and support.", title);
		
	}
	
	@Then("^user enters username and password$")
	public void user_enters_username_and_password() throws Throwable {
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	    
	}

	@Then("^validate homepage title$")
	public void validate_homepage_title() throws Throwable {
		String homeTitle = homepage.verifyHomepageTitle();
	    Assert.assertEquals("CRMPRO", homeTitle);
	}

	
	@Then("^close the browser$")
	public void close_the_browser() {
		driver.quit();
	}


}
