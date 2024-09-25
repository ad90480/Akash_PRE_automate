@gui
Feature: Admin Login

  @LoginTest
  Scenario: Successful admin login
    Given I am on the admin login page
    When I enter username and password
    And I click the login button
    Then I should be logged in successfully


#Feature: Admin Login
#
#  @Excel
#  Scenario: Successful admin login
#    Given I am on the admin login page
#    When I enter username and password from file "src/test/resources/testexcelfile.xlsx" and sheet "LoginTestData"
#    And I click the login button
#    Then I should be logged in successfully

