Feature: CashWise payment method

@practice
  Scenario: Create new invoice functionality verification

    Given User is on the cashWise web page
    And  User logs  in with valid credentials  "user99@gmail.com" and "123456"
    When  User is on the reposts chat
    When User clicks on the create invoice button
    And User fill all the requested information and clicks on the save button
    Then User should see "Successfully created" message

Scenario: Get all the payment methods

  Given User is on the cashWise web page
  And  User logs  in with valid credentials  "user99@gmail.com" and "123456"
  When  User is on the reposts chat
  Then User verifies the list of payment methods

Scenario: Edit payment methods

  Given User is on the cashWise web page
  And  User logs in with valid credentials  "user99@gmail.com" and "123456"
  When  User is on the reposts chat
  When User clicks on the edit icon next to certain payment
  And User edits all the requested information in the module window and clicks on the save button
  Then User should see "Successfully changed" message
  And User verifies the title of payment method for "New Title"

  Scenario: Delete payment method

    Given User is on the cashWise web page
    And  User logs in with valid credentials  "user99@gmail.com" and "123456"
    When  User is on the reposts chat
    When User clicks on the edit icon next to certain payment
    And  User clicks on the delete icon next to certain payment
    When User should see "Are you sure you want to delete?" message and clicks on the delete button
    Then User couldn't see deleted payment method and list of payment should be decreased for one

