package com.previnci.stepdefinitions;

import com.previnci.core.PageManager;
import com.previnci.pages.AddUser;
import com.previnci.pages.BasePage;
import com.previnci.pages.CommonlyUsed;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;

public class AdminAddUserDef {
    private final PageManager pageManager = PageManager.getInstance();
    private final AddUser addUser = this.pageManager.getPageGenerator().getInstance(AddUser.class);
    private final CommonlyUsed common = this.pageManager.getPageGenerator().getInstance(CommonlyUsed.class);
    private final BasePage basePage = this.pageManager.getPageGenerator().getInstance(BasePage.class);

    @And("navigate to the admin user module page")
    public void navigateToTheAdminUserModulePage() {
        WebElement actualText = this.addUser.userModule();
        this.addUser.userModule();
        basePage.assertTextEquals(actualText, "Users");
    }

    @And("click on the add user button")
    public void clickOnTheAddUserButton() {
        this.addUser.addUserButton();
    }

    @When("user fill the details")
    public void userFillTheDetails() {
        this.addUser.firstName();
        this.addUser.lastName();
        this.addUser.email();
        this.addUser.phone();
    }

    @And("click on submit button")
    public void clickOnSubmitButton() {
        this.common.submitbutton();
    }

    @And("validate the toast message")
    public void validateTheToastMessage() {
        WebElement addUserToastMsg = this.addUser.verifyToastMsg();
        basePage.assertTextEquals(addUserToastMsg, "User created successfully.");
        System.out.println("User Created Validation" + addUserToastMsg);
        System.out.println(addUserToastMsg);
    }

    @And("Validate email in user table")
    public void validate_email_in_user_table() {
        String filledUserEmail = this.addUser.getFilledUserEmail(); // Retrieve filled user email once
        WebElement verifyUserEmail = this.addUser.getEmailElement(); // Assuming you have a method to get the email element from the user table
        basePage.assertTextEquals(verifyUserEmail, filledUserEmail); // Validate against filled user email
        System.out.println(filledUserEmail);
        System.out.println(verifyUserEmail);
    }

    @Then("assign role to user")
    public void assign_role_to_user() {
        // Implement role assignment here if needed
    }
}

