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

    @When("user fills the role name and description")
    public void user_fills_the_role_name_and_description() {
        this.addrole.roleName();
        this.addrole.roleDescription();
    }
    @And("drag and drop dashboard menus order")
    public void drag_and_drop_dashboard_menus_order() {
      this.addrole.roleDragFirst();
    }

    @And("click submit button")
    public void clickOnSubmitButton() {
    }

    @Then("verify role created successfully")
    public void verify_role_created_successfully() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
}
