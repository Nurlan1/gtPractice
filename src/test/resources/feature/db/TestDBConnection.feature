Feature: Test connection to codeWise DB

@db
  Scenario: happy path

    Given User connects to the DB
    When  "select * from employees" query
    Then  verify if data is returned


    Scenario:
      Given User try to connect to the DB with incorrect password
      Then  verify user is not able to connect