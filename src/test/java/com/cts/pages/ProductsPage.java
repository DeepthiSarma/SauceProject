
package com.cts.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductsPage {

	private  By menuLoc = By.xpath("//button[text()='Open Menu']");
	private  By aboutloc = By.xpath("//a[@id='about_sidebar_link']");
	private  By aboutwaitloc = By.linkText("About");
	
	private WebDriver driver;
	
	public ProductsPage(WebDriver driver)
	{
		this.driver = driver;
	}

	
	public  void clickOnMenuBar() {
		driver.findElement(menuLoc).click();
	}

	public  void WaitForAbout() {

		WebDriverWait wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.presenceOfElementLocated(aboutwaitloc));
	}

	public  void clickOnAbout() {

		driver.findElement(aboutloc).click();
	}

	public  String getTitle() {
		String actualtitle = driver.getTitle();
		return actualtitle;
	}
}
