package com.previnci.stepdefinitions;

import com.previnci.core.PageManager;
import com.previnci.pages.AddUser;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AdminAddUserDef {
    private final PageManager pageManager = PageManager.getInstance();
    private AddUser addUser = this.pageManager.getPageGenerator().getInstance(AddUser.class);

    @And("navigate to the admin user module page")
    public void navigateToTheAdminUserModulePage() {
        this.addUser.usermodule();

    }

    @And("click on the add user button")
    public void clickOnTheAddUserButton() {
        this.addUser.adduserbutton();
    }

    @When("user fill the details {string},{string},{string},{string} and {string}")
    public void userFillTheDetailsFirstNameLastNameUsernameEmailAndPhone(String Fn, String Ln, String Un, String Email, String Pn) {
        this.addUser.firstname(Fn);
        this.addUser.lastname(Ln);
        this.addUser.username(Un);
        this.addUser.email(Email);
        this.addUser.phone(Pn);
    }

    @Then("click on submit button")
    public void clickOnSubmitButton() {
        this.addUser.submitbutton();
        this.addUser.verifytoastmsg();
    }

}
