package com.sf.StepDefinition;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import com.pages.forgotpasswordpage.Forgot_Password;
import com.pages.home.HomePage;
import com.pages.login.Check_RememberMe;
import com.pages.login.Login_Error;
import com.pages.login.ValidateLoginErrorMessage;
import com.pages.login.loginPage;
import com.utility.PropertiesUtility;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StepForSF {
	

	WebDriver driver;
	loginPage loginpage;
	HomePage home;
	Login_Error loginError;
	Check_RememberMe rememberMe;
	Forgot_Password forgotPassword;
	ValidateLoginErrorMessage loginErrorMessage;
	protected PropertiesUtility propertiesUtility = null;
	
	@Before
	public void setUp() {
		this.propertiesUtility = new PropertiesUtility();
		propertiesUtility.loadFile("dataProperties");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		rememberMe = new Check_RememberMe(driver);
		forgotPassword = new Forgot_Password(driver);
		loginErrorMessage = new ValidateLoginErrorMessage(driver);
	}
	
	@After
	public void tearDown() {
		driver.close();
	}
	
	@Given("User open Salesforce application")
	public void user_open_salesforce_application() {
		driver.manage().window().maximize();
		driver.get("https://login.salesforce.com/");
	}
	
	@When("user on {string}")
	
	public void user_on(String page) {

		switch(page) {
		
		case "login" : loginpage = new loginPage(driver);
		//System.out.println("in login page");
						break;
						
		case "home" : home = new HomePage(driver);
						break;
						
		case "loginErrorPage" : loginError = new Login_Error(driver);
							break;
							
		default:
			System.out.println("Please enter valid page  - ");
		}
	}

	@When("enter valid {string}")
	public void enter_valid(String userName) throws IOException {//,String login, and {string} 
		String uName = this.propertiesUtility.readPropertyData(userName);
		
		loginpage.enterUserName(uName );
	
	}

	@When("click the login button")
	public void click_the_login_button() {
		loginpage.clickLogin();
	}

	@Then("validate the {string}")
	public void validate_the_errormessage(String expected) throws IOException, InterruptedException {
		String actual = loginpage.getErrorMessage();
		Thread.sleep(4000);
		expected = this.propertiesUtility.readPropertyData(expected);
		Assert.assertEquals(actual, expected);
	}

	@When("enter valid {string} and {string}")
	public void enter_valid_username_and_password(String userName, String password) throws IOException {
		String uName = this.propertiesUtility.readPropertyData(userName);
		String pword = this.propertiesUtility.readPropertyData(password);
		loginpage.enterUserName(uName);
		loginpage.enterPassword(pword);
	}

	
	@When("select logout and click it")
	public void select_logout_and_click_it() {
		
		rememberMe.findUserMenu();
		rememberMe.selectLogOut();
	}


	@Then("validate the home page {string}")
	public void validate_the_home_page(String expected) throws IOException {
		String actual = home.getTextfromHomePage();
		expected = this.propertiesUtility.readPropertyData(expected);
		Assert.assertEquals(actual, expected);
	}
	
	@When("click the Remember me check box")
	public void click_the_remember_me_check_box() {
	
	  rememberMe.clickonRememberMe();
	}


	@Then("validate the loginPage with username {string}")
	public void validate_the_login_page_with_username(String expected) throws IOException, InterruptedException {
		 expected = this.propertiesUtility.readPropertyData(expected);
		 Thread.sleep(4000);
		 String actual = rememberMe.checkUserNameField();
		 Assert.assertEquals(actual, expected);
	}

	@When("click on forgot password")
	public void click_on_forgot_password() {
		forgotPassword.clickOnForgotPasswordLink();
	}

	@When("provide {string} in the username field")
	public void provide_in_the_username_field(String uname) throws IOException, InterruptedException {
		String userName = this.propertiesUtility.readPropertyData(uname);
		Thread.sleep(5000);
		forgotPassword.sendUserName(userName);
		forgotPassword.clickOnContinue();
	}

	@Then("validate the password reset message {string}")
	public void validate_the_password_reset_message(String message) throws IOException {
	    String actual = forgotPassword.checkMessage();
	    String expected = this.propertiesUtility.readPropertyData(message);
	    Assert.assertEquals(actual, expected);
	}


	@When("enter invalid {string} and {string}")
	public void enter_invalid_and(String invalidUname, String invalidPword) throws IOException {
	    String uname = this.propertiesUtility.readPropertyData(invalidUname);
	    String pword = this.propertiesUtility.readPropertyData(invalidPword);
	    System.out.println("invalid uname"+uname);
	    System.out.println("invalid pword"+pword);
	    loginErrorMessage.wrongUserName(uname);
	    loginErrorMessage.wrongPassword(pword);
	}


	
	@Then("validate the error message {string}")
	public void validate_the_error_message(String expected) throws IOException, InterruptedException {
		Thread.sleep(4000);
	    expected = this.propertiesUtility.readPropertyData(expected);
	    String actual = loginErrorMessage.errorMessage();
	    System.out.println("actual"+actual);
	    Assert.assertEquals(actual,expected);
	}


	
}
