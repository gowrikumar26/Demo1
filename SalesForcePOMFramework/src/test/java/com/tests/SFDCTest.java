package com.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.pages.forgotpasswordpage.Forgot_Password;
import com.pages.home.HomePage;
import com.pages.login.Check_RememberMe;
import com.pages.login.Login_Error;
import com.pages.login.ValidateLoginErrorMessage;
import com.pages.login.loginPage;
import com.utility.PropertiesUtility;

import Reusable.BaseClass;
import io.github.bonigarcia.wdm.WebDriverManager;

@Listeners(com.utility.TestEventListenersUtility.class)
public class SFDCTest extends BaseClass {//TekarchAutomation in divya's video
@Test(priority = 0)
	public void loginToSalesforce() {
		logger.info("inside login to salesforce");
		String expected = "Home";
		//extentReport
		PropertiesUtility propertiesUtility = new PropertiesUtility();
		propertiesUtility.loadFile("dataProperties");
		String username = propertiesUtility.getPropertyValue("valid.username");
		String password = propertiesUtility.getPropertyValue("valid.password");
		
		loginPage loginpage = new loginPage(driver);
		loginpage.enterUserName(username);
		loginpage.enterPassword(password);
		driver = loginpage.clickLogin();
		fluentWait();

		HomePage homepage = new HomePage(driver);
		String actual = homepage.getTextfromHomePage();
		System.out.println(actual + " actual");
		Assert.assertEquals(actual, expected);
	}
@Test(priority = 1)
	public void Error_Login() {
		logger.info("Entering only user name without password to check error message");
		String expected = "Please enter your password.";
		PropertiesUtility propertiesUtility = new PropertiesUtility();
		propertiesUtility.loadFile("dataProperties");
		String username = propertiesUtility.getPropertyValue("valid.username");
	
		Login_Error error = new Login_Error(driver);
		error.enterUserName(username);
		fluentWait();
		error.clickLogin();
		String actual = error.getErrorMessage();
		Assert.assertEquals(actual, expected); 
	
}
	
@Test(priority = 2)
public void CheckRememberMe() throws InterruptedException {
	String expected = "ezhilnila26@gmail.com";
	PropertiesUtility propertiesUtility = new PropertiesUtility();
	propertiesUtility.loadFile("dataProperties");
	String username = propertiesUtility.getPropertyValue("valid.username");
	String password = propertiesUtility.getPropertyValue("valid.password");
	Check_RememberMe rememberMe = new Check_RememberMe(driver);
	rememberMe.enterUserName(username);
	rememberMe.enterPassword(password);
	rememberMe.clickonRememberMe();
	driver = rememberMe.clickLogin();
	
	rememberMe.findUserMenu();
	rememberMe.selectLogOut();
	Thread.sleep(5000);
	String actual = rememberMe.checkUserNameField();
	Assert.assertEquals(actual, expected);
}

@Test(priority = 3)
public void ForgotPassword() throws InterruptedException {
	String expected = "Return to Login";
	PropertiesUtility propertiesUtility = new PropertiesUtility();
	propertiesUtility.loadFile("dataProperties");
	String username = propertiesUtility.getPropertyValue("valid.username");
	Forgot_Password forgotpwd = new Forgot_Password(driver);
	forgotpwd.clickOnForgotPasswordLink();
	forgotpwd.sendUserName(username);
	forgotpwd.clickOnContinue();
	Thread.sleep(5000);
	String actual = forgotpwd.checkMessage();
	Assert.assertEquals(actual, expected);
	
}

@Test(priority = 4)
public void ValidateErrorMessage() {
	String expected = "Please check your username and password. If you still can't log in, contact your Salesforce administrator.";
	PropertiesUtility propertiesUtility = new PropertiesUtility();
	propertiesUtility.loadFile("dataProperties");
	String invalidusername = propertiesUtility.getPropertyValue("invalid.username");
	String invalidpassword = propertiesUtility.getPropertyValue("invalid.password");
	ValidateLoginErrorMessage em = new ValidateLoginErrorMessage(driver);
	em.wrongUserName(invalidusername);
	em.wrongPassword(invalidpassword);
	em.clickonLogin();
	
	String actual = em.errorMessage();
	Assert.assertEquals(expected, actual);
}
}
