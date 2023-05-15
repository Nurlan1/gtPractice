Feature: Get All clients API

  @dddd
  Scenario: Verifying number of clients

    Given User hits all clients API "/api/myaccount/clients" "false" "1" "5"
    Then  User verifies that the total number of clients should be "3"


