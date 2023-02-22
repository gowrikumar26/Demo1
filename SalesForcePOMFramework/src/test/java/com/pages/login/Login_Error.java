package com.pages.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BasePage;

public class Login_Error extends BasePage {
	
	
	@FindBy(id = "username") WebElement userName;
	@FindBy(id = "Login") WebElement loginButton;
	@FindBy(id = "error") WebElement errormessage;
	
	
	public Login_Error(WebDriver driver) {
		super(driver);
	}
	
	public void enterUserName(String data) {
		enterText(userName, data, "username element");
		//userName.sendKeys(data);
	}
	
	public WebDriver clickLogin() {
		clickElement(loginButton, "login button");
		//loginButton.click();
		return driver;
	}
	
	public String getErrorMessage() {
		return errormessage.getText();
	}
	

}
