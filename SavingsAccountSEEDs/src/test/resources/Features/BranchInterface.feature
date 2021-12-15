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


	Background: User will be at branch interface
    Given User should be on Savings-Account interface "http://localhost:8080/SavingsAccount"
    And Clicks on Admin link
    When User enters valid credentials "admin" and "admin"
    Then Click on login button present
    When User moves mouse over Setup
    And Click on branch Sub-menu
    Then User verifys title as "Branch List"
	
	
  @tag1
  Scenario: Add branch new in list
    When User clicks on add button
    Then new Window is opened
    When User enters the following data
    |bank | Bank of Chikago |
    |branch_name| RT Road |
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
    And Clicks on submit buttom 
    Then User validate the outcomes from the list of branch
    
  Scenario: Add duplicate branch in list #Index is made as PrimaryKey so furthure tests will definetely fail #Primary Key should be IFSC code
    When User clicks on add button			
    Then new Window is opened
    When User enters the following data
    |bank | Bank of Chikago |
    |branch_name| RT Road |
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
    And Clicks on submit buttom 
    Then Verify mgs contains "Branch is already in List"
     
  Scenario: Edit branch details
    When User clicks on edit button			
    Then new Window is opened
    When User enters ifsc code as "CGD456212"
    And Clicks on submit buttom 
		Then User validate the outcomes from the list of branch
		
	Scenario: Edit branch details with duplicate IFSC code
    When User clicks on edit button	next to preciding entry		
    Then new Window is opened
    When User enters ifsc code as "CGD456212"
    And Clicks on submit buttom 
		Then Verify mgs contains "Branch is already in List" 
		
	Scenario: functionality of clear button
    When User clicks on edit button	
    Then new Window is opened
    When Clicks on clear buttom 
		Then Verify textfeild is cleared   


	Scenario: add/edit branch by same/different IFSC/MIRC
	  Then checks for assert fails 


	Scenario: To  check/verify admin can remove branch details with remove button
    Then User verify remove button persent on DOM
    

	










