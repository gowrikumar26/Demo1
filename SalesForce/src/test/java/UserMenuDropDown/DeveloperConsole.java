package UserMenuDropDown;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import Reusable.ReusableMed;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DeveloperConsole extends ReusableMed{
	@Test
	public static void dConsole() throws InterruptedException{
		
	login();
	
	By umenu = By.id("userNav");
	WebElement userMenu = driver.findElement(umenu);
	click(userMenu);
	waiting();
	
	WebElement devConsole = driver.findElement(By.xpath("//a[contains(text(),'Developer Console')]"));
	click(devConsole);
	//String newWindow = driver.getWindowHandle();
	//System.out.println(newWindow);
	//waiting();
	Thread.sleep(5000);
	driver.switchTo().window(driver.getWindowHandle()); 
	//System.out.println(driver.getCurrentUrl());
//	driver.switchTo().parentFrame();
//	driver.close();
	driver.switchTo().activeElement();
	driver.close();
	}

}
