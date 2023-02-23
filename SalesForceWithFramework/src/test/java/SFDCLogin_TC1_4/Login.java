package SFDCLogin_TC1_4;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.utility.PropertiesUtility;

import Reusable.BaseClass;
import io.github.bonigarcia.wdm.WebDriverManager;
@Listeners(com.utility.TestEventListenersUtility.class)
public class Login extends BaseClass{
	
	@Test
	public static void loginSF_TC_2() throws IOException  {
		login();
		String expected ="Home";
		By home = By.xpath("//li[@id='home_Tab']/a");
		WebElement homeText = driver.findElement(home);
		
		String actual =	homeText.getText();
		
		logger.info("Expected webpage is : " + expected);
		logger.info("Actual webpage is : " + actual);
		//System.out.println("actual : " + actual );
		
		validation(expected, actual);
	}
	
	@Test
	
	public  void error_LoginTC_1() throws InterruptedException, IOException {
		String expected = "Please enter your password.";
		
		By uname = By.id("username");
		WebElement userName = driver.findElement(uname);
		enter_Credentials(userName,"ezhilnila26@gmail.com", "UserName");
		
		By login1 = By.id("Login");
		WebElement logn = driver.findElement(login1);
		clickElement(logn, "login button");

		By err = By.id("error");
		WebElement error = driver.findElement(err);
		String actual = error.getText();
		waitUntilElementVisible(error,"error message");
		validation(expected,actual);
		
	}

	@Test(priority = 2)
	public void checkRememberMe_TC_3() throws InterruptedException, IOException {
		String expected = "ezhilnila26@gmail.com";
		By uname = By.id("username");
		WebElement userName = driver.findElement(uname);
		enter_Credentials(userName,"ezhilnila26@gmail.com", "UserName");
		
		By pword = By.id("password");
		WebElement password = driver.findElement(pword);
		enter_Credentials(password, "kumaravadivel26", "Password");
		
		WebElement chkrememberme = driver.findElement(By.id("rememberUn"));
		waitUntilElementVisible(chkrememberme,"chkrememberme");
		chkrememberme.click();
			
		By login1 = By.id("Login");
		WebElement logn = driver.findElement(login1);
		clickElement(logn, "login button");
			
		//Thread.sleep(5000);
		By umenu = By.id("userNav");
		WebElement userMenu = driver.findElement(umenu);
		userMenu.click();
		waitUntilElementVisible(userMenu,"userMenu");
		WebElement logout = driver.findElement(By.xpath("//a[contains(text(),'Logout')]"));
		logout.click();
		//Thread.sleep(3000);
		
		WebElement chkUserName = driver.findElement(By.id("idcard-identity"));
		String actual = chkUserName.getText();
		
		waitUntilElementVisible(chkUserName,"UserName in the field");
		validation(expected,actual);
		
		
	}
	
	@Test(priority = 1)
	public static void forgot_Password_TC_4A() throws InterruptedException {
		String expected = "Return to Login";
		
		By uname = By.id("username");
		WebElement userName = driver.findElement(uname);
		enter_Credentials(userName,"ezhilnila26@gmail.com", "UserName");
		
		WebElement forgotpword = driver.findElement(By.id("forgot_password_link"));
		forgotpword.click();
		
		WebElement sendun = driver.findElement(By.id("un"));
		sendun.sendKeys("ezhilnila26@gmail.com");
		
		fluentWait();
		WebElement clickoncontinue = driver.findElement(By.id("continue"));
		clickElement(clickoncontinue, "Continue");
		
		WebElement message = driver.findElement(By.xpath("//a[contains(text(),'Return to Login')]"));
		String actual = message.getText();
		
		validation(expected,actual);
	}
	
	@Test(priority = 10)
	public static void login_error_msg_TC_4B() throws InterruptedException {
		String expected = "Please check your username and password. If you still can't log in, contact your Salesforce administrator.";

		By uname = By.id("username");
		WebElement userName = driver.findElement(uname);
		enter_Credentials(userName,"ezhilnila@gmail.com", "UserName");
		
		By pword = By.id("password");
		WebElement password = driver.findElement(pword);
		enter_Credentials(password,"kumar", "Password");
		
		By login1 = By.id("Login");
		WebElement logn = driver.findElement(login1);
		clickElement(logn,"clicked login button");
		
		fluentWait();
		WebElement errormsg = driver.findElement(By.id("error"));
		String actual = errormsg.getText();
		validation(expected,actual);
	}
	
}
