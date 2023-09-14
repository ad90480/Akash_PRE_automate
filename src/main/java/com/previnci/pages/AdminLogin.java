package com.previnci.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.Locale;
import java.util.ResourceBundle;

public class AdminLogin extends BasePage {

    private final String userName =rb.getString("adminusername");
    private final String passWord = rb.getString("adminpassword");

    @FindBy(how = How.XPATH, using = "//div/input[@placeholder=\"Enter Username\"]")
    private WebElement usernametext;
    @FindBy(how = How.XPATH, using = "//div/input[@placeholder=\"Enter Password\"]")
    private WebElement passwordtext;
    @FindBy(how = How.XPATH, using = "//button[@type='button']")
    private WebElement loginbuttotn;

    public AdminLogin(WebDriver driver) {
        super(driver);
    }

    public void adminusername() {
        super.writeText(this.usernametext,userName);
    }
    public void adminpassword(){
        super.writeText(this.passwordtext, passWord);
    }
    public void loginbutton(){
        super.click(this.loginbuttotn);

    }
    public void adminloggedin(){
        super.writeText(this.usernametext, userName);
        super.writeText(this.passwordtext, passWord);
        super.click(this.loginbuttotn);
    }

}
