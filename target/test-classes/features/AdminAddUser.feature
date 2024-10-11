@gui
Feature: Add Admin User


  @test3
  Scenario: Add a new admin user
    Given the user is logged in as an admin
    And  navigate to the admin user module page
    And  click on the add user button
    When user fill the details
    And  click on submit button
    And validate the toast message
    And Validate email in user table
    #Then assign role to user



