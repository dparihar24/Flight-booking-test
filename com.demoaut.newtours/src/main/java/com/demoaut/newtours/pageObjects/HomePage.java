package com.demoaut.newtours.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement; 
import org.openqa.selenium.support.FindBy; 
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePage {	
	 
		final WebDriver driver;
	 
		@FindBy(how = How.XPATH, using = "//a[contains(.,'SIGN-ON')]")	 
		public WebElement signOnLink;
	 
		@FindBy(how = How.XPATH, using = "//a[contains(.,'REGISTER')]")	 
		public WebElement registerLink;
	 
	 
		public HomePage(WebDriver driver){	 
			this.driver = driver;
			PageFactory.initElements(driver, this);
			}
		public void signOnLinkClick() {
			signOnLink.click();
		}
		public void registerLinkClick() {
			registerLink.click();
		}
	}


