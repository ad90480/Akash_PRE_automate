package com.previnci.pages;

import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AdminLogin extends BasePage {
    private final String userName = System.getProperty("user");
    private final String password = System.getProperty("password");

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
        super.writeText(this.usernametext, userName);
    }
    public void adminpassword(){
        super.writeText(this.passwordtext, password);
    }
    public void loginbutton(){
        super.click(this.loginbuttotn);

    }
    public void adminloggedin(){
        super.writeText(this.usernametext, userName);
        super.writeText(this.passwordtext, password);
        super.click(this.loginbuttotn);
    }

}
