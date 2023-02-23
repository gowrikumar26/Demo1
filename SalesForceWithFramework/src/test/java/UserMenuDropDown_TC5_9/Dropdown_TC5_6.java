package UserMenuDropDown_TC5_9;

import java.awt.AWTException;
import java.awt.Desktop.Action;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Reusable.BaseClass;
import io.github.bonigarcia.wdm.WebDriverManager;

@Listeners(com.utility.TestEventListenersUtility.class)
public class Dropdown_TC5_6 extends BaseClass {
	
	@Test
	public static void dropdownMenu_TC5() throws InterruptedException, IOException {
	login();
	clickOnUserMenu();
	
	WebElement userList = driver.findElement(By.id("userNav-menuItems"));
	String list = userList.getText();
	logger.info("User Menu drop down");
	extentreport.logTestInfo("User Menu drop down from extent report "+list);
	System.out.println(list );
	
	}

	
	@Test
	public static void myProfile_TC6() throws InterruptedException, IOException {
		login();
		clickOnUserMenu();
		
		fluentWait();
		WebElement profile = driver.findElement(By.xpath("//a[contains(text(),'My Profile')]"));
		clickElement(profile, "Clicked profile");
		
		fluentWait();
		WebElement lnameb4edit = driver.findElement(By.id("tailBreadcrumbNode"));
		String expected = lnameb4edit.getText();
		
		WebElement edit = driver.findElement(By.xpath("//*[@id=\"chatterTab\"]/div[2]/div[2]/div[1]/h3/div/div/a/img"));
		//fluentWait();
		Thread.sleep(5000);
		clickElement(edit,"edit");
		
		//Thread.sleep(5000);
		fluentWait();
		driver.switchTo().frame("contactInfoContentId");
		Thread.sleep(3000);
		System.out.println("after switching to frame");
		WebElement about =driver.findElement(By.xpath("//*[@id=\"aboutTab\"]/a"));
		clickElement(about,"about");
		
		fluentWait();
		WebElement lname = driver.findElement(By.id("lastName"));
		lname.clear();
		lname.sendKeys("Oviya");
		
		WebElement save = driver.findElement(By.xpath("//*[@id=\"TabPanel\"]/div/div[2]/form/div/input[1]"));
		clickElement(save,"save");
		
		fluentWait();
		WebElement afteredit =driver.findElement(By.id("tailBreadcrumbNode"));
		String actual = afteredit.getText();
		validation(expected,actual);
		
	}
	@Test
	public static void post() throws InterruptedException, IOException {
		login();
		clickOnUserMenu();
		
		fluentWait();
		WebElement profile = driver.findElement(By.xpath("//a[contains(text(),'My Profile')]"));
		clickElement(profile, "profile");
		fluentWait();
		//Click on post and send some texts
		
		WebElement post = driver.findElement(By.xpath("//*[@id='publisherAttachTextPost']/span[contains(text(),\"Post\")]"));
		//waiting();
		waitUntilElementVisible(post,"post");
		post.click();
		//System.out.println(post.isDisplayed());
			
		//System.out.println(post.getText());
		driver.switchTo().frame(0);
		logger.info("moved to frame");
		
		Thread.sleep(5000);
		WebElement text = driver.findElement(By.xpath("//body[contains(text(),'Share an update, @mention someone...')]"));
		text.sendKeys("This is first text");
		//share button is out of frame. so switching to parent frame again
		
		driver.switchTo().parentFrame();
		Thread.sleep(5000);
		WebElement share = driver.findElement(By.xpath("//input[@id='publishersharebutton']"));
		share.click();
	}
	
	@Test
	public static void uploadingFile() throws InterruptedException, AWTException, IOException {
		//file is not uploading 
		login();
		clickOnUserMenu();
		
		fluentWait();
		WebElement profile = driver.findElement(By.xpath("//a[contains(text(),'My Profile')]"));
		clickElement(profile, "Clicked profile");
		fluentWait();
		
		//Click on file link
		Thread.sleep(5000);
		WebElement clickfile = driver.findElement(By.xpath("//span[contains(text(),'File')]"));
		clickfile.click();
		
		Thread.sleep(3000);
		WebElement uploadFile = driver.findElement(By.id("chatterUploadFileAction"));
		uploadFile.click();
		Thread.sleep(3000);
		WebElement chooseFile = driver.findElement(By.id("chatterFile"));
		chooseFile.sendKeys("/Users/ku2e8te/Desktop/uploadfile.csv");		
		Thread.sleep(5000);
				
		WebElement share = driver.findElement(By.id("publishersharebutton"));
		share.click();
				
	}
	@Test
	public static void uploadPhoto() throws InterruptedException, IOException {
		login();
		clickOnUserMenu();
		
		fluentWait();
		WebElement profile = driver.findElement(By.xpath("//a[contains(text(),'My Profile')]"));
		profile.click();
		fluentWait();
		
		//Mouse over on the add photo. Using actions class to move the mouse
		Actions action = new Actions(driver);
		WebElement photo = driver.findElement(By.id("displayBadge"));//photoSection
	
		action.moveToElement(photo).build().perform();
		System.out.println(photo.isEnabled());
		//Thread.sleep(8000);
		//waiting();

		Thread.sleep(8000);
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("document.getElementById('uploadLink').click();");
		Thread.sleep(5000);
		WebElement frame2 = driver.findElement(By.xpath("//iframe[@id='uploadPhotoContentId']"));
		driver.switchTo().frame(frame2);
		Thread.sleep(3000);
		//System.out.print(driver.getTitle());
		WebElement choosePhoto = driver.findElement(By.xpath("//form[@id='j_id0:uploadFileForm']/input[2]"));
		choosePhoto.sendKeys("/Users/ku2e8te/Downloads/IMG-20150130-WA0036.jpg");
		Thread.sleep(5000);
		WebElement save = driver.findElement(By.id("j_id0:uploadFileForm:uploadBtn"));//j_id0:uploadFileForm:uploadBtn
		clickElement(save,"");//j_id0:j_id7:save
		Thread.sleep(3000);
		
		WebElement finalSave = driver.findElement(By.id("j_id0:j_id7:save"));//j_id0:uploadFileForm:uploadBtn
		clickElement(finalSave, "finalSave");
		Thread.sleep(3000);
	}

}
