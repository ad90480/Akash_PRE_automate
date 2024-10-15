@gui
Feature: Add Dental Plan

  @AddDentalPlan
  Scenario Outline: Successfully add a new dental plan with all new contacts
    Given the user is logged in as an admin
    When I navigate to the Plan Details Page
    And I choose type Dental and plan design Create New Plan
    And I click on the next button
    And I fill in the Den Plan details "<Plan Name>", "<Benefit Year Start>", "<Benefit Year End>" with all new contacts
    And I fill Den Plan In-Network section with new contacts details
    And I fill Den Plan Out-Network section with new contacts details
    And I submit the form
    And I should see a Den Add Plan confirmation message
    Then the new Den plan should be listed in the Plan List section

    Examples:
      | Plan Name        | Benefit Year Start | Benefit Year End |
      | Test Dental Plan | 01012024           | 12312024         |




