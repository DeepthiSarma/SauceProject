package com.cts.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	private  By nameLoc= By.id("user-name");
	private  By passLoc= By.id("password");
	private  By loginLoc=By.className("btn_action");
	private  By errorLoc=By.className("error-button");
	
	private WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public  void enterUsername(String username) {
		
		driver.findElement(nameLoc).sendKeys(username);
	}

	public  void enterPassword(String password) {
		
		driver.findElement(passLoc).sendKeys(password);
}
	public  void clickOnLogin() {
		
		driver.findElement(loginLoc).click();
	}
	public  String getTitle() {
		String actualtitle = driver.getTitle();
		return actualtitle;
	}
	
	public  String errorMessage(WebDriver driver) {
		WebElement errele = driver.findElement(errorLoc);
		String ele = errele.getText();
		return ele;
	}
}
