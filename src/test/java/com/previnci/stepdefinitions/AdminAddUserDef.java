package com.previnci.stepdefinitions;

import com.previnci.core.PageManager;
import com.previnci.pages.AddUser;
import com.previnci.pages.CommonlyUsed;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class AdminAddUserDef {
    private final PageManager pageManager = PageManager.getInstance();
    private final AddUser addUser = this.pageManager.getPageGenerator().getInstance(AddUser.class);
    private final CommonlyUsed common = this.pageManager.getPageGenerator().getInstance(CommonlyUsed.class);

    @And("navigate to the admin user module page")
    public void navigateToTheAdminUserModulePage() {
        this.addUser.userModule();
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

    @Then("validate the toast message")
    public void validateTheToastMessage() {
        String addUserToastMsg = this.addUser.verifyToastMsg();
        Assert.assertEquals("User Created", "User created successfully.", addUserToastMsg);
        System.out.println("User Created Validation" + addUserToastMsg);
    }
}
