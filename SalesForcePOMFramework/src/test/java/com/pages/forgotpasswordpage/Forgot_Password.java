package com.pages.forgotpasswordpage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BasePage;

public class Forgot_Password extends BasePage{
	

	@FindBy(id = "forgot_password_link") WebElement forgotPasswordLink;
	@FindBy(id = "un") WebElement sendUName;
	@FindBy(id = "continue") WebElement clickContinue;
	@FindBy(xpath = "//a[contains(text(),'Return to Login')]") WebElement message;//
	
	public Forgot_Password(WebDriver driver) {
		super(driver);
		}
	
	public void clickOnForgotPasswordLink() {
		clickElement(forgotPasswordLink, "Forgot Password link ");
//		forgotPasswordLink.click();
	}
	
	public void sendUserName(String data) {
		enterText(sendUName, data, "username element for email confirmation ");
		//sendUName.sendKeys(data);
	}
	public void clickOnContinue() throws InterruptedException {
		clickElement(clickContinue, "continue element ");
		//clickContinue.click();
	}
	
	public String checkMessage() {
		return message.getText();
	}
}
