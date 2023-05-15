Feature: Popular tools MVN Repository


  Scenario: Verifying the top rated tools on mvn repository
    Given I as a User on the mvnrepository page
    When  I click on the Popular link
    Then I as a User should  see tools listed from top rated to less rated
