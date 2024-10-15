package com.previnci.stepdefinitions;

import com.previnci.core.PageManager;
import com.previnci.pages.TPAAdminLogin;
import com.previnci.pages.UtilityMethods;
import io.cucumber.java.en.*;

public class ForgetPasswordDef {

    private final PageManager pageManager = PageManager.getInstance();
    private final TPAAdminLogin tpaAdminLogin = this.pageManager.getPageGenerator().getInstance(TPAAdminLogin.class);
    private final UtilityMethods utilityMethods = this.pageManager.getPageGenerator().getInstance(UtilityMethods.class);


    @And("the user clicks on the {string} link")
    public void the_user_clicks_on_the_link(String linkText) {
    }

    @When("the user enters their email {string}")
    public void the_user_enters_their_email(String email) {
    }

    @And("the user clicks on the submit button")
    public void the_user_clicks_on_the_submit_button() {
    }

    @Then("a toast message {string} should be displayed on forget password page")
    public void a_toast_message_should_be_displayed_on_forget_password_page(String expectedToastMessage) {
//        String actualMessage = adminLogin.invalidCredErrMsg();
//        System.out.println(actualMessage);
//        utilityMethods.assertEqualsString(actualMessage, expectedToastMessage);
    }
}
