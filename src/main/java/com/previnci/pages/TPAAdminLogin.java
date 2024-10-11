package com.previnci.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class TPAAdminLogin extends CommonCode {

    private final String userName = rb.getString("adminusername");
    private final String passWord = rb.getString("adminpassword");
    @FindBy(how = How.XPATH, using = "//div/input[@placeholder=\"Enter Username\"]")
    private WebElement writeUsername;
    @FindBy(how = How.XPATH, using = "//div/input[@placeholder=\"Enter Password\"]")
    private WebElement writePassword;
    @FindBy(how = How.XPATH, using = "//button[@type='button']")
    private WebElement clickLogin;
    @FindBy(how = How.XPATH, using = "(//span[text()=\"Groups\"])[2]")
    private WebElement dashBoard;
    @FindBy(how = How.XPATH, using = "//span[@class=\"pvt-nav-link-text\"]")
    private WebElement successfulLoggedIn;
    @FindBy(how = How.CSS, using = "li[class=\"pvt-nav-item ng-star-inserted\"]")
    private WebElement navBarMenus;
    @FindBy(how = How.XPATH, using = "//span[@class=\"pvt-toast toast toast-default default\"]")
    private WebElement invalidCredErrMsg;
    @FindBy(how = How.XPATH, using = " //*[text()='Forgot Password / New User']")
    private WebElement clickForgetPassword;
    @FindBy(how = How.XPATH, using = "//input[@placeholder=\"Enter Email\"]")
    private WebElement enterUserEmail;
    @FindBy(how = How.XPATH, using = "//span[@class=\"pvt-toast toast toast-default default\"]")
    private WebElement forgetPassMailToastMsg;



    public TPAAdminLogin(WebDriver driver) {
        super(driver);
    }

    public void adminLoggedIn() {
        super.writeText(this.writeUsername, userName);
        super.writeText(this.writePassword, passWord);
        super.click(this.clickLogin);
    }

    public void enterUsername(String username) {
        writeText(this.writeUsername, username);
    }

    public void enterPassword(String password) {
        writeText(this.writePassword, password);
    }

    public void clickLogin() {
        super.click(this.clickLogin);
    }

    public WebElement loggedIn() {
        return dashBoard;
    }

    public String successfulLoggedIn() {
        return getText(successfulLoggedIn);
    }

    public String invalidCredErrMsg() {
        return getText(this.invalidCredErrMsg);
    }

    public void clickForgetPassword() {
        click(this.clickForgetPassword);
    }

    public void enterUserEmail(String email) {
        writeText(this.enterUserEmail, email);
    }

    public String forgetPassMailToastMsg() {
        return getText(this.forgetPassMailToastMsg);
    }

}
