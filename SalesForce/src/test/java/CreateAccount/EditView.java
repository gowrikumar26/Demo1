package CreateAccount;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditView {
	
	public static void edit() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://developer.salesforce.com/signup");//https://login.salesforce.com/
		Thread.sleep(3000);
		By login = By.linkText("Log in");
		WebElement log = driver.findElement(login);
		log.click();
		By uname = By.id("username");
		WebElement userName = driver.findElement(uname);
		userName.sendKeys("ezhilnila26@gmail.com");
		
		By pword = By.id("password");
		WebElement password = driver.findElement(pword);
		password.sendKeys("kumaravadivel26");
		
		By login1 = By.id("Login");
		WebElement logn = driver.findElement(login1);
		logn.click();
		
		WebElement clickAcc = driver.findElement(By.xpath("//a[contains(text(),'Accounts')]"));
		clickAcc.click();
		
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

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		edit();
	}

}
