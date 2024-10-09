package com.previnci.stepdefinitions;

import com.previnci.core.PageManager;
import com.previnci.pages.AddTenant;
import com.previnci.pages.CommonCode;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AdminAddTenantDef {
    private final PageManager pageManager = PageManager.getInstance();
    private AddTenant addtenant = this.pageManager.getPageGenerator().getInstance(AddTenant.class);
    private CommonCode common = this.pageManager.getPageGenerator().getInstance(CommonCode.class);

    @And("I navigate to the tenant module and open add tenant form")
    public void iNavigateToTheTenantModuleAndOpenAddTenantForm() {
        this.addtenant.tenantModule();
        this.addtenant.addTenantbutton();
    }

        @When("I enter the following details {string}, {string}, {string}, {string},{string},{string},{string}")
        public void iEnterTheFollowingDetailsOrganizationNameStreetAddressCityPostalCodeStateOrganizationTypePhoneTaxIDAndSICCode(String orgName, String street, String city, String postalCode,  String phone, String taxID, String SICcode) {
        this.addtenant.fillOrgname(orgName);
        this.addtenant.fillStreet(street);
        this.addtenant.fillCity(city);
        this.addtenant.fillPostalcode(postalCode);
        this.addtenant.selectState();
        this.addtenant.selectOrgtype();
        this.addtenant.fillPhone(phone);
        this.addtenant.fillTaxid(taxID);
        this.addtenant.fillSICcode(SICcode);
    }
    @Then("I click the submit button")
    public void iClickTheSubmitButton() {
        this.common.submitButton();
    }

    @And("I should see a confirmation message")
    public void iShouldSeeAConfirmationMessage() {
    }


    @When("I enter the following details {string}, {string}, {string}, {string}, {string}, {string},{string}")
    public void iEnterTheFollowingDetailsOrganizationNameStreetAddressCityPostalCodePhoneTaxIDSICCode(String orgName, String street, String city, String postalCode,  String phone, String taxID, String SICcode) {
        this.addtenant.fillOrgname(orgName);
        this.addtenant.fillStreet(street);
        this.addtenant.fillCity(city);
        this.addtenant.fillPostalcode(postalCode);
        this.addtenant.selectState();
        this.addtenant.selectOrgtype();
        this.addtenant.fillPhone(phone);
        this.addtenant.fillTaxid(taxID);
        this.addtenant.fillSICcode(SICcode);
    }
}
