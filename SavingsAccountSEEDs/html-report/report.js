$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/Features/AC_Opening.feature");
formatter.feature({
  "name": "AC Opening",
  "description": "  I want to use this template for my feature file",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@tag"
    }
  ]
});
formatter.scenarioOutline({
  "name": "Customer Login\t\t#Duplicate entry is allowed so we cant processes further.  for more variable inputs provide it in examples",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "C-User enter the following data",
  "keyword": "When ",
  "rows": [
    {
      "cells": [
        "bank_id",
        "\u003cbank_id\u003e"
      ]
    },
    {
      "cells": [
        "branch_id",
        "\u003cbranch_id\u003e"
      ]
    },
    {
      "cells": [
        "account_type",
        "\u003caccount_type\u003e"
      ]
    },
    {
      "cells": [
        "account_no",
        "\u003caccount_no\u003e"
      ]
    },
    {
      "cells": [
        "account_status",
        "\u003caccount_status\u003e"
      ]
    },
    {
      "cells": [
        "operation",
        "\u003coperation\u003e"
      ]
    },
    {
      "cells": [
        "balance",
        "\u003cbalance\u003e"
      ]
    },
    {
      "cells": [
        "debit_card_no",
        "\u003cdebit_card_no\u003e"
      ]
    },
    {
      "cells": [
        "nomination",
        "\u003cnomination\u003e"
      ]
    },
    {
      "cells": [
        "cosigner",
        "\u003ccosigner\u003e"
      ]
    },
    {
      "cells": [
        "text_feild_Contains_mgs",
        "\u003ctext_feild_Contains_mgs\u003e"
      ]
    }
  ]
});
formatter.step({
  "name": "C-User clicks on Submit button",
  "keyword": "And "
});
formatter.step({
  "name": "C-User verify The contain of page",
  "keyword": "Then "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "bank_id",
        "branch_id",
        "account_type",
        "account_no",
        "account_status",
        "operation",
        "balance",
        "debit_card_no",
        "nomination",
        "cosigner",
        "text_feild_Contains_mgs"
      ]
    },
    {
      "cells": [
        "SBI",
        "BOI Amaravati",
        "Savings",
        "2",
        "New",
        "Single",
        "1000",
        "1000",
        "1000",
        "regf",
        "successfully"
      ]
    },
    {
      "cells": [
        "SBI",
        "BOI Amaravati",
        "Savings",
        "2",
        "New",
        "Single",
        "1000",
        "1000",
        "1000",
        "regf",
        "Duplicate"
      ]
    },
    {
      "cells": [
        "BOI",
        "BOI Amaravati",
        "Savings",
        "2",
        "New",
        "Single",
        "1000",
        "1000",
        "1000",
        "regf",
        "Duplicate"
      ]
    },
    {
      "cells": [
        "HDFC",
        "BOI Amaravati",
        "Savings",
        "2",
        "New",
        "Single",
        "1000",
        "1000",
        "1000",
        "regf",
        "Duplicate"
      ]
    }
  ]
});
formatter.background({
  "name": "user will be at A/C opening interface",
  "description": "",
  "keyword": "Background"
});
formatter.step({
  "name": "c-user is on Savings-Account Interface \"http://localhost:8080/SavingsAccount\"",
  "keyword": "Given "
});
formatter.match({
  "location": "TC_AC_Opening.c_user_is_on_Savings_Account_Interface(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "c-user c-user clicks on Customer Link",
  "keyword": "And "
});
formatter.match({
  "location": "TC_AC_Opening.c_user_c_user_clicks_on_Customer_Link()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "c-user enters valid Credential \"username\" and \"password\"",
  "keyword": "When "
});
formatter.match({
  "location": "TC_AC_Opening.c_user_enters_valid_Credential_and(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "c-user click on login buttons",
  "keyword": "Then "
});
formatter.match({
  "location": "TC_AC_Opening.c_user_click_on_login_buttons()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "c-user mouse Over Account",
  "keyword": "When "
});
formatter.match({
  "location": "TC_AC_Opening.c_user_mouse_Over_Account()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "c-user click On A/C Opening Sub-Menu",
  "keyword": "And "
});
formatter.match({
  "location": "TC_AC_Opening.c_user_click_On_A_C_Opening_Sub_Menu()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "c-user verify Title as \"Open Account\"",
  "keyword": "Then "
});
formatter.match({
  "location": "TC_AC_Opening.c_user_verify_Title_as(String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Customer Login\t\t#Duplicate entry is allowed so we cant processes further.  for more variable inputs provide it in examples",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@tag"
    }
  ]
});
formatter.step({
  "name": "C-User enter the following data",
  "rows": [
    {
      "cells": [
        "bank_id",
        "SBI"
      ]
    },
    {
      "cells": [
        "branch_id",
        "BOI Amaravati"
      ]
    },
    {
      "cells": [
        "account_type",
        "Savings"
      ]
    },
    {
      "cells": [
        "account_no",
        "2"
      ]
    },
    {
      "cells": [
        "account_status",
        "New"
      ]
    },
    {
      "cells": [
        "operation",
        "Single"
      ]
    },
    {
      "cells": [
        "balance",
        "1000"
      ]
    },
    {
      "cells": [
        "debit_card_no",
        "1000"
      ]
    },
    {
      "cells": [
        "nomination",
        "1000"
      ]
    },
    {
      "cells": [
        "cosigner",
        "regf"
      ]
    },
    {
      "cells": [
        "text_feild_Contains_mgs",
        "successfully"
      ]
    }
  ],
  "keyword": "When "
});
formatter.match({
  "location": "TC_AC_Opening.c_User_enter_the_following_data(DataTable)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "C-User clicks on Submit button",
  "keyword": "And "
});
formatter.match({
  "location": "TC_AC_Opening.c_User_clicks_on_Submit_button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "C-User verify The contain of page",
  "keyword": "Then "
});
formatter.match({
  "location": "TC_AC_Opening.c_User_verify_The_contain_of_page()"
});
formatter.result({
  "status": "passed"
});
formatter.background({
  "name": "user will be at A/C opening interface",
  "description": "",
  "keyword": "Background"
});
formatter.step({
  "name": "c-user is on Savings-Account Interface \"http://localhost:8080/SavingsAccount\"",
  "keyword": "Given "
});
formatter.match({
  "location": "TC_AC_Opening.c_user_is_on_Savings_Account_Interface(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "c-user c-user clicks on Customer Link",
  "keyword": "And "
});
formatter.match({
  "location": "TC_AC_Opening.c_user_c_user_clicks_on_Customer_Link()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "c-user enters valid Credential \"username\" and \"password\"",
  "keyword": "When "
});
formatter.match({
  "location": "TC_AC_Opening.c_user_enters_valid_Credential_and(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "c-user click on login buttons",
  "keyword": "Then "
});
formatter.match({
  "location": "TC_AC_Opening.c_user_click_on_login_buttons()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "c-user mouse Over Account",
  "keyword": "When "
});
formatter.match({
  "location": "TC_AC_Opening.c_user_mouse_Over_Account()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "c-user click On A/C Opening Sub-Menu",
  "keyword": "And "
});
formatter.match({
  "location": "TC_AC_Opening.c_user_click_On_A_C_Opening_Sub_Menu()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "c-user verify Title as \"Open Account\"",
  "keyword": "Then "
});
formatter.match({
  "location": "TC_AC_Opening.c_user_verify_Title_as(String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Customer Login\t\t#Duplicate entry is allowed so we cant processes further.  for more variable inputs provide it in examples",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@tag"
    }
  ]
});
formatter.step({
  "name": "C-User enter the following data",
  "rows": [
    {
      "cells": [
        "bank_id",
        "SBI"
      ]
    },
    {
      "cells": [
        "branch_id",
        "BOI Amaravati"
      ]
    },
    {
      "cells": [
        "account_type",
        "Savings"
      ]
    },
    {
      "cells": [
        "account_no",
        "2"
      ]
    },
    {
      "cells": [
        "account_status",
        "New"
      ]
    },
    {
      "cells": [
        "operation",
        "Single"
      ]
    },
    {
      "cells": [
        "balance",
        "1000"
      ]
    },
    {
      "cells": [
        "debit_card_no",
        "1000"
      ]
    },
    {
      "cells": [
        "nomination",
        "1000"
      ]
    },
    {
      "cells": [
        "cosigner",
        "regf"
      ]
    },
    {
      "cells": [
        "text_feild_Contains_mgs",
        "Duplicate"
      ]
    }
  ],
  "keyword": "When "
});
formatter.match({
  "location": "TC_AC_Opening.c_User_enter_the_following_data(DataTable)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "C-User clicks on Submit button",
  "keyword": "And "
});
formatter.match({
  "location": "TC_AC_Opening.c_User_clicks_on_Submit_button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "C-User verify The contain of page",
  "keyword": "Then "
});
formatter.match({
  "location": "TC_AC_Opening.c_User_verify_The_contain_of_page()"
});
formatter.result({
  "error_message": "java.lang.AssertionError\r\n\tat org.junit.Assert.fail(Assert.java:87)\r\n\tat org.junit.Assert.assertTrue(Assert.java:42)\r\n\tat org.junit.Assert.assertTrue(Assert.java:53)\r\n\tat stepdefination.TC_AC_Opening.c_User_verify_The_contain_of_page(TC_AC_Opening.java:153)\r\n\tat ✽.C-User verify The contain of page(file:src/test/resources/Features/AC_Opening.feature:48)\r\n",
  "status": "failed"
});
formatter.background({
  "name": "user will be at A/C opening interface",
  "description": "",
  "keyword": "Background"
});
formatter.step({
  "name": "c-user is on Savings-Account Interface \"http://localhost:8080/SavingsAccount\"",
  "keyword": "Given "
});
formatter.match({
  "location": "TC_AC_Opening.c_user_is_on_Savings_Account_Interface(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "c-user c-user clicks on Customer Link",
  "keyword": "And "
});
formatter.match({
  "location": "TC_AC_Opening.c_user_c_user_clicks_on_Customer_Link()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "c-user enters valid Credential \"username\" and \"password\"",
  "keyword": "When "
});
formatter.match({
  "location": "TC_AC_Opening.c_user_enters_valid_Credential_and(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "c-user click on login buttons",
  "keyword": "Then "
});
formatter.match({
  "location": "TC_AC_Opening.c_user_click_on_login_buttons()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "c-user mouse Over Account",
  "keyword": "When "
});
formatter.match({
  "location": "TC_AC_Opening.c_user_mouse_Over_Account()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "c-user click On A/C Opening Sub-Menu",
  "keyword": "And "
});
formatter.match({
  "location": "TC_AC_Opening.c_user_click_On_A_C_Opening_Sub_Menu()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "c-user verify Title as \"Open Account\"",
  "keyword": "Then "
});
formatter.match({
  "location": "TC_AC_Opening.c_user_verify_Title_as(String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Customer Login\t\t#Duplicate entry is allowed so we cant processes further.  for more variable inputs provide it in examples",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@tag"
    }
  ]
});
formatter.step({
  "name": "C-User enter the following data",
  "rows": [
    {
      "cells": [
        "bank_id",
        "BOI"
      ]
    },
    {
      "cells": [
        "branch_id",
        "BOI Amaravati"
      ]
    },
    {
      "cells": [
        "account_type",
        "Savings"
      ]
    },
    {
      "cells": [
        "account_no",
        "2"
      ]
    },
    {
      "cells": [
        "account_status",
        "New"
      ]
    },
    {
      "cells": [
        "operation",
        "Single"
      ]
    },
    {
      "cells": [
        "balance",
        "1000"
      ]
    },
    {
      "cells": [
        "debit_card_no",
        "1000"
      ]
    },
    {
      "cells": [
        "nomination",
        "1000"
      ]
    },
    {
      "cells": [
        "cosigner",
        "regf"
      ]
    },
    {
      "cells": [
        "text_feild_Contains_mgs",
        "Duplicate"
      ]
    }
  ],
  "keyword": "When "
});
formatter.match({
  "location": "TC_AC_Opening.c_User_enter_the_following_data(DataTable)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "C-User clicks on Submit button",
  "keyword": "And "
});
formatter.match({
  "location": "TC_AC_Opening.c_User_clicks_on_Submit_button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "C-User verify The contain of page",
  "keyword": "Then "
});
formatter.match({
  "location": "TC_AC_Opening.c_User_verify_The_contain_of_page()"
});
formatter.result({
  "error_message": "java.lang.AssertionError\r\n\tat org.junit.Assert.fail(Assert.java:87)\r\n\tat org.junit.Assert.assertTrue(Assert.java:42)\r\n\tat org.junit.Assert.assertTrue(Assert.java:53)\r\n\tat stepdefination.TC_AC_Opening.c_User_verify_The_contain_of_page(TC_AC_Opening.java:153)\r\n\tat ✽.C-User verify The contain of page(file:src/test/resources/Features/AC_Opening.feature:48)\r\n",
  "status": "failed"
});
formatter.background({
  "name": "user will be at A/C opening interface",
  "description": "",
  "keyword": "Background"
});
formatter.step({
  "name": "c-user is on Savings-Account Interface \"http://localhost:8080/SavingsAccount\"",
  "keyword": "Given "
});
formatter.match({
  "location": "TC_AC_Opening.c_user_is_on_Savings_Account_Interface(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "c-user c-user clicks on Customer Link",
  "keyword": "And "
});
formatter.match({
  "location": "TC_AC_Opening.c_user_c_user_clicks_on_Customer_Link()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "c-user enters valid Credential \"username\" and \"password\"",
  "keyword": "When "
});
formatter.match({
  "location": "TC_AC_Opening.c_user_enters_valid_Credential_and(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "c-user click on login buttons",
  "keyword": "Then "
});
formatter.match({
  "location": "TC_AC_Opening.c_user_click_on_login_buttons()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "c-user mouse Over Account",
  "keyword": "When "
});
formatter.match({
  "location": "TC_AC_Opening.c_user_mouse_Over_Account()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "c-user click On A/C Opening Sub-Menu",
  "keyword": "And "
});
formatter.match({
  "location": "TC_AC_Opening.c_user_click_On_A_C_Opening_Sub_Menu()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "c-user verify Title as \"Open Account\"",
  "keyword": "Then "
});
formatter.match({
  "location": "TC_AC_Opening.c_user_verify_Title_as(String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Customer Login\t\t#Duplicate entry is allowed so we cant processes further.  for more variable inputs provide it in examples",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@tag"
    }
  ]
});
formatter.step({
  "name": "C-User enter the following data",
  "rows": [
    {
      "cells": [
        "bank_id",
        "HDFC"
      ]
    },
    {
      "cells": [
        "branch_id",
        "BOI Amaravati"
      ]
    },
    {
      "cells": [
        "account_type",
        "Savings"
      ]
    },
    {
      "cells": [
        "account_no",
        "2"
      ]
    },
    {
      "cells": [
        "account_status",
        "New"
      ]
    },
    {
      "cells": [
        "operation",
        "Single"
      ]
    },
    {
      "cells": [
        "balance",
        "1000"
      ]
    },
    {
      "cells": [
        "debit_card_no",
        "1000"
      ]
    },
    {
      "cells": [
        "nomination",
        "1000"
      ]
    },
    {
      "cells": [
        "cosigner",
        "regf"
      ]
    },
    {
      "cells": [
        "text_feild_Contains_mgs",
        "Duplicate"
      ]
    }
  ],
  "keyword": "When "
});
formatter.match({
  "location": "TC_AC_Opening.c_User_enter_the_following_data(DataTable)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "C-User clicks on Submit button",
  "keyword": "And "
});
formatter.match({
  "location": "TC_AC_Opening.c_User_clicks_on_Submit_button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "C-User verify The contain of page",
  "keyword": "Then "
});
formatter.match({
  "location": "TC_AC_Opening.c_User_verify_The_contain_of_page()"
});
formatter.result({
  "error_message": "java.lang.AssertionError\r\n\tat org.junit.Assert.fail(Assert.java:87)\r\n\tat org.junit.Assert.assertTrue(Assert.java:42)\r\n\tat org.junit.Assert.assertTrue(Assert.java:53)\r\n\tat stepdefination.TC_AC_Opening.c_User_verify_The_contain_of_page(TC_AC_Opening.java:153)\r\n\tat ✽.C-User verify The contain of page(file:src/test/resources/Features/AC_Opening.feature:48)\r\n",
  "status": "failed"
});
formatter.background({
  "name": "user will be at A/C opening interface",
  "description": "",
  "keyword": "Background"
});
formatter.step({
  "name": "c-user is on Savings-Account Interface \"http://localhost:8080/SavingsAccount\"",
  "keyword": "Given "
});
formatter.match({
  "location": "TC_AC_Opening.c_user_is_on_Savings_Account_Interface(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "c-user c-user clicks on Customer Link",
  "keyword": "And "
});
formatter.match({
  "location": "TC_AC_Opening.c_user_c_user_clicks_on_Customer_Link()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "c-user enters valid Credential \"username\" and \"password\"",
  "keyword": "When "
});
formatter.match({
  "location": "TC_AC_Opening.c_user_enters_valid_Credential_and(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "c-user click on login buttons",
  "keyword": "Then "
});
formatter.match({
  "location": "TC_AC_Opening.c_user_click_on_login_buttons()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "c-user mouse Over Account",
  "keyword": "When "
});
formatter.match({
  "location": "TC_AC_Opening.c_user_mouse_Over_Account()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "c-user click On A/C Opening Sub-Menu",
  "keyword": "And "
});
formatter.match({
  "location": "TC_AC_Opening.c_user_click_On_A_C_Opening_Sub_Menu()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "c-user verify Title as \"Open Account\"",
  "keyword": "Then "
});
formatter.match({
  "location": "TC_AC_Opening.c_user_verify_Title_as(String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "verify balance is reflected in account\t\t#False",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@tag"
    }
  ]
});
formatter.step({
  "name": "user navigate to balance Enquiry",
  "keyword": "When "
});
formatter.match({
  "location": "TC_AC_Opening.user_navigate_to_balance_Enquiry()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "verify the balance",
  "keyword": "Then "
});
formatter.match({
  "location": "TC_AC_Opening.verify_the_balance()"
});
formatter.result({
  "error_message": "java.lang.AssertionError\r\n\tat org.junit.Assert.fail(Assert.java:87)\r\n\tat org.junit.Assert.assertTrue(Assert.java:42)\r\n\tat org.junit.Assert.assertTrue(Assert.java:53)\r\n\tat stepdefination.TC_AC_Opening.verify_the_balance(TC_AC_Opening.java:172)\r\n\tat ✽.verify the balance(file:src/test/resources/Features/AC_Opening.feature:59)\r\n",
  "status": "failed"
});
});