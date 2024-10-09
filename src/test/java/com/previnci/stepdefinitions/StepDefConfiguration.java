package com.previnci.stepdefinitions;

import com.previnci.Util.ExtendReportManager;
import com.previnci.core.PageManager;
import com.previnci.pages.AddRole;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
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
        ExtendReportManager.getExtent();
        ExtendReportManager.test = ExtendReportManager.extent.createTest("Test Case");
    }

    @After(order = 0, value = "@gui")
    public void clean(Scenario scenario) {
        if (scenario.isFailed()) {
            takeScreenshot(scenario);
        }
        cleanUpResources();
        ExtendReportManager.extent.flush();
    }

    private void takeScreenshot(Scenario scenario) {
        String screenshotDirectory = "target/screenshots"; // Customize your screenshot directory
        createDirectoryIfNotExists(screenshotDirectory);

        String screenshotFileName = scenario.getName() + ".png";
        String screenshotFilePath = Paths.get(screenshotDirectory, screenshotFileName).toString();

        try {
            WebDriver driver = PageManager.getInstance().getPageGenerator().driver;
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            Files.write(Paths.get(screenshotFilePath), screenshot);
            scenario.attach(screenshot, "image/png", screenshotFileName);
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
