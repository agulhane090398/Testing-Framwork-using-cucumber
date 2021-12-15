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
Feature: Admin Account Interface
  I want to check Login feature for admin account

  Background: user will be at admin interface
    Given user is on Savings Account interface "http://localhost:8080/SavingsAccount"
    When user click on Admin link
    Then check Admin interface is opened

  Scenario Outline: Admin Login
      When User enter "<userid>" and "<pwd>"
      And clicks on login button
      Then user verify the "<status>" in step

    Examples: 
      | userid | pwd   | status  	 		  |
      | admin  | admin | welcome admin  |
      | admin1 | admin | Online Banking |
      | admin  | admin1| Online Banking |
      | admin1 | admin1| Online Banking |
      
  Scenario: Admin Login with space at end of username
  	When User enter "admin " and "admin"
    And clicks on login button
    Then user verify by checking heading as "Admin"
  
  Scenario: Admin Login with space at end of password
  	When User enter "admin" and "admin "
    And clicks on login button
    Then user verify by checking heading as "Online Banking"
    
  Scenario: forgot user id
  	When user click on forgot userId
  	Then user verify that count of windowhandler is 2
  	
  Scenario: forgot user password
  	When user click on forgot password
  	Then user verify that count of windowhandler is 2
  	
  Scenario: Logout button check
  	When User enter "admin" and "admin"
    And clicks on login button
  	When user click on logout button
  	Then user verify by checking heading as "Online Banking"
