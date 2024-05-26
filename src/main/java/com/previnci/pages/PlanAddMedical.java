package com.previnci.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PlanAddMedical extends CommonlyUsed {
    @FindBy(how = How.XPATH, using = "//input[@placeholder=\"Search\"]")
    private WebElement searchForGroup;
    @FindBy(how = How.XPATH, using = "//span[contains(text(), 'Apple Incorp Ltd')]")
    private WebElement clickAppleGroup;
    @FindBy(how = How.XPATH, using = "//span[contains(text(), 'Apple Incorp Ltd')]")
    private WebElement groupsHighlight;
    @FindBy(how = How.XPATH, using = "//div[text()='Medical']")
    private WebElement clickDentalType;
    @FindBy(how = How.XPATH, using = "//div[text()='Create New Plan']")
    private WebElement clickCreateNewPlan;
    @FindBy(how = How.XPATH, using = "//input[@placeholder=\"Plan Name\"]")
    private WebElement planName;
    @FindBy(how = How.XPATH, using = "//input[@placeholder=\"Start MM/DD/YYYY\"]")
    private WebElement planBenefitStart;
    @FindBy(how = How.XPATH, using = "//input[@placeholder=\"End MM/DD/YYYY\"]")
    private WebElement planBenefitEnd;
    @FindBy(how = How.XPATH, using = "//input[@placeholder=\"Claim Adjudication System Name\"]")
    private WebElement claimAdjudication;
    @FindBy(how = How.XPATH, using = "//input[@placeholder=\"Plan ID\"]")
    private WebElement planID;
    @FindBy(how = How.XPATH, using = "//span[text()=\"Accumulator Reset\"]")
    private WebElement accumulatorResetDrop;
    @FindBy(how = How.XPATH, using = "//a[.='Benefit Year']")
    private WebElement accumulatorResetValue;
    @FindBy(how = How.XPATH, using = "//input[@placeholder=\"Specific deductible limit\"]")
    private WebElement specificDedLimit;
    @FindBy(how = How.XPATH, using = "//span[.='Please Select']")
    private WebElement planTypeDrop;
    @FindBy(how = How.XPATH, using = "//a[.='Embedded']")
    private WebElement planTypeValue;
    @FindBy(how = How.XPATH, using = "//span[.= 'ID Card Template']")
    private WebElement idCardDrop;
    @FindBy(how = How.XPATH, using = "//div/a[.= 'CAN2024Dental Card']")//(//div[@class="pvt-select-list"])[3]
    private WebElement idCardValue;
    @FindBy(how = How.XPATH, using = "//input[@placeholder=\"Individual Deductible\"]")
    private WebElement individualDeductible;
    @FindBy(how = How.XPATH, using = "//input[@placeholder=\"Family Deductible\"]")
    private WebElement familyDeductible;
    @FindBy(how = How.XPATH, using = "//input[@placeholder=\"Dental Annual Max\"]")
    private WebElement dentalAnnualMax;
    @FindBy(how = How.XPATH, using = "//input[@placeholder=\"Orthodontia Lifetime Max\"]")
    private WebElement orthodontiaMax;
    @FindBy(how = How.XPATH, using = "(//input[@ng-reflect-name=\"checkbox\"])[1]")
    private WebElement selectAllCoveredServices;
    @FindBy(how = How.XPATH, using = "//previnci-buttons[@label=\"Assign\"]")
    private WebElement clickAssignButton;
    @FindBy(how = How.XPATH, using = "((//div[@class=\"modal-content-container\"])//span[.='Select'])[1]")
    private WebElement inCoveredServiceTypeDrop;
    @FindBy(how = How.XPATH, using = "((//div[@class=\"modal-content-container\"])//span[.='Select'])[1]")
    private WebElement outCoveredServiceTypeDrop;
    @FindBy(how = How.XPATH, using = "(((//div[@class=\"modal-content-container\"])//a[.='Coinsurance Percentage']))[1]")
    private WebElement inCoveredServiceTypeValue;
    @FindBy(how = How.XPATH, using = "(((//div[@class=\"modal-content-container\"])//a[.='Coinsurance Percentage']))[2]")
    private WebElement outCoveredServiceTypeValue;
    @FindBy(how = How.XPATH, using = "(//input[@placeholder=\"Member portion %\"])[1]")
    private WebElement inMemberPortion;
    @FindBy(how = How.XPATH, using = "(//input[@placeholder=\"Member portion %\"])[2]")
    private WebElement outMemberPortion;
    @FindBy(how = How.XPATH, using = "(//span[.='Done '])[1]")
    private WebElement inAssignPopupDone;
    @FindBy(how = How.XPATH, using = "(//span[.='Done '])[2]")
    private WebElement outAssignPopupDone;

    @FindBy(how = How.XPATH, using = "//div[.= '+ Add Out of Network Benefits']")
    private WebElement addOutNetworkSection;
//    @FindBy(how = How.XPATH, using = "(//div[@class=\"pv-border-right pv-border-gray\"])//div[.='+ Add Out of Network Benefits']")
//    private WebElement addOutNetworkSection;

    public PlanAddMedical(WebDriver driver) {
        super(driver);
    }

    public void searchAndSelectGroup(String groupName) {
        super.writeText(this.searchForGroup, groupName, true);
        super.click(this.clickAppleGroup);
        highlightElement(driver, this.groupsHighlight, "blue", "green");

    }

    public void chooseTypeAndDesign() {
        super.click(this.clickDentalType);
        super.click(this.clickCreateNewPlan);
    }


    public void fillPlanName(String DP) {
        super.writeText(this.planName, DP);
    }

    public void fillBenefitYearDate(String PS, String PE) {
        super.writeText(this.planBenefitStart, PS);
        super.writeText(this.planBenefitEnd, PE);
        super.selectOptionFromDropdown(this.accumulatorResetDrop, this.accumulatorResetValue);

    }

    public void claimAdjAndPlanID() {
        super.writeText(this.claimAdjudication, "CLAIMDEN123");
        super.writeText(this.planID, "DEN" + randomNumber(3));

    }

    public void choosePlanDesignAndIdCard() {
        super.selectOptionFromDropdown(this.planTypeDrop, this.planTypeValue);
        super.writeText(this.specificDedLimit, randomNumber(4));
        super.selectOptionFromDropdown(idCardDrop, idCardValue);

    }

    //DentalInNetworkSection
    public void denInNetworkValues() {
        writeText(individualDeductible, randomNumber(4));
        writeText(familyDeductible, randomNumber(4));
        writeText(dentalAnnualMax, randomNumber(4));
        writeText(orthodontiaMax, randomNumber(4));
        click(selectAllCoveredServices);
        click(clickAssignButton);
        click(inCoveredServiceTypeDrop);
        click(inCoveredServiceTypeValue);
        writeText(inMemberPortion, randomNumber(2));
        click(inAssignPopupDone);
        click(addOutNetworkSection);
    }

    //DentalOutNetworkSection
    public void denOutNetworkValues() {
        //  click(addOutNetworkSection);
        writeText(individualDeductible, randomNumber(4));
        writeText(familyDeductible, randomNumber(4));
        click(selectAllCoveredServices);
        click(clickAssignButton);
        click(outCoveredServiceTypeDrop);
        click(outCoveredServiceTypeValue);
        writeText(outMemberPortion, randomNumber(2));
        click(outAssignPopupDone);
    }


}
