Feature: Adding products to Cart


  Scenario Outline:

    Given user on the DemoBlaze application
    And  user add to cart "<Product>"
    And user sees "Product added"
    When user clicks on  Cart
    Then user should be able to see the same "<Product>", "<price>" of added product

Examples:
  | Product           | price |
  | Samsung galaxy s6 | 360   |
  | Nokia lumia 1520  | 820   |
  | Nexus 6           | 650   |


    @demo
    Scenario:

      Given user on the DemoBlaze application
      And  user add to cart products and sees "Product added"
        | Samsung galaxy s6 |
        | Nokia lumia 1520  |
        | Nexus 6           |

      When user clicks on  Cart
      Then user should be able to see the same "<Product>", "<price>" of added products
