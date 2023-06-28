@regression
Feature: Testing the Search Functionality of the Etsy Website

  Scenario: Search Functionality Happy Path for Etsy hat
    When User searches for 'Hat' for Etsy
    Then User validates the title 'Hat - Etsy' from Etsy

  Scenario: Search Functionality Happy Path for Etsy key
    When User searches for 'Key' for Etsy
    Then User validates the title 'Hat - Etsy' from Etsy

  Scenario: Search Functionality Happy Path for Etsy pin
    When User searches for 'Pin' for Etsy
    Then User validates the title 'Hat - Etsy' from Etsy