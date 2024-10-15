  @gui
Feature: Group Sign-Up Process
  @GroupSignup
  Scenario: Successful Group Sign-Up
    When the user fills in the organization details with "Legal Name","DBA Name" Street "123 Main St",State "Alabama" city "Tampa", zip code "10001", phone "0923478687", and TIN
    And the user clicks the Next button
    And the user enters first name, last name, last four digits SSN, username, password, and confirm password
    And the user clicks the Review button and then clicks Submit
    Then the user navigates to the Login page

#  @gui
#Feature: Group Sign-Up Process
#@GroupSignup
#  Scenario: Successful Group Sign-Up
#    When the user fills in the organization details with
#      | Field          | Value             |
#      | Legal Name     | "ABC Corp"       |
#      | Address        | "123 Main St"    |
#      | City           | "Tampa"          |
#      | Zip Code       | "10001"          |
#      | Phone          | "0923478687"     |
#      | TIN            | "12-3456789"     |
#    And the user clicks the Next button
#    And the user enters the following details:
#      | Field          | Value                    |
#      | First Name     | "John"                  |
#      | Last Name      | "Doe"                   |
#      | Last Four      | "1234"                  |
#      | Username       | "johndoe"               |
#      | Password       | "SecureP@ssw0rd"        |
#      | Confirm Password| "SecureP@ssw0rd"       |
#    And the user clicks the Review button and then clicks Submit
#    Then the user is navigated to the Login page
