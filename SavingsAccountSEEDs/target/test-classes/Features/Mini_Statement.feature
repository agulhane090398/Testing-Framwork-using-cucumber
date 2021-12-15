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
Feature: Mini Statement

	Background: user will be at Mini-Statement interface
    Given c-user is on  Saving Account Interface "http://localhost:8080/SavingsAccount"
    And c-user  clicks  on Customer Link
    When c-user Enters  valid Credential "username" and "password"
    Then c-user Click  on login buttons
    When c-user moves   mouse Over Account
    And c-user click On Mini-Statement Sub-Menu
    Then c-user verify Title  "Insert title here"
    

  @tag1
  Scenario: Mini Statement validation
    When C-user validate check balance column available in table
    Then C-user validate count of row greater than 1
    

  #@tag2
  #Scenario Outline: Title of your scenario outline
    #Given I want to write a step with <name>
    #When I check for the <value> in step
    #Then I verify the <status> in step
#
    #Examples: 
      #| name  | value | status  |
      #| name1 |     5 | success |
      #| name2 |     7 | Fail    |
