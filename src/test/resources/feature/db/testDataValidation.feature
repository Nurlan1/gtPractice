Feature:Employee Data validation

  Scenario: Verify the creation of a new employee

    Given I have access to the database
    When  I create a new employee with 3398 as employee_id, "Fera" as a first_name, "Dina", "fdina@gmail.com", "112.334.343","22-Jan-21", 5, 3300, 100, 10
    Then the record should be successfully inserted

    Scenario Outline:

      Given I have access to the database
      And  I update 





      Examples:
