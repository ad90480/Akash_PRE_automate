@gui
Feature: Login Functionality
  @LoginTest
  Scenario Outline: Successful Login with valid credentials
    Given the user is on the Login Page
    When the user enters the username "<username>" and password "<password>"
    And the user clicks on the login button
    Then the user should be redirected to the Dashboard

    Examples:
      | username      | password     |
      | StanLee     | StanLee2024! |

  Scenario Outline: Unsuccessful Login with invalid password
    Given the user is on the Login Page
    When the user enters the username "<username>" and password "<password>"
    And the user clicks on the login button
    Then an error message "Your username or password is incorrect" should be displayed

    Examples:
      | username      | password     |
      | StanLee     | StanLee2024 |

  Scenario Outline: Unsuccessful Login with invalid username
    Given the user is on the Login Page
    When the user enters the username "<username>" and password "<password>"
    And the user clicks on the login button
    Then an error message "Your username or password is incorrect" should be displayed

    Examples:
      | username      | password     |
      | StanLee1  | StanLee2024! |

  Scenario Outline: Login attempt with empty credentials
    Given the user is on the Login Page
    When the user enters the username "<username>" and password "<password>"
    And the user clicks on the login button
    Then a toast message "Enter username and password" should be displayed

    Examples:
      | username | password |
      |          |          |

  Scenario Outline: Forgot password functionality
    Given the user is on the Login Page
    When the user clicks on the "Forgot Password" link
    And the user enters their email "<email>"
    Then a toast message "Password reset link sent to your email" should be displayed

    Examples:
      | email              |
      | Test-user@imqudfxx.mailosaur.net |

