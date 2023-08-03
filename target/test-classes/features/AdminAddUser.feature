@gui
Feature: Add Admin User


  @test3
  Scenario Outline: Add a new admin user
    Given I am logged in as an admin
    And  navigate to the admin user module page
    And  click on the add user button
    When user fill the details '<First Name>','<Last Name>','<Email>' and '<Phone>'
    Then  click on submit button


    Examples:
      | First Name | Last Name |  Email       | Phone      |
      | QA         | testing   | QA@test.com | 1234567890 |

