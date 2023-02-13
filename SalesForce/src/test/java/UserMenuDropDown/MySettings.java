package UserMenuDropDown;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import Reusable.ReusableMed;
import io.github.bonigarcia.wdm.WebDriverManager;

public class MySettings extends ReusableMed{
	
	public static void publiclink() throws InterruptedException {
		login();
		
		By umenu = By.id("userNav");
		WebElement userMenu = driver.findElement(umenu);
		click(userMenu);
		
		WebElement userList = driver.findElement(By.id("userNav-menuItems"));
		String list = userList.getText();
		System.out.println("User Menu drop down "+list);
		WebElement settings = driver.findElement(By.xpath("//a[contains(text(),'My Settings')]"));
		click(settings);
		waiting();
		WebElement personal = driver.findElement(By.id("PersonalInfo_font"));
		click(personal);
		
		WebElement history = driver.findElement(By.id("LoginHistory_font"));
		history.click();
		
		WebElement link = driver.findElement(By.xpath("//div[@id='RelatedUserLoginHistoryList_body']/div[1]/a"));
		link.click();
		//driver.close();
		
		}
		public static void display() throws InterruptedException {
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
			
			By umenu = By.id("userNav");
			WebElement userMenu = driver.findElement(umenu);
			userMenu.click();
			
			WebElement userList = driver.findElement(By.id("userNav-menuItems"));
			String list = userList.getText();
			System.out.println("User Menu drop down "+list);
			WebElement settings = driver.findElement(By.xpath("//a[contains(text(),'My Settings')]"));
			settings.click();
			Thread.sleep(3000);
			WebElement dplay = driver.findElement(By.id("DisplayAndLayout_font"));
			dplay.click();
			WebElement customize = driver.findElement(By.id("CustomizeTabs_font"));
			customize.click();
			Thread.sleep(3000);
			WebElement tab = driver.findElement(By.id("p4"));
			tab.click();
			Select select = new Select(tab);
			select.selectByVisibleText("Salesforce Chatter");
			//WebElement list = driver.findElement(By.xpath(""))
			WebElement availableTab = driver.findElement(By.id("duel_select_0"));
			//availableTab.;
			Select select1 = new Select(availableTab);
			select1.selectByVisibleText("Reports");
			WebElement add = driver.findElement(By.id("duel_select_0_right"));
			add.click();
		}
		
		public static void emailUpdate() throws InterruptedException {
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
			
			By umenu = By.id("userNav");
			WebElement userMenu = driver.findElement(umenu);
			userMenu.click();
			
			WebElement userList = driver.findElement(By.id("userNav-menuItems"));
			String list = userList.getText();
			System.out.println("User Menu drop down "+list);
			WebElement settings = driver.findElement(By.xpath("//a[contains(text(),'My Settings')]"));
			settings.click();

			Thread.sleep(3000);

			WebElement email = driver.findElement(By.id("EmailSetup"));
			email.click();
			WebElement emailSetup = driver.findElement(By.id("EmailSettings_font"));
			emailSetup.click();

			Thread.sleep(2000);
			WebElement emailName = driver.findElement(By.id("sender_name"));
			emailName.clear();
			emailName.sendKeys("Kevuri");

			WebElement emailAddr = driver.findElement(By.id("sender_email"));
			emailAddr.clear();
			emailAddr.sendKeys("Kevuri@yahoo.com");

			WebElement autoBCC = driver.findElement(By.id("auto_bcc1"));
			autoBCC.click();

			Thread.sleep(2000);
			
			WebElement save = driver.findElement(By.name("save"));
			save.click();
			
			Thread.sleep(2000);

			driver.switchTo().alert().accept();
		}

		public static void reminder() throws InterruptedException {
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
			
			By umenu = By.id("userNav");
			WebElement userMenu = driver.findElement(umenu);
			userMenu.click();
			
			WebElement userList = driver.findElement(By.id("userNav-menuItems"));
			String list = userList.getText();
			System.out.println("User Menu drop down "+list);
			WebElement settings = driver.findElement(By.xpath("//a[contains(text(),'My Settings')]"));
			settings.click();

			Thread.sleep(3000);

			WebElement cal = driver.findElement(By.id("CalendarAndReminders_font"));
			cal.click();
			WebElement actrem = driver.findElement(By.id("Reminders_font"));
			actrem.click();

			Thread.sleep(2000);
			WebElement open= driver.findElement(By.id("testbtn"));
			open.click();
			
		}
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//publiclink();
		//display();
		//emailUpdate();
		reminder(); 
	}

}
