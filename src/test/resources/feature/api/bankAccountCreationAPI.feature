Feature: Bank account creation API
# User Story: CAS-55

  Scenario Outline: Positive testing

    Given User hits create Bank account API with "<path>" "<type_of_pay>"  "<bank_account_name>" "<description>" "<balance>"
    Then  User verifies that bank account is successfully created

    Examples:
      | path                       | type_of_pay               | bank_account_name | description                     | balance |
      | /api/myaccount/bankaccount | CASH                      | Discovery         | For cash invoices               | 765     |
      | /api/myaccount/bankaccount | BANK                      | Serena Williams    | Account to bank transfer        | -666    |
      | /api/myaccount/bankaccount | ELECTRONIC_MONEY_TRANSFER | Sabina Co.        | Account for electronic transfer | 3456    |


  Scenario: Mandatory fields testing

    Given User hits create Bank account API with "path" "type_of_pay"  "bank_account_name" "balance"
    Then  User verifies that bank account is successfully created

  Scenario: Security testing

    Given User hits create Bank account API with "/api/myaccount/bankaccount" "BANK" "Bank #1" "2300" without setting the Token
    Then  User verifies that bank account didn't create by status code "403"

  Scenario: Data validating

    Given User hits create Bank account API with "path" "type_of_pay" duplicate "bank_account_name" "description" "balance"
    Then  User verifies creating with duplicate "bahk_account_name" by status code

