package com.previnci.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class AddUser extends BasePage {

    @FindBy(how = How.XPATH, using = "(//span[.='Users'])[1]")
    private WebElement usermodule;
    @FindBy(how = How.XPATH, using = "//previnci-buttons[@label=\"Add User\"]")
    private WebElement adduserbutton;
    @FindBy(how = How.XPATH, using = "(//div//previnci-input//input)[1]")
    private WebElement userfirstname;
    @FindBy(how = How.XPATH, using = "(//div//previnci-input//input)[2]")
    private WebElement userlastname;
    @FindBy(how = How.XPATH, using = "(//div//previnci-input//input)[3]")
    private WebElement userusername;
    @FindBy(how = How.XPATH, using = "(//div//previnci-input//input)[4]")
    private WebElement useremail;
    @FindBy(how = How.XPATH, using = "(//div//previnci-input//input)[5]")
    private WebElement userphone;
    @FindBy(how = How.XPATH, using = "//previnci-buttons[@label=\"Submit\"]")
    private WebElement usersubmit;
    @FindBy(how = How.XPATH, using = "//*[contains(text(),'QA has been created successfully')]")
    private WebElement toastmsg;
    @FindBy(how=How.XPATH,using = "//a[@class=\"brandLogoIcon hide-mobile\"]")
    private WebElement clickonlogo;

    public AddUser(WebDriver driver) {
        super(driver);
    }

    public void usermodule() {
        super.click(this.usermodule);

    }

    public void adduserbutton() {
        super.click(this.adduserbutton);

    }

    public void firstname(String Fn) {
        super.writeText(userfirstname, Fn);
    }

    public void lastname(String Ln) {
        super.writeText(userlastname, Ln);
    }

    public void username(String Un) {
        super.writeText(userusername,Un);
    }

    public void email(String email) {
        super.writeText(this.useremail, email);
    }

    public void phone(String Pn) {
        super.writeText(this.userphone, Pn);
    }

    public void submitbutton() {

        super.click(this.usersubmit);
        //waitUntil(6);
        waitUntil().until(ExpectedConditions.visibilityOf(toastmsg));
        System.out.println(this.toastmsg.getText());
    }
    public void verifytoastmsg(){
        System.out.println(this.toastmsg.getText());
        Assert.assertEquals("QA has been created successfully.",this.toastmsg.getText(),"QA has been created successfully.");
        super.click(this.clickonlogo);
    }
}
