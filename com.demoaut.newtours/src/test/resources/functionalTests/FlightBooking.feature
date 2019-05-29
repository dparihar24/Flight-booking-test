Feature: Login and Book Flight 

Scenario: Successful Login with Valid Credentials 
	Given User is on Home Page 
	When User Navigate to LogIn Page 
	And User enters UserName as "debtestd" and Password as "Welcome@1" 
	Then Validate Login Successful 
	
Scenario Outline: Successful Flight booking 
	Given User selects flight type 
	Then User selects passenger count as "1" 
	And User selects "departing" location as "<departure>" 
	And User selects "departing" date "<departMonth>" "<departDay>" 
	And User selects "arriving" location as "<destination>" 
	And User selects "returning" date "<ReturnMonth>" "<ReturnDay>" 
	And User selects service class 
	And User selects airline preference "Blue Skies Airlines" 
	Then User clicks on to "findFlights" 
	And User selects "departing" flight "0" 
	And User selects "returning" flight "0" 
	Then User clicks on to "reserveFlights" 
	Then User enters "fname" as "deb" 
	Then User enters "lname" as "test" 
	Then User selects card type "American Express" 
	Then User enters "creditnumber" as "375811111111115" 
	Then User selects "cardexpiry" date "12" "2010" 
	Then User clicks on to "buyFlights" 
	And User validates booking summary 
	Then User tries to navigate to new flights booking page from flight summary page 	
	
	Examples: 
		|departure|destination|departMonth|departDay|ReturnMonth|ReturnDay|
		|London|New York|1|13|1|20|
		|London|Paris|1|24|1|31|
		
Scenario: Successful LogOut 
	When User LogOut from the Application 
	Then Validate LogOut Successfully