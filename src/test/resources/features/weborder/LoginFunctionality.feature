@regression
Feature: Testing the weborder login Functionality
#general description
  @smoke
  Scenario: Happy Path(Correct username -Correct password)

    When User provides 'guest1@microworks.com','Guest1!' and click Login button
    Then User validates the 'ORDER DETAILS - Weborder'


  Scenario: Negative login(Correct username-Wrong Password)
    When User provides 'guest1@microworks.com','ahmet' and click Login button
    Then User validates the message 'Sign in Failed'

  @smoke
  Scenario: Negative login (Wrong username-Correct Password)
    When User provides 'ahmet@gmail.com','Guest1!' and click Login button
    Then User validates the message 'Sign in Failed'


  Scenario: Negative login(Empty username-Empty password)
    When User provides ' ',' ' and click Login button
    Then User validates the message 'Sign in Failed'












