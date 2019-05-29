package com.demoaut.newtours.pageObjects;

import java.util.List;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement; 
import org.openqa.selenium.support.FindBy; 
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class FlightSelectionPage {	
	 
		final WebDriver driver;
	 
		@FindBy(how = How.NAME, using = "outFlight")	 
		public List<WebElement> outFlight;
	 
		@FindBy(how = How.NAME, using = "inFlight")	 
		public List<WebElement> inFlight;
		
		@FindBy(how = How.NAME, using = "reserveFlights")	 
		public WebElement reserveFlights;
	 
		public FlightSelectionPage(WebDriver driver){	 
			this.driver = driver; 
			PageFactory.initElements(driver, this);
			}
		public void selectoutFlight(int index){
			try{
				List  oRadioButton = outFlight;		 
				boolean bValue = false;		
				 
				bValue =  ((WebElement) oRadioButton.get(index)).isSelected();	
				 
				if(!bValue)	((WebElement) oRadioButton.get(index)).click();	
			}catch(ElementNotVisibleException|ElementClickInterceptedException e){
				System.out.println(e.getMessage());
			}
		}
		public void selectinFlight(int index){
			try{
				List  oRadioButton = inFlight;		 
				boolean bValue = false;		
				 
				bValue =  ((WebElement) oRadioButton.get(index)).isSelected();	
				 
				if(!bValue)	((WebElement) oRadioButton.get(index)).click();	
			}catch(ElementNotVisibleException|ElementClickInterceptedException e){
				System.out.println(e.getMessage());
			}
		}
		public void reserveFlightsButtonClick() {
			reserveFlights.click();
		}
	}



