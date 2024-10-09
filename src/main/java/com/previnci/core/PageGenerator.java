package com.previnci.core;

import com.previnci.pages.UtilityMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


public class PageGenerator {

    public WebDriver driver;

    public PageGenerator(WebDriver driver) {
        this.driver = driver;
    }

    public <TPage extends UtilityMethods> TPage getInstance(Class<TPage> pageClass) {
        return PageFactory.initElements(driver, pageClass);
    }
}

