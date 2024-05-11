@gui
Feature: Add Admin User


  @test3
  Scenario: Add a new admin user
    Given I am logged in as an admin
    And  navigate to the admin user module page
    And  click on the add user button
    When user fill the details
    And  click on submit button
    Then validate the toast message
   # Then assign role to user



