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
Feature: Customer Account Interface
  I want to check Login feature for customer account

  Background: user will be at customer interface
    Given C-user is on Savings Account interface "http://localhost:8080/SavingsAccount"
    When user click on Customer link
    Then check Customer interface is opened

  Scenario Outline: Customer Login
      When C-User enter "<userid>" and "<pwd>"
      And C-User clicks on login button
      Then C-User verify the "<status>" in step

    Examples: 
      | userid 		| pwd   	 | status  	 		  |
      | username  | password | welcome 				|
      | username1 | password | Online Banking |
      | username  | password1| Online Banking |
      | username1 | password1| Online Banking |
      
  Scenario: Customer Login with space at end of username
  	When C-User enters "username " and "password"
    And C-User clicks on login button
    Then C-User verify by checking heading as "welcome"
  
  Scenario: Customer Login with space at end of password
  	When C-User enter "username" and "password "
    And C-User clicks on login button
    Then C-User verify by checking heading as "Online Banking"
    
  Scenario: forgot user id
  	When C-User click on forgot userId
  	Then C-User verify that count of windowhandler is 2
  	
  Scenario: forgot user password
  	When C-User click on forgot password
  	Then C-User verify that count of windowhandler is 2
  	
  Scenario: Logout button check
  	When C-User enter "username" and "password"
    And C-User clicks on login button
  	When C-User click on logout button
  	Then C-User verify by checking heading as "Online Banking"