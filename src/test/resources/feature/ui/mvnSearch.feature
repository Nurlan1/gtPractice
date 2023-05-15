Feature: MVN Repository Search


  Scenario: Verifying the search result for mvn repository
    Given I am on the mvnRepository page
    When I should be able to search for "Cucumber"
    Then  I as a user should see only "cucumber" related results

