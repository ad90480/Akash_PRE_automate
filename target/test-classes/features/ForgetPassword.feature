@gui
Feature: Login Functionality

  @ForgetPassword
  Scenario Outline: Forgot password functionality
    Given the user is on the Login Page
    And the user clicks on the "Forgot Password" link
    When the user enters their email "<email>"
    And the user clicks on the submit button
    Then a toast message "<message>" should be displayed on forget password page

    Examples:
      | email                            | message                                |
      | Test-user@imqudfxx.mailosaur.net | Password reset link sent to your email |
      | Test-user@                       | Please enter a valid address           |
      |                                  | Please enter a valid address           |

