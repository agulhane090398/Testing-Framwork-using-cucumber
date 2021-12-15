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
Feature: Statement Interface
# the interface is missing with format and look & fill

Background: user will be at Mini-Statement interface
    Given c-user is  on  Saving Account Interface "http://localhost:8080/SavingsAccount"
    And c-user   clicks  on Customer Link
    When c-user  Enters  valid Credential "username" and "password"
    Then c-user  Click  on login buttons
    When c-user  moves   mouse Over Account
    And c-user  click On Statement Sub-Menu
    Then c-user  verify Title  "Insert title here"

  @tag1
  Scenario: Statement to verify for credits
    When C-user enter account details for "Credit"
    And click on generate statement button
    Then C-user verify all data not for "Debit"

  @tag2
  Scenario: Title of your scenario outline
    When C-user enter account details for "Debit"
    And click on generate statement button
    Then C-user verify all data not for "Credit"

 
