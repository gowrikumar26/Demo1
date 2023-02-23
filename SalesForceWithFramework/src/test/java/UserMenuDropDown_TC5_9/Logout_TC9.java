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
public class Logout_TC9 extends BaseClass{
	
	@Test
	public static void logOutSF_TC9() throws IOException, InterruptedException  {
		String expected = "https://tekarch70-dev-ed.develop.my.salesforce.com/";
		login();
		clickOnUserMenu();
		
		WebElement logout = driver.findElement(By.xpath("//a[contains(text(),'Logout')]"));
		clickElement(logout,"logout");
		//waiting();
		Thread.sleep(4000);
		String actual = driver.getCurrentUrl();
		validation(expected, actual);
	}
}
