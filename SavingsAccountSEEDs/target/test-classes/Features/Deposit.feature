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
Feature: Deposite interface


Background: user will be at Mini-Statement interface
    Given c-user is  on Saving Account Interface "http://localhost:8080/SavingsAccount"
    And c-user   clicks on Customer  Link
    When c-user  Enters valid Credential  "username" and "password"
    Then c-user  Click on login  buttons
    When c-user  moves  mouse Over  Account
    And c-user  click On Deposit  Sub-Menu
    Then c-user  verify   Title  "Deposit"
    
  Scenario Outline: Deposite in different account by same customer
    When C-user provideds account num as <accountNum> and amount as <amount>
    Then C-user verify the <status> in step

    Examples: 
      | accountNum  | amount | status     |
      | 1-SBI-SBI Wardha-Saving|   500  | Successful |
      | 10-SBI-SBI Wardha-Saving	|   100  | Successful |

      
   @tag1
  Scenario: cancels button functionality
     When C-user provideds account num as "1-SBI-SBI Wardha-Saving" and amount as 100
     And click on cancel button
    Then C-user verify the amount field as empty
    
    
    
    



    
    
    
    
    
    


    



    
    
    
    
    
    
    
    