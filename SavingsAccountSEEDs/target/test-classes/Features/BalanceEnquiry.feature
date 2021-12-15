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
Feature: Balance Enquiry interface


  Background: user will be at Bank Enquiry
    Given c-user is On Savings-Account Interface "http://localhost:8080/SavingsAccount"
    And c-user c-user clicks On Customer Link
    When c-user enters Valid Credential "username" and "password"
    Then c-user click On login buttons
    When c-user moves mouse over Account
    And c-user click On Balance Enquiry Sub-Menu
    Then c-user Verify Title as "Balance Enquiry"
  
  @tag1
  Scenario: verify balance is displayed or not
    When C-user reads numerical value displayed on screen and database
    Then C-user validate the assert
    

  