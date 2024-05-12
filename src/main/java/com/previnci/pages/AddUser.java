package com.previnci.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AddUser extends BasePage {

    @FindBy(how = How.XPATH, using = "(//span[@class=\"pvt-nav-link-text nested-title-text\"])[7]")
    private WebElement usermodule;
    @FindBy(how = How.XPATH, using = "//div[@ng-reflect-fx-flex-align=\"start\"]")
    private WebElement adduserbutton;
    @FindBy(how = How.XPATH, using = "(//div//previnci-input//input)[1]")
    private WebElement userfirstname;
    @FindBy(how = How.XPATH, using = "(//div//previnci-input//input)[2]")
    private WebElement userlastname;
    @FindBy(how = How.XPATH, using = "(//div//previnci-input//input)[3]")
    private WebElement useremail;
    @FindBy(how = How.XPATH, using = "(//div//previnci-input//input)[4]")
    private WebElement userphone;
    @FindBy(how = How.XPATH, using = "//strong[text()=\"User created successfully.\"]")
    private WebElement toastmsg;
    @FindBy(how = How.XPATH, using = " (//td[@class=\"mat-mdc-cell mdc-data-table__cell cdk-cell pointer text-transform-none cdk-column-personalEmail mat-column-personalEmail ng-star-inserted\"])[1]")
    private WebElement emailusertable;

    private String filledUserEmail; // Declare a variable to store filled user email

    public AddUser(WebDriver driver) {
        super(driver);
    }

    public String getFilledUserEmail() {
        return filledUserEmail;
    }

    public String randomEmail() {
        filledUserEmail = randomString(5) + "@testemail.com";
        return filledUserEmail;
    }
    public WebElement getEmailElement() {
        return emailusertable; // Return the email element from the user table
    }

    public WebElement userModule() {
        super.click(this.usermodule);
        return usermodule;
    }

    public void addUserButton() {
        super.click(this.adduserbutton);
    }

    public void firstName() {
        super.writeText(this.userfirstname, randomString(5));
    }

    public void lastName() {
        super.writeText(this.userlastname, randomString(5));
    }

    public void email() {
        super.writeText(this.useremail, randomEmail()); // Use randomEmail() to fill email
    }

    public void phone() {
        super.writeText(this.userphone, randomNumber(10));
    }

    public WebElement verifyToastMsg() {
        return toastmsg;
    }
}

