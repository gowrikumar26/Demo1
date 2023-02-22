package SFDCLogin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Reusable.ReusableMed;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Login extends ReusableMed{
	@Test
	public static void loginSF()  {
		
		
		login();
		
		close();
		
	}
	@Test
	public static void error_Login() throws InterruptedException {
		String expected = "Please enter your password.";
		getDriver("chromedriver");
		enterLoginPage();
		
		By uname = By.id("username");
		WebElement userName = driver.findElement(uname);
		enter_Credentials(userName,"ezhilnila26@gmail.com", "UserName");
		
		By login1 = By.id("Login");
		WebElement logn = driver.findElement(login1);
		click(logn);
		
		waiting();
		By err = By.id("error");
		WebElement error = driver.findElement(err);
		String actual = error.getText();
		
		if(expected.equals(actual)) {
			System.out.println("Testcase passed");
		}
		else
			System.out.println("Testcase failed");
//		Actions action = new Actions(driver);
//		action.moveToElement(log).build().perform();
		close();
	}

	@Test
	public static void check_Remember_Me() throws InterruptedException {
		getDriver("chromedriver");
		enterLoginPage();
		
		By uname = By.id("username");
		WebElement userName = driver.findElement(uname);
		enter_Credentials(userName,"ezhilnila26@gmail.com", "UserName");
		
		
		By pword = By.id("password");
		WebElement password = driver.findElement(pword);
		enter_Credentials(password,"kumaravadivel26", "Password");
		
		
		WebElement chkrememberme = driver.findElement(By.id("rememberUn"));
		
		if(chkrememberme.isSelected()) {
			By login1 = By.id("Login");
			WebElement logn = driver.findElement(login1);
			click(logn);
			System.out.println("chk is selected");
		}else 
			{
			chkrememberme.click();
			By login1 = By.id("Login");
			WebElement logn = driver.findElement(login1);
			click(logn);
			System.out.println("not selected");
		}
		
		waiting();
		By umenu = By.id("userNav");
		WebElement userMenu = driver.findElement(umenu);
		userMenu.click();
		
		WebElement logout = driver.findElement(By.xpath("//a[contains(text(),'Logout')]"));
		logout.click();
		
		Thread.sleep(5000);
		waiting();
		WebElement chkUserName = driver.findElement(By.xpath("//span[@id='idcard-identity']"));
		
		if(chkUserName.isDisplayed()) {
			System.out.println("User name is displayed");
		}
		else
			System.out.println("Testcase failed");
		close();
	}
	
	@Test
	public static void forgot_Password() throws InterruptedException {
		getDriver("chromedriver");
		enterLoginPage();
		
		By uname = By.id("username");
		WebElement userName = driver.findElement(uname);
		enter_Credentials(userName,"ezhilnila26@gmail.com", "UserName");
		
		WebElement forgotpword = driver.findElement(By.id("forgot_password_link"));
		forgotpword.click();
		waiting();
		WebElement sendun = driver.findElement(By.id("un"));
		sendun.sendKeys("ezhilnila26");
		
		waiting();
		WebElement clickoncontinue = driver.findElement(By.id("continue"));
		click(clickoncontinue);
		close();
	}
	
	@Test
	public static void login_error_msg() throws InterruptedException {
		String expected = "Please check your username and password. If you still can't log in, contact your Salesforce administrator.";
		getDriver("chromedriver");
		enterLoginPage();
		
		By uname = By.id("username");
		WebElement userName = driver.findElement(uname);
		enter_Credentials(userName,"ezhilnila@gmail.com", "UserName");
		
		By pword = By.id("password");
		WebElement password = driver.findElement(pword);
		enter_Credentials(password,"kumar", "Password");
		
		By login1 = By.id("Login");
		WebElement logn = driver.findElement(login1);
		click(logn);
		
		waiting();
		WebElement errormsg = driver.findElement(By.id("error"));
		String actual = errormsg.getText();
		if(expected.equals(actual)) {
			System.out.println("Testcase passed");
		}
		else
			System.out.println("Testcase failed");
		close();
	}
	
}
