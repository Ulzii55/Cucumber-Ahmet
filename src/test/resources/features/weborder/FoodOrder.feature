Feature: Testing food Group order functionality for Weborder website

  Scenario: Place Group Order
    When User provides 'guest1@microworks.com','Guest1!', and clicks Sign in Button
    Then User clicks GroupOrderBox,clicks NextButton
    Then User provides InviteNote 'I LOVE SELENIUM', InviteEmails 'ulzii55@gmail.com','ahmet@gmail.com'
    Then User Selects delivery 'MyHouse' and validates address '3131 Laguna'
    Then User clicks GroupOrderButton, validates Header 'View Group Order', Order Info Contains 'Your Group order is now pending'