@gui

Feature: Group Management Functionality
  @TPAAddGroupTest
  Scenario Outline: Successful Creation of a New Group
    Given the user is logged in as an admin
    And the user navigates to the Groups page
    And the user clicks the Add New button
    When the user enters the Group Details: "<Group Name>", "<Group Number>", "<Policy Term Start Date>", and "<Policy Term End Date>"
    And the user enters the Primary Plan Sponsor Details: "<First Name>", "<Last Name>", and "<Email>"
    And the user clicks the Save button
    Then the group should be successfully created, and a confirmation message should be displayed "Contract created successfully"
    And the newly added group should appear in the group list

    Examples:
      | Group Name | Group Number | Policy Term Start Date | Policy Term End Date | First Name | Last Name | Email                        |
      | New Group   | TEST         | 01012024               | 12312024             | Test       | Group     | @imqudfxx.mailosaur.net      |

  Scenario Outline: Unsuccessful Creation due to Missing Mandatory Fields
    Given the user is logged in as an admin
    And the user navigates to the Groups page
    And the user clicks the Add New button
    When the user leaves all fields blank: "<Group Name>", "<Group Number>", "<Policy Term Start Date>", and "<Policy Term End Date>"
    And the user leaves the Primary Plan Sponsor Details blank: "<First Name>", "<Last Name>", and "<Email>"
    And the user clicks the Save button
    Then the system should display an error message indicating that all mandatory fields must be completed

    Examples:
      | Group Name | Group Number | Policy Term Start Date | Policy Term End Date | First Name | Last Name | Email |
      |            |              |                        |                      |            |           |       |

  Scenario Outline: Invalid Email Address Validation
    Given the user is logged in as an admin
    And the user navigates to the Groups page
    And the user clicks the Add New button
    When the user provides the Group Details: "<Group Name>", "<Group Number>", "<Policy Term Start Date>", and "<Policy Term End Date>"
    And the user provides the Primary Plan Sponsor Details: "<First Name>", "<Last Name>", and an invalid email "<Email>"
    And the user clicks the Save button
    Then the system should display an error message indicating that the entered email address format is invalid

    Examples:
      | Group Name | Group Number | Policy Term Start Date | Policy Term End Date | First Name | Last Name | Email           |
      | New Group  | TEST         | 01012024               | 12312024             | Test       | Group     | invalid-email   |
