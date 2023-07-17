@gui
Feature: Admin add role


  @test4
  Scenario Outline: Add a new admin role
    Given I am logged in as an admin
    And  navigate to the admin role module page
    And  click on the add role button
    When user fill the details '<Name>' and '<Description>'
    Then  click submit button
    Examples:
      | Name      | Description         |
      | Test Role | This is for testing |