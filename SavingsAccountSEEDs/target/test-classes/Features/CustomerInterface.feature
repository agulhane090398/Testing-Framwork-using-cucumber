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
Feature: Customer Interface


	Background: User will be at customer Interface
    Given User should be on Savings-Account Interface "http://localhost:8080/SavingsAccount"
    And Clicks on Admin Link
    When User Enters valid credentials "admin" and "admin"
    Then Click on login button present on it
    When User moves mouse over Setup Menu
    And Click on Customer Sub-menu
    Then User verifys title as "Customer Profile"
	
	
  @tag1
  Scenario: Add customer new in list
    When User Enters the following data
    |customer_type | invidual |
    |Title | Mr |
    |first_name | Aniket |
    |middle_name | Sanjay |
    |last_name | Gulhane |
    |dob | 09-03-1998 |
    |phone_no | 7350813275 |
    |email_id | agulhane090398@gmail.com |
    |gender | Male  |
    |address_line1 | B18 Jasrana Appartment |
    |address_line2| Ek vira chowk |
    |address_line3| Darwha Road |
    |pin_code| 445001 |
    |city| Yavatmal |
    |state | Maharashtra |
    |country | India |
    |nationality | Indian  |
    |pan | BVFPG6971D |
    |aadhar_no| 233916313155 |
    |marital_status| Single |
    |username| agulhane090398@gmail.com |
    |password| Pass@123 |
    And Clicks on Submit buttom 
    Then Verify mgs Contains "Record Created"
    
  Scenario: Add duplicate customer in list 		#Index is made as PrimaryKey so furthure tests will definetely fail #Primary Key should be IFSC code
    When User Enters the following data
    |customer_type | invidual |
    |Title | Mr |
    |first_name | Aniket |
    |middle_name | Sanjay |
    |last_name | Gulhane |
    |dob | 09-03-1998 |
    |phone_no | 7350813275 |
    |email_id | agulhane090398@gmail.com |
    |gender | Male  |
    |address_line1 | B18 Jasrana Appartment |
    |address_line2| Ek vira chowk |
    |address_line3| Darwha Road |
    |pin_code| 445001 |
    |city| Yavatmal |
    |state | Maharashtra |
    |country | India |
    |nationality | Indian  |
    |pan | BVFPG6971D |
    |aadhar_no| 233916313155 |
    |marital_status| Single |
    |username| agulhane090398@gmail.com |
    |password| Pass@123 |
    And Clicks on Submit buttom 
    Then Verify mgs Contains "Duplicate username, choose another"
     
	
	Scenario: functionality of Reset button
    When Clicks on reset buttom 
		Then Verify textfeilds are cleared   


	Scenario: add/edit customer by same/different (customer_type/Pan no/Adhar no)
		Then assert fails



	










