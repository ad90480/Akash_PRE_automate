package com.previnci.stepdefinitions;

import com.previnci.core.PageManager;
import com.previnci.pages.BasePage;
import com.previnci.pages.CommonlyUsed;
import com.previnci.pages.PlanAddMedical;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class PlanAddMedicalDef {
    private final PageManager pageManager = PageManager.getInstance();
    private final PlanAddMedical addMedical = this.pageManager.getPageGenerator().getInstance(PlanAddMedical.class);
    private final CommonlyUsed common = this.pageManager.getPageGenerator().getInstance(CommonlyUsed.class);
    private final BasePage basePage = this.pageManager.getPageGenerator().getInstance(BasePage.class);

    @When("I navigate to the Plan Details Page")
    public void iNavigateToThePlanDetailsPage() {
        addMedical.searchAndSelectGroup("Apple");
        common.addNewButton();
        common.clickPolicyAndPlansMenu();
        common.addNewButton();
    }

    @And("I choose type Medical and plan design Create New Plan")
    public void iChooseTypeMedicalAndPlanDesignCreateNewPlan() {
        addMedical.chooseTypeAndDesign();
    }

    @And("I click on the next button")
    public void iClickOnTheButton() {
        common.nextButton();
    }

    @And("I fill in the details of Med {string}, {string}, {string} with all new contacts")
    public void iFillInTheDetailsOfMedWithAllNewContacts(String planName, String benefitYearStart, String benefitYearEnd) {
        addMedical.generateAndFillPlanName(planName);
        addMedical.fillBenefitYearDate(benefitYearStart, benefitYearEnd);
        addMedical.claimAdjAndPlanID();
        addMedical.choosePlanDesignAndIdCard();
        common.addPayerContact();
        common.addPatientContact();
        common.addAdminContact();
        common.addBillingContact();
        common.nextButton();
    }

    @And("I fill Med Plan In-Network section with new contacts details")
    public void iFillMedPlanInNetworkSectionWithNewContactsDetails() {
        common.addInNetworkContact();
        common.addPBMContact();
        addMedical.medInNetworkValues();
    }

    @And("I fill Med Plan Out-Network section with new contacts details")
    public void iFillMedPlanOutNetworkSectionWithNewContactsDetails() {
        common.addOutNetworkContact();
        addMedical.medOutNetworkValues();
    }

    @And("I submit the form")
    public void iSubmitTheForm() {
        common.submitButton();
    }

    @And("I should see a Med Add Plan confirmation message")
    public void iShouldSeeAMedAddPlanConfirmationMessage() {
        String planNames = addMedical.getGeneratedPlanName();
        WebElement actualToast = addMedical.verifyAddMedPlanToast();
        basePage.waitForElementToBeVisible(actualToast, Duration.ofSeconds(15));
        basePage.assertTextEquals(actualToast, planNames + " has been added successfully.");
    }

    @Then("the new Med plan should be listed in the Plan List section")
    public void theNewMedPlanShouldBeListedInThePlanListSection() throws InterruptedException {
        String planName = addMedical.getGeneratedPlanName();
        WebElement planListed = addMedical.verifyListedPlan();
        basePage.assertTextEquals(planListed, planName);
    }

}
