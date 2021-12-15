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
Feature: AC Opening
  I want to use this template for my feature file


	Background: user will be at A/C opening interface
    Given c-user is on Savings-Account Interface "http://localhost:8080/SavingsAccount"
    And c-user c-user clicks on Customer Link
    When c-user enters valid Credential "username" and "password"
    Then c-user click on login buttons
    When c-user mouse Over Account
    And c-user click On A/C Opening Sub-Menu
    Then c-user verify Title as "Open Account"
    
    
  Scenario Outline: Customer Login		#Duplicate entry is allowed so we cant processes further.  for more variable inputs provide it in examples 
      When C-User enter the following data
       |bank_id|<bank_id>|
    	 |branch_id| <branch_id>|
  	   |account_type| <account_type> |
	     |account_no| <account_no> |
  	   |account_status| <account_status> |
 	     |operation| <operation> |
 	     |balance| <balance> |
 	     |debit_card_no| <debit_card_no> |
 	     |nomination| <nomination> |
   	   |cosigner| <cosigner> |
   	   |text_feild_Contains_mgs| <text_feild_Contains_mgs> |
      And C-User clicks on Submit button
      Then C-User verify The contain of page

    Examples: 
      | bank_id	| branch_id | account_type | account_no | account_status | operation | balance | debit_card_no | nomination | cosigner | text_feild_Contains_mgs |
      | SBI     | BOI Amaravati | Savings	 | 2          | New            | Single    | 1000    | 1000          | 1000 			| regf		 | successfully  					 |
      | SBI     | BOI Amaravati | Savings	 | 2 					| New 						| Single	 | 1000		 | 1000 				 | 1000 			| regf		 | Duplicate    					 |
      | BOI 	  | BOI Amaravati | Savings	 | 2 					| New 						| Single	 | 1000		 | 1000 				 | 1000 			| regf 	   | Duplicate     						 |
      | HDFC	  | BOI Amaravati | Savings	 | 2 					| New 						| Single 	 | 1000		 | 1000 				 | 1000 			| regf 		 | Duplicate 								 |
      
			Scenario: verify balance is reflected in account		#False
				When user navigate to balance Enquiry
				Then verify the balance 

  