package com.previnci.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AdminLogin extends BasePage {

    private final String userName = rb.getString("adminusername");
    private final String passWord = rb.getString("adminpassword");

    @FindBy(how = How.XPATH, using = "//div/input[@placeholder=\"Enter Username\"]")
    private WebElement usernametext;
    @FindBy(how = How.XPATH, using = "//div/input[@placeholder=\"Enter Password\"]")
    private WebElement passwordtext;
    @FindBy(how = How.XPATH, using = "//button[@type='button']")
    private WebElement loginbuttotn;
    @FindBy(how = How.XPATH, using = "(//span[text()=\"Groups\"])[2]")
    private WebElement afterloggedin;

    public AdminLogin(WebDriver driver) {
        super(driver);
    }

    public void adminUsername() {
        super.writeText(this.usernametext, userName);
    }

    public void adminPassword() {
        super.writeText(this.passwordtext, passWord);
    }

    public void loginButton() {
        super.click(this.loginbuttotn);
    }

    public WebElement loggedIn() {
        return afterloggedin;
    }

    public void adminLoggedIn() {
        super.writeText(this.usernametext, userName);
        super.writeText(this.passwordtext, passWord);
        super.click(this.loginbuttotn);
    }
}
