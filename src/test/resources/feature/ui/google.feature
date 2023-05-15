

Feature:Google search


  Scenario: Verifying the results for google search
    Given I am on the Google page
    When I search for "toyota"
    Then I should see only "toyota" related results


    Scenario: Verifying image result
      Given I am on the Google page
      When I search for "James Bond"
      And I click on image option
      Then I should see only "James Bond" related images


