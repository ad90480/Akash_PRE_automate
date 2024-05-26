package com.previnci.stepdefinitions;

import com.previnci.core.PageManager;
import com.previnci.pages.BasePage;
import com.previnci.pages.CommonlyUsed;
import com.previnci.pages.PlanAddDental;
import com.previnci.pages.PlanAddVision;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class PlanAddVisionDef {
    private final PageManager pageManager = PageManager.getInstance();
    private final PlanAddVision addVision = this.pageManager.getPageGenerator().getInstance(PlanAddVision.class);
 //   private final PlanAddDental addDental = this.pageManager.getPageGenerator().getInstance(PlanAddDental.class);
    private final CommonlyUsed common = this.pageManager.getPageGenerator().getInstance(CommonlyUsed.class);
    private final BasePage basePage = this.pageManager.getPageGenerator().getInstance(BasePage.class);

    @When("I navigate to the Plan Details Page")
    public void iNavigateToThePlanDetailsPage() {
        this.addVision.searchAndSelectGroup("Apple");
        this.common.addNewButton();
        this.common.clickPolicyAndPlansMenu();
        this.common.addNewButton();
    }

    @And("I choose type Dental and plan design Create New Plan")
    public void iChooseTypeDentalAndPlanDesignCreateNewPlan() {
        this.addVision.chooseTypeAndDesign();
    }

    @And("I click on the next button")
    public void iClickOnTheButton() {
        this.common.nextButton();
    }

    @And("I fill in the details {string}, {string}, {string} with all new contacts")
    public void iFillInTheDetailsWithAllNewContacts(String planName, String benefitYearStart, String benefitYearEnd) {
        this.addVision.fillPlanName(planName);
        this.addVision.fillBenefitYearDate(benefitYearStart, benefitYearEnd);
        this.addVision.claimAdjAndPlanID();
        this.addVision.choosePlanDesignAndIdCard();
        this.common.addPayerContact();
        this.common.addPatientContact();
        this.common.addAdminContact();
        this.common.addBillingContact();
        this.common.nextButton();
        this.common.addInNetworkContact();
        this.addVision.denInNetworkValues();
        this.common.addOutNetworkContact();
        this.addVision.denOutNetworkValues();
        this.common.submitButton();
    }

    @And("I fill In-Network section with new contacts details")
    public void iFillInNetworkSectionWithNewContactsDetails() {
        this.common.addInNetworkContact();
        this.addVision.denInNetworkValues();
    }

    @And("I fill Out-Network section with new contacts details")
    public void iFillOutNetworkSectionWithNewContactsDetails() {
        this.common.addOutNetworkContact();
        this.addVision.denOutNetworkValues();
    }

    @Then("I submit the form")
    public void iSubmitTheForm() {
        this.common.submitButton();
    }

    @Then("I should see a confirmation message {string}")
    public void iShouldSeeAConfirmationMessage(String message) {

    }

//    @Then("the new plan should be listed in the {string} section")
//    public void theNewPlanShouldBeListedInTheSection(String section) {
//        // Code to verify the new plan is listed in the specified section
//        boolean isPlanListed = false; // Check if the plan is listed in the section
//        assertTrue(isPlanListed);
//    }
}
