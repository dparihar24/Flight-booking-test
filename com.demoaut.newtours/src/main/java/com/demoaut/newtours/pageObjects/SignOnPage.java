package com.demoaut.newtours.pageObjects;

import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement; 
import org.openqa.selenium.support.FindBy; 
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class SignOnPage {	
	 
		final WebDriver driver;
	 
		@FindBy(how = How.NAME, using = "userName")	 
		public WebElement userName;
	 
		@FindBy(how = How.NAME, using = "password")	 
		public WebElement password;
		
		@FindBy(how = How.NAME, using = "login")	 
		public WebElement login;
	 
		public SignOnPage(WebDriver driver){	 
			this.driver = driver; 
			PageFactory.initElements(driver, this);
			}
		
		public void enteruserName(String fieldValue){
			
			try{
				userName.sendKeys(fieldValue);				
			}catch(ElementNotVisibleException e){
				System.out.println(e.getMessage());
			}
		}
		public void enterpassword(String fieldValue){
					
					try{
						password.sendKeys(fieldValue);				
					}catch(ElementNotVisibleException e){
						System.out.println(e.getMessage());
					}
				}
		public void loginLinkClick() {
			login.click();
}
	 
	}


