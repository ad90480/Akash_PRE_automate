//package com.previnci.pages;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.How;
//
//import java.sql.Timestamp;
//import java.util.Currency;
//
//public class TPAAddGroup extends CommonCode {
//
//    @FindBy(how = How.XPATH, using = "//td[text()='Group Name']/following-sibling::td//input")
//    private WebElement groupNameField;
//    @FindBy(how = How.XPATH, using = "//td[text()='Group Number']/following-sibling::td//input")
//    private WebElement groupNumberField;
//    @FindBy(how = How.XPATH, using = "//td[text()='Policy Term Start Date']/following-sibling::td//input")
//    private WebElement policyStartDateField;
//    @FindBy(how = How.XPATH, using = "//td[text()='Policy Term End Date']/following-sibling::td//input\n")
//    private WebElement policyEndDateField;
//    @FindBy(how = How.XPATH, using = "//td[text()='First Name']/following-sibling::td//input")
//    private WebElement primaryFirstNameField;
//    @FindBy(how = How.XPATH, using = "//td[text()='Last Name']/following-sibling::td//input")
//    private WebElement primaryLastNameField;
//    @FindBy(how = How.XPATH, using = "//td[text()='Email']/following-sibling::td//input")
//    private WebElement primaryEmailField;
//    @FindBy(how = How.XPATH, using = "//span/strong[@class=\"label-text\"]")
//    private WebElement confirmationMessage;
//    @FindBy(how = How.XPATH, using = "//tbody/tr/td/div/span[contains(text(),' Test Password Issue ')]")
//    private WebElement addedGroupInList;
//
//    public TPAAddGroup(WebDriver driver) {
//        super(driver);
//    }
//
//    // Method to enter group details
//    public void enterGroupDetails(String groupName, String groupNumber, String startDate, String endDate) {
//        writeText(this.groupNameField, groupName+ " "+randomNumber(2));
//        writeText(this.groupNumberField, groupNumber+ randomNumber(4));
//        writeText(this.policyStartDateField, startDate);
//        writeText(this.policyEndDateField, endDate);
//    }
//
//    // Method to enter primary plan sponsor details
//    public void enterPrimaryPlanSponsorDetails(String firstName, String lastName, String email) {
//        writeText(this.primaryFirstNameField, firstName);
//        writeText(this.primaryLastNameField, lastName);
//        writeText(this.primaryEmailField, firstName+"_"+lastName+randomNumber(2)+email);
//    }
//
//    // Method to get confirmation message
//    public String getConfirmationMessage() {
//        return getText(this.confirmationMessage);
//    }
//
//    // Method to verify that the group is added in the list
//    public String isGroupAddedInList() {
//        return getText(addedGroupInList);
//    }
//    public void isGroupAddedInListHighlight() {
//        scrollElementIntoView(this.addedGroupInList);
//        highlightElement(driver, this.addedGroupInList, "blue", "green");
//    }
//
//}
//
////validation- previnci-input[@ng-reflect-appearance="validate"]
////Toast msg- //span/strong[@class="label-text"]
//

////}
//
//
//

package com.previnci.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.Set;

public class TPAAddGroup extends CommonCode {

