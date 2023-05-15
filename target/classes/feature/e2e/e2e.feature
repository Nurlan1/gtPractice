Feature: Create a client on API and validate with
@cw
  Scenario: Verify client

    Given User hit and POST a client "endPoint"
      | company_name | JJJJ              |
      | client_name  | kkkk              |
      | email        | gggff@.gmail.com  |
      | phone_number | 224536378         |
      | address      | lkjgfdsdfghjk 354 |
      | tag_id       | 0                |

    When User navigate to cahwise home page
    And  User navigate to Client page
    And  Get client data from UI
    Then User verify data from Backend and Frontend