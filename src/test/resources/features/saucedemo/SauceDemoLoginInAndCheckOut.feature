@regression
Feature: User Login and Checkout

  Scenario Outline : User login, add item to cart, and complete checkout

    Given User provides username and password and login for SauceDemo Website
    Then User chooses the first '<item>' and clicks Add to cart
    Then User clicks on the cart sign on the top right
    And User clicks on the checkout button
    Then User fills in the '<firstname>','<lastname>', and '<zipCode>'
    And User clicks on the Continue Button
    Then User Validates the '<item>', '<item total amount>', and '<tax amount>'
    And User Validates the '<item price>' plus '<tax amount>' mathces  with the '<item total amount>'
    And User clicks on the Finish Button
    Then User alidates the Thank you for your order message

    Examples:
      | item                              | firstname | lastname | zipCode | item price | tax amount | item total amount |
      | Sauce Labs Backpack               | Ulzii     | Ganbat   | 60089   | 29.99      | 2.40       | 32.39             |
      | Sauce Labs Bolt T-Shirt           | David     | Johnson  | 60102   | 15.99      | 1.28       | 17.27             |
      | Sauce Labs Onesie                 | John      | Jones    | 60869   | 7.99       | 0.64       | 8.63              |
      | Sauce Labs Bike Light             | Alex      | Smith    | 69789   | 9.99       | 0.80       | 10.79             |
      | Sauce Labs Fleece Jacket          | Chris     | Smith    | 69456   | 49.99      | 4.00       | 53.99             |
      | Test.allTheThings() T-Shirt (Red) | Mike      | Smith    | 69768   | 15.99      | 1.28       | 17.27             |
