@regression
Feature: Testing food Group order functionality for Weborder website
  //general description of the test

  Background:Food Order same steps
    Given User provides username and password for successful login
    When User clicks GroupOrderBox,clicks NextButton
    And User provides note 'I LOVE SELENIUM' to invitees box
    And User provides gmail 'ulzii55@gmail.com','ahmet@gmail.com' to invite list

  Scenario: Testing Happy Path for Place Group Order
    And User chooses the location 'My House' and validates address '3137 Laguna'
    And User clicks Create Group Order Button
    Then User validates the 'View Group Order' and 'Your Group order is now pending' from description


  Scenario: Testing Happy Path for Office Food Order
    And User chooses the location 'Office' and validates address '2012 EMPIRE BLVD'
    And User clicks Create Group Order Button
    Then User validates the 'View Group Order' and 'Your Group order is now pending' from description
