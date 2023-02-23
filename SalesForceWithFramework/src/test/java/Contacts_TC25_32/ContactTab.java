package Contacts_TC25_32;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Reusable.BaseClass;

@Listeners(com.utility.TestEventListenersUtility.class)
public class ContactTab extends BaseClass{
@Test
	public static void createNewContact_TC25() throws InterruptedException, IOException {
		login();
		//waiting();
		WebElement contact = driver.findElement(By.id("Contact_Tab"));
		clickElement(contact, "contact element");
		//click(contact);
		Thread.sleep(5000);
		//waiting();
		closeAddPage();
		
		WebElement clickOnNew = driver.findElement(By.xpath("//form[@id='hotlist']/table/tbody/tr/td[2]/input"));
		clickElement(clickOnNew, "new element");
		//click(clickOnNew);
		WebElement lname = driver.findElement(By.id("name_lastcon2"));
		enter_Credentials(lname,"Pechi","last name");
		//lname.sendKeys("Pechi");
		
		WebElement accName = driver.findElement(By.id("con4"));
		enter_Credentials(accName,"Ezhil","account name");
		//accName.sendKeys("Ezhil");
		
		WebElement save = driver.findElement(By.xpath("//body[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[2]/form[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/input[1]"));
		clickElement(save, "save button");
		//click(save);
		
		Thread.sleep(5000);
		
}

@Test
public static void createNewView_TC26() throws InterruptedException, IOException {
	login();
	//waiting();
	WebElement contact = driver.findElement(By.id("Contact_Tab"));
	clickElement(contact,"Contact tab");
	Thread.sleep(5000);
	//waiting();
	closeAddPage();
	
	WebElement newView = driver.findElement(By.xpath("//a[contains(text(),'Create New View')]"));
	clickElement(newView, "create new view element");
	
	WebElement viewName = driver.findElement(By.id("fname"));
	enter_Credentials(viewName,"Mennila","view name");
	//viewName.sendKeys("Mennila");
	
	//waiting();
	WebElement viewUniqueName = driver.findElement(By.id("fname"));
	enter_Credentials(viewUniqueName,"nila","view unique name");
	//viewUniqueName.sendKeys("nila");
	
	WebElement save = driver.findElement(By.xpath("//body[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[2]/div[2]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/input[1]"));
	clickElement(save,"save button");
	
	Thread.sleep(5000);
}

@Test
public static void recentlyCreated_TC27	() throws InterruptedException, IOException {
	login();
	//waiting();
	WebElement contact = driver.findElement(By.id("Contact_Tab"));
	clickElement(contact,"Contact tab");
	Thread.sleep(5000);
	//waiting();
	closeAddPage();
	
	WebElement clickRecentlyCreated = driver.findElement(By.id("hotlist_mode"));
	clickElement(clickRecentlyCreated,"recently created one");
	
	Select select = new Select(clickRecentlyCreated);
	select.selectByVisibleText("Recently Created");
	
	Thread.sleep(5000);
	
}

@Test
public static void myContacts_TC28() throws InterruptedException, IOException {
	login();
	//waiting();
	WebElement contact = driver.findElement(By.id("Contact_Tab"));
	clickElement(contact,"Contact tab");
	Thread.sleep(5000);
	//waiting();
	closeAddPage();
	
	Thread.sleep(3000);
	WebElement selectMyCon = driver.findElement(By.id("fcf"));
	clickElement(selectMyCon,"my contacts");
	
	Select select = new Select(selectMyCon);
	select.selectByVisibleText("My Contacts");
	
	//Thread.sleep(3000);
}

@Test
public static void recentContacts_TC29() throws InterruptedException, IOException {
	login();
	//waiting();
	WebElement contact = driver.findElement(By.id("Contact_Tab"));
	clickElement(contact,"contact tab");
	Thread.sleep(5000);
	//waiting();
	closeAddPage();
	
	Thread.sleep(3000);
	
	WebElement clickName = driver.findElement(By.xpath("//a[contains(text(),'Pechi')]"));
	clickElement(clickName,"name field");
	Thread.sleep(3000);
}

@Test
public static void viewNameError_TC30() throws InterruptedException, IOException {
	String expected = "Error: You must enter a value";
	login();
	//waiting();
	WebElement contact = driver.findElement(By.id("Contact_Tab"));
	clickElement(contact,"Contact tab");
	Thread.sleep(3000);
	//waiting();
	closeAddPage();
	
	WebElement createNewView = driver.findElement(By.xpath("//a[contains(text(),'Create New View')]"));
	clickElement(createNewView,"create new view");
	
	WebElement viewUniqueName = driver.findElement(By.xpath("//form[@id='editPage']/div[2]/div/div[2]/table/tbody/tr[2]/td[2]/div/input"));
	viewUniqueName.sendKeys("efgh");
	
	WebElement save = driver.findElement(By.xpath("//body[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[2]/div[2]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/input[1]"));
	clickElement(save,"save");
	
	Thread.sleep(3000);
	WebElement errormsg = driver.findElement(By.xpath("//form[@id='editPage']/div[2]/div[1]/div[2]/table/tbody/tr/td[2]/div/div[2]"));
	String actual = errormsg.getText();
	
	Thread.sleep(3000);
	validation(expected,actual);
}

@Test
public static void checkingCancel_TC31() throws InterruptedException, IOException {
	
	login();
	//waiting();
	WebElement contact = driver.findElement(By.id("Contact_Tab"));
	clickElement(contact,"contact");
	Thread.sleep(3000);
	//waiting();
	closeAddPage();
	
	WebElement createNewView = driver.findElement(By.xpath("//a[contains(text(),'Create New View')]"));
	createNewView.click();
	
	WebElement viewUniqueName = driver.findElement(By.xpath("//form[@id='editPage']/div[2]/div/div[2]/table/tbody/tr[2]/td[2]/div/input"));
	viewUniqueName.sendKeys("efgh");
	
	WebElement viewName = driver.findElement(By.id("fname"));
	viewName.sendKeys("ghij");
	
	Thread.sleep(3000);
	WebElement cancel = driver.findElement(By.xpath("//body[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[2]/div[2]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/input[2]"));
	clickElement(cancel,"cancel");
	
	Thread.sleep(3000);
}

@Test
public static void newContact_TC32() throws InterruptedException, IOException {
	//String expected = "Error: You must enter a value";
	login();
	
	//waiting();
	WebElement contact = driver.findElement(By.id("Contact_Tab"));
	clickElement(contact,"contact");
	Thread.sleep(3000);
	//waiting();
	closeAddPage();
	
	WebElement clickOnNew = driver.findElement(By.xpath("//tbody/tr[1]/td[2]/input[1]"));
	clickOnNew.click();
	
	Thread.sleep(3000);
	WebElement lastName = driver.findElement(By.xpath("//input[@id='name_lastcon2']"));
	lastName.sendKeys("india");
	
	Thread.sleep(3000);
	WebElement accName = driver.findElement(By.id("con4"));
	accName.sendKeys("Edge Communications");
	
	Thread.sleep(3000);
	WebElement saveAndNew = driver.findElement(By.xpath("//body[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[2]/form[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/input[2]"));
	saveAndNew.click();
	
	Thread.sleep(3000);
	
}
}