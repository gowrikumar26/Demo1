package Random_TC33_37;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Reusable.BaseClass;

@Listeners(com.utility.TestEventListenersUtility.class)
public class RandomTestCases extends BaseClass {

	@Test
	public static void checkingProfileName_TC33() throws IOException {
		login();
		WebElement clickHome = driver.findElement(By.xpath("//a[contains(text(),'Home')]"));
		clickElement(clickHome,"clickHome");
		
		WebElement clickName = driver.findElement(By.xpath("//div[@id='ptBody']/div/div[2]/span/h1/a[contains(text(),'Ezhil Oviya')]"));
		clickElement(clickName,"clickName");
		
		String nameURL = driver.getCurrentUrl();
		logger.info("URL for name link " + nameURL );
		
		clickOnUserMenu();
		
		//WebElement userList = driver.findElement(By.id("userNav-menuItems"));
		//String list = userList.getText();
		
		//waiting();
		WebElement profile = driver.findElement(By.xpath("//a[contains(text(),'My Profile')]"));
		clickElement(profile,"profile");
		
		String profileURL = driver.getCurrentUrl();
		logger.info("My Profile URL "+profileURL);
		
		validation(nameURL,profileURL);
	}
	
	@Test
	public static void verifyEditedLastname_TC34() throws InterruptedException, IOException {
		login();
		WebElement clickHome = driver.findElement(By.xpath("//a[contains(text(),'Home')]"));
		clickElement(clickHome,"clickHome");
		
		WebElement clickName = driver.findElement(By.xpath("//div[@id='ptBody']/div/div[2]/span/h1/a[contains(text(),'Ezhil Oviya')]"));
		clickElement(clickName,"clickName");
		
		//WebElement lnameb4edit = driver.findElement(By.id("tailBreadcrumbNode"));
		//String expected = lnameb4edit.getText();
		WebElement edit = driver.findElement(By.xpath("//*[@id=\"chatterTab\"]/div[2]/div[2]/div[1]/h3/div/div/a/img"));
		Thread.sleep(1000);
		clickElement(edit,"edit");
		
		Thread.sleep(5000);
		driver.switchTo().frame("contactInfoContentId");
		
		WebElement about =driver.findElement(By.xpath("//*[@id=\"aboutTab\"]/a"));
		clickElement(about,"about");
		
		WebElement lname = driver.findElement(By.id("lastName"));
		lname.clear();
		lname.sendKeys("Ovi");
		
		WebElement save = driver.findElement(By.xpath("//*[@id=\"TabPanel\"]/div/div[2]/form/div/input[1]"));
		clickElement(save,"save");
		
		Thread.sleep(5000);
	}
	
	@Test
	public static void tabCustom_TC35() throws InterruptedException, IOException {
		login();
		//waiting();
		
		WebElement plus = driver.findElement(By.xpath("//li[@id='AllTab_Tab']/a/img"));
		clickElement(plus,"plus");
		
		WebElement customizeTabs = driver.findElement(By.xpath("//span[contains(text(),'Add Tabs to Your Default Display')]/following::input"));
		clickElement(customizeTabs,"customizeTabs");
		
		WebElement selectTab = driver.findElement(By.id("duel_select_1"));//"//select[@id='duel_select_1']/option[4]"
		selectTab.click();
		Select select = new Select(selectTab);
		select.selectByVisibleText("Content");
		logger.info("Content got selected");
		
		WebElement remove = driver.findElement(By.xpath("//a[@id='duel_select_0_left']/img"));
		remove.click();
		Thread.sleep(2000);
		
		logger.info("Content removed");
		
		By save = By.xpath("//tbody/tr[1]/td[2]/input[1]");
		WebElement clickSave = driver.findElement(save);
		clickElement(clickSave,"clickSave");
		
		clickOnUserMenu();
		
		Thread.sleep(3000);
		By logout = By.xpath("//a[contains(text(),'Logout')]");
		WebElement lo = driver.findElement(logout);
		lo.click();
		
		login();
		Thread.sleep(5000);
		
	}
	
