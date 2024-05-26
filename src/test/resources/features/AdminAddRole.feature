@gui
Feature: Admin add role


  @test4
  Scenario: Add a new admin role
    Given I am logged in as an admin
    And  navigate to the admin role module page
    And  click on the add role button
    When user fills the role name and description
    And  drag and drop dashboard menus order
    And  click on submit button
    Then verify role created successfully