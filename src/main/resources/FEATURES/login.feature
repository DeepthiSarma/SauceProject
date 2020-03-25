Feature: Login 
	As a e_commerce vendor
 I want to access to the portal
Background: 
	Given I have browser with SauceDemo Test 
	When I enter username as 'standard_user' and I enter password as 'secret_sauce' 
	
Scenario: ValidCredentials 

	Then I should access to the portal with title as 'Swag Labs' 
	
Scenario: Click on Menu 

	And I click on Menu button 
	Then I side menu with about button has to appear 
	
Scenario: Click on About 

	And I click on Menu button 
	And I click on About 
	Then application is redirected to page with title as 'Cross Browser Testing, Selenium Testing, Mobile Testing | Sauce Labs' 
	
Scenario: click on company 
	When  I click on Menu button 
	And I click on About
	And I click on Company 
	Then a list with About Us option must open
	
Scenario: click on careers 
	When  I click on Menu button 
	And I click on About
	And I click on Company 
	And click on careers 
	Then career page with title 'Careers | Sauce Labs' has to open 
	
#		Scenario: join mail list 
#	When I click on Menu button 
#	And I click on About
#	And I enter valid mail id as 'deepthi@gmail.com'
##	 And click on send 
#	Then mail must be added 
#	
#Scenario: join mail list with empty mail
#	When I click on Menu button 
#	And I click on About
#	And I enter invalid mail id as ''
#	Then error message must be displayed