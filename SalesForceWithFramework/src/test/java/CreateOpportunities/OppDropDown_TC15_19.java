package CreateOpportunities;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Reusable.BaseClass;

@Listeners(com.utility.TestEventListenersUtility.class)
public class OppDropDown_TC15_19 extends BaseClass{
	@Test
	public static void dropdown_15() throws IOException {
		login();
		//String expected = "All Opportunities/n Closing Next Month Closing This Month My Opportunities New Last Week;
		clickOnOpportunities();
		
		WebElement view = driver.findElement(By.id("fcf"));
		clickElement(view,"view");
		
		waitUntilElementVisible(view,"view");
		Select select = new Select(view);
		List<WebElement> options =  select.getOptions();
		//String actual = "";
			
			for(WebElement list : options)
				//actual = list.getText();
            System.out.println(list.getText());
	
}
	@Test
	public static void createNewOpp_TC16() throws InterruptedException, IOException {
		String expectedOppName = "First";
		login();
		clickOnOpportunities();
		
		//waiting();
		WebElement clickNew = driver.findElement(By.name("new"));
		clickElement(clickNew,"new");
		
		WebElement oppName = driver.findElement(By.id("opp3"));
		oppName.sendKeys("First");
		
		WebElement accName = driver.findElement(By.id("opp4"));
		accName.sendKeys("Ezhilkumar");
		Thread.sleep(4000);
		closeAddPage();
		
		//waiting();
		Thread.sleep(2000);
		WebElement source = driver.findElement(By.id("opp6"));
		clickElement(source,"source");
		Select select = new Select(source);
		select.selectByVisibleText("Partner Referral");
		
		//waiting();
		Thread.sleep(2000);
		WebElement clickDate = driver.findElement(By.id("opp9"));
		clickDate.sendKeys("2/8/2023");
		Thread.sleep(2000);
//		WebElement clickOnToday = driver.findElement(By.xpath("a[contains(text(),'Today')]"));
//		click(clickOnToday);
		
		//Simply click outside once to get out of the date picker
		WebElement simplyClick = driver.findElement(By.id("head_1_ep"));
		clickElement(simplyClick,"simplyClick");
		
		//waiting(); 
		Thread.sleep(1000);
		WebElement stage = driver.findElement(By.id("opp11"));
		clickElement(stage,"stage");
		Select select1 = new Select(stage);
		select1.selectByVisibleText("Qualification");
		
		WebElement prob = driver.findElement(By.id("opp12"));
		prob.clear();
		prob.sendKeys("1");
		
		//waiting();
		
		Thread.sleep(1000);
		WebElement campign = driver.findElement(By.id("opp17"));
		campign.sendKeys("GC Product Webinar - Jan 7, 2002");
		
		Thread.sleep(1000);
		//waiting();
		WebElement save = driver.findElement(By.xpath("//body[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[2]/form[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/input[1]"));
		clickElement(save,"stage");
		
		Thread.sleep(3000);
		WebElement newOppName = driver.findElement(By.id("opp3_ileinner"));
		String newName = newOppName.getText();
		validation(expectedOppName,newName);
//		if(newName.equals(expectedOppName)) {
//			System.out.println("The oppourtunity name is displayed in the new page");
//		}
//		else
//		{
//			System.out.println("Opp name not displayed");
//		}
		
		Thread.sleep(2000);
		}
	
	@Test
	public static void oppPipelineReport_TC17() throws InterruptedException, IOException {
		login();
		String expectedReport = "Complete";
		clickOnOpportunities();
		
		Thread.sleep(3000);
		closeAddPage();
		//waiting();
		Thread.sleep(3000);
		WebElement pipeline = driver.findElement(By.xpath("//a[contains(text(),'Opportunity Pipeline')]"));
		clickElement(pipeline,"pipeline");
		//closeAddPage();
		
		WebElement report = driver.findElement(By.id("status"));
		String actual = report.getText();
		
		validation(expectedReport,actual);
	}
	
	@Test
	public static void stuckReports_TC18() throws IOException {
		String expectedReport = "Complete";
		login();
		clickOnOpportunities();
		//waiting();
		
		WebElement stuck = driver.findElement(By.xpath("//a[contains(text(),'Stuck Opportunities')]"));
		clickElement(stuck,"stuck");
		
		WebElement report = driver.findElement(By.id("status"));
		String actual = report.getText();
		
		validation(expectedReport,actual);
//		if(expectedReport.equals(actual)) {
//			System.out.println("The stuck reports page is displayed");
//		}
//		else {
//			System.out.println("Stuck Report testcase is failed");
//		}
	}
	
	@Test
	public static void quarterlySummary_TC19() throws InterruptedException, IOException {
		login();
		clickOnOpportunities();
		//waiting();
		
		Thread.sleep(3000);
		closeAddPage();
		Thread.sleep(10000);
		
		WebElement intervalCurrent = driver.findElement(By.id("quarter_q"));
		intervalCurrent.click();
		Select select = new Select(intervalCurrent);
		select.selectByIndex(0);
		
		WebElement include1 = driver.findElement(By.id("open"));
		include1.click();
		Select select1 = new Select(include1);
		select1.selectByIndex(0);
		
		Thread.sleep(5000);
		WebElement run = driver.findElement(By.xpath("//form[@id='lead_summary']/table/tbody/tr[3]/td/input[@name='go']"));
		run.click();
		
		clickOnOpportunities();
		
		Thread.sleep(5000);
		WebElement interval = driver.findElement(By.id("quarter_q"));
		interval.click();
		Select select2 = new Select(interval);
		select2.selectByIndex(1);
		
		WebElement include = driver.findElement(By.id("open"));
		include.click();
		Select select3 = new Select(include);
		select3.selectByIndex(1);
		
		WebElement run1 = driver.findElement(By.xpath("//form[@id='lead_summary']/table/tbody/tr[3]/td/input[@name='go']"));
		run1.click();
		Thread.sleep(5000);
		
		clickOnOpportunities();
		
		//Thread.sleep(5000);
		WebElement interval2 = driver.findElement(By.id("quarter_q"));
		interval2.click();
		Select select4 = new Select(interval2);
		select4.selectByIndex(2);
		
		WebElement include2 = driver.findElement(By.id("open"));
		include2.click();
		Select select5 = new Select(include2);
		select5.selectByIndex(2);
		
		WebElement run2 = driver.findElement(By.xpath("//form[@id='lead_summary']/table/tbody/tr[3]/td/input[@name='go']"));
		run2.click();
		Thread.sleep(5000);
		
		clickOnOpportunities();
		
		Thread.sleep(5000);
		WebElement interval3 = driver.findElement(By.id("quarter_q"));
		interval3.click();
		Select select6 = new Select(interval3);
		select6.selectByIndex(3);
		
		WebElement include3 = driver.findElement(By.id("open"));
		include3.click();
		Select select7 = new Select(include3);
		select7.selectByIndex(3);
		
		WebElement run3 = driver.findElement(By.xpath("//form[@id='lead_summary']/table/tbody/tr[3]/td/input[@name='go']"));
		run3.click();
		Thread.sleep(5000);
	}
}
