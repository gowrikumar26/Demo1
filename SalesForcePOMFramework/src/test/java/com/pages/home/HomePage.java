package com.pages.home;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BasePage;

public class HomePage extends BasePage{
//	WebDriver driver;
	
	@FindBy(xpath = "//li[@id='home_Tab']/a") WebElement home;
	
	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	public String getTextfromHomePage() {
		return home.getText();
	}
	
}
