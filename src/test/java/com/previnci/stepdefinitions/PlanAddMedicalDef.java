package com.previnci.stepdefinitions;

import com.previnci.core.PageManager;
import com.previnci.pages.BasePage;
import com.previnci.pages.CommonlyUsed;
import com.previnci.pages.PlanAddMedical;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class PlanAddMedicalDef {
    private final PageManager pageManager = PageManager.getInstance();
    private final PlanAddMedical addMedical = this.pageManager.getPageGenerator().getInstance(PlanAddMedical.class);
    private final CommonlyUsed common = this.pageManager.getPageGenerator().getInstance(CommonlyUsed.class);
    private final BasePage basePage = this.pageManager.getPageGenerator().getInstance(BasePage.class);

    @When("I navigate to the Plan Details Page")
    public void iNavigateToThePlanDetailsPage() {
        this.addMedical.searchAndSelectGroup("Apple");
        this.common.addNewButton();
        this.common.clickPolicyAndPlansMenu();
        this.common.addNewButton();
    }

    @And("I choose type Medical and plan design Create New Plan")
    public void iChooseTypeMedicalAndPlanDesignCreateNewPlan() {
        this.addMedical.chooseTypeAndDesign();
    }

    @And("I click on the next button")
    public void iClickOnTheButton() {
        this.common.nextButton();
    }

    @And("I fill in the details of Med {string}, {string}, {string} with all new contacts")
    public void iFillInTheDetailsOfMedWithAllNewContacts(String planName, String benefitYearStart, String benefitYearEnd) {
        this.addMedical.fillPlanName(planName);
        this.addMedical.fillBenefitYearDate(benefitYearStart, benefitYearEnd);
        this.addMedical.claimAdjAndPlanID();
        this.addMedical.choosePlanDesignAndIdCard();
        this.common.addPayerContact();
        this.common.addPatientContact();
        this.common.addAdminContact();
        this.common.addBillingContact();
        this.common.nextButton();
    }

    @And("I fill Med Plan In-Network section with new contacts details")
    public void iFillMedPlanInNetworkSectionWithNewContactsDetails() {
        this.common.addInNetworkContact();
        this.addMedical.medInNetworkValues();
    }

    @And("I fill Med Plan Out-Network section with new contacts details")
    public void iFillMedPlanOutNetworkSectionWithNewContactsDetails() {
        this.common.addOutNetworkContact();
        this.addMedical.medOutNetworkValues();
    }

    @And("I submit the form")
    public void iSubmitTheForm() {
        this.common.submitButton();
    }

    @And("I should see a Med Add Plan confirmation message")
    public void iShouldSeeAMedAddPlanConfirmationMessage() {

    }

    @Then("the new Med plan should be listed in the Plan List section")
    public void theNewMedPlanShouldBeListedInThePlanListSection() {

    }
}
