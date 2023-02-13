package AccountReport;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AccReport {
	public static void clickOnAcc() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://developer.salesforce.com/signup");//https://login.salesforce.com/
		Thread.sleep(3000);
		By login = By.linkText("Log in");
		WebElement log = driver.findElement(login);
		log.click();
		By uname = By.id("username");
		WebElement userName = driver.findElement(uname);
		userName.sendKeys("ezhilnila26@gmail.com");
		
		By pword = By.id("password");
		WebElement password = driver.findElement(pword);
		password.sendKeys("kumaravadivel26");
		
		By login1 = By.id("Login");
		WebElement logn = driver.findElement(login1);
		logn.click();
		
		WebElement clickAcc = driver.findElement(By.xpath("//a[contains(text(),'Accounts')]"));
		clickAcc.click();
		
		Thread.sleep(4000);
		
		driver.switchTo().activeElement();
		Thread.sleep(2000);
		WebElement frameClose = driver.findElement(By.id("tryLexDialogX"));
		frameClose.click();
		Thread.sleep(2000);
		
		WebElement accActivity = driver.findElement(By.xpath("//a[contains(text(),'Accounts with last activity > 30 days')]"));
		accActivity.click();
		Thread.sleep(2000);
		WebElement dateField = driver.findElement(By.id("ext-gen20"));
		dateField.click();//Last Modified Date
		
//		WebElement lastAct = driver.findElement(By.xpath("//div[@id=\"ext-gen269\"]/div[4]"));
//		lastAct.click();
		
		WebElement date = driver.findElement(By.id("ext-gen152"));
		date.click();
		
		
	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		clickOnAcc();
	}

}
