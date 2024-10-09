@gui
@AdminLoginTest
Feature: Login Functionality

  Scenario Outline: Successful Login with valid credentials
    Given the user is on the Login Page
    When the user enters the username "<username>" and password "<password>"
    And the user clicks on the login button
    Then the user should be redirected to the Dashboard "Stan Lee"

    Examples:
      | username | password      |
      | StanLee  | StanLee2024!  |

  Scenario Outline: Unsuccessful Login with invalid credentials
    Given the user is on the Login Page
    When the user enters the username "<username>" and password "<password>"
    And the user clicks on the login button
    Then an error toast message "<message>" should be displayed on the login page

    Examples:
      | username  | password      | message                                |
      | StanLee1  | StanLee2024   | Your username or password is incorrect  |
      | StanLee1  | StanLee2024!  | Your username or password is incorrect  |
      | StanLee   | StanLee2024   | Your username or password is incorrect  |

  Scenario Outline: Login attempt with empty credentials
    Given the user is on the Login Page
    When the user enters the username "<username>" and password "<password>"
    And the user clicks on the login button
    Then an error toast message "<message>" should be displayed on the login page

    Examples:
      | username | password | message                          |
      |          |          | Enter username and password      |
