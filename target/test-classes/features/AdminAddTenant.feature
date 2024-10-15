@gui
Feature: Add Tenant
  As an SuperAdmin
  I want to add a new tenant

  @test2
  Scenario Outline: Admin add tenant
    Given the user is logged in as an admin
    And I navigate to the tenant module and open add tenant form
    When I enter the following details '<Organization Name>', '<Street Address>', '<City>', '<Postal Code>', '<Phone>', '<Tax ID>','<SIC code>'
    Then I click the submit button
    #And I should see a confirmation message
    Examples:
      | Organization Name | Street Address | City | Postal Code |Phone      | Tax ID    | SIC code |
      | QAchandrat1 Org     | Street         | City | 11385       |1234567890 | 567534562 | 2545     |