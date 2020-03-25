package com.cts.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AboutPage {
	private  By companyloc = By.linkText("Company");
	private  By waitForCareerloc= By.linkText("Careers");
	private  By careerloc = By.xpath("//a[@class='link'][contains(text(),'Careers')]");
	
	private WebDriver driver;
	public AboutPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public  void company(WebDriver driver) {
		Actions mouse = new Actions(driver);
		mouse.moveToElement(driver.findElement(companyloc)).pause(1000).build().perform();
	}

	public  void waitForCareers(WebDriver driver) {

		WebDriverWait wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.presenceOfElementLocated(waitForCareerloc));
	}
	public  void career(WebDriver driver) {
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();",driver.findElement(careerloc));
	}
	
	public  String getTitle(WebDriver driver) {
		String actualtitle = driver.getTitle();
		return actualtitle;
	}
	

}