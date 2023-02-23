package Reusable;
import java.io.File;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;
import com.utility.PropertiesUtility;

import io.github.bonigarcia.wdm.WebDriverManager;
import com.utility.*;

public class BaseClass {
	
	protected static WebDriver driver = null;
	protected static Logger logger = null;
	protected static ExtendReportUtility extentreport = ExtendReportUtility.getInstance();
	protected static WebDriverWait wait = null;
	@BeforeTest
	public void setUpBeforeTest() {
		//extentreport.logTestInfo("before test method has started");
		
		logger = LogManager.getLogger(BaseClass.class.getName());
		System.out.println("Inside @BeforeTest method");
	}

	@BeforeMethod
	@Parameters("browsername")
	public void login(@Optional("chromedriver")String browser,Method method) throws IOException {
		logger.info("started testscript : "+ method.getName());
//		FileInputStream fis = new FileInputStream(new File(curDir + "/src/test/resources/data.properties"));
//		Properties ob = new Properties();
//		ob.load(fis);
		
		//calling startSingleTestReport method 
		extentreport.startSingleTestReport("testcase");
//		extentreport.logTestInfo("started testscript name" + method.getName());
		
		//Here taking url link from propertiesUtility file from utility package. 
		PropertiesUtility propertiesUtility = new PropertiesUtility();
		propertiesUtility.loadFile("dataProperties");
		String url = PropertiesUtility.readPropertyData("url");

		
		getDriver(browser);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(url);// here link is passing through parameters from testng.xml
		
	}	
	
	@AfterMethod
	public void logOutSF() throws IOException  {
		logger.info("closing the browser");
		if(driver != null) {
			driver.quit();
			}
	}
	
	public void goToUrl(String url) {
		logger.info("going to the url" + url);
		driver.get(url);// here link is passing through parameters from testng.xml
	}
	
	public WebDriver returnDriverInstance() {
		return driver;
	}
	
	public static void validation(String expected, String actual) {
		
		Assert.assertEquals(actual, expected);
	}
	
	public static void login() throws IOException {
		
		String validUserName = PropertiesUtility.readPropertyData("valid.username");
		String validPword = PropertiesUtility.readPropertyData("valid.password");
		
		By uname = By.id("username");
		WebElement username = driver.findElement(uname);
		enter_Credentials(username, validUserName, "UserName");
		
		By pword = By.id("password");
		WebElement password = driver.findElement(pword);
		enter_Credentials(password, validPword, "Password");
		
		By login = By.id("Login");
		WebElement logn = driver.findElement(login);
		clickElement(logn,"login Button");
	}
	
	public static void clickOnUserMenu() {
		By umenu = By.id("userNav");
		WebElement userMenu = driver.findElement(umenu);
		clickElement(userMenu,"Clicked on user menu");
	}
	

	public static void clickOnOpportunities() {
		
		WebElement opp = driver.findElement(By.xpath("//li[@id='Opportunity_Tab']/a[contains(text(),'Opportunities')]"));
		clickElement(opp,"Opportunities");
		//waitUntilElementVisible(opp,"Opportunities");
	}
	
	public static void closeAddPage()  {
		
		driver.switchTo().activeElement();
		
		WebElement frameClose = driver.findElement(By.id("tryLexDialogX"));
		frameClose.click();
	
	}
	
	public static void fluentWait() {
		FluentWait waitforElement = new FluentWait(driver);
		waitforElement.withTimeout(40, TimeUnit.SECONDS);
		waitforElement.pollingEvery(2, TimeUnit.SECONDS);
	}
	
	public static void waitUntilElementVisible(WebElement element, String objName) {
		logger.info("Waiting for an Web element "+  objName + " for its visiblity");
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(element));
		
		//driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
	}

	public static void enter_Credentials(WebElement element, String userName, String name ) {
		//useProperties(userName);
		if(element.isDisplayed()) {
			element.clear();
			element.sendKeys(userName);
			}
		else
			logger.info(name + " Webelement is not displayed");
	}
	
	public static void clickElement(WebElement element, String objName) {
		if(element.isDisplayed()) {
			element.click();
			logger.info("pass : " + objName + " element clicked");
			extentreport.logTestInfo("pass : " + objName + " element clicked");
			}else
				
				logger.info("fail : " + objName + "element not displayed");
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
	public static void userMenuDropDown() {
		By umenu = By.id("userNav");
		WebElement userMenu = driver.findElement(umenu);
		clickElement(userMenu, "UserMenu");
	}
	@Test
	public static String getScreenshotOfThePage(WebDriver driver)  {
		String date = new SimpleDateFormat("yyyy_mm_dd_hh_mm").format(new Timestamp(System.currentTimeMillis()));
		//String curDir = System.getProperty("user.dir");
		TakesScreenshot screenshot=(TakesScreenshot)driver;
		File imageFile = screenshot.getScreenshotAs(OutputType.FILE);
		File destFile = new File(Constants.SCREENSHOTS_DIRECTORY_PATH+date+".png");
		try {
			FileHandler.copy(imageFile, destFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("captured");
		return destFile.getAbsolutePath();
	}
	
}
