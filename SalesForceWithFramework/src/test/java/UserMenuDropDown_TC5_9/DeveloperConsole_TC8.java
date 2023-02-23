package UserMenuDropDown_TC5_9;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Reusable.BaseClass;
import io.github.bonigarcia.wdm.WebDriverManager;
@Listeners(com.utility.TestEventListenersUtility.class)
public class DeveloperConsole_TC8 extends BaseClass{
	@Test
	public static void dConsole() throws InterruptedException, IOException{
	login();
	logger.info("now in homepage");
	extentreport.logTestInfo("now in homepage");
	
	By umenu = By.id("userNav");
	WebElement userMenu = driver.findElement(umenu);
	clickElement(userMenu,"Clicked on user menu");
	
	WebElement devConsole = driver.findElement(By.xpath("//a[contains(text(),'Developer Console')]"));
	clickElement(devConsole,"clicked developer console");
	
	driver.switchTo().window(driver.getWindowHandle()); 
	Thread.sleep(3000);
	}
}
