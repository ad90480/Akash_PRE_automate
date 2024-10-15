package com.previnci.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PlanAddMedical extends CommonCode {
    @FindBy(how = How.XPATH, using = "//input[@placeholder=\"Search\"]")
    private WebElement searchForGroup;
    @FindBy(how = How.XPATH, using = "//span[contains(text(), 'Group 07-10-2024')]")
    private WebElement clickAppleGroup;
    @FindBy(how = How.XPATH, using = "//span[contains(text(), 'Group 07-10-2024')]")
    private WebElement groupsHighlight;
    @FindBy(how = How.XPATH, using = "//div[text()='Medical']")
    private WebElement clickMedicalType;
    @FindBy(how = How.XPATH, using = "//div[text()='Create New Plan']")
    private WebElement clickCreateNewPlan;
    @FindBy(how = How.XPATH, using = "//input[@placeholder=\"Plan Name\"]")
    private WebElement planName;
    @FindBy(how = How.XPATH, using = "//input[@placeholder=\"Start MM/DD/YYYY\"]")
    private WebElement planBenefitStart;
    @FindBy(how = How.XPATH, using = "//input[@placeholder=\"End MM/DD/YYYY\"]")
    private WebElement planBenefitEnd;
    @FindBy(how = How.XPATH, using = "(//span[text()=\"Please Select\"])[1]")
    private WebElement medAccumulatorResetDrop;
    @FindBy(how = How.XPATH, using = "//a[.='Benefit Year']")
    private WebElement medAccumulatorResetValue;
    @FindBy(how = How.XPATH, using = "//input[@placeholder=\"Claim Adjudication System Name\"]")
    private WebElement claimAdjudication;
    @FindBy(how = How.XPATH, using = "//input[@placeholder=\"Plan ID\"]")
    private WebElement planID;
    @FindBy(how = How.XPATH, using = "(//a[@class=\"pvt-select-selection\"])[2]")
    private WebElement medPlanTypeDrop;
    @FindBy(how = How.XPATH, using = "//a[.='Embedded']")
    private WebElement medPlanTypeValue;
    @FindBy(how = How.XPATH, using = "//input[@placeholder=\"Specific deductible limit\"]")
    private WebElement specificDedLimit;
    @FindBy(how = How.XPATH, using = "(//label[@class=\"pv-toggle ng-star-inserted\"])[1]")
    private WebElement hsaEligible;
    @FindBy(how = How.XPATH, using = "(//label[@class=\"pv-toggle ng-star-inserted\"])[2]")
    private WebElement copayMedical;
    @FindBy(how = How.XPATH, using = "(//label[@class=\"pv-toggle ng-star-inserted\"])[3]")
    private WebElement copayPharmacy;
    @FindBy(how = How.XPATH, using = "//previnci-select[@ng-reflect--select-text=\"Select ID Card Template\"]")//(//a[@class="pvt-select-selection"])[3]
    private WebElement idCardDrop;
    @FindBy(how = How.XPATH, using = "//div/a[.= 'CAN2024_Traditional Card']")//(//div[@class="pvt-select-list"])[3]
    private WebElement idCardValue;
    @FindBy(how = How.XPATH, using = "//input[@placeholder=\"Individual Deductible\"]")
    private WebElement individualDeductible;
    @FindBy(how = How.XPATH, using = "//input[@placeholder=\"Family Deductible\"]")
    private WebElement familyDeductible;
    @FindBy(how = How.XPATH, using = "//input[@placeholder=\"Individual OOPM\"]")
    private WebElement individualOOPM;
    @FindBy(how = How.XPATH, using = "//input[@placeholder=\"Family OOPM\"]")
    private WebElement familyOOPM;
    @FindBy(how = How.XPATH, using = "//input[@placeholder=\"RxBin\"]")
    private WebElement rxBin;
    @FindBy(how = How.XPATH, using = "//input[@placeholder=\"RxPCN\"]")
    private WebElement rxPCN;
    @FindBy(how = How.XPATH, using = "//input[@placeholder=\"RxGroup\"]")
    private WebElement rxGroup;
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
    private WebElement addMedPlanToastMsg;
    @FindBy(how = How.XPATH, using = "//td[@class=\"pvt-name ng-star-inserted\"]")
    private WebElement medPlanListedTable;
//    @FindBy(how = How.XPATH, using = "((//tbody[@class=\"p-element p-datatable-tbody\"])/tr/td)[5]")
//    private WebElement getTableData;

    private String generatedPlanName;

    public PlanAddMedical(WebDriver driver) {
        super(driver);
    }


    public void searchAndSelectGroup(String groupName) {
        writeText(this.searchForGroup, groupName, true);
        click(this.clickAppleGroup);
        highlightElement(driver, this.groupsHighlight, "blue", "green");

    }

    public void chooseTypeAndDesign() {
        click(this.clickMedicalType);
        click(this.clickCreateNewPlan);
    }

    public void generateAndFillPlanName(String planName) {
        this.generatedPlanName = planName + " " + randomNumber(2);
        fillPlanName(this.generatedPlanName);
    }

    public void fillPlanName(String DP) {
        writeText(this.planName, DP);
    }

    public String getGeneratedPlanName() {
        return generatedPlanName;
    }

    public void fillBenefitYearDate(String PS, String PE) {
        writeText(this.planBenefitStart, PS);
        writeText(this.planBenefitEnd, PE);
        selectOptionFromDropdown(this.medAccumulatorResetDrop, this.medAccumulatorResetValue);

    }

    public void claimAdjAndPlanID() {
        writeText(this.claimAdjudication, "CLAIMMED123");
        writeText(this.planID, "MED" + randomNumber(3));

    }

    public void choosePlanDesignAndIdCard() {
        selectOptionFromDropdown(this.medPlanTypeDrop, this.medPlanTypeValue);
        writeText(this.specificDedLimit, randomNumber(4));
        click(hsaEligible);
        click(copayMedical);
        click(copayPharmacy);
        selectOptionFromDropdown(this.idCardDrop, this.idCardValue);
    }

    //MedicalInNetworkSection
    public void medInNetworkValues() {
        writeText(individualDeductible, randomNumber(4));
        writeText(individualOOPM, randomNumber(4));
        writeText(familyDeductible, randomNumber(4));
        writeText(familyOOPM, randomNumber(4));
        writeText(rxBin, "rxBin" + randomNumber(2));
        writeText(rxPCN, "rxPCN" + randomNumber(2));
        writeText(rxGroup, "rxGroup" + randomNumber(2));
        click(selectAllCoveredServices);
        click(clickAssignButton);
        click(inCoveredServiceTypeDrop);
        click(inCoveredServiceTypeValue);
        writeText(inMemberPortion, randomNumber(2));
        click(inAssignPopupDone);
        click(addOutNetworkSection);
    }

    //MedicalOutNetworkSection
    public void medOutNetworkValues() {
        writeText(individualDeductible, randomNumber(4));
        writeText(individualOOPM, randomNumber(4));
        writeText(familyDeductible, randomNumber(4));
        writeText(familyOOPM, randomNumber(4));
        click(selectAllCoveredServices);
        click(clickAssignButton);
        click(outCoveredServiceTypeDrop);
        click(outCoveredServiceTypeValue);
        writeText(outMemberPortion, randomNumber(2));
        click(outAssignPopupDone);

    }

    //Verify Plan toast
    public WebElement verifyAddMedPlanToast() {
        return addMedPlanToastMsg;
    }

    //Listed Plan
    public WebElement verifyListedPlan(){
        return medPlanListedTable;
    }
    //public void selectNavBarMenuByValue() {
//    List<List<String>> tableData = printTableContents(driver, By.xpath("//tbody"), true);
//    boolean valueFound = tableData.stream().flatMap(List::stream).anyMatch(cell -> cell.equals("Silicon Valley, Inc."));
//    Assert.assertTrue("Table does not contain the expected value.", valueFound);

}
