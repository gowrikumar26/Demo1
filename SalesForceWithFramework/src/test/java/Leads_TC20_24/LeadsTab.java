package Leads_TC20_24;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Reusable.BaseClass;

@Listeners(com.utility.TestEventListenersUtility.class)
public class LeadsTab extends BaseClass {

	@Test
	public static void clickOnLeads_TC20() throws InterruptedException, IOException  {
		login();
		
		WebElement lead = driver.findElement(By.xpath("//li[@id='Lead_Tab']/a"));
		clickElement(lead,"lead");
		Thread.sleep(5000);
		
		closeAddPage();
	}
@Test
	public static void leadsDropDown_TC21() throws InterruptedException, IOException  {
		login();
		
		WebElement lead = driver.findElement(By.xpath("//li[@id='Lead_Tab']/a"));
		clickElement(lead,"lead");
		Thread.sleep(5000);
		
		closeAddPage();
		WebElement leadView = driver.findElement(By.id("fcf"));
		clickElement(leadView,"leadView");
		Select select = new Select(leadView);
		List <WebElement> list = select.getOptions();
		for(WebElement listMenu : list ) {
			System.out.println(listMenu.getText());
		}
		
	}
@Test
public static void defaultsView_TC22() throws InterruptedException, IOException  {
	login();
	//waiting();
	WebElement lead = driver.findElement(By.xpath("//li[@id='Lead_Tab']/a"));
	clickElement(lead,"lead");
	Thread.sleep(5000);
	//waiting();
	closeAddPage();
	WebElement leadView = driver.findElement(By.id("fcf"));
	clickElement(leadView,"leadView");
	Select select1 = new Select(leadView);
	select1.selectByVisibleText("Today's Leads");
	
	By umenu = By.id("userNav");
	WebElement userMenu = driver.findElement(umenu);
	userMenu.click();
	By logout = By.xpath("//a[contains(text(),'Logout')]");
	WebElement lo = driver.findElement(logout);
	lo.click();
	login();
	
	//waiting();
	WebElement clickOnLead = driver.findElement(By.xpath("//li[@id='Lead_Tab']/a"));
	clickElement(clickOnLead,"clickOnLead");
	Thread.sleep(5000);
	//waiting();
	closeAddPage();
//	WebElement defaultLeadView = driver.findElement(By.id("fcf"));
//	click(defaultLeadView);
	WebElement go = driver.findElement(By.xpath("//form[@id='filter_element']/div/span/span/input"));
	clickElement(go,"go");
}

@Test
public static void todaysDeals_TC23() throws InterruptedException, IOException  {
	login();
	//waiting();
	WebElement lead = driver.findElement(By.xpath("//li[@id='Lead_Tab']/a"));
	clickElement(lead,"lead");
	Thread.sleep(5000);
	//waiting();
	closeAddPage();
	WebElement leadView = driver.findElement(By.id("fcf"));
	clickElement(leadView,"leadView");
	Select select1 = new Select(leadView);
	select1.selectByVisibleText("Today's Leads");
	Thread.sleep(5000);
}

@Test
public static void clickOnNew_TC24() throws InterruptedException, IOException  {
	login();
	//waiting();
	WebElement lead = driver.findElement(By.xpath("//li[@id='Lead_Tab']/a"));
	clickElement(lead,"lead");
	Thread.sleep(5000);
	//waiting();
	closeAddPage();
	WebElement newEle = driver.findElement(By.xpath("//form[@id='hotlist']/table/tbody/tr/td[2]/input"));
	clickElement(newEle,"newEle");
	
	WebElement lastName = driver.findElement(By.id("name_lastlea2"));
	lastName.sendKeys("Shan");
	
	WebElement compName = driver.findElement(By.id("lea3"));
	compName.sendKeys("Kumar&co");
	
	Thread.sleep(3000);
	WebElement save = driver.findElement(By.xpath("//body[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[2]/form[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/input[1]"));
	clickElement(save,"save");
	Thread.sleep(3000);
}
}