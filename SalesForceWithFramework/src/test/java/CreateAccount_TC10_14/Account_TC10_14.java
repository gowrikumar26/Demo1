package CreateAccount_TC10_14;

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
public class Account_TC10_14 extends BaseClass{
	
	@Test
	public static void newAccount_TC10() throws InterruptedException, IOException {
		login();
		
		WebElement clickAcc = driver.findElement(By.xpath("//a[contains(text(),'Accounts')]"));
		clickAcc.click();
		logger.info("Accounts tab clicked");
		Thread.sleep(5000);
		closeAddPage();
		
		Thread.sleep(3000);
		WebElement clickNew = driver.findElement(By.name("new"));
		clickNew.click();
		
		WebElement accName = driver.findElement(By.id("acc2"));
		accName.sendKeys("GowriKumar");
		
		WebElement type = driver.findElement(By.id("acc6"));
		type.click();
		Select select = new Select(type);
		select.selectByVisibleText("Technology Partner");
		
		WebElement priority = driver.findElement(By.id("00NDn00000Sjnh0"));
		priority.click();
		Select select1 = new Select(priority);
		select1.selectByVisibleText("High");
		
		WebElement save = driver.findElement(By.name("save"));
		save.click();
		
	}
	@Test
	public static void newView_TC11() throws InterruptedException, IOException {
		login();
		
		WebElement clickAcc = driver.findElement(By.xpath("//a[contains(text(),'Accounts')]"));
		clickAcc.click();
		logger.info("Accounts tab clicked");
		Thread.sleep(5000);
		closeAddPage();
		
		Thread.sleep(5000);
		WebElement createNew = driver.findElement(By.xpath("//a[contains(text(),'Create New View')]"));
		createNew.click();
		
		WebElement accName = driver.findElement(By.id("fname"));
		accName.clear();
		accName.sendKeys("Kumar");
		
		WebElement uniquName = driver.findElement(By.id("devname"));
		uniquName.clear();
		uniquName.sendKeys("GowriK");
		
		WebElement save = driver.findElement(By.xpath("//body[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[2]/div[2]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/input[1]"));
		save.click();
		
	}
	
	@Test
	public static void edit_TC12() throws InterruptedException, IOException {
		
		login();
		
		WebElement clickAcc = driver.findElement(By.xpath("//a[contains(text(),'Accounts')]"));
		clickAcc.click();
		logger.info("Accounts tab clicked");
		Thread.sleep(5000);
		closeAddPage();
		
		Thread.sleep(5000);
		
		driver.switchTo().activeElement();
		Thread.sleep(1000);

		WebElement frameClose = driver.findElement(By.id("tryLexDialogX"));
		frameClose.click();
		Thread.sleep(2000);
		
		WebElement clickEdit = driver.findElement(By.xpath("//form[@id='filter_element']/div[1]/span/span[2]/a[contains(text(),'Edit')]"));
		clickEdit.click();
		
		WebElement accName = driver.findElement(By.id("fname"));
		accName.clear();
		accName.sendKeys("Kumarshan");
		
		Thread.sleep(3000);
		WebElement field = driver.findElement(By.id("fcol1"));
		Select select = new Select(field);
		select.selectByVisibleText("Account Name");
		
		Thread.sleep(3000);
		WebElement contain = driver.findElement(By.name("fop1"));
		Select select1 = new Select(contain);
		//System.out.println(select1.selectByVisibleText("contains"));
		select1.selectByVisibleText("contains");
		
		WebElement value = driver.findElement(By.id("fval1"));
		value.clear();
		value.sendKeys("a");
		
		Thread.sleep(2000);
		WebElement selectField = driver.findElement(By.id("colselector_select_0"));
		Select select2 = new Select(selectField);
		select2.selectByVisibleText("Last Activity");
		
		WebElement clickAdd = driver.findElement(By.id("colselector_select_0_right"));
		clickAdd.click();
		Thread.sleep(2000);
		WebElement save = driver.findElement(By.xpath("//body[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[2]/div[2]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/input[1]"));
		save.click();
	}
@Test
	public static void mergeAccount_TC13() throws InterruptedException, IOException {
		login();
	
		WebElement clickAcc = driver.findElement(By.xpath("//a[contains(text(),'Accounts')]"));
		clickAcc.click();
		logger.info("Accounts tab clicked");
		Thread.sleep(5000);
		closeAddPage();
		
		Thread.sleep(3000);
		driver.switchTo().activeElement();
		Thread.sleep(1000);

		WebElement frameClose = driver.findElement(By.id("tryLexDialogX"));
		frameClose.click();
		Thread.sleep(2000);
		
		Thread.sleep(2000);
		WebElement clickMerge = driver.findElement(By.xpath("//a[contains(text(),'Merge Accounts')]"));
		clickMerge.click();//
		
		Thread.sleep(2000);
		WebElement accName = driver.findElement(By.id("srch"));
		accName.sendKeys("un");
		Thread.sleep(2000);
		WebElement clickFind = driver.findElement(By.name("srchbutton"));
		clickFind.click();
		Thread.sleep(2000);
		WebElement clickNext = driver.findElement(By.xpath("//tbody/tr[1]/td[2]/form[1]/div[1]/div[2]/div[5]/div[1]/input[1]"));
		clickNext.click();
		
		WebElement clickOnMerge = driver.findElement(By.name("save"));
		clickOnMerge.click();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		
	}
@Test
	public static void clickOnAcc_TC14() throws InterruptedException, IOException {
	login();
	WebElement clickAcc = driver.findElement(By.xpath("//a[contains(text(),'Accounts')]"));
	clickAcc.click();
	logger.info("Accounts tab clicked");
	Thread.sleep(5000);
	closeAddPage();
	
	Thread.sleep(4000);
	
	driver.switchTo().activeElement();
	Thread.sleep(2000);
	WebElement frameClose = driver.findElement(By.id("tryLexDialogX"));
	frameClose.click();
	Thread.sleep(2000);
	
	WebElement accActivity = driver.findElement(By.xpath("//a[contains(text(),'Accounts with last activity > 30 days')]"));
	accActivity.click();
	Thread.sleep(2000);
	WebElement dateField = driver.findElement(By.id("ext-gen20"));
	dateField.click();//Last Modified Date
	
//	WebElement lastAct = driver.findElement(By.xpath("//div[@id=\"ext-gen269\"]/div[4]"));
//	lastAct.click();
	
	WebElement date = driver.findElement(By.id("ext-gen152"));
	date.click();
	}
}

