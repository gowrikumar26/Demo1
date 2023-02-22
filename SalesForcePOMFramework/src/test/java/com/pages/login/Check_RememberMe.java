package com.pages.login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BasePage;

public class Check_RememberMe extends BasePage{
	
	
	@FindBy(id = "username") WebElement userName;
	@FindBy(id = "password") WebElement password;
	@FindBy(id = "Login") WebElement loginButton;
	@FindBy(id = "rememberUn") WebElement clickRememberMe;
	@FindBy(id = "userNav") WebElement userMenu;
	@FindBy(xpath = "//a[contains(text(),'Logout')]") WebElement logOut;
	@FindBy(xpath = "//span[@id='idcard-identity']") WebElement userNameField;
	
	public Check_RememberMe(WebDriver driver) {
	super(driver);
	}
	
	public void enterUserName(String data) {
		enterText(userName,data, "username element");
		//userName.sendKeys(data);
	}
	
	public void enterPassword(String data) {
		enterText(password, data, "password element");
		//password.sendKeys(data);
	}
	
	public void clickonRememberMe() {
		clickElement(clickRememberMe, "remember me button");
		//clickRememberMe.click();
	}
	
	public WebDriver clickLogin() {
		clickElement(loginButton,"login button");
		//loginButton.click();
		return driver;
	}
	
	public void findUserMenu() {
		clickElement(userMenu, "User menu");
		//userMenu.click();
	}
	
	public void selectLogOut() {
		clickElement(logOut, "logout from User menu");
		//logOut.click();
	}
	
	public String checkUserNameField() {
		return userNameField.getText();
	}
	
}
