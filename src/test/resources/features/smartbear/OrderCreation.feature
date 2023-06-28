@regression
Feature: Testing the Order Functionality of the SmartBear Website

  Scenario Outline: Creating the WebOrder from SmartBear
    Given User provides username and password for SmartBear login
    When User clicks Order Button provides the '<product>' and '<Quantity>' for product information
    And User provides '<Name>','<Street>','<City>','<State>','<zipCode>' for address information
    And User provides '<cardType>','<CardNumber>','<ExpDate>' for payment information
    Then User clicks process button and validates '<Message>'
    And User validates all information '<Name>','<product>','<Quantity>','<Street>','<City>','<State>','<zipCode>','<cardType>','<CardNumber>','<ExpDate>',frome table
    Examples:
      | product     | Quantity | Name   | Street        | City     | State | zipCode | cardType         | CardNumber | ExpDate | Message                                |
      | MyMoney     | 4        | Ahmet  | 123 Main St   | CHICAGO  | IL    | 60012   | Visa             | 123456     | 06/25   | New order has been successfully added. |
      | FamilyAlbum | 5        | Mehmet | 2334 Main St  | LA       | CA    | 29292   | MasterCard       | 123456     | 06/26   | New order has been successfully added. |
      | ScreenSaver | 6        | Ayse   | 1234 Devon St | NEW YORK | NY    | 10001   | American Express | 123456     | 06/27   | New order has been successfully added. |


  Scenario: Creating the WebOrder from SmartBear with DataTable

    Given User provides username and password for SmartBear login
    When User clicks OrderButton and provides the product and quantity for product information
      | product  | MyMoney |
      | quantity | 4       |
    And User provides customerName,street,city,state,zipcode for address information
      | customerName | Ulzii           |
      | street       | 123 Main Street |
      | city         | Chicago         |
      | state        | IL              |
      | zipCode      | 60102           |

    And User provides cardType,cardNumber,expireDate for payment information
      | cardType   | Visa      |
      | cardNumber | 112423453 |
      | expireDate | 06/25     |
    And User clicks procees button and validates message
      | New order has been successfully added. |

















