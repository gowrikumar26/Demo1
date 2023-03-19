package com.base;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.utility.ExtendReportUtility;
import com.utility.PropertiesUtility;

public class BasePage {
		protected WebDriver driver = null;
		protected Logger logger = LogManager.getLogger(BasePage.class.getName());
		protected ExtendReportUtility extentreport = ExtendReportUtility.getInstance();
		protected static WebDriverWait wait = null;
		
		public BasePage(WebDriver driver) {
			 	this.driver = driver;
				PageFactory.initElements(driver, this);
			}
		
		public void enterText(WebElement element, String text, String name) {
			//if(element.isDisplayed()) {
				//clearElement(element, name);
				element.sendKeys(text);
				logger.info("text entered in "+ name + "field");
				//extentreport.logTestInfo("text entered in "+ name + "field");
				//}
			//else
//			{
//				logger.info("fail "+ name + "element not displayed");
//			}
			driver.getTitle();
		}
		
//		public void clearElement(WebElement element, String objName) {
//			if(element.isDisplayed()) {
//				element.clear();
//				logger.info("pass"+ objName + "element cleared");
//				extentreport.logTestInfo("pass"+ objName + "element cleared");
//			}
//			else {
//				logger.info("fail"+ objName + "element not displayed");
//			}
			
//}
		public void refershPage() {
			driver.navigate().refresh();
		}
		
		public void waitUntilVisible(WebElement element, String objName) {
			logger.info("Waiting for an Web element"+  objName + "for its visiblity");
			wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOf(element));
			
			//driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
		}
		
		
		
		
		public String getTextFromWebElement(WebElement element, String name) {
			if(element.isDisplayed()) {
				return element.getText();
			}else
				logger.info(element + "element is not displayed");	
				return null;
		}
		
		public void clickElement(WebElement element, String name) {
			if(element.isDisplayed()) {
				element.click();
				logger.info(name + "is clicked");
			}
			
		}
		
		
	}
