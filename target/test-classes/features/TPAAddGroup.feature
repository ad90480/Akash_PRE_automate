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
#    And the user logs out successfully from the application
## Organization Signup
#    And the user opens the Mailosaur app, logs in successfully, and navigates to the Inbox
#    And the user verifies the content of the received email and clicks on it
#    And the user opens the received email
#    And the user clicks on the Complete Registration link
#    When the user fills in the organization details with "Legal Name","DBA Name" Street "123 Main St",city "Tampa",State "Alabama", zip code "09412", phone "0923478687", and TIN
#    And the user clicks the Next button
#    And the user enters first name, last name, last four digits SSN, username, password, and confirm password
#    And the user clicks the Review button and then clicks Submit
#    Then the user navigates to the Login page

    Examples:
      | Group Name | Group Number | Policy Term Start Date | Policy Term End Date | First Name | Last Name | Email                   |
      | New Group  | TEST         | 01012024               | 12312024             | Test       | Group     | @imqudfxx.mailosaur.net |

  Scenario Outline: Unsuccessful Creation due to Missing Mandatory Fields
    Given the user is logged in as an admin
    And the user navigates to the Groups page
    And the user clicks the Add New button
    When the user leaves all fields blank: "<Group Name>", "<Group Number>", "<Policy Term Start Date>", and "<Policy Term End Date>"
    And the user leaves the Primary Plan Sponsor Details blank: "<First Name>", "<Last Name>", and "<Email>"
    And the user clicks the Save button
    Then the validation should appear on the input fields

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
    Then the validation should appear on the input fields

    Examples:
      | Group Name | Group Number | Policy Term Start Date | Policy Term End Date | First Name | Last Name | Email         |
      | New Group  | TEST         | 01012024               | 12312024             | Test       | Group     | invalid-email |
