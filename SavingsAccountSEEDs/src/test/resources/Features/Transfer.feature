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
Feature: Transfer interface


	Background: user will be at Mini-Statement interface
    Given c-user is  On Saving Account Interface "http://localhost:8080/SavingsAccount"
    And c-user   Clicks on Customer  Link
    When c-user  Enters Valid Credential  "username" and "password"
    Then c-user  Click on Login    buttons
    When c-user  Moves  mouse Over  Transaction
    And c-user  Click On Transfer  Sub-Menu
    Then c-user  Verify   Title  "Transfer"

  @tag1
  Scenario: Transfer amount with different circumstances
     When C-User Enters the following data
       |from_account|<from_account>|
    	 |to_account| <to_account>|
  	   |reconfirm_account| <reconfirm_account> |
	     |amount| <amount> |
  	   |naration| <naration> |
 	     |ifsc| <ifsc> |
 	     |acc_holder_name| <acc_holder_name> |
      And C-User retrives the initial balance of both the acconts
      Then C-User verify The contain of page with correct results

    Examples: 
      | from_account							| to_account | reconfirm_account | amount 		| naration | ifsc 		| acc_holder_name |
      | 1-SBI-SBI Wardha-Saving | 10 				 | 10	 							 | 2          | Transfer | SBID1015 | first_name 			| 
      | 1-SBI-SBI Wardha-Saving | 1  				 | 1	 							 | 2 					| Self 	   | SBID1015	| first_name		  |
      

  @tag2
  Scenario: Clear button functionality
    When C-user enters 2 as amount and "SBID1015" as ifsc code
    And click on clear button
    Then C-user verfies feild is empty
































    