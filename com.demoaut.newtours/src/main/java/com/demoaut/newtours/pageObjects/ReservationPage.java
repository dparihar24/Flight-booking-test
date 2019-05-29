package com.demoaut.newtours.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement; 
import org.openqa.selenium.support.FindBy; 
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ReservationPage {	
	 
		final WebDriver driver;
	 
		@FindBy(how = How.NAME, using = "tripType")	 
		public List<WebElement> tripType;
	 
		@FindBy(how = How.NAME, using = "passCount")	 
		public WebElement passCount;
		
		@FindBy(how = How.NAME, using = "fromPort")	 
		public WebElement fromPort;
	 
		@FindBy(how = How.NAME, using = "toPort")	 
		public WebElement toPort;
	 
		@FindBy(how = How.NAME, using = "fromMonth")	 
		public WebElement fromMonth;
		
		@FindBy(how = How.NAME, using = "fromDay")	 
		public WebElement fromDay;
		@FindBy(how = How.NAME, using = "toMonth")	 
		public WebElement toMonth;
	 
		@FindBy(how = How.NAME, using = "toDay")	 
		public WebElement toDay;
		
		@FindBy(how = How.NAME, using = "servClass")	 
		public List<WebElement> servClass;
		
		@FindBy(how = How.NAME, using = "airline")	 
		public WebElement airline;
		
		@FindBy(how = How.NAME, using = "findFlights")	 
		public WebElement findFlights;
		
		
		
		public ReservationPage(WebDriver driver){	 
			this.driver = driver; 
			PageFactory.initElements(driver, this);
			}
		
		public void selecttriptype(){
			try{
				List  oRadioButton = tripType;		 
				boolean bValue = false;		
				 
				bValue =  ((WebElement) oRadioButton.get(0)).isSelected();	
				 
				if(!bValue)	((WebElement) oRadioButton.get(0)).click();	
			}catch(ElementNotVisibleException|ElementClickInterceptedException e){
				System.out.println(e.getMessage());
			}
		}
		
		public void selectservClass(){
			try{
				List  oRadioButton = servClass;		 
				boolean bValue = false;		
				 
				bValue =  ((WebElement) oRadioButton.get(1)).isSelected();	
				 
				if(!bValue)	((WebElement) oRadioButton.get(1)).click();	
			}catch(ElementNotVisibleException|ElementClickInterceptedException e){
				System.out.println(e.getMessage());
			}
		}
		
		public void selectpassCount(String selectionitm){
			selectOptions(passCount,selectionitm,"selectByVisibleText");			
		}
		public void selectfromPort(String selectionitm){
			selectOptions(fromPort,selectionitm,"selectByValue");			
		}
		public void selecttoPort(String selectionitm){
			selectOptions(toPort,selectionitm,"selectByValue");			
		}
		public void selectfromMonth(String selectionitm){
			selectOptions(fromMonth,selectionitm,"selectByValue");			
		}
		public void selectfromDay(String selectionitm){
			selectOptions(fromDay,selectionitm,"selectByValue");			
		}
		public void selecttoMonth(String selectionitm){
			selectOptions(toMonth,selectionitm,"selectByValue");			
		}
		public void selecttoDay(String selectionitm){
			selectOptions(toDay,selectionitm,"selectByValue");			
		}
		public void selectairline(String selectionitm){
			selectOptions(airline,selectionitm,"selectByVisibleText");			
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
		public void findFlightsButtonClick() {
			findFlights.click();
		}
	 
	}


