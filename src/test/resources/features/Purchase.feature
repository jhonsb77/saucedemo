Feature: As a user of the saucedemo.com portal
  I want to be able to select an item
  to make your purchase

  @confirmOrder
  Scenario Outline: Confirm order
    Given that an user is on login page
    When he login with account "<user>" "<pass>"
    And he select an article "<article>"
    And he confirm order on shopping cart
    And he enter the purchase information "<firstName>" "<lastName>" "<postalCode>"
    And He verifies the total of the purchase
    Then he should be to see confirm purchase message
    Examples:
    | user           | pass          | article                           | firstName | lastName | postalCode |
    | standard_user  | secret_sauce  | Sauce Labs Fleece Jacket          | Juan      | Perez    |  09232     |
#    | standard_user  | secret_sauce  | Sauce Labs Onesie                 | Juan      | Perez    |  09232     |
#    | standard_user  | secret_sauce  | Test.allTheThings() T-Shirt (Red) | Juan      | Perez    |  09232     |
#    | standard_user  | secret_sauce  | Sauce Labs Bolt T-Shirt           | Juan      | Perez    |  09232     |

