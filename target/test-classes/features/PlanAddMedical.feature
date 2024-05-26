@gui
Feature: Add Medical Plan

  @AddMedicalPlan
  Scenario Outline: Successfully add a new medical plan with all new contacts
    Given I am logged in as an admin
    When I navigate to the Plan Details Page
    And I choose type Medical and plan design Create New Plan
    And I click on the next button
    And I fill in the details of Med "<Plan Name>", "<Benefit Year Start>", "<Benefit Year End>" with all new contacts
    And I fill Med Plan In-Network section with new contacts details
    And I fill Med Plan Out-Network section with new contacts details
    And I submit the form
    And I should see a Med Add Plan confirmation message
    Then the new Med plan should be listed in the Plan List section

    Examples:
      | Plan Name         | Benefit Year Start | Benefit Year End |
      | Test Medical Plan | 2024-01-01         | 2024-12-31       |


