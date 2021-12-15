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
Feature: Withdraw interface


Background: user will be at Withdraw interface
    Given c-user is  on Saving Account interface "http://localhost:8080/SavingsAccount"
    And c-user   clicks on Customer  link
    When c-user  Enters valid credential  "username" and "password"
    Then c-user  Click on Login  buttons
    When c-user  move  mouse Over  Account
    And c-user  click On Withdraw  Sub-menu
    Then c-user  verify   title  "Withdraw"
    
  Scenario Outline: Withdraw in different account by same customer
    When C-user provided account num as <accountNum> and amount as <amount>
    Then C-user verifys the <status> in step

    Examples: 
      | accountNum   						| amount | status     |
      | 1-SBI-SBI Wardha-Saving |   500  | Successful |
      | 10-SBI-SBI Wardha-Saving|   100  | Successful |

      
   @tag1
  Scenario: cancel button functionality
     When C-user provided account num as "1-SBI-SBI Wardha-Saving" and amount as 100
     And C-user click on cancel button
    Then C-user verify the Amount field as empty
    
    
    
    
    
    
    
    
    
    
    





    
    
    
    
    
    
    
    