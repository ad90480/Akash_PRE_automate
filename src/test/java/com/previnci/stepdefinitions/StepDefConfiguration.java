package com.previnci.stepdefinitions;

import com.previnci.core.PageManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
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
            String screenshotDirectory = "target/screenshots"; // Customize your screenshot directory
            String screenshotFileName = scenario.getName() + ".png";
            String screenshotFilePath = Paths.get(screenshotDirectory, screenshotFileName).toString();

            try {
                WebDriver driver = PageManager.getInstance().getPageGenerator().driver;
                byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
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
}
 /*  @After(order = 0, value = "@gui")
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            try {
                // Take a screenshot
                File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                String screenshotFileName = scenario.getName() + ".png";
                String screenshotFilePath = "target/screenshots" + screenshotFileName;

                // Copy the screenshot to the desired location
                org.apache.commons.io.FileUtils.copyFile(screenshot, new File(screenshotFilePath));
                System.out.println("Screenshot saved to: " + screenshotFilePath);

                // Attach the screenshot to the Cucumber report
                scenario.attach(screenshotFileName, "image/png", scenario.getName());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        // Quit the WebDriver instance
        if (driver != null) {
            driver.quit();
        }
    }*/

/*
    @After(order = 0, value = "@gui")
    public void clean(Scenario scenario) {
        if (scenario.isFailed()) {
            scenario.attach(this.takeScreenshot(), "image/png", scenario.getName());
        }
        PageManager.getInstance().closeDriver();
        PageManager.cleanUp();
    }

    private byte[] takeScreenshot() {
        WebDriver driver = PageManager.getInstance().getPageGenerator().driver;
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);

    }
}*/
