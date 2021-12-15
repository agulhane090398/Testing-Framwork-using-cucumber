#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Bank Interface


	Background: user will be at bank interface
    Given user should be on Savings-Account interface "http://localhost:8080/SavingsAccount"
    And clicks on Admin link
    When user enters valid credentials "admin" and "admin"
    Then click on login button present
    When user moves mouse over Setup
    And click on bank Sub-menu
    Then user verifys title as "Bank List"
	
	
  @tag1
  Scenario: Add bank new in list
    When user clicks on add button
    Then new window is opened
    When user enters the following data
    |bank_name|Bank of Chikago |
    |address_1| B18 jasrana Appartment |
    |address_2| Ek vira chowk |
    |address_3| Darwha Road |
    |city| Yavatmal |
    |state| Maharashtra |
    |country| India |
    |pin_code| m445001  |
    |phone_no| m7350813275 |
    |email| agulhane090398@gmail.com |
    |IFSC_code| BOC110083 |
    |MIRC_code| COB115552 |
    |hqAdd| xyz building, abc country |
    And clicks on submit buttom 
    Then user validate the outcomes from the list of bank
    
  Scenario: Add duplicate bank in list #Index is made as PrimaryKey so furthure tests will definetely fail #Primary Key should be IFSC code
    When user clicks on add button			
    Then new window is opened
    When user enters the following data
    |bank_name|Bank of Chikago |
    |address_1| B18 jasrana Appartment |
    |address_2| Ek vira chowk |
    |address_3| Darwha Road |
    |city| Yavatmal |
    |state| Maharashtra |
    |country| India |
    |pin_code| m445001  |
    |phone_no| m7350813275 |
    |email| agulhane090398@gmail.com |
    |IFSC_code| BOC110083 |
    |MIRC_code| COB115552 |
    |hqAdd| xyz building, abc country |
    And clicks on submit buttom 
    Then verify mgs contains "Bank is already in List"
     
  Scenario: Edit bank details
    When user clicks on edit button			
    Then new window is opened
    When user enters ifsc code as "CGD456212"
    And clicks on submit buttom 
		Then user validate the outcomes from the list of bank
		
	Scenario: Edit bank details with duplicate IFSC code
    When user clicks on edit button	next to preciding entry		
    Then new window is opened
    When user enters ifsc code as "CGD456212"
    And clicks on submit buttom 
		Then verify mgs contains "Bank is already in List" 
		
	Scenario: functionality of clear button
    When user clicks on edit button	
    Then new window is opened
    When clicks on clear buttom 
		Then verify textfeild is cleared   


	Scenario: add/edit bank by same/different IFSC/MIRC
		Then assert fail


	Scenario: To  check/verify admin can remove bank details with remove button
    Then user verify remove button persent on DOM
    

	










