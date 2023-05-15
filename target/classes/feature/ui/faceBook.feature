Feature: Facebook Login

  @positive
  Scenario Outline: Login Attempt
    Given User is on the Facebook login page
    When User enters "<email>" and "<password>" and tries to log in
    Then user should be provided to main profile page and verifies by element "Friends"


    Examples:
      | email         | password  |
      | +996556030689 | a04012012 |


  Scenario:  Forgot Password Attempt
    Given User is on the Facebook login page
    When User clicks on the Forgot Password link
    Then User should be redirected to the Find Your Account page


  Scenario: Create Account Attempt
    Given User is on the Facebook login page
    When User clicks on the Create Account button
    Then User should be redirected to the Sign Up pag