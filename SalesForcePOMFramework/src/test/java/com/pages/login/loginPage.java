package com.pages.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BasePage;

public class loginPage extends BasePage{

//		WebDriver driver;
		
		@FindBy(id = "username") WebElement userName;
		@FindBy(id = "password") WebElement password;
		@FindBy(id = "Login") WebElement loginButton;
		
		public loginPage(WebDriver driver) {
			super(driver);
		}
		
		public void enterUserName(String data) {
			waitUntilVisible(userName, "username element");
			enterText(userName, data, "username element");
			//userName.sendKeys(data);
		}
		
		public void enterPassword(String data) {
			enterText(password, data, "password element");
			//password.sendKeys(data);
		}
		public WebDriver clickLogin() {
			clickElement(loginButton, "login button");
			//loginButton.click();
			return driver;
		}
}
