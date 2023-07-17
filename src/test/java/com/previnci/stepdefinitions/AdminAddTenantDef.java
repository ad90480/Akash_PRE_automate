package com.previnci.stepdefinitions;

import com.previnci.core.PageManager;
import com.previnci.pages.AddTenant;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AdminAddTenantDef {
    private final PageManager pageManager = PageManager.getInstance();
    private AddTenant addtenant = this.pageManager.getPageGenerator().getInstance(AddTenant.class);

    @And("I navigate to the tenant module and open add tenant form")
    public void iNavigateToTheTenantModuleAndOpenAddTenantForm() {
        this.addtenant.tenantModule();
        this.addtenant.addTenantbutton();
    }
    @When("I enter the following details {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string} and {string}")
    public void iEnterTheFollowingDetailsOrganizationNameStreetAddressCityPostalCodeStateOrganizationTypePhoneTaxIDAndSICCode(String ON, String FS, String FC, String FP, String FT, String FSIC) {
        this.addtenant.fillOrgname(ON);
        this.addtenant.fillStreet(FS);
        this.addtenant.fillCity(FC);
        this.addtenant.fillPostalcode(FP);
        this.addtenant.selectState();
        this.addtenant.selectOrgtype();
        this.addtenant.fillPhone(FP);
        this.addtenant.fillTaxid(FT);
        this.addtenant.fillSICcode(FSIC);
    }
    @Then("I click the submit button")
    public void iClickTheSubmitButton() {
        this.addtenant.clickSubmit();
    }

    @And("I should see a confirmation message")
    public void iShouldSeeAConfirmationMessage() {
    }


}