	@Test
	public static void blockingCalender_TC36() throws InterruptedException, IOException {
		login();
		WebElement home = driver.findElement(By.xpath("//a[contains(text(),'Home')]"));
		clickElement(home,"home");
		
		WebElement date = driver.findElement(By.xpath("//div[@id='ptBody']/div/div[2]/span[2]/a"));
		clickElement(date,"date");
		
		WebElement newevent = driver.findElement(By.xpath("//div[@id='bCalDiv']/div/div[2]/span[6]/input"));
		clickElement(newevent,"newevent");
		Thread.sleep(3000);
		closeAddPage();
		Thread.sleep(10000);
		WebElement subCombo = driver.findElement(By.xpath("//tbody/tr[2]/td[2]/div/a"));
		clickElement(subCombo,"subCombo");
		//waiting();
		String baseWindowHandle = driver.getWindowHandle();
		logger.info("id of parent window "+baseWindowHandle);
		
		Set<String> allWindowHandle = driver.getWindowHandles();
		for(String handle : allWindowHandle) {
			if(!baseWindowHandle.equals(handle)) {
				driver.switchTo().window(handle);
				break;
			}
		}
		driver.manage().window().maximize();
		
		
//		Thread.sleep(3000);
//		Set<String> childWindowHandles = driver.getWindowHandles();
//	     Iterator<String> iterator = childWindowHandles.iterator();
//	     iterator.hasNext();
//	     System.out.println("im a child window");
	     
	     Thread.sleep(5000);
	     WebElement other = driver.findElement(By.xpath("//body/div[2]/ul/li[5]/a[contains(text(),'Other')]"));
	     Thread.sleep(3000);
	     clickElement(other,"other");
	     logger.info("clicked other");
	     driver.switchTo().window(baseWindowHandle);///Users/ku2e8te/git/repository
	     
	     logger.info("moved parent window");
	     WebElement endTime = driver.findElement(By.id("EndDateTime_time"));
	     clickElement(endTime,"endTime");
	     Thread.sleep(3000);
	     
	     WebElement save = driver.findElement(By.xpath("//body[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[2]/form[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/input[1]"));
	     clickElement(save,"save");
	     Thread.sleep(5000);
		
	}
	
	@Test
	public static void TC37() throws InterruptedException, IOException {
		login();
		WebElement home = driver.findElement(By.xpath("//a[contains(text(),'Home')]"));
		clickElement(home,"home");
		
		WebElement date = driver.findElement(By.xpath("//div[@id='ptBody']/div/div[2]/span[2]/a"));
		clickElement(date,"date");
		
		System.out.println(Math.random());
		WebElement newevent = driver.findElement(By.xpath("//div[@id='bCalDiv']/div/div[2]/span[6]/input"));
		clickElement(newevent,"newevent");
		Thread.sleep(3000);
		closeAddPage();
		Thread.sleep(5000);
		WebElement subCombo = driver.findElement(By.xpath("//tbody/tr[2]/td[2]/div/a"));
		clickElement(subCombo,"subCombo");
		//waiting();
		String baseWindowHandle = driver.getWindowHandle();
		logger.info("id of parent window "+baseWindowHandle);
		
		Set<String> allWindowHandle = driver.getWindowHandles();
		for(String handle : allWindowHandle) {
			if(!baseWindowHandle.equals(handle)) {
				driver.switchTo().window(handle);
				break;
			}
		}
		driver.manage().window().maximize();
		
		
//		Thread.sleep(3000);
//		Set<String> childWindowHandles = driver.getWindowHandles();
//	     Iterator<String> iterator = childWindowHandles.iterator();
//	     iterator.hasNext();
//	     System.out.println("im a child window");
	     
	     Thread.sleep(5000);
	     WebElement other = driver.findElement(By.xpath("//body/div[2]/ul/li[5]/a[contains(text(),'Other')]"));
	     Thread.sleep(3000);
	     clickElement(other,"other");
	     logger.info("clicked other");
	     driver.switchTo().window(baseWindowHandle);///Users/ku2e8te/git/repository
	     
	     logger.info("moved parent window");
	     WebElement endTime = driver.findElement(By.id("EndDateTime_time"));
	     clickElement(endTime,"endTime");
	     Thread.sleep(3000);
	     
	     WebElement recurrence = driver.findElement(By.id("IsRecurrence"));
	     clickElement(recurrence,"recurrence");//
	     
	    // waiting();
	     WebElement weeklyRadioButton = driver.findElement(By.id("rectypeftw"));
	     clickElement(weeklyRadioButton,"weeklyRadioButton");
	     
	     WebElement recursEvery = driver.findElement(By.id("wi"));
	     recursEvery.clear();
	     recursEvery.sendKeys("1");
	     
	     WebElement endDate = driver.findElement(By.id("RecurrenceEndDateOnly"));
	     endDate.sendKeys("2/28/2023");
	     
	    // waiting();
  
	     Thread.sleep(3000);
	     WebElement save = driver.findElement(By.xpath("//body[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[2]/form[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/input[1]"));
	     clickElement(save,"save");
	     Thread.sleep(5000);
	}
}
