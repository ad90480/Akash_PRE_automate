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

    @And("I choose type Vision and plan design Create New Plan")
    public void iChooseTypeVisAndPlanDesignCreateNewPlan() {
        this.addVision.chooseTypeAndDesign();
    }

    @And("I fill in the Vis Plan details {string}, {string}, {string} with all new contacts")
    public void iFillInTheVisPlanDetailsWithAllNewContacts(String planName, String benefitYearStart, String benefitYearEnd) {
        this.addVision.fillPlanName(planName);
        this.addVision.fillBenefitYearDate(benefitYearStart, benefitYearEnd);
        this.addVision.claimAdjAndPlanID();
        this.addVision.choosePlanDesignAndIdCard();
        this.common.addPayerContact();
        this.common.addPatientContact();
        this.common.addAdminContact();
        this.common.addBillingContact();
        this.common.nextButton();
    }

    @And("I fill Vis Plan In-Network section with new contacts details")
    public void iFillVisPlanInNetworkSectionWithNewContactsDetails() {
        this.common.addInNetworkContact();
        this.addVision.visInNetworkValues();
    }

    @And("I fill Vis Plan Out-Network section with new contacts details")
    public void iFillVisPlanOutNetworkSectionWithNewContactsDetails() {
        this.common.addOutNetworkContact();
        this.addVision.visOutNetworkValues();
    }

    @And("I should see a Vis Add Plan confirmation message")
    public void iShouldSeeAVisAddPlanConfirmationMessage() {

    }

    @Then("the new Vis plan should be listed in the Plan List section")
    public void theNewVisPlanShouldBeListedInThePlanListSection() {

    }
}
