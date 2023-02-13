package CreateAccount;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateNewView {
	
	public static void newView() throws InterruptedException {
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
		WebElement createNew = driver.findElement(By.xpath("//a[contains(text(),'Create New View')]"));
		createNew.click();
		
		WebElement accName = driver.findElement(By.id("fname"));
		accName.sendKeys("Kumar");
		
		WebElement uniquName = driver.findElement(By.id("devname"));
		uniquName.sendKeys("GowriK");
		
		WebElement save = driver.findElement(By.xpath("//body[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[2]/div[2]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/input[1]"));
		save.click();
		
	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		newView();
	}

}
