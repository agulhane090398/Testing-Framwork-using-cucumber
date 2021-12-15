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
Feature: Admin login Interface
  Exploring functionality ofAdmin Login interface
  
  Background: user will be at admin interface
    Given user is on Savings-Account interface "http://localhost:8080/SavingsAccount"
    And user clicks on Admin link
    When user enters valid credential "admin" and "admin"
    Then click on login button
    
    
  @tag1
  Scenario: Check Admin Profile
    When user clicks on admin profile link
    Then user verify admin-profile
    
    
  @tag1
  Scenario: Interact with web-element bank
    When user mouse over Setup
    And click on bank Sub-Menu
    Then user verify title as "Bank List"
    
       
  @tag1
  Scenario: Interact with web-element branch
    When user mouse over Setup
    And click on branch Sub-Menu
    Then user verify title as "Branch List"
    
       
  @tag1
  Scenario: Interact with web-element customer
    When user mouse over Setup
    And click on customer Sub-Menu
    Then user verify title as "Customer Profile"
    

 
