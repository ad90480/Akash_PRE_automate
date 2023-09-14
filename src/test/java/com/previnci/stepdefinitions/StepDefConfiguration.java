package com.previnci.stepdefinitions;

import com.previnci.core.PageManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class StepDefConfiguration {

    @Before(value = "@gui", order = 0)
    public void initPages() {
        PageManager.getInstance().initialisePageGenerator();
    }
    @After(order = 0, value = "@gui")
    public void clean(Scenario scenario) {
        if (scenario.isFailed()) {
            // Save the screenshot to a specific directory
            String screenshotDirectory = "target/screenshots";
            String screenshotFileName = scenario.getName() + ".png";
            String screenshotFilePath = Paths.get(screenshotDirectory, screenshotFileName).toString();

            try {
                byte[] screenshot = this.takeScreenshot();
                Files.write(Paths.get(screenshotFilePath), screenshot);
                scenario.attach(screenshot, "image/png", screenshotFileName);
                System.out.println("Screenshot saved to: " + screenshotFilePath);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        PageManager.getInstance().closeDriver();
        PageManager.cleanUp();
    }

    private byte[] takeScreenshot() {
        WebDriver driver = PageManager.getInstance().getPageGenerator().driver;
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

/*    @After(order = 0, value = "@gui")
    public void clean(Scenario scenario) {
        if (scenario.isFailed()) {
            scenario.attach(this.takeScreenshot(), "image/png", scenario.getName());
        }
        PageManager.getInstance().closeDriver();
        PageManager.cleanUp();
    }

    private byte[] takeScreenshot(){
        WebDriver driver = PageManager.getInstance().getPageGenerator().driver;
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);

    }*/
}