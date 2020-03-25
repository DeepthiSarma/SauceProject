package com.cts.stepdefinition;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.cts.base.LaunchWebBrowser;
import com.cts.pages.AboutPage;
import com.cts.pages.CareerPage;
import com.cts.pages.LoginPage;
import com.cts.pages.ProductsPage;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import com.cts.base.*;

public class StepDefinitions {
	WebDriver driver;

	@Given("I have browser with SauceDemo Test")
	public void i_have_browser_with_SauceDemo_Test() {
		LaunchWebBrowser.LaunchWebDriver("ch");
		this.driver = LaunchWebBrowser.driver;
	}
	
//	AboutPage about = new AboutPage(driver);
//	LoginPage login = new LoginPage(driver);
//	ProductsPage products = new ProductsPage(driver);

	@When("I enter username as {string} and I enter password as {string}")
	public void i_enter_username_as_and_I_enter_password_as(String username, String password) {
		LoginPage login = new LoginPage(driver);
		// username
		login.enterUsername(username);

		// password
		login.enterPassword(password);

		// login
		login.clickOnLogin();
	}

	@Then("I should access to the portal with title as {string}")
	public void i_should_access_to_the_portal_with_title_as(String expectedTitle) {
		LoginPage login = new LoginPage(driver);
	
		String actualTitle = login.getTitle();
		Assert.assertEquals(expectedTitle, actualTitle);
		
		LaunchWebBrowser.trerminate();
	}

	@When("I click on Menu button")
	public void i_click_on_Menu_button() {
		ProductsPage products = new ProductsPage(driver);
		
		products.clickOnMenuBar();
	}

	@Then("I side menu with about button has to appear")
	public void i_side_menu_with_about_button_has_to_appear() {
		ProductsPage products = new ProductsPage(driver);
		
		products.WaitForAbout();
		LaunchWebBrowser.trerminate();
	}

	@When("I click on About")
	public void i_click_on_About() {
		ProductsPage products = new ProductsPage(driver);
		products.clickOnAbout();
	}

	@Then("application is redirected to page with title as {string}")
	public void application_is_redirected_to_page_with_title_as(String expectedTitle) {
		ProductsPage products = new ProductsPage(driver);
		
		String actualTitle = products.getTitle();
		Assert.assertEquals(expectedTitle, actualTitle);
		LaunchWebBrowser.trerminate();	
	}

	@When("I click on Company")
	public void i_click_on_Company() {
		
		AboutPage about = new AboutPage(driver);
		
		about.company(driver);
	}

	@Then("a list with About Us option must open")
	public void a_list_with_careers_option_must_open() {
		AboutPage about = new AboutPage(driver);
		
		about.waitForCareers(driver);
		LaunchWebBrowser.trerminate();
	}

	@When("click on careers")
	public void click_on_careers() {
		AboutPage about = new AboutPage(driver);
		
		about.career(driver);
	}

	@Then("career page with title {string} has to open")
	public void career_page_with_title_has_to_open(String expectedTitle) {
		AboutPage about = new AboutPage(driver);
		
		String actualTitle = about.getTitle(driver);
		Assert.assertEquals(expectedTitle, actualTitle);
		LaunchWebBrowser.trerminate();
	}

		
//	@When("I enter valid mail id as {string}")
//	public void i_enter_valid_mail_id_as_and_click_on_send(String mailid) throws InterruptedException {
//	    CareerPage.joinMailList(driver, "deepthi@gmail.com");
//	    Thread.sleep(3000);
//	    CareerPage.sendClick(driver);
//		}
//
//	@Then("mail must be added")
//	public void mail_must_be_added() {
//		String actualthankyouMessage = CareerPage.joinedMessage(driver);
//	String	expectedMsg= "THANK YOU FOR YOUR INTEREST";
//		//Assert.assertEquals("THANK YOU FOR YOUR INTEREST",actualMessage);
//		 Assert.assertTrue(expectedMsg, actualthankyouMessage.contains(expectedMsg));
//	}
//
//	@When("I enter invalid mail id as {string}")
//	public void i_enter_invalid_mail_id_as_and_click_on_send(String mailid) {
//	   CareerPage.joinMailList(driver, "");
//	   CareerPage.sendClick(driver);
//	}
//
//	@Then("error message must be displayed")
//	public void error_message_must_be_displayed() {
//		String actualMessage = CareerPage.errorMessage(driver);
//		Assert.assertTrue("Must be valid email",actualMessage.contains("be valid email"));
//	}
}
