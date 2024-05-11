package com.previnci.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class AddUser extends BasePage {
//(//div/div/ul[@class="pvt-nav-list"]/li)[7]
    @FindBy(how = How.XPATH, using = "(//div/div/ul[@class=\"pvt-nav-list\"]/li)[7]")
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
    @FindBy(how = How.XPATH, using = "//strong[text()=\"User created successfully.\"]")//strong[@class="label-text"]
    private WebElement toastmsg;
    @FindBy(how = How.XPATH, using = "(//previnci-buttons[@label=\"Edit\"])[1]")
    private WebElement edituser;
    @FindBy(how = How.XPATH, using = "//previnci-buttons[@label=\"Assign Role\"]")
    private WebElement assignrole;
    @FindBy(how = How.XPATH, using = "//a/span[.='Select Role']")
    private WebElement selectroledd;
    @FindBy(how = How.XPATH, using = "//a[.='MA Dashboard']")
    private WebElement chooserole;
    @FindBy(how = How.XPATH, using = "//a[.='MA Dashboard']")
    private WebElement submitrole;

    public AddUser(WebDriver driver) {
        super(driver);
    }

    public void userModule() {
        super.click(this.usermodule);
        System.out.println(this.usermodule);
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
        super.writeText(this.useremail, randomString(5) + "@testemail.com");
    }

    public void phone() {
        super.writeText(this.userphone,randomNumber(10));
    }


    public String verifyToastMsg() {
        String addUserToastMsg=super.getText(this.toastmsg);
        return addUserToastMsg;
    }


    public void edituser() {
        super.click(this.edituser);
        super.click(this.assignrole);
        super.click(this.selectroledd);
        super.click(this.chooserole);
        super.click(this.submitrole);
    }
}
