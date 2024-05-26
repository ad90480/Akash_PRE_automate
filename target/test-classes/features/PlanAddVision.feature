@gui
Feature: Add Vision Plan

  @AddVisionPlan
  Scenario Outline: Successfully add a new dental plan with all new contacts
    Given I am logged in as an admin
    When I navigate to the Plan Details Page
    And I choose type Vision and plan design Create New Plan
    And I click on the next button
    And I fill in the details "<Plan Name>", "<Benefit Year Start>", "<Benefit Year End>" with all new contacts
    Examples:
      | Plan Name        | Benefit Year Start | Benefit Year End |
      | Test Vision Plan | 01012024           | 12312024         |
#    And I fill In-Network section with new contacts details
#    And I fill Out-Network section with new contacts details
#    Then I submit the form
#    Then I should see a confirmation message "Dental plan added successfully"
#    And the new plan should be listed in the "Dental Plans" section

