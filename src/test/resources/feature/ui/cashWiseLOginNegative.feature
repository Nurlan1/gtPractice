
Feature:CashWise login page
@cashwise
  Scenario Outline:CashWise negative login
    Given  I am on the CahWise login page
    And    I Click on signIn button
    When   I input  "<email>" and "<password>"
    Then   I should land on "<url>" page

    Examples:
      | email       | password | url                                     |
      | test        | test     | https://cashwise.us/main?showLogin=true |
      #| hi@test.com | test     | https://cashwise.us/main?showLogin=true |
      #|             | test     | https://cashwise.us/main?showLogin=true |
      # | hi@test.com |          | https://cashwise.us/main?showLogin=true |



     Scenario Outline: Verifying the error message for negative login
       Given I am on the CahWise login page
       And I Click on signIn button
       When   I input  "<email>" and "<password>"
       Then User sees error message "<email error message>" and "<password error message>"

       Examples:
         | email          | password | email error message                | password error message                 |
         | test@gmail.com | test     |                                    | Password must be at least 6 characters |
         | test           | test123  | Please enter a valid email address |                                        |
         | test           | test     | Please enter a valid email address | Password must be at least 6 characters |
