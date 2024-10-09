package com.previnci.stepdefinitions;

import com.previnci.core.PageManager;
import com.previnci.pages.UtilityMethods;
import com.previnci.pages.CommonCode;
import com.previnci.pages.PlanAddVision;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class PlanAddVisionDef {
    private final PageManager pageManager = PageManager.getInstance();
    private final PlanAddVision addVision = pageManager.getPageGenerator().getInstance(PlanAddVision.class);
    private final CommonCode common = pageManager.getPageGenerator().getInstance(CommonCode.class);
    private final UtilityMethods utilityMethods = pageManager.getPageGenerator().getInstance(UtilityMethods.class);

    @And("I choose type Vision and plan design Create New Plan")
    public void iChooseTypeVisAndPlanDesignCreateNewPlan() {
        addVision.chooseTypeAndDesign();
    }

    @And("I fill in the Vis Plan details {string}, {string}, {string} with all new contacts")
    public void iFillInTheVisPlanDetailsWithAllNewContacts(String planName, String benefitYearStart, String benefitYearEnd) {
        addVision.generateAndFillVisPlanName(planName);
        addVision.fillBenefitYearDate(benefitYearStart, benefitYearEnd);
        addVision.claimAdjAndPlanID();
        addVision.choosePlanDesignAndIdCard();
//        common.addPayerContact();
//        common.addPatientContact();
//        common.addAdminContact();
//        common.addBillingContact();
        common.nextButton();
    }

    @And("I fill Vis Plan In-Network section with new contacts details")
    public void iFillVisPlanInNetworkSectionWithNewContactsDetails() {
       // common.addInNetworkContact();
        addVision.visInNetworkValues();
    }

    @And("I fill Vis Plan Out-Network section with new contacts details")
    public void iFillVisPlanOutNetworkSectionWithNewContactsDetails() {
        //common.addOutNetworkContact();
        addVision.visOutNetworkValues();
    }

    @And("I should see a Vis Add Plan confirmation message")
    public void iShouldSeeAVisAddPlanConfirmationMessage() {
        String planNames = addVision.getGeneratedVisPlanName();
        WebElement actualToast = addVision.verifyAddVisPlanToast();
        utilityMethods.waitForElementToBeVisible(actualToast, Duration.ofSeconds(15));
        utilityMethods.assertTextEquals(actualToast, planNames + " has been added successfully.");
    }

    @Then("the new Vis plan should be listed in the Plan List section")
    public void theNewVisPlanShouldBeListedInThePlanListSection() {
        String planName = addVision.getGeneratedVisPlanName();
        WebElement planListed = addVision.verifyVisListedPlan();
        utilityMethods.assertTextEquals(planListed, planName);
    }
}
