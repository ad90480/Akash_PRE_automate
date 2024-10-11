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

public class TPAAddGroup extends CommonCode {

    @FindBy(how = How.XPATH, using = "//td[text()='Group Name']/following-sibling::td//input")
    private WebElement groupNameField;
    @FindBy(how = How.XPATH, using = "//td[text()='Group Number']/following-sibling::td//input")
    private WebElement groupNumberField;
    @FindBy(how = How.XPATH, using = "//td[text()='Policy Term Start Date']/following-sibling::td//input")
    private WebElement policyStartDateField;
    @FindBy(how = How.XPATH, using = "//td[text()='Policy Term End Date']/following-sibling::td//input\n")
    private WebElement policyEndDateField;
    @FindBy(how = How.XPATH, using = "//td[text()='First Name']/following-sibling::td//input")
    private WebElement primaryFirstNameField;
    @FindBy(how = How.XPATH, using = "//td[text()='Last Name']/following-sibling::td//input")
    private WebElement primaryLastNameField;
    @FindBy(how = How.XPATH, using = "//td[text()='Email']/following-sibling::td//input")
    private WebElement primaryEmailField;
    @FindBy(how = How.XPATH, using = "//span/strong[@class=\"label-text\"]")
    private WebElement confirmationMessage;

    @FindBy(how = How.CSS, using = "tbody.p-element.p-datatable-tbody")
    private WebElement addedGroupInList;
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
        super.waitForFixedTime(10000);
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
                super.waitForFixedTime(10000);
                if (companyName.equals(expectedGroupName) && groupNumber.equals(expectedGroupNumber)) {
                    return true;  // Group is found
                }
            }
        }
        return false;  // Group not found
    }
}

