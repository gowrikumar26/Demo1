package com.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.pages.forgotpasswordpage.Forgot_Password;
import com.pages.home.HomePage;
import com.pages.login.Check_RememberMe;
import com.pages.login.Login_Error;
import com.pages.login.ValidateLoginErrorMessage;
import com.pages.login.loginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutomationTest {

	@Test
	public void Login_Script() throws InterruptedException {
		String expected = "Home";
		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://login.salesforce.com/");
		Thread.sleep(5000);
		loginPage loginpage = new loginPage(driver);
		loginpage.enterUserName("ezhilnila26@gmail.com");
		loginpage.enterPassword("kumaravadivel26");
		driver = loginpage.clickLogin();
		
		HomePage homepage = new HomePage(driver);
		String actual = homepage.getTextfromHomePage();
		Assert.assertEquals(actual, expected);
	}
	
	@Test
	public void Error_Login() throws InterruptedException {
		String expected = "Please enter your password.";
		
		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://login.salesforce.com/");
		Thread.sleep(5000);
		loginPage loginpage = new loginPage(driver);
		loginpage.enterUserName("ezhilnila26@gmail.com");
		driver = loginpage.clickLogin();
		
		Login_Error errormessage = new Login_Error(driver);
		String actual = errormessage.getErrorMessage();
		Assert.assertEquals(actual, expected); 
	}
	
	@Test
	public void CheckRememberMe() throws InterruptedException {
		String expected = "ezhilnila26@gmail.com";
		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://login.salesforce.com/");
		Thread.sleep(2000);
		Check_RememberMe rememberMe = new Check_RememberMe(driver);
		rememberMe.enterUserName("ezhilnila26@gmail.com");
		rememberMe.enterPassword("kumaravadivel26");
		rememberMe.clickonRememberMe();
		driver = rememberMe.clickLogin();
		rememberMe.findUserMenu();
		rememberMe.selectLogOut();
		
		Thread.sleep(2000);
		Check_RememberMe userNameText = new Check_RememberMe(driver);
		String actual = userNameText.checkUserNameField();
		Assert.assertEquals(actual, expected);
	}
	
	@Test
	public void ForgotPassword() throws InterruptedException {
		String expected = "Check Your Email";
		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://login.salesforce.com/");
		Thread.sleep(2000);
		Forgot_Password forgotpwd = new Forgot_Password(driver);
		forgotpwd.clickOnForgotPasswordLink();
		Thread.sleep(3000);
		forgotpwd.sendUserName("ezhilnila26@gmail.com");
		forgotpwd.clickOnContinue();
		Thread.sleep(3000);
		String actual = forgotpwd.checkMessage();
		Assert.assertEquals(actual, expected);
		
	}
	
	@Test
	public void ValidateErrorMessage() {
		String expected = "Please check your username and password. If you still can't log in, contact your Salesforce administrator.";
		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://login.salesforce.com/");
		
		ValidateLoginErrorMessage em = new ValidateLoginErrorMessage(driver);
		em.wrongUserName("ezhil");
		em.wrongPassword("kumar");
		em.clickonLogin();
		
		String actual = em.errorMessage();
		Assert.assertEquals(expected, actual);
	}
}
