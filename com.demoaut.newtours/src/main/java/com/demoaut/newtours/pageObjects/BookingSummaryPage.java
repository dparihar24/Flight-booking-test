package com.demoaut.newtours.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement; 
import org.openqa.selenium.support.FindBy; 
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class BookingSummaryPage {	
	 
		final WebDriver driver;
	 
		@FindBy(how = How.XPATH, using = "//img[@src='/images/printit.gif']")	 
		public WebElement printTicketLink;
	 
		@FindBy(how = How.XPATH, using = "//img[@src='/images/forms/backtoflights.gif']")	 
		public WebElement backtoflightsNavigator;
	 
	 
		public BookingSummaryPage(WebDriver driver){	 
			this.driver = driver;
			PageFactory.initElements(driver, this);
			}
		public void backtoflightsNavigatorLinkClick() {
			backtoflightsNavigator.click();
		}
	 
	}


