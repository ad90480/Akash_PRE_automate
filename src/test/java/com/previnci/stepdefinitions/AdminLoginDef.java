package com.previnci.stepdefinitions;

import com.previnci.core.PageManager;
import com.previnci.pages.AdminLogin;
import com.previnci.pages.UtilityMethods;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;

public class AdminLoginDef {

    private final PageManager pageManager = PageManager.getInstance();
    private final AdminLogin adminLogin = this.pageManager.getPageGenerator().getInstance(AdminLogin.class);
    private final UtilityMethods utilityMethods = this.pageManager.getPageGenerator().getInstance(UtilityMethods.class);


    @Given("I am logged in as an admin")
    public void loginAsAdmin() {
        this.adminLogin.adminLoggedIn();
    }

    @Given("the user is on the Login Page")
    public void the_user_is_on_the_login_page() {
        System.out.println("I am on Login Page");
    }

    @When("the user enters the username {string} and password {string}")
    public void the_user_enters_the_username_and_password(String username, String password) {
        this.adminLogin.enterUsername(username);
        this.adminLogin.enterPassword(password);
    }

    @And("the user clicks on the login button")
    public void the_user_clicks_on_the_login_button() {
        this.adminLogin.clickLogin();
    }

    @Then("the user should be redirected to the Dashboard")
    public void the_user_should_be_redirected_to_the_dashboard() {
        WebElement actualText = this.adminLogin.loggedIn();
        WebElement logo = this.adminLogin.logoCheck();
        utilityMethods.assertTextEquals(actualText, "Groups");
        utilityMethods.assertUrlEquals("https://benicomp.dev.previnci.app/groups");
        utilityMethods.assertTitleEquals("BeniComp");
        utilityMethods.assertElementDisplayed(logo);
    }

    @When("the user clicks on the {string} link")
    public void the_user_clicks_on_the_link(String linkText) {
    }

    @Then("an error message {string} should be displayed")
    public void an_error_message_should_be_displayed(String expectedMessage) {
        String actualMessage = adminLogin.invalidCredErrMsg();
        System.out.println(actualMessage);
        utilityMethods.assertEqualsString(actualMessage, expectedMessage);
    }

    @And("the user enters their email {string}")
    public void the_user_enters_their_email(String email) {

    }
    @Then("a toast message {string} should be displayed")
    public void a_toast_message_should_be_displayed(String expectedToastMessage) {
        String actualMessage = adminLogin.invalidCredErrMsg();
        System.out.println(actualMessage);
        utilityMethods.assertEqualsString(actualMessage, expectedToastMessage);
    }

//        @When("I enter username and password from file {string} and sheet {string}")
//        public void iEnterUsernameAndPassword(String filePath, String sheetName) throws IOException {
//        // Read user credentials from Excel file
//        adminLogin.enterCredentialsFromExcel(filePath, sheetName);
//   }
}

