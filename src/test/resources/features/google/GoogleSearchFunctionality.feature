Feature: Testing the Google Search Functionality
#general description
  Scenario: Happy Path(positive) Testing for Search
#test case
    Given User navigate to the google
    When  User searches for CodeFish
    Then  User validates first page returns more than ten Links

    Scenario: Happy Path(positive) Testing Result for Search

      Given User navigate to the google
      When User searches for Kyrgyz Food in USA
      Then User validates the result is less than three hundred million

      Scenario: Testing Loading Time Search for an Item

        Given User navigate to the google
        When User searches for Turkish Baklava
        Then User validates it loads less than one seconds

















