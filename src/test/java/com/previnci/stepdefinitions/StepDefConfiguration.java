package com.previnci.stepdefinitions;

import com.previnci.Util.ExtendReportManager;
import com.previnci.core.PageManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;

public class StepDefConfiguration {

    @Before(value = "@gui", order = 0)
    public void initPages(Scenario scenario) {
        PageManager.getInstance().initialisePageGenerator();
        ExtendReportManager.getExtent();
        ExtendReportManager.createTest(scenario.getName()); // Initialize the ExtentTest for this scenario
        ExtendReportManager.logInfo("Test case initialized: " + scenario.getName());
    }

    @After(order = 0, value = "@gui")
    public void clean(Scenario scenario) {
        if (scenario.isFailed()) {
            takeScreenshot(scenario);
            ExtendReportManager.logError("Scenario failed: " + scenario.getName());
        } else {
            ExtendReportManager.logInfo("Scenario passed: " + scenario.getName());
        }
        cleanUpResources();
        ExtendReportManager.flush(); // Ensure to flush reports
    }

    private void takeScreenshot(Scenario scenario) {
        String screenshotDirectory = "target/screenshots"; // Customize your screenshot directory
        createDirectoryIfNotExists(screenshotDirectory);

        String screenshotFileName = scenario.getName() + ".png";
        String screenshotFilePath = Paths.get(screenshotDirectory, screenshotFileName).toString();

        try {
            WebDriver driver = PageManager.getInstance().getPageGenerator().driver;
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            // Save screenshot to file
            Files.write(Paths.get(screenshotFilePath), screenshot);
            // Attach screenshot to the Cucumber report
            scenario.attach(screenshot, "image/png", screenshotFileName);
            // Convert bytes to Base64 and attach the Base64 screenshot to ExtentReports
            String base64Screenshot = Base64.getEncoder().encodeToString(screenshot);
            ExtendReportManager.logError("Screenshot of failure:").addScreenCaptureFromBase64String(base64Screenshot);
            System.out.println("Screenshot has been taken and saved to: " + screenshotFilePath);
        } catch (IOException e) {
            System.err.println("Failed to save screenshot: " + e.getMessage());
        }
    }

    private void createDirectoryIfNotExists(String dirPath) {
        try {
            Files.createDirectories(Paths.get(dirPath));
        } catch (IOException e) {
            System.err.println("Could not create screenshot directory: " + e.getMessage());
        }
    }

    private void cleanUpResources() {
        PageManager.getInstance().closeDriver();
        PageManager.cleanUp();
    }
}

