@uiregression @regression
Feature: Testing the Google Search Functionality

  Background: navigate to the website step
    Given User navigate to the google

  Scenario: Happy Path(positive)Testing for Search
    When  User searches for CodeFish
    Then  User validates first page returns more than ten Links
 @smoke
  Scenario: Happy Path(positive) Testing Result for Search
    When User searches for Kyrgyz Food in USA
    Then User validates the result is less than three hundred million

  Scenario: Testing Loading Time Search for an Item
    When User searches for Turkish Baklava
    Then User validates it loads less than one seconds

















