package com.previnci.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PlanAddVision extends CommonlyUsed {
    @FindBy(how = How.XPATH, using = "//div[text()='Vision']")
    private WebElement clickVisionType;
    @FindBy(how = How.XPATH, using = "//div[text()='Create New Plan']")
    private WebElement clickCreateNewPlan;
    @FindBy(how = How.XPATH, using = "//input[@placeholder=\"Plan Name\"]")
    private WebElement planName;
    @FindBy(how = How.XPATH, using = "//input[@placeholder=\"Start MM/DD/YYYY\"]")
    private WebElement planBenefitStart;
    @FindBy(how = How.XPATH, using = "//input[@placeholder=\"End MM/DD/YYYY\"]")
    private WebElement planBenefitEnd;
    @FindBy(how = How.XPATH, using = "//span[text()=\"Accumulator Reset\"]")
    private WebElement accumulatorResetDrop;
    @FindBy(how = How.XPATH, using = "//a[.='Benefit Year']")
    private WebElement accumulatorResetValue;
    @FindBy(how = How.XPATH, using = "//input[@placeholder=\"Claim Adjudication System Name\"]")
    private WebElement claimAdjudication;
    @FindBy(how = How.XPATH, using = "//input[@placeholder=\"Plan ID\"]")
    private WebElement planID;
    @FindBy(how = How.XPATH, using = "//input[@placeholder=\"Specific deductible limit\"]")
    private WebElement specificDedLimit;
    @FindBy(how = How.XPATH, using = "//span[text()=\"Please Select\"]")
    private WebElement planTypeDrop;
    @FindBy(how = How.XPATH, using = "//a[.='Embedded']")
    private WebElement planTypeValue;
    @FindBy(how = How.XPATH, using = "//span[text()=\"ID Card Template\"]")
    private WebElement idCardDrop;
    @FindBy(how = How.XPATH, using = "//div/a[.= 'CAN2024_Vision Card']")
    private WebElement idCardValue;
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
    @FindBy(how = How.XPATH, using = "//div[@class=\"pvt-toast-wrraper active\"]/span/strong")
    private WebElement addVisPlanToastMsg;
    @FindBy(how = How.XPATH, using = "//td[@class=\"pvt-name ng-star-inserted\"]")
    private WebElement visPlanListedTable;

    private String generatedVisPlanName;

    public PlanAddVision(WebDriver driver) {
        super(driver);
    }

//    public void searchAndSelectGroup(String groupName) {
//        super.writeText(this.searchForGroup, groupName, true);
//        super.click(this.clickAppleGroup);
//        highlightElement(driver, this.groupsHighlight, "blue", "green");
//
//    }

    public void chooseTypeAndDesign() {
        click(this.clickVisionType);
        click(this.clickCreateNewPlan);
    }

    public void fillBenefitYearDate(String PS, String PE) {
        writeText(this.planBenefitStart, PS);
        writeText(this.planBenefitEnd, PE);
        selectOptionFromDropdown(this.accumulatorResetDrop, this.accumulatorResetValue);

    }

    public void claimAdjAndPlanID() {
        writeText(this.claimAdjudication, "CLAIMVIS123");
        writeText(this.planID, "VIS" + randomNumber(3));

    }

    public void choosePlanDesignAndIdCard() {
        selectOptionFromDropdown(this.planTypeDrop, this.planTypeValue);
        writeText(this.specificDedLimit, randomNumber(4));
        selectOptionFromDropdown(idCardDrop, idCardValue);

    }

    //VisionInNetworkSection
    public void visInNetworkValues() {
        click(selectAllCoveredServices);
        click(clickAssignButton);
        click(inCoveredServiceTypeDrop);
        click(inCoveredServiceTypeValue);
        writeText(inMemberPortion, randomNumber(2));
        click(inAssignPopupDone);
        click(addOutNetworkSection);
    }

    //VisionOutNetworkSection
    public void visOutNetworkValues() {
        click(selectAllCoveredServices);
        click(clickAssignButton);
        click(outCoveredServiceTypeDrop);
        click(outCoveredServiceTypeValue);
        writeText(outMemberPortion, randomNumber(2));
        click(outAssignPopupDone);
    }

    //Verify Plan Name
    public String getGeneratedVisPlanName() {
        return generatedVisPlanName;
    }
    public void generateAndFillVisPlanName(String planName) {
        this.generatedVisPlanName = planName + " " + randomNumber(2);
        fillVisPlanName(this.generatedVisPlanName);
    }

    public void fillVisPlanName(String DP) {
        writeText(this.planName, DP);
    }

    //Verify Plan toast
    public WebElement verifyAddVisPlanToast() {
        return addVisPlanToastMsg;
    }

    //Listed Plan
    public WebElement verifyVisListedPlan() {
        return visPlanListedTable;
    }

}