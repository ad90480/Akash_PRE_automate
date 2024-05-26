@gui
Feature: Add Vision Plan

  @AddVisionPlan
  Scenario Outline: Successfully add a new vision plan with all new contacts
    Given I am logged in as an admin
    When I navigate to the Plan Details Page
    And I choose type Vision and plan design Create New Plan
    And I click on the next button
    And I fill in the Vis Plan details "<Plan Name>", "<Benefit Year Start>", "<Benefit Year End>" with all new contacts
    And I fill Vis Plan In-Network section with new contacts details
    And I fill Vis Plan Out-Network section with new contacts details
    And I submit the form
    And I should see a Vis Add Plan confirmation message
    Then the new Vis plan should be listed in the Plan List section

    Examples:
      | Plan Name        | Benefit Year Start | Benefit Year End |
      | Test Vision Plan | 01012024           | 12312024         |