    private final String usernameCreate = "Testing" + randomString(2) + randomNumber(3);
    @FindBy(how = How.XPATH, using = "//td[text()='Group Name']/following-sibling::td//input")
    private WebElement groupNameField;
    @FindBy(how = How.XPATH, using = "//td[text()='Group Number']/following-sibling::td//input")
    private WebElement groupNumberField;
    @FindBy(how = How.XPATH, using = "//td[text()='Policy Term Start Date']/following-sibling::td//input")
    private WebElement policyStartDateField;
    @FindBy(how = How.XPATH, using = "//td[text()='Policy Term End Date']/following-sibling::td//input")
    private WebElement policyEndDateField;
    @FindBy(how = How.XPATH, using = "//td[text()='First Name']/following-sibling::td//input")
    private WebElement primaryFirstNameField;
    @FindBy(how = How.XPATH, using = "//td[text()='Last Name']/following-sibling::td//input")
    private WebElement primaryLastNameField;
    @FindBy(how = How.XPATH, using = "//td[text()='Email']/following-sibling::td//input")
    private WebElement primaryEmailField;
    @FindBy(how = How.XPATH, using = "//span/strong[@class=\"label-text\"]")
    private WebElement confirmationMessage;
    @FindBy(how = How.XPATH, using = "//td[text()='Email']/following-sibling::td//previnci-input[@ng-reflect-appearance='validate']")
    private WebElement errorHighlighted;
    @FindBy(how = How.CSS, using = "tbody.p-element.p-datatable-tbody")
    private WebElement addedGroupInList;
    //  Mailasaur
    @FindBy(how = How.XPATH, using = "//input[@id=\"email\"]")
    private WebElement emailField;
    @FindBy(how = How.XPATH, using = "//button[@type=\"submit\"]")
    private WebElement continueButton;
    @FindBy(how = How.XPATH, using = "//input[@id=\"password\"]")
    private WebElement passwordField;
    @FindBy(how = How.XPATH, using = "//button[@type=\"submit\"]")
    private WebElement submitButton;
    @FindBy(how = How.XPATH, using = "//div/a[@data-testid=\"imqudfxx-2\"]")
    private WebElement inboxDevNav;
    @FindBy(how = How.XPATH, using = "//button[@data-testid=\"refresh-messages\"]") // Replace with actual locators
    private WebElement refresh;
    //    @FindBy(how = How.XPATH, using = "(//div[@class=\"pv-accordion-header\"])[2]") // Replace with actual locators
    //    private WebElement inboxListBody;
    @FindBy(how = How.XPATH, using = "(//div[@data-testid=\"address-0\"]/p)[1]")
    private WebElement inboxListSubject;
    @FindBy(how = How.XPATH, using = "//a[text()='COMPLETE REGISTRATION']") // Replace with actual locators
    private WebElement completeRegistrationLink;

    // OrgSignUp
    // Locators
    //    @FindBy(how = How.XPATH, using = "//previnci-input[@formcontrolname=\"companyLegalName\"]/div/div")
    //    private WebElement companyLegalName;
    @FindBy(how = How.XPATH, using = "(//form//previnci-input[@class='ng-untouched ng-pristine ng-invalid']//input)[1]")
    private WebElement companyLegalName;
    @FindBy(how = How.XPATH, using = "//input[@placeholder='Enter company DBA name']")
    private WebElement companyDBAName;
    @FindBy(how = How.XPATH, using = "//input[@placeholder='Enter street address']")
    private WebElement streetAddress;
    @FindBy(how = How.XPATH, using = "//input[@placeholder='Enter city']")
    private WebElement city;
    @FindBy(how = How.XPATH, using = "//input[@placeholder='Enter state name']")
    private WebElement state;
    @FindBy(how = How.XPATH, using = "//input[@placeholder='Enter ZipCode']")
    private WebElement zipCode;
    @FindBy(how = How.XPATH, using = "//input[@placeholder='']")
    private WebElement phoneNo;
    @FindBy(how = How.XPATH, using = "//input[@placeholder='##-#######']")
    private WebElement tin;
    @FindBy(how = How.XPATH, using = "//button[contains(., 'Next')]")
    private WebElement nextButton;
    @FindBy(how = How.XPATH, using = "//input[@placeholder='Enter first name']")
    private WebElement firstName;
    @FindBy(how = How.XPATH, using = "//input[@placeholder='Enter last name']")
    private WebElement lastName;
    @FindBy(how = How.XPATH, using = "//input[@placeholder='Enter Last Four']")
    private WebElement lastFour;
    @FindBy(how = How.XPATH, using = "//input[@placeholder='Enter username']")
    private WebElement username;
    @FindBy(how = How.XPATH, using = "//input[@placeholder='Enter password']")
    private WebElement password;
    @FindBy(how = How.XPATH, using = "//input[@placeholder='Enter confirm password']")
    private WebElement confirmPassword;
    @FindBy(how = How.XPATH, using = "//button[contains(., 'Review')]")
    private WebElement reviewButton;
    @FindBy(how = How.XPATH, using = "//button[contains(., 'Submit')]")
    private WebElement orgSubmitButton;

    private String generatedGroupName;
    private String generatedGroupNumber;

    public TPAAddGroup(WebDriver driver) {
        super(driver);
    }

    public void enterGroupDetails(String groupName, String groupNumber, String startDate, String endDate) {
        this.generatedGroupName = groupName + " " + randomNumber(2);
        this.generatedGroupNumber = groupNumber + randomNumber(4);

        writeText(this.groupNameField, this.generatedGroupName);
        writeText(this.groupNumberField, this.generatedGroupNumber);
        writeText(this.policyStartDateField, startDate);
        writeText(this.policyEndDateField, endDate);
    }

