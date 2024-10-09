package com.previnci.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class CommonCode extends UtilityMethods {
    @FindBy(how = How.XPATH, using = "//button[contains(., 'Submit')]")
    private WebElement submitButton;
    @FindBy(how = How.XPATH, using = "//button[contains(., 'next')]")
    private WebElement nextButton;
    @FindBy(how = How.XPATH, using = "//previnci-buttons[@label=\"Add new\"]")//button[contains(., 'Add new')]
    private WebElement addNewButton;
    @FindBy(how = How.XPATH, using = "//previnci-buttons[@ng-reflect-label=\"Cancel\"]")
    private WebElement cancelButton;
    @FindBy(how = How.XPATH, using = "//li/a/span[text()='Policy and Plans']")
    private WebElement policyAndPlans;
    //Add Plan Contacts:
    @FindBy(how = How.XPATH, using = "(//div[@class=\"pv-accordion-header\"])[1]")
    private WebElement payerContactAccordion;
    @FindBy(how = How.XPATH, using = "(//div[@class=\"pv-accordion-header\"])[2]")
    private WebElement patientContactAccordion;
    @FindBy(how = How.XPATH, using = "(//div[@class=\"pv-accordion-header\"])[3]")
    private WebElement adminContactAccordion;
    @FindBy(how = How.XPATH, using = "(//div[@class=\"pv-accordion-header\"])[4]")
    private WebElement billingContactAccordion;
    @FindBy(how = How.XPATH, using = "//input[@placeholder=\"PayerId\"]")
    private WebElement payerId;
    @FindBy(how = How.XPATH, using = "//div[@class=\"add-New-Contact\"]")
    private WebElement addNewContactButton;
    @FindBy(how = How.XPATH, using = "//input[@placeholder=\"vendor name\"]")
    private WebElement vendorName;
    @FindBy(how = How.XPATH, using = "//span[.='Choose Type']")
    private WebElement vendorTypeDrop;
    @FindBy(how = How.XPATH, using = "//div/a[.= 'Back Office']")
    private WebElement vendorTypeValue;
    @FindBy(how = How.XPATH, using = "(//previnci-input[@inputpattern=\"phone\"])/div/div/input")
    private WebElement vendorPhone;
    @FindBy(how = How.XPATH, using = "//input[@placeholder=\"email\"]")
    private WebElement vendorEmail;
    @FindBy(how = How.XPATH, using = "//input[@placeholder=\"street address\"]")
    private WebElement vendorStreetAdd;
    @FindBy(how = How.XPATH, using = "//input[@placeholder=\"city\"]")
    private WebElement vendorCity;
    @FindBy(how = How.XPATH, using = "//input[@placeholder=\"State\"]")
    private WebElement vendorStateDrop;
    @FindBy(how = How.XPATH, using = "//div/a[.= 'District of Columbia']")
    private WebElement vendorStateValue;
    @FindBy(how = How.XPATH, using = "//input[@placeholder=\"zipcode\"]")
    private WebElement vendorZipCode;
    @FindBy(how = How.XPATH, using = "(//div[@class=\"pv-accordion-header\"])[1]")
    private WebElement inNetworkContactAccordion;
    @FindBy(how = How.XPATH, using = "//a[.='RBP']")
    private WebElement networkType;
    @FindBy(how = How.XPATH, using = "(//div[@class=\"pv-accordion-header\"])[2]")
    private WebElement pbmContactAccordion;
    @FindBy(how = How.XPATH, using = "(//div[@class=\"pv-accordion-header\"])[1]")
    private WebElement outNetworkContactAccordion;

    public CommonCode(WebDriver driver) {
        super(driver);
    }

    public void submitButton() {
        super.click(this.submitButton);
    }

    public void nextButton() {
        super.click(this.nextButton);
    }

    public void addNewButton() {
        super.click(this.addNewButton);
    }

    public void cancelButton() {
        super.click(this.cancelButton);

    }

    public void clickPolicyAndPlansMenu() {
        click(this.policyAndPlans);
    }

    public void addPayerContact() {
        click(payerContactAccordion);
        writeText(payerId, "PAYER" + randomNumber(3));
        click(addNewContactButton);
        writeText(vendorName, "Payer Contact " + randomNumber(2));
        selectOptionFromDropdown(vendorTypeDrop, vendorTypeValue);
        writeText(vendorPhone, "1111111111");
        writeText(vendorEmail, "payer" + randomNumber(3) + "@testemail.com");
        writeText(vendorStreetAdd, "Street01");
        writeText(vendorCity, "City01");
        selectOptionFromDropdown(vendorStateDrop, vendorStateValue);
        writeText(vendorZipCode, "11111");
    }

    public void addPatientContact() {
        click(patientContactAccordion);
        click(addNewContactButton);
        writeText(vendorName, "Patient Contact " + randomNumber(2));
        selectOptionFromDropdown(vendorTypeDrop, vendorTypeValue);
        writeText(vendorPhone, "2222222222");
        writeText(vendorEmail, "patient" + randomNumber(3) + "@testemail.com");
        writeText(vendorStreetAdd, "Street02");
        writeText(vendorCity, "City02");
        selectOptionFromDropdown(vendorStateDrop, vendorStateValue);
        writeText(vendorZipCode, "22222");
    }

    public void addAdminContact() {
        click(adminContactAccordion);
        click(addNewContactButton);
        writeText(vendorName, "Admin Contact " + randomNumber(2));
        selectOptionFromDropdown(vendorTypeDrop, vendorTypeValue);
        writeText(vendorPhone, "3333333333");
        writeText(vendorEmail, "admin" + randomNumber(3) + "@testemail.com");
        writeText(vendorStreetAdd, "Street03");
        writeText(vendorCity, "City03");
        selectOptionFromDropdown(vendorStateDrop, vendorStateValue);
        writeText(vendorZipCode, "33333");

    }

    public void addBillingContact() {
        click(billingContactAccordion);
        click(addNewContactButton);
        writeText(vendorName, "Billing Contact " + randomNumber(2));
        selectOptionFromDropdown(vendorTypeDrop, vendorTypeValue);
        writeText(vendorPhone, "4444444444");
        writeText(vendorEmail, "billing" + randomNumber(3) + "@testemail.com");
        writeText(vendorStreetAdd, "Street04");
        writeText(vendorCity, "City04");
        selectOptionFromDropdown(vendorStateDrop, vendorStateValue);
        writeText(vendorZipCode, "44444");

    }

    public void addInNetworkContact() {
        click(inNetworkContactAccordion);
        click(addNewContactButton);
        writeText(vendorName, "In-Network Contact " + randomNumber(2));
        selectOptionFromDropdown(vendorTypeDrop, networkType);
        writeText(vendorPhone, "5555555555");
        writeText(vendorEmail, "in-network" + randomNumber(3) + "@testemail.com");
        writeText(vendorStreetAdd, "Street05");
        writeText(vendorCity, "City05");
        selectOptionFromDropdown(vendorStateDrop, vendorStateValue);
        writeText(vendorZipCode, "55555");

    }

    public void addPBMContact() {
        click(pbmContactAccordion);
        click(addNewContactButton);
        writeText(vendorName, "PBM Contact " + randomNumber(2));
       // selectOptionFromDropdown(vendorTypeDrop, networkType);
        writeText(vendorPhone, "6666666666");
        writeText(vendorEmail, "pbm-contact" + randomNumber(3) + "@testemail.com");
        writeText(vendorStreetAdd, "Street06");
        writeText(vendorCity, "City06");
        selectOptionFromDropdown(vendorStateDrop, vendorStateValue);
        writeText(vendorZipCode, "66666");
    }

    public void addOutNetworkContact() {
        click(outNetworkContactAccordion);
        click(addNewContactButton);
        writeText(vendorName, "Out-Network Contact " + randomNumber(2));
        selectOptionFromDropdown(vendorTypeDrop, networkType);
        writeText(vendorPhone, "7777777777");
        writeText(vendorEmail, "out-network" + randomNumber(3) + "@testemail.com");
        writeText(vendorStreetAdd, "Street07");
        writeText(vendorCity, "City07");
        selectOptionFromDropdown(vendorStateDrop, vendorStateValue);
        writeText(vendorZipCode, "77777");

    }

}
