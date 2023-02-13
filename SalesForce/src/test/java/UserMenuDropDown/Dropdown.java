package UserMenuDropDown;

import java.awt.Desktop.Action;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import Reusable.ReusableMed;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Dropdown extends ReusableMed {
	@Test
	public static void dropdownmenu() throws InterruptedException {
	login();
	
	By umenu = By.id("userNav");
	WebElement userMenu = driver.findElement(umenu);
	click(userMenu);
	
	WebElement userList = driver.findElement(By.id("userNav-menuItems"));
	String list = userList.getText();
	System.out.println("User Menu drop down "+list);
	close();
	}
	@Test
	public static void my_profile() throws InterruptedException {
		//dropDownMenu();
		
		login();
		
		By umenu = By.id("userNav");
		WebElement userMenu = driver.findElement(umenu);
		click(userMenu);
		
		WebElement userList = driver.findElement(By.id("userNav-menuItems"));
		String list = userList.getText();
		System.out.println("User Menu drop down "+list);
		//driver.close();
		waiting();
		WebElement profile = driver.findElement(By.xpath("//a[contains(text(),'My Profile')]"));
		click(profile);
		
		WebElement lnameb4edit = driver.findElement(By.id("tailBreadcrumbNode"));
		String expected = lnameb4edit.getText();
		WebElement edit = driver.findElement(By.xpath("//*[@id=\"chatterTab\"]/div[2]/div[2]/div[1]/h3/div/div/a/img"));
		Thread.sleep(5000);
		click(edit);
		
		Thread.sleep(5000);
		System.out.println("After clicking the edit button");
		//driver.switchTo().activeElement();//("contactInfoContentId")
		driver.switchTo().frame("contactInfoContentId");
		
		System.out.println("after switching to frame");
		WebElement about =driver.findElement(By.xpath("//*[@id=\"aboutTab\"]/a"));
		click(about);
		
		WebElement lname = driver.findElement(By.id("lastName"));
		lname.clear();
		lname.sendKeys("Oviya");
		
		WebElement save = driver.findElement(By.xpath("//*[@id=\"TabPanel\"]/div/div[2]/form/div/input[1]"));
		click(save);
		
		WebElement afteredit =driver.findElement(By.id("tailBreadcrumbNode"));
		String actual = afteredit.getText();
		if(expected.equalsIgnoreCase(actual)) {
			System.out.println("Last name not edited. So testcase failed");
		}
		else
			System.out.println("name edited");
		close();
	}
	@Test
	public static void post() throws InterruptedException {
		login();
		
		By umenu = By.id("userNav");
		WebElement userMenu = driver.findElement(umenu);
		click(userMenu);
		
		WebElement userList = driver.findElement(By.id("userNav-menuItems"));
		String list = userList.getText();
		System.out.println("User Menu drop down "+list);
		//driver.close();
		waiting();
		WebElement profile = driver.findElement(By.xpath("//a[contains(text(),'My Profile')]"));
		click(profile);
		waiting();
		//Click on post and send some texts
//		WebElement post = driver.findElement(By.xpath("//*[@id='publisherAttachTextPost']/span[contains(text(),\"Post\")]"));
//		post.click();
//		System.out.println(post.isDisplayed());
//			
//		System.out.println(post.getText());
//		driver.switchTo().frame(0);
//		System.out.println("moved to frame");
//		Thread.sleep(5000);
//		WebElement text = driver.findElement(By.xpath("//body[contains(text(),'Share an update, @mention someone...')]"));
//		text.sendKeys("This is first text");
//		//share button is out of frame. so switching to paent frame again
//		driver.switchTo().parentFrame();
//		Thread.sleep(5000);
//		WebElement share = driver.findElement(By.xpath("//input[@id='publishersharebutton']"));
//		share.click();
		
		//Click on file link
		Thread.sleep(5000);
		WebElement clickfile = driver.findElement(By.xpath("//span[contains(text(),'File')]"));
		clickfile.click();
		
		WebElement uploadFile = driver.findElement(By.id("chatterUploadFileAction"));
		uploadFile.click();
		Thread.sleep(3000);
		//WebElement chooseFile = driver.findElement(By.xpath("//input[@id='chatterFile']"));
		JavascriptExecutor executor =(JavascriptExecutor)driver;
		//executor.executeScript("arguments[0].click;", chooseFile);
		//used java script executor to click on choosefile. can use above line or below line.
		executor.executeScript("document.getElementById('chatterFile').click();");
		
		
		
	}
	@Test
	public static void uploadPhoto() throws InterruptedException {
		login();
		
		By umenu = By.id("userNav");
		WebElement userMenu = driver.findElement(umenu);
		userMenu.click();
		
//		WebElement userList = driver.findElement(By.id("userNav-menuItems"));
//		String list = userList.getText();
//		System.out.println("User Menu drop down "+list);
		//driver.close();
		waiting();
		WebElement profile = driver.findElement(By.xpath("//a[contains(text(),'My Profile')]"));//a
		profile.click();
		waiting();
		
		//Mouse over on the add photo. Using actions class to move the mouse
		Actions action = new Actions(driver);
		WebElement photo = driver.findElement(By.id("displayBadge"));//photoSection  displayBadge
	
		//action.moveToElement(photo).build().perform();
		//System.out.println(photo.isEnabled());
		//waiting();
		Thread.sleep(5000);
		photo.click();
		
		Thread.sleep(3000);
		WebElement moveToFrame = driver.findElement(By.id("uploadPhotoContentId"));//uploadPhotoContentId
		driver.switchTo().frame(moveToFrame);
		System.out.println("first clicked");
		WebElement uploadPhoto = driver.findElement(By.xpath("//form[@id='j_id0:uploadFileForm']/input[2]"));////form[@id='j_id0:uploadFileForm']/input[2]
		System.out.println(uploadPhoto.isEnabled());
		Thread.sleep(1000);
		System.out.println("2nd clicked");
		//uploadPhoto.click();
		System.out.println("clicked");
		uploadPhoto.sendKeys("/Users/ku2e8te/Desktop/Ovi/chinnu.jpg⁩");//Users/⁨ku2e8te⁩/⁨Downloads⁩/my-passport-photo.jpg//$HOME/⁨Users/⁨ku2e8te/⁨Desktop/⁨Ovi/chinnu.jpg⁩
		Thread.sleep(1000);///Users/ku2e8te/Desktop/Ovi
		
		WebElement save = driver.findElement(By.id("j_id0:uploadFileForm:uploadBtn"));
		Thread.sleep(1000);
		click(save);
//		JavascriptExecutor executor = (JavascriptExecutor)driver;
//		executor.executeScript("document.getElementById('photoSection').click();");
	}
	
}
