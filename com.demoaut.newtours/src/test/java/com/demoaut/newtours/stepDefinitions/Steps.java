package com.demoaut.newtours.stepDefinitions;

import static org.testng.Assert.assertEquals;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import com.demoaut.newtours.managers.FileReaderManager;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import com.demoaut.newtours.pageObjects.FlightBookingPage;
import com.demoaut.newtours.pageObjects.FlightSelectionPage;
import com.demoaut.newtours.pageObjects.HomePage;
import com.demoaut.newtours.pageObjects.ReservationPage;
import com.demoaut.newtours.pageObjects.SignOnPage;

public class Steps {
	
    static WebDriver driver;
	
	public void initDriver(){
		
		System.setProperty("webdriver.chrome.driver", FileReaderManager.getInstance().getConfigReader().getDriverPath());
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(FileReaderManager.getInstance().getConfigReader().getImplicitlyWait(), TimeUnit.SECONDS);
		}

	@Given("^User is on Home Page$")
	public void user_is_on_Home_Page() throws Throwable {
		
		initDriver();		
			try{
				driver.get(FileReaderManager.getInstance().getConfigReader().getApplicationUrl());			
			}
			catch(Exception e){
				System.out.println(e.getMessage());
			}		
		}

	@When("^User Navigate to LogIn Page$")
	public void user_Navigate_to_LogIn_Page() throws Throwable {
		
			try{
				HomePage hp1 = new HomePage(driver);
				hp1.signOnLinkClick();						
			}
			catch(ElementNotVisibleException|ElementClickInterceptedException e){
				System.out.println(e.getMessage());
			}			
			assertEquals(urlValidator("http://newtours.demoaut.com/mercurysignon.php"),true);
		}

	@When("^User enters UserName as \"([^\"]*)\" and Password as \"([^\"]*)\"$")
	public void user_enters_UserName_and_Password(String usrname,String pwd) throws Throwable {
		
		SignOnPage soPage = new SignOnPage(driver);
		soPage.enteruserName(usrname);
		soPage.enterpassword(pwd);
		soPage.loginLinkClick();		
		}

	@Then("^Validate Login Successful$")
	public void message_displayed_Login_Successfully() throws Throwable {
		
		assertEquals(urlValidator("http://newtours.demoaut.com/mercuryreservation.php"),true);	    
	}

	
	@Given("^User selects flight type$")
	public void user_selects_flight_type() throws Throwable {
		ReservationPage resPage = new ReservationPage(driver);
		resPage.selecttriptype();			
	}
	
	@Then("^User selects passenger count as \"([^\"]*)\"$")
	public void user_selects_passenger_count(String count) throws Throwable {
		ReservationPage resPage = new ReservationPage(driver);
		resPage.selectpassCount(count);				
	}

	@Then("^User selects \"([^\"]*)\" location as \"([^\"]*)\"$")
	public void user_selects_location_as(String side,String location) throws Throwable {
		ReservationPage resPage = new ReservationPage(driver);		
		if(side.equalsIgnoreCase("departing"))
		resPage.selectfromPort(location);		
		else
		resPage.selecttoPort(location);
	}

	@Then("^User selects \"([^\"]*)\" date \"([^\"]*)\" \"([^\"]*)\"$")
	public void user_selects_date(String side,String departMonth,String departDate) throws Throwable {
		ReservationPage resPage = new ReservationPage(driver);
		if(side.equalsIgnoreCase("departing")){
			resPage.selectfromMonth(departMonth);
			resPage.selectfromDay(departDate);			
		}
		else if(side.equalsIgnoreCase("returning")){
			resPage.selecttoMonth(departMonth);
			resPage.selecttoDay(departDate);						
		}
		else if(side.equalsIgnoreCase("cardexpiry")){
			FlightBookingPage fbPage = new FlightBookingPage(driver);
			fbPage.selectcc_exp_dt_mn(departMonth);
			fbPage.selectcc_exp_dt_yr(departDate);			
		}
	}
	
	@Then("^User selects service class$")
	public void user_selects_service_class() throws Throwable {	   
		ReservationPage resPage = new ReservationPage(driver);
		resPage.selectservClass();	    
	}

	@Then("^User selects airline preference \"([^\"]*)\"$")
	public void user_selects_airline_preference(String airpreference) throws Throwable {
		ReservationPage resPage = new ReservationPage(driver);
		resPage.selectairline(airpreference);	
	}

	@Then("^User clicks on to \"([^\"]*)\"$")
	public void user_clicks_on_the_button(String buttonName) throws Throwable {
	    driver.findElement(By.name(buttonName)).click();
	}

	@Then("^User selects \"([^\"]*)\" flight \"([^\"]*)\"$")
	public void user_selects_flight(String side,int flightindex) throws Throwable {
		FlightSelectionPage fsPage = new FlightSelectionPage(driver);
		if(side.equalsIgnoreCase("departing"))
			fsPage.selectoutFlight(flightindex);
			else
				fsPage.selectinFlight(flightindex);
	    
	}	
	@Then("^User enters \"([^\"]*)\" as \"([^\"]*)\"$")
	public void user_enters_Firstname(String fName,String fValue) throws Throwable {
		FlightBookingPage fbPage = new FlightBookingPage(driver);
		if(fName.equalsIgnoreCase("fname"))
			fbPage.enterfirstname(fValue);
		else if (fName.equalsIgnoreCase("lname"))
			fbPage.enterlastname(fValue);
		else 
			fbPage.entercreditnumber(fValue);
	}	

	@Then("^User selects card type \"([^\"]*)\"$")
	public void user_selects_card_type(String cctype) throws Throwable {
		FlightBookingPage fbPage = new FlightBookingPage(driver);
		fbPage.selectcreditCard(cctype);		
	}	

	@Then("^User validates booking summary$")
	public void user_validates_booking_summary() throws Throwable {
		
	  assertEquals(driver.findElement(By.xpath("//img[@src='/images/printit.gif']")).isDisplayed(), true);
	  
	}

	@When("^User tries to navigate to new flights booking page from flight summary page$")
	public void user_tries_to_navigate_to_new_flights_booking_page_from_flight_summary_page() throws Throwable {
	   driver.findElement(By.xpath("//img[@src='/images/forms/backtoflights.gif']")).click();
	}
	@When("^User LogOut from the Application$")
	public void user_LogOut_from_the_Application() throws Throwable {
		try{
			WebElement registerlink = driver.findElement(By.xpath("//a[contains(.,'SIGN-OFF')]"));
			registerlink.click();			
		}
		catch(ElementNotVisibleException|ElementClickInterceptedException e){
			System.out.println(e.getMessage());
		}
		assertEquals(driver.getCurrentUrl(), "http://newtours.demoaut.com/mercurysignon.php");
	}

	@Then("^Validate LogOut Successfully$")
	public void message_displayed_LogOut_Successfully() throws Throwable {		
		assertEquals(driver.getCurrentUrl(), "http://newtours.demoaut.com/mercurysignon.php");
		driver.quit();
	}
	
public boolean urlValidator(String expected){
	
	String currentUrl=driver.getCurrentUrl();
	if(currentUrl.contains(expected))
		return true;
	else
	return false;
}
}

