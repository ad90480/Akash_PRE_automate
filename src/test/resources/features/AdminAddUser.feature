@gui
Feature: Add Admin User


  @test3
  Scenario Outline: Add a new admin user
    Given I am logged in as an admin
    And  navigate to the admin user module page
    And  click on the add user button
    When user fill the details '<First Name>','<Last Name>' and '<Phone>'
    And  click on submit button
    #Then validate the toast message
    #Then assign role to user


    Examples:
      | First Name | Last Name | Phone      |
      | Test       | User  | 1234567890 |


