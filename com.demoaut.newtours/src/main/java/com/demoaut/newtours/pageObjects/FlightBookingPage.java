package com.demoaut.newtours.pageObjects;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement; 
import org.openqa.selenium.support.FindBy; 
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class FlightBookingPage {	
	 
		final WebDriver driver;
	 
		@FindBy(how = How.NAME, using = "passFirst0")	 
		public WebElement passFirst0;
	 
		@FindBy(how = How.NAME, using = "passLast0")	 
		public WebElement passLast0;
		
		@FindBy(how = How.NAME, using = "creditnumber")	 
		public WebElement creditnumber;
	 
		@FindBy(how = How.NAME, using = "creditCard")	 
		public WebElement creditCard;
	 
		@FindBy(how = How.NAME, using = "cc_exp_dt_mn")	 
		public WebElement cc_exp_dt_mn;
		
		@FindBy(how = How.NAME, using = "cc_exp_dt_yr")	 
		public WebElement cc_exp_dt_yr;
		
		@FindBy(how = How.NAME, using = "buyFlights")	 
		public WebElement buyFlights;		
		
		public FlightBookingPage(WebDriver driver){	 
			this.driver = driver; 
			PageFactory.initElements(driver, this);
			}
public void enterfirstname(String fName){
	enterdata(passFirst0,fName);
}
public void enterlastname(String fName){
	enterdata(passLast0,fName);
}
public void entercreditnumber(String val){
	enterdata(creditnumber,val);
}
public void enterdata(WebElement ele,String fieldValue){
			
			try{
				ele.sendKeys(fieldValue);				
			}catch(ElementNotVisibleException e){
				System.out.println(e.getMessage());
			}
		}
public void buyFlightsLinkClick() {
	buyFlights.click();
}
public void selectcreditCard(String selectionitm){
	selectOptions(creditCard,selectionitm,"selectByVisibleText");			
}
public void selectcc_exp_dt_mn(String selectionitm){
	selectOptions(cc_exp_dt_mn,selectionitm,"selectByVisibleText");			
}
public void selectcc_exp_dt_yr(String selectionitm){
	selectOptions(cc_exp_dt_yr,selectionitm,"selectByVisibleText");			
}
public void selectOptions(WebElement selectornm,String selectionitm,String selectionmthd){
	try{
		Select selectionlst = new Select(selectornm);
		
		switch (selectionmthd){
		case "selectByVisibleText" : 
			selectionlst.selectByVisibleText(selectionitm);
			break;
		case "selectByIndex" : 
			selectionlst.selectByIndex(Integer.parseInt(selectionitm));
			break;
		case "selectByValue" : 
			selectionlst.selectByValue(selectionitm);
			break;
		}			
	}
	catch(ElementNotVisibleException|ElementClickInterceptedException e){
		System.out.println(e.getMessage());
	}
	
}
	 
	}



