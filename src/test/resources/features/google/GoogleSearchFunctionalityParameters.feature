@apiregression
Feature: Testing the Google Search Functionality Parameters
  Background: navigate to the website same step
    Given User navigate to the 'https://www.google.com/'

  Scenario: Happy Path(positive) Testing for Search Parameters
    When  User searches for 'CodeFish'
    Then  User validates first page returns more than 10 Links

  Scenario: Happy Path(positive) Testing Result for Search Parameters
    When User searches for 'Kyrgyz Food in USA'
    Then User validates the result is less than 300000000
@smoke
  Scenario: Testing Loading Time Search for an Item Parameters
    When User searches for 'Turkish Baklava'
    Then User validates it loads less than 1.0