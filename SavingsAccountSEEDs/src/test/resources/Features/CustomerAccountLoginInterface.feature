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
Feature: Customer Account login Interface
  Exploring functionality ofCustomer Login interface
  
  Background: c-user will be at customer interface
    Given c-user is on Savings-Account interface "http://localhost:8080/SavingsAccount"
    And c-user c-user clicks on Customer link
    When c-user enters valid credential "username" and "password"
    Then c-user click on login button
    
    
  @tag1
  Scenario: Check Customer Profile
    When c-user c-user clicks on customer profile link
    Then c-user verify title as "customer-profile"
    
    
  @tag1
  Scenario: Interact with web-element A/C Opening
    When c-user mouse over Account
    And c-user click on A/C Opening Sub-Menu
    Then c-user verify title as "Open Account"
    
       
  @tag1
  Scenario: Interact with web-element Balanace Enquiry
    When c-user mouse over Account
    And c-user click on Balanace Enquiry Sub-Menu
    Then c-user verify title as "Balanace Enquiry"
    
       
  @tag1
  Scenario: Interact with web-element Mini-Statement		#Insert title here
    When c-user mouse over Account
    And c-user click on Mini-Statement Sub-Menu
    Then c-user verify title as "Mini-Statement"				
    
  @tag1
  Scenario: Interact with web-element Statement		#Insert title here
    When c-user mouse over Account
    And c-user click on Statement Sub-Menu
    Then c-user verify title as "Statement"							
    
@tag1
  Scenario: Interact with web-element Deposit
    When c-user mouse over Transaction
    And c-user click on Deposit Sub-Menu
    Then c-user verify title as "Deposit"
    
    @tag1
  Scenario: Interact with web-element Withdraw
    When c-user mouse over Transaction
    And c-user click on Withdraw Sub-Menu
    Then c-user verify title as "Withdraw"
    
    @tag1
  Scenario: Interact with web-element Transfer
    When c-user mouse over Transaction
    And c-user click on Transfer Sub-Menu
    Then c-user verify title as "Transfer"
 
