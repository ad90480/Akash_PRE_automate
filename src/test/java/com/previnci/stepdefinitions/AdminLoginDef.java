package com.previnci.stepdefinitions;

import com.previnci.core.PageManager;
import com.previnci.pages.AdminLogin;
import com.previnci.pages.CommonlyUsed;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AdminLoginDef {

    private final PageManager pageManager = PageManager.getInstance();
    private AdminLogin adminLogin = this.pageManager.getPageGenerator().getInstance(AdminLogin.class);

    @Given("I am on the admin login page")
    public void iAmOnTheAdminLoginPage() {
        System.out.println("get data");
    }

    @When("I enter username and password")
    public void iEnterUsernameAndPassword() {
        this.adminLogin.adminusername();
        this.adminLogin.adminpassword();
    }

    @Then("I click the login button")
    public void iClickTheLoginButton() {
        this.adminLogin.loginbutton();
    }
    @Given("I am logged in as an admin")
    public void iAmLoggedInAsAnAdmin() {
        this.adminLogin.adminusername();
        this.adminLogin.adminpassword();
        this.adminLogin.loginbutton();

    }
}
