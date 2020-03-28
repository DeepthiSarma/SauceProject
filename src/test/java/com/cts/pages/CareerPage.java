package com.cts.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CareerPage {

	private  By searchloc=By.xpath("//i[@class='svg svg-search nav-action-list-items-search-form-icon has-fill-primary']");
	private  By textBoxwaitloc= By.xpath("//div[@class='nav-action-list-items-search-form-input-container is-hidden']");
	private  By joinMailloc = By.id("Email");
	private  By sendloc = By.xpath("//span[@class='mktoButtonWrap mktoSimple']");
	private  By errorMsgloc = By.xpath("//div[@class='mktoErrorMsg']");
	private  By joinedloc = By.xpath("//p[@class='supertitle']");
	
	private WebDriver driver;
	public CareerPage(WebDriver driver)
	{
		this.driver = driver;
	}

	public   void clickOnSearchBar() {
		driver.findElement(searchloc).click();
	}

	public  void textBoxWait() {

		WebDriverWait wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.presenceOfElementLocated(textBoxwaitloc));
	}
}

