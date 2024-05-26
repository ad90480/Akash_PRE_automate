package com.previnci.stepdefinitions;

import com.previnci.core.PageManager;
import com.previnci.pages.BasePage;
import com.previnci.pages.CommonlyUsed;
import com.previnci.pages.PlanAddDental;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class PlanAddDentalDef {
    private final PageManager pageManager = PageManager.getInstance();
    private final PlanAddDental addDental = this.pageManager.getPageGenerator().getInstance(PlanAddDental.class);
    private final CommonlyUsed common = this.pageManager.getPageGenerator().getInstance(CommonlyUsed.class);
    private final BasePage basePage = this.pageManager.getPageGenerator().getInstance(BasePage.class);

//    @When("I navigate to the Plan Details Page")
//    public void iNavigateToThePlanDetailsPage() {
//        this.addDental.searchAndSelectGroup("Apple");
//        this.common.addNewButton();
//        this.common.clickPolicyAndPlansMenu();
//        this.common.addNewButton();
//    }

    @And("I choose type Dental and plan design Create New Plan")
    public void iChooseTypeDentalAndPlanDesignCreateNewPlan() {
        this.addDental.chooseTypeAndDesign();
    }

    @And("I fill in the Den Plan details {string}, {string}, {string} with all new contacts")
    public void iFillInTheDenPlanDetailsWithAllNewContacts(String planName, String benefitYearStart, String benefitYearEnd) {
        this.addDental.fillPlanName(planName);
        this.addDental.fillBenefitYearDate(benefitYearStart, benefitYearEnd);
        this.addDental.claimAdjAndPlanID();
        this.addDental.choosePlanDesignAndIdCard();
        this.common.addPayerContact();
        this.common.addPatientContact();
        this.common.addAdminContact();
        this.common.addBillingContact();
        this.common.nextButton();
    }

    @And("I fill Den Plan In-Network section with new contacts details")
    public void iFillDenPlanInNetworkSectionWithNewContactsDetails() {
        this.common.addInNetworkContact();
        this.addDental.denInNetworkValues();
    }

    @And("I fill Den Plan Out-Network section with new contacts details")
    public void iFillDenPlanOutNetworkSectionWithNewContactsDetails() {
        this.common.addOutNetworkContact();
        this.addDental.denOutNetworkValues();
    }


    @And("I should see a Den Add Plan confirmation message")
    public void iShouldSeeADenAddPlanConfirmationMessage() {

    }

    @Then("the new Den plan should be listed in the Plan List section")
    public void theNewDenPlanShouldBeListedInThePlanListSection() {

    }
}
