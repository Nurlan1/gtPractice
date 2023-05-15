Feature: Benefit offers

  Scenario: Verifying the offer benefits on homepage
    Given I am on the CahWise login page
    When  User scrolls down to four offer benefits on homepage
    Then User should see four offers
      | Convenient infographics |
      | General access          |
      | Advanced Analytics      |
      | Security                |