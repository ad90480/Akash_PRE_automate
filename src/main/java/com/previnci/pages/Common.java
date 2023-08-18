package com.previnci.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Common extends BasePage {
    @FindBy(how = How.XPATH, using = "//previnci-buttons[@label=\"Submit\"]")
    private WebElement usersubmit;
    @FindBy(how = How.XPATH, using = "//previnci-buttons[@label=\"Submit\"]")
    private WebElement usercancel;
    public Common (WebDriver driver) {
        super(driver);
    }
    public void submitbutton() {
        super.click(this.usersubmit);
    }

    public void cancelbutton() {
        super.click(this.usercancel);
    }
}
