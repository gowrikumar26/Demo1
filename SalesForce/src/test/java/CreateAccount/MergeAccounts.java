package CreateAccount;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeAccounts {
	public static void mergeAccount() throws InterruptedException {
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
		
		Thread.sleep(3000);
		driver.switchTo().activeElement();
		Thread.sleep(1000);

		WebElement frameClose = driver.findElement(By.id("tryLexDialogX"));
		frameClose.click();
		Thread.sleep(2000);
		
		Thread.sleep(2000);
		WebElement clickMerge = driver.findElement(By.xpath("//a[contains(text(),'Merge Accounts')]"));
		clickMerge.click();//
		
		Thread.sleep(2000);
		WebElement accName = driver.findElement(By.id("srch"));
		accName.sendKeys("un");
		Thread.sleep(2000);
		WebElement clickFind = driver.findElement(By.name("srchbutton"));
		clickFind.click();
		Thread.sleep(2000);
		WebElement clickNext = driver.findElement(By.xpath("//tbody/tr[1]/td[2]/form[1]/div[1]/div[2]/div[5]/div[1]/input[1]"));
		clickNext.click();
		
		WebElement clickOnMerge = driver.findElement(By.name("save"));
		clickOnMerge.click();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		driver.close();
		
	}
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		mergeAccount();
	}

}
