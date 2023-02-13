package Random_TC33_37;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import Reusable.ReusableMed;

public class RandomTestCases extends ReusableMed {

	@Test
	public static void checkingProfileName_TC33() {
		
		WebElement clickHome = driver.findElement(By.xpath("//a[contains(text(),'Home')]"));
		click(clickHome);
		
		WebElement clickName = driver.findElement(By.xpath("//div[@id='ptBody']/div/div[2]/span/h1/a[contains(text(),'Ezhil Oviya')]"));
		click(clickName);
		
		String nameURL = driver.getCurrentUrl();
		System.out.println("URL for name link " + nameURL );
		
		By umenu = By.id("userNav");
		WebElement userMenu = driver.findElement(umenu);
		click(userMenu);
		
		//WebElement userList = driver.findElement(By.id("userNav-menuItems"));
		//String list = userList.getText();
		
		waiting();
		WebElement profile = driver.findElement(By.xpath("//a[contains(text(),'My Profile')]"));
		click(profile);
		
		String profileURL = driver.getCurrentUrl();
		System.out.println("My Profile URL "+profileURL);
		
		if(nameURL.equals(profileURL)) {
			System.out.println("Both the URL are same. So the test case is passed");
		}
		else
		{
			System.out.println("URL is not match. so the test case failed");
		}
	}
	
	@Test
	public static void verifyEditedLastname_TC34() throws InterruptedException {
		
		WebElement clickHome = driver.findElement(By.xpath("//a[contains(text(),'Home')]"));
		click(clickHome);
		
		WebElement clickName = driver.findElement(By.xpath("//div[@id='ptBody']/div/div[2]/span/h1/a[contains(text(),'Ezhil Oviya')]"));
		click(clickName);
		
		//WebElement lnameb4edit = driver.findElement(By.id("tailBreadcrumbNode"));
		//String expected = lnameb4edit.getText();
		WebElement edit = driver.findElement(By.xpath("//*[@id=\"chatterTab\"]/div[2]/div[2]/div[1]/h3/div/div/a/img"));
		Thread.sleep(1000);
		click(edit);
		
		Thread.sleep(5000);
		driver.switchTo().frame("contactInfoContentId");
		
		WebElement about =driver.findElement(By.xpath("//*[@id=\"aboutTab\"]/a"));
		click(about);
		
		WebElement lname = driver.findElement(By.id("lastName"));
		lname.clear();
		lname.sendKeys("Ovi");
		
		WebElement save = driver.findElement(By.xpath("//*[@id=\"TabPanel\"]/div/div[2]/form/div/input[1]"));
		click(save);
		
		Thread.sleep(5000);
	}
	
	@Test
	public static void tabCustom_TC35() throws InterruptedException {
		
		waiting();
		
		WebElement plus = driver.findElement(By.xpath("//li[@id='AllTab_Tab']/a/img"));
		click(plus);
		
		WebElement customizeTabs = driver.findElement(By.xpath("//span[contains(text(),'Add Tabs to Your Default Display')]/following::input"));
		click(customizeTabs);
		
		WebElement selectTab = driver.findElement(By.id("duel_select_1"));//"//select[@id='duel_select_1']/option[4]"
		selectTab.click();
		Select select = new Select(selectTab);
		select.selectByVisibleText("Content");
		System.out.println("Content got selected");
		
		WebElement remove = driver.findElement(By.xpath("//a[@id='duel_select_0_left']/img"));
		remove.click();
		Thread.sleep(2000);
		
		System.out.println("Content removed");
		
		By save = By.xpath("//tbody/tr[1]/td[2]/input[1]");
		WebElement clickSave = driver.findElement(save);
		click(clickSave);
		
		By umenu = By.id("userNav");
		WebElement userMenu = driver.findElement(umenu);
		userMenu.click();
		
		Thread.sleep(3000);
		By logout = By.xpath("//a[contains(text(),'Logout')]");
		WebElement lo = driver.findElement(logout);
		lo.click();
		
		login();
		Thread.sleep(5000);
		
	}
	
	@Test
	public static void blockingCalender_TC36() throws InterruptedException {
		
		WebElement home = driver.findElement(By.xpath("//a[contains(text(),'Home')]"));
		click(home);
		
		WebElement date = driver.findElement(By.xpath("//div[@id='ptBody']/div/div[2]/span[2]/a"));
		click(date);
		
		WebElement newevent = driver.findElement(By.xpath("//div[@id='bCalDiv']/div/div[2]/span[6]/input"));
		click(newevent);
		
		closeAddPage();
		Thread.sleep(10000);
		WebElement subCombo = driver.findElement(By.xpath("//tbody/tr[2]/td[2]/div/a"));
		click(subCombo);
		waiting();
		
		//driver.getWindowHandles();
	
		
		Thread.sleep(3000);
		Set<String> childWindowHandles = driver.getWindowHandles();
	     Iterator<String> iterator = childWindowHandles.iterator();
	     iterator.hasNext();
	     System.out.println("im a child window");
	     
	     Thread.sleep(6000);
	     WebElement other = driver.findElement(By.xpath("//body/div[2]/ul/li[5]/a"));
	     click(other);
	     driver.switchTo().parentFrame();///Users/ku2e8te/git/repository
	     
	     WebElement endTime = driver.findElement(By.id("EndDateTime_time"));
	     click(endTime);
	     Thread.sleep(3000);
	     
	     WebElement save = driver.findElement(By.xpath("//body[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[2]/form[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/input[1]"));
	     click(save);
	     Thread.sleep(5000);
		
	}
}