    public void enterPrimaryPlanSponsorDetails(String firstName, String lastName, String email) {
        writeText(this.primaryFirstNameField, firstName);
        writeText(this.primaryLastNameField, lastName);
        writeText(this.primaryEmailField, firstName + "_" + lastName + randomNumber(2) + email);
    }

    public String getConfirmationMessage() {
        return getText(this.confirmationMessage);
    }

    public String getGeneratedGroupName() {
        return this.generatedGroupName;
    }

    public String getGeneratedGroupNumber() {
        return this.generatedGroupNumber;
    }

    public boolean isGroupAddedInList(String expectedGroupName, String expectedGroupNumber) {
        super.waitForFixedTime(7000);
        super.createDefaultFluentWait().until(ExpectedConditions.visibilityOf(addedGroupInList));
        // Find all rows in the group list
        List<WebElement> rows = addedGroupInList.findElements(By.tagName("tr"));
        // Loop through the rows to find the expected group
        for (WebElement row : rows) {
            List<WebElement> columns = row.findElements(By.tagName("td"));
            if (columns.size() > 2) {  // Ensure there are enough columns to check
                String companyName = columns.get(0).getText(); // Group Name
                String groupNumber = columns.get(2).getText(); // Group Number
                System.out.println(companyName);
                System.out.println(groupNumber);
                // Check if the expected group name and number match
                if (companyName.equals(expectedGroupName) && groupNumber.equals(expectedGroupNumber)) {
                    return true;  // Group is found
                }
            }
        }
        return false;  // Group not found
    }

    public void fillGroupDetails(String groupName, String groupNumber, String startDate, String endDate) {
        writeText(this.groupNameField, groupName);
        writeText(this.groupNumberField, groupNumber);
        writeText(this.policyStartDateField, startDate);
        writeText(this.policyEndDateField, endDate);
    }

    public void fillPlanSponserDetails(String firstName, String lastName, String email) {
        writeText(this.primaryFirstNameField, firstName);
        writeText(this.primaryLastNameField, lastName);
        writeText(this.primaryEmailField, email);
    }

    public Boolean getErrorMessage() {
        return errorHighlighted.isDisplayed();
    }

    // Method to open Mailosaur app and log in
    public void openAppAndLogin() {
        openNewTab(driver, rb.getString("mailosaurURL"), false);
        click(emailField);
        writeText(emailField, rb.getString("mailosaurUseName"));
        click(continueButton);
        click(passwordField);
        writeText(this.passwordField, rb.getString("mailosaurPassword"));
        click(submitButton);
    }

    public void navigateToInbox() {
        click(inboxDevNav);
        click(refresh);
    }

    public String verifyEmailContent() {
        return getText(inboxListSubject);
    }

    public void openReceivedEmail() {
        click(inboxListSubject);
    }

    public void clickCompleteRegistrationLink() {
        click(completeRegistrationLink);
        super.switchToWindowByTitle(driver, "PreVinci", false);
    }

    // Org SignUp
    public void enterCompanyLegalName(String legalName) {
        writeText(companyLegalName, legalName);
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
    }

    public void enterCompanyDBAName(String dbaName) {
        writeText(companyDBAName, dbaName);
    }

    public void enterStreetAddress(String address) {
        writeText(streetAddress, address);
    }

    public void enterCity(String cityName) {
        writeText(city, cityName);
    }

    public void enterState(String stateName) {
        writeText(state, stateName);
    }

    public void enterZipCode(String zip) {
        writeText(zipCode, zip);
    }

    public void enterPhone(String phone) {
        writeText(phoneNo, phone);
    }

    public void enterEINorTIN() {
        writeText(tin, randomNumber(9));
    }

    public void clickNextButton() {
        click(nextButton);
    }

    public void enterFirstName() {
        writeText(firstName, "Testing" + randomString(2));
    }

    public void enterLastName() {
        writeText(lastName, "Create" + randomString(2));
    }

    public void enterLastFour() {
        writeText(lastFour, randomNumber(2));
    }

    public void enterUsername() {
        writeText(username, usernameCreate);
    }

    public void enterPassword() {
        writeText(password, usernameCreate + "2024!");
    }

    public void enterConfirmPassword() {
        writeText(confirmPassword, usernameCreate + "2024!");
    }

    public void clickReviewButton() {
        click(reviewButton);
    }

    public void clickSubmitButton() {
        click(orgSubmitButton);
        waitForFixedTime(10000);
    }
}

