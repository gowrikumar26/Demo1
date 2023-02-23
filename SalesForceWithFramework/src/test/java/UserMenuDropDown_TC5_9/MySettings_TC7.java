package UserMenuDropDown_TC5_9;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Reusable.BaseClass;
import io.github.bonigarcia.wdm.WebDriverManager;
@Listeners(com.utility.TestEventListenersUtility.class)
public class MySettings_TC7 extends BaseClass{
	@Test
	public static void publiclink() throws InterruptedException, IOException {
		login();
		userMenuDropDown();
		
		WebElement settings = driver.findElement(By.xpath("//a[contains(text(),'My Settings')]"));
		clickElement(settings,"");
		//waiting();
		
		WebElement personal = driver.findElement(By.id("PersonalInfo_font"));
		clickElement(personal,"");
		
		Thread.sleep(3000);
		WebElement history = driver.findElement(By.id("LoginHistory_font"));
		history.click();
		
		WebElement link = driver.findElement(By.xpath("//div[@id='RelatedUserLoginHistoryList_body']/div[1]/a"));
		link.click();
		
		}
	
	@Test
		public static void display() throws InterruptedException, IOException {
			login();
			userMenuDropDown();
			
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
			
			Select select1 = new Select(availableTab);
			select1.selectByVisibleText("Reports");
			WebElement add = driver.findElement(By.id("duel_select_0_right"));
			add.click();
			logger.info("Reports tab added and available in top of salesforce page");

		}
		
	@Test
		public static void emailUpdate() throws InterruptedException, IOException {
			login();
			userMenuDropDown();
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

	@Test
		public static void reminder() throws InterruptedException, IOException {
			login();
			userMenuDropDown();
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
}
