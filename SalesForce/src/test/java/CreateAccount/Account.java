package CreateAccount;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Account {

	public static void newAccount() throws InterruptedException {
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
		
		Thread.sleep(5000);
		WebElement clickNew = driver.findElement(By.name("new"));
		clickNew.click();
		
		WebElement accName = driver.findElement(By.id("acc2"));
		accName.sendKeys("GowriKumar");
		
		WebElement type = driver.findElement(By.id("acc6"));
		type.click();
		Select select = new Select(type);
		select.selectByVisibleText("Technology Partner");
		
		WebElement priority = driver.findElement(By.id("00NDn00000Sjnh0"));
		priority.click();
		Select select1 = new Select(priority);
		select1.selectByVisibleText("High");
		
		WebElement save = driver.findElement(By.name("save"));
		save.click();
		
	}
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub new 
		newAccount();
	}

}
