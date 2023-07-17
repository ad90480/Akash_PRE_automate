@gui
Feature: Admin Login

  @test1
  Scenario: Successful admin login
    Given I am on the admin login page
    When I enter username and password
    Then I click the login button
