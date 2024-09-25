package com.previnci.stepdefinitions;

import com.previnci.core.PageManager;
import com.previnci.pages.AdminLogin;
import com.previnci.pages.BasePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class AdminLoginDef {

    private final PageManager pageManager = PageManager.getInstance();
    private final AdminLogin adminLogin = this.pageManager.getPageGenerator().getInstance(AdminLogin.class);
    private final BasePage basePage = this.pageManager.getPageGenerator().getInstance(BasePage.class);

    @Given("I am on the admin login page")
    public void iAmOnTheAdminLoginPage() {
        System.out.println("get data");
    }

    @When("I enter username and password")
    public void iEnterUsernameAndPassword() {
        this.adminLogin.adminUsername();
        this.adminLogin.adminPassword();
    }
//    @When("I enter username and password from file {string} and sheet {string}")
//    public void iEnterUsernameAndPassword(String filePath, String sheetName) throws IOException {
//        // Read user credentials from Excel file
//        adminLogin.enterCredentialsFromExcel(filePath, sheetName);
//    }

    @And("I click the login button")
    public void iClickTheLoginButton() throws InterruptedException {
        this.adminLogin.loginButton();
    }

    @Then("I should be logged in successfully")
    public void Ishouldbeloggedinsuccessfully() {
        WebElement actualText = this.adminLogin.loggedIn();
        WebElement logo = this.adminLogin.logoCheck();
        basePage.assertTextEquals(actualText, "Groups");
        basePage.assertUrlEquals("https://benicomp.dev.previnci.app/groups");
        basePage.assertTitleEquals("BeniComp");
        basePage.assertElementDisplayed(logo);
//        adminLogin.printNavBar();
//        basePage.waitForFixedTime(10000);
        adminLogin.selectNavBarMenuByValue();
//        basePage.waitForFixedTime(10000);
//        basePage.assertUrlEquals("https://benicomp.dev.previnci.app/advocates/members-search");
    }

    @Given("I am logged in as an admin")
    public void iAmLoggedInAsAnAdmin() {
        adminLogin.adminLoggedIn();

    }
}
