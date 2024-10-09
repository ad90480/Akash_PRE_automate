package com.previnci.stepdefinitions;

import com.previnci.core.PageManager;
import com.previnci.pages.TPAAdminLogin;
import com.previnci.pages.UtilityMethods;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

public class TPAAdminLoginDef {

    private final PageManager pageManager = PageManager.getInstance();
    private final TPAAdminLogin tpaAdminLogin = this.pageManager.getPageGenerator().getInstance(TPAAdminLogin.class);
    private final UtilityMethods utilityMethods = this.pageManager.getPageGenerator().getInstance(UtilityMethods.class);

    @Given("I am logged in as an admin")
    public void loginAsAdmin() {
        tpaAdminLogin.adminLoggedIn();
    }

    @Given("the user is on the Login Page")
    public void the_user_is_on_the_login_page() {
        System.out.println("User is on Login Page");
    }

    @When("the user enters the username {string} and password {string}")
    public void the_user_enters_the_username_and_password(String username, String password) {
        tpaAdminLogin.enterUsername(username);
        tpaAdminLogin.enterPassword(password);
    }

    @And("the user clicks on the login button")
    public void the_user_clicks_on_the_login_button() {
        tpaAdminLogin.clickLogin();
    }

    @Then("the user should be redirected to the Dashboard {string}")
    public void the_user_should_be_redirected_to_the_dashboard(String isLoggedIn) {
        WebElement actualText =tpaAdminLogin.loggedIn();
        String loggedInUsername = tpaAdminLogin.successfulLoggedIn();
        utilityMethods.assertTextEquals(actualText, "Groups");
        utilityMethods.assertUrlEquals("https://benicomp.dev.previnci.app/groups");
        utilityMethods.assertTitleEquals("BeniComp");
        utilityMethods.assertEqualsString(loggedInUsername,isLoggedIn);
        System.out.println(loggedInUsername);
    }

    @Then("an error toast message {string} should be displayed on the login page")
    public void an_error_toast_message_should_be_displayed_on_the_login_page(String expectedMessage) {
        String actualMessage = tpaAdminLogin.invalidCredErrMsg();
        System.out.println(actualMessage);
        utilityMethods.assertEqualsString(actualMessage, expectedMessage);
    }


//        @When("I enter username and password from file {string} and sheet {string}")
//        public void iEnterUsernameAndPassword(String filePath, String sheetName) throws IOException {
//        // Read user credentials from Excel file
//        adminLogin.enterCredentialsFromExcel(filePath, sheetName);
//   }
}

