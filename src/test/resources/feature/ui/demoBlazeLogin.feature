Feature: DemoBlaze login page

  Scenario: Positive logIn verification

    Given user on the DemoBlaze application
    When user click on the logIn button for demo blaze
    And  user enters credentials "test" and "test" and clicks login
    Then user should successfully login to application