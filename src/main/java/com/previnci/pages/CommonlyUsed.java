package com.previnci.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class CommonlyUsed extends BasePage {
    public CommonlyUsed(WebDriver driver) {
        super(driver);
    }
    @FindBy(how = How.XPATH,using = "//previnci-buttons[@ng-reflect-label=\"Submit\"]")
    private WebElement Submitbutton;

    @FindBy(how = How.XPATH,using = "//previnci-buttons[@ng-reflect-label=\"Cancel\"]")
    private WebElement Cancelbutton;

    public void submitbutton() {
        super.click(this.Submitbutton);
//        waitForPageToReload(20);

    }

    public void cancelbutton() {
        super.click(this.Cancelbutton);

    }
}
