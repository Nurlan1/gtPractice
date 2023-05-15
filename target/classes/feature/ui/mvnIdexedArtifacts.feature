Feature:  MVN Repository Indexed Artifact

  Scenario: Verifying the result for Indexed Artifacts
    Given User is on the mvnrepository main page
    When  User click on the Indexed Artifact menu
    Then  User should see 20 listed results header "Top 20 Repositories"
    And   User should see "20" repositories in the result
