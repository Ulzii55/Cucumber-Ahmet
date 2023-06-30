@regression
Feature: User Login and Checkout

  Scenario Outline: User login, add item to cart, and complete checkout
    Given User provides username and password and login for SauceDemo Website
    Then User chooses the first '<item>' and clicks Add to cart
    Then User clicks on the cart sign on the top right and clicks on the checkout button
    Then User fills in the '<firstname>','<lastname>','<zipCode>' and clicks clicks on the Continue Button
    Then User Validates the '<item>','<tax amount>' is eight percent and '<item total amount>'
    And User clicks on the Finish Button
    Then User Validates '<message>'

    Examples:
      | item                              | firstname | lastname | zipCode | tax amount | item total amount | message                          |
      | Sauce Labs Backpack               | Ulzii     | Ganbat   | 60089   | 2.40       | 32.39             | Thank you for your order message |
      | Sauce Labs Bolt T-Shirt           | David     | Johnson  | 60102   | 1.28       | 17.27             | Thank you for your order message |
      | Sauce Labs Onesie                 | John      | Jones    | 60869   | 0.64       | 8.63              | Thank you for your order message |
      | Sauce Labs Bike Light             | Alex      | Smith    | 69789   | 0.80       | 10.79             | Thank you for your order message |
      | Sauce Labs Fleece Jacket          | Chris     | Smith    | 69456   | 4.00       | 53.99             | Thank you for your order message |
      | Test.allTheThings() T-Shirt (Red) | Mike      | Smith    | 69768   | 1.28       | 17.27             | Thank you for your order message |

  Scenario: User Login, add item and complet checkout with DataTable

    Given User provides username and password and login for SauceDemo Website
    Then User choosec the first item and clicks Add to cart
      | item | Sauce Labs Backpack |
    Then User clicks on the cart sign on the top right and clicks on the checkout button
    Then User fills in the (firstName,lastName, and zipCode) and clicks clicks on the Continue Button
      | firstname | Ulzii  |
      | lastname  | Ganbat |
      | zipCode   | 60089  |
    Then User Validates the (item, taxAmount is eight percent and total amount
      | item              | Sauce Labs Backpack |
      | tax amount        | 2.40                |
      | item total amount | 32.39               |
    And User clicks on the Finish Button
    Then User Validates thank you message
      | message | Thank you for your order message |















