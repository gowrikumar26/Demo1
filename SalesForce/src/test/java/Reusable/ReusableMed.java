package Reusable;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ReusableMed {
	
	protected static WebDriver driver = null;
	
	@BeforeMethod
	
	public static void login() {
		getDriver("chromedriver");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://developer.salesforce.com/signup");//https://login.salesforce.com/
		
		By login = By.linkText("Log in");
		WebElement log = driver.findElement(login);
		click(log);
		
		By uname = By.id("username");
		WebElement userName = driver.findElement(uname);
		enter_Credentials(userName, "ezhilnila26@gmail.com", "UserName");
		
		By pword = By.id("password");
		WebElement password = driver.findElement(pword);
		enter_Credentials(password, "kumaravadivel26", "Password");
		
		By login1 = By.id("Login");
		WebElement logn = driver.findElement(login1);
		click(logn);
	}	
	public static void waiting() {
		FluentWait waitforElement = new FluentWait(driver);
		waitforElement.withTimeout(40, TimeUnit.SECONDS);
		waitforElement.pollingEvery(2, TimeUnit.SECONDS);
	}
	
	public static void enterLoginPage() {
		
		driver.get("https://developer.salesforce.com/signup");//https://login.salesforce.com/
		
		waiting();
		
		By login = By.linkText("Log in");
		WebElement log = driver.findElement(login);
		click(log);
	}
	
	public static void enter_Credentials(WebElement element, String text, String name ) {
		if(element.isDisplayed()) {
			element.clear();
			element.sendKeys(text);
			}
		else
			System.out.println(name + " Webelement is not displayed");
		}
	
	public static void click(WebElement element) {
		element.click();
	}
	
	@AfterMethod
	public static void close() {
		driver.quit();
	}
	
	public static void closeAddPage()  {
		
		driver.switchTo().activeElement();
		
		WebElement frameClose = driver.findElement(By.id("tryLexDialogX"));
		frameClose.click();
	
	}
	
	public static void clickOnOpportunities() {
		waiting();
		WebElement opp = driver.findElement(By.xpath("//li[@id='Opportunity_Tab']/a[contains(text(),'Opportunities')]"));
		click(opp);
	}
	
	
	public static void getDriver(String browserName) {
			
			switch(browserName){
			
			case "chromedriver" :		WebDriverManager.chromedriver().setup();
										driver= new ChromeDriver();
										driver.manage().window().maximize();
										break;
			case "firefoxdriver" :		
										WebDriverManager.firefoxdriver().setup();
										driver= new FirefoxDriver();
										driver.manage().window().maximize();
										break;
			case "safaridriver" :
										WebDriverManager.safaridriver().setup();
										driver = new SafariDriver();
										driver.manage().window().maximize();
										break;
			default :
				System.out.println("Not entered proper browsername ");
			}	
	}
}
