package com.previnci.stepdefinitions;

import com.previnci.core.PageManager;
import com.previnci.pages.AddRole;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AdminAddRoleDef {
    private final PageManager pageManager = PageManager.getInstance();
    private AddRole addrole = this.pageManager.getPageGenerator().getInstance(AddRole.class);

    @And("navigate to the admin role module page")
    public void navigateToTheAdminRoleModulePage() {
        this.addrole.openrolemodule();
    }

    @And("click on the add role button")
    public void clickOnTheAddRoleButton() {
        this.addrole.addrolebutton();
    }

    @When("user fill the details {string} and {string}")
    public void userFillTheDetailsNameAndDescription(String Rn, String Rd) {
        this.addrole.roleName(Rn);
        this.addrole.roleDescription(Rd);
    }

    @Then("click submit button")
    public void clickOnSubmitButton() {
    }
}
