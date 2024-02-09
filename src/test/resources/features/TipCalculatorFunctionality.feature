Feature: Tip Calculation Functionality
  As a user of the Time Calculator page
  I want to be able to enter inputs
  So that i can view the correct tip amount

  Scenario: Tip calculation with empty inputs
    Given I am on the Tip Calculator page
    When I click the 'Calculate' Button
    Then an error message 'Please Enter a Valid Input.' should be visible

  Scenario: Tip calculation with Invalid inputs
    Given I am on the Tip Calculator page
    When I enter a invalid input
    And I click the 'Calculate' Button
    Then an error message 'Please Enter a Valid Input.' should be visible

  Scenario: Tip calculation with Valid inputs
    Given I am on the Tip Calculator page
    When I enter a valid input
    And I click the 'Calculate' Button
    Then I can view the expected tip calculation text