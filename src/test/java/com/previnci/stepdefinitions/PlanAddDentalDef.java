package com.previnci.stepdefinitions;

import com.previnci.core.PageManager;
import com.previnci.pages.UtilityMethods;
import com.previnci.pages.CommonCode;
import com.previnci.pages.PlanAddDental;
import com.previnci.pages.PlanAddMedical;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebElement;

import java.time.Duration;


public class PlanAddDentalDef {
    private final PageManager pageManager = PageManager.getInstance();
    private final PlanAddDental addDental = this.pageManager.getPageGenerator().getInstance(PlanAddDental.class);
    private final CommonCode common = this.pageManager.getPageGenerator().getInstance(CommonCode.class);
    private final UtilityMethods utilityMethods = this.pageManager.getPageGenerator().getInstance(UtilityMethods.class);
    private final PlanAddMedical addMedical = this.pageManager.getPageGenerator().getInstance(PlanAddMedical.class);

    @And("I choose type Dental and plan design Create New Plan")
    public void iChooseTypeDentalAndPlanDesignCreateNewPlan() {
        addDental.chooseTypeAndDesign();
    }

    @And("I fill in the Den Plan details {string}, {string}, {string} with all new contacts")
    public void iFillInTheDenPlanDetailsWithAllNewContacts(String planName, String benefitYearStart, String benefitYearEnd) {
      addDental.generateAndFillPlanName(planName);
        addDental.fillBenefitYearDate(benefitYearStart, benefitYearEnd);
       addDental.denClaimAdjAndPlanID();
        addDental.denChoosePlanDesignAndIdCard();
//        common.addPayerContact();
//        common.addPatientContact();
//        common.addAdminContact();
//        common.addBillingContact();
       common.nextButton();
    }

    @And("I fill Den Plan In-Network section with new contacts details")
    public void iFillDenPlanInNetworkSectionWithNewContactsDetails() {
       // common.addInNetworkContact();
       addDental.denInNetworkValues();
    }

    @And("I fill Den Plan Out-Network section with new contacts details")
    public void iFillDenPlanOutNetworkSectionWithNewContactsDetails() {
        // common.addOutNetworkContact();
       addDental.denOutNetworkValues();
    }


    @And("I should see a Den Add Plan confirmation message")
    public void iShouldSeeADenAddPlanConfirmationMessage() {
        String planNames = addDental.getGeneratedDenPlanName();
        WebElement actualToast = addDental.verifyAddDenPlanToast();
        utilityMethods.waitForElementToBeVisible(actualToast, Duration.ofSeconds(15));
        utilityMethods.assertTextEquals(actualToast, planNames + " has been added successfully.");

    }

    @Then("the new Den plan should be listed in the Plan List section")
    public void theNewDenPlanShouldBeListedInThePlanListSection() {
        String planName = addDental.getGeneratedDenPlanName();
        WebElement planListed = addDental.verifyDenListedPlan();
        utilityMethods.assertTextEquals(planListed,planName);

    }
}
