package com.cts.stepdefinition;

import java.io.IOException;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import com.cts.base.LaunchWebBrowser;
import com.cts.pages.AboutPage;
import com.cts.pages.LoginPage;
import com.cts.pages.ProductsPage;
import com.cts.utils.ReadExcel;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitions {
	WebDriver driver;

	@Given("I have browser with SauceDemo Test")
	public void i_have_browser_with_SauceDemo_Test() {
		
		//launch webdriver
		LaunchWebBrowser.LaunchWebDriver("ch");
		this.driver = LaunchWebBrowser.driver;
	}
	
	//reading details from excel
	@When("I enter login details from Excel {string} with SheetName {string}")
	public void i_enter_login_details_from_Excel_with_SheetName(String filedetails, String sheetname) throws IOException {
		String str[][] = ReadExcel.getSheetIntoStringArray("src/test/resources/resources/excel/swaglabs.xlsx",
				"validcredentials");
		
		LoginPage login = new LoginPage(driver);
		
		//username
		login.enterUsername(str[0][0]);
		// password
		login.enterPassword(str[0][1]);
		// login
		login.clickOnLogin();
	}

	@Then("I should access to the portal with title as {string}")
	public void i_should_access_to_the_portal_with_title_as(String expectedTitle) {
		LoginPage login = new LoginPage(driver);
	
		//get page title
		String actualTitle = login.getTitle();
		Assert.assertEquals(expectedTitle, actualTitle);
		
		//quitting browser
		LaunchWebBrowser.trerminate();
	}

	@When("I click on Menu button")
	public void i_click_on_Menu_button() {
		ProductsPage products = new ProductsPage(driver);
		
		// click on menu bar
		products.clickOnMenuBar();
	}

	@Then("I side menu with about button has to appear")
	public void i_side_menu_with_about_button_has_to_appear() {
		ProductsPage products = new ProductsPage(driver);
		//waiting for about element 
		products.WaitForAbout();
		//quitting the scenario
		LaunchWebBrowser.trerminate();
	}

	@When("I click on About")
	public void i_click_on_About() {
		ProductsPage products = new ProductsPage(driver);
		//click on products
		products.clickOnAbout();
	}

	@Then("application is redirected to page with title as {string}")
	public void application_is_redirected_to_page_with_title_as(String expectedTitle) {
		//creating a reference variable for ProductsPage
		ProductsPage products = new ProductsPage(driver);
		//getting the title of the page
		String actualTitle = products.getTitle();
		//Asserting the title to the expected Title
		Assert.assertEquals(expectedTitle, actualTitle);
		//quitting the Scenario
		LaunchWebBrowser.trerminate();	
	}

	@When("I click on Company")
	public void i_click_on_Company() {
		//creating reference variable for About page
		AboutPage about = new AboutPage(driver);
		//clicking on the company
		about.company();
	}

	@Then("a list with About Us option must open")
	public void a_list_with_careers_option_must_open() {
		AboutPage about = new AboutPage(driver);
		//wait for the careers element to be visible
		about.waitForCareers();
		//quit the scenario
		LaunchWebBrowser.trerminate();
	}

	@When("click on careers")
	public void click_on_careers() {
		AboutPage about = new AboutPage(driver);
		//going into careers page
		about.career();
	}

	@Then("career page with title {string} has to open")
	public void career_page_with_title_has_to_open(String expectedTitle) {
		AboutPage about = new AboutPage(driver);
		//getting the title of the page
		String actualTitle = about.getTitle();
		//aserting the expected Title to the actual Title
		Assert.assertEquals(expectedTitle, actualTitle);
		//quit the scenario
		LaunchWebBrowser.trerminate();
	}

}
