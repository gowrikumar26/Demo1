package com.pages.login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BasePage;

public class ValidateLoginErrorMessage extends BasePage{
	@FindBy(id = "username") WebElement worngUName;
	@FindBy(id = "password") WebElement wrongPword;
	@FindBy(id = "Login") WebElement loginButton;
	@FindBy(id = "error") WebElement errorMsg;
	
	public ValidateLoginErrorMessage(WebDriver driver) {
		super(driver);
	}
	
	public void wrongUserName(String data) {
		enterText(worngUName, data, "wrong username element");
//		worngUName.sendKeys(data);
	}
	
	public void wrongPassword(String data) {
		enterText(wrongPword, data, "wrong password element");
		//wrongPword.sendKeys(data);
	}
	
	public void clickonLogin() {
		clickElement(loginButton,"login button");
		//loginButton.click();
	}
	
	public String errorMessage() {
		return errorMsg.getText();
	}
}
