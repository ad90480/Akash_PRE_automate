package com.previnci.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PlanAddDental extends CommonCode {
    @FindBy(how = How.XPATH, using = "//div[text()='Dental']")
    private WebElement clickDentalType;
    @FindBy(how = How.XPATH, using = "//div[text()='Create New Plan']")
    private WebElement clickCreateNewPlan;
    @FindBy(how = How.XPATH, using = "//input[@placeholder=\"Plan Name\"]")
    private WebElement denPlanName;
    @FindBy(how = How.XPATH, using = "//input[@placeholder=\"Start MM/DD/YYYY\"]")
    private WebElement denPlanBenefitStart;
    @FindBy(how = How.XPATH, using = "//input[@placeholder=\"End MM/DD/YYYY\"]")
    private WebElement denPlanBenefitEnd;
    @FindBy(how = How.XPATH, using = "//span[text()=\"Accumulator Reset\"]")
    private WebElement denAccumulatorResetDrop;
    @FindBy(how = How.XPATH, using = "//a[.='Benefit Year']")
    private WebElement denAccumulatorResetValue;
    @FindBy(how = How.XPATH, using = "//input[@placeholder=\"Claim Adjudication System Name\"]")
    private WebElement denClaimAdjudication;
    @FindBy(how = How.XPATH, using = "//input[@placeholder=\"Plan ID\"]")
    private WebElement denPlanID;
    @FindBy(how = How.XPATH, using = "//input[@placeholder=\"Specific deductible limit\"]")
    private WebElement denSpecificDedLimit;
    @FindBy(how = How.XPATH, using = "//span[text()=\"Please Select\"]")
    private WebElement denPlanTypeDrop;
    @FindBy(how = How.XPATH, using = "//a[.='Embedded']")
    private WebElement denPlanTypeValue;
    @FindBy(how = How.XPATH, using = "//span[text()=\"ID Card Template\"]")
    private WebElement denIdCardDrop;
    @FindBy(how = How.XPATH, using = "//div/a[.= 'CAN2024Dental Card']")//(//div[@class="pvt-select-list"])[3]
    private WebElement denIdCardValue;
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
    @FindBy(how = How.XPATH, using = "(//input[@placeholder=\"Value\"])[1]")
    private WebElement inMemberPortion;
    @FindBy(how = How.XPATH, using = "(//input[@placeholder=\"Value\"])[2]")
    private WebElement outMemberPortion;
    @FindBy(how = How.XPATH, using = "(//span[.='Done '])[1]")
    private WebElement inAssignPopupDone;
    @FindBy(how = How.XPATH, using = "(//span[.='Done '])[2]")
    private WebElement outAssignPopupDone;
    @FindBy(how = How.XPATH, using = "//div[.= '+ Add Out of Network Benefits']")
    private WebElement addOutNetworkSection;
    @FindBy(how = How.XPATH, using = "//div[@class=\"pvt-toast-wrraper active\"]/span/strong")
    private WebElement addDenPlanToastMsg;
    @FindBy(how = How.XPATH, using = "//td[@class=\"pvt-name ng-star-inserted\"]")
    private WebElement denPlanListedTable;
    //    @FindBy(how = How.XPATH, using = "(//div[@class=\"pv-border-right pv-border-gray\"])//div[.='+ Add Out of Network Benefits']")
//    private WebElement addOutNetworkSection;
    private String generatedDenPlanName;

    public PlanAddDental(WebDriver driver) {
        super(driver);
    }

//    public void searchAndSelectGroup(String groupName) {
//        super.writeText(this.searchForGroup, groupName, true);
//        super.click(this.clickAppleGroup);
//        highlightElement(driver, this.groupsHighlight, "blue", "green");
//
//    }

    public void chooseTypeAndDesign() {
        super.click(clickDentalType);
        super.click(clickCreateNewPlan);
    }
    public void fillBenefitYearDate(String PS, String PE) {
        writeText(denPlanBenefitStart, PS);
        writeText(denPlanBenefitEnd, PE);
        selectOptionFromDropdown(denAccumulatorResetDrop, denAccumulatorResetValue);

    }

    public void denClaimAdjAndPlanID() {
        super.writeText(denClaimAdjudication, "CLAIMDEN123");
        super.writeText(denPlanID, "DEN" + randomNumber(3));

    }

    public void denChoosePlanDesignAndIdCard() {
        selectOptionFromDropdown(denPlanTypeDrop, denPlanTypeValue);
        writeText(denSpecificDedLimit, randomNumber(4));
        selectOptionFromDropdown(denIdCardDrop, denIdCardValue);

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
        writeText(individualDeductible, randomNumber(4));
        writeText(familyDeductible, randomNumber(4));
        click(selectAllCoveredServices);
        click(clickAssignButton);
        click(outCoveredServiceTypeDrop);
        click(outCoveredServiceTypeValue);
        writeText(outMemberPortion, randomNumber(2));
        click(outAssignPopupDone);
    }

    //Verify Den Plan Name

    public String getGeneratedDenPlanName() {
        return generatedDenPlanName;
    }

    public void generateAndFillPlanName(String planName) {
        this.generatedDenPlanName = planName + " " + randomNumber(2);
        fillDenPlanName(this.generatedDenPlanName);
    }

    public void fillDenPlanName(String DP) {
        writeText(this.denPlanName, DP);
    }

    //Verify Plan toast
    public WebElement verifyAddDenPlanToast() {
        return addDenPlanToastMsg;
    }

    //Listed Plan
    public WebElement verifyDenListedPlan() {
        return denPlanListedTable;
    }


}
