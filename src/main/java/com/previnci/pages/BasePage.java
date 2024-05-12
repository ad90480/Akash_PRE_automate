package com.previnci.pages;

import com.previnci.core.PageGenerator;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.ResourceBundle;

import static org.junit.Assert.assertEquals;

public class BasePage extends PageGenerator {

    private static final Duration DEFAULT_TIMEOUT = Duration.ofSeconds(20);
    ResourceBundle rb = ResourceBundle.getBundle("config");

    public BasePage(WebDriver driver) {
        super(driver);
        //this.navigationHelper = new NavigationHelper(driver);
    }

    public static void highlightElement(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('style', 'border: 2px solid red;');", element);
    }

    public WebElement printListAndSelect(List<WebElement> list, boolean selectOption) {
        System.out.println("List Items:");
        for (int i = 0; i < list.size(); i++) {
            WebElement item = list.get(i);
            System.out.println((i + 1) + ". " + item.getText());
            if (selectOption && i == 0) { // Optionally select the first element
                System.out.println("Selected: " + item.getText());
                return item; // Return the selected element
            }
        }
        return null; // Return null if no element is selected
    }

    protected FluentWait<WebDriver> createFluentWait(Duration timeout, Duration polling) {
        return new FluentWait<>(driver).withTimeout(timeout).pollingEvery(polling).ignoring(NoSuchElementException.class);
    }

    protected FluentWait<WebDriver> createDefaultFluentWait() {
        return createFluentWait(DEFAULT_TIMEOUT, Duration.ofSeconds(1));
    }

    protected void clearText(WebElement element) {
        createDefaultFluentWait().until(ExpectedConditions.visibilityOf(element));
        element.clear();
    }

    public void scrollElementIntoView(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void click(WebElement element) {
        try {
            createDefaultFluentWait().until(ExpectedConditions.elementToBeClickable(element));
            scrollElementIntoView(element);
            element.click();
        } catch (WebDriverException e) {
            System.out.println("Element Not Clickable: " + e.getMessage());
            e.printStackTrace();
        }
    }

    protected void writeText(WebElement element, String text) {
        if (StringUtils.isNotEmpty(text)) {
            element.clear();
            element.sendKeys(text);
            driver.findElement(By.cssSelector("body")).click();
        }
    }

    protected String getText(WebElement element) {
        try {
            return createDefaultFluentWait().until(ExpectedConditions.visibilityOf(element)).getText();
        } catch (TimeoutException e) {
            System.out.println("Element is not visible within the specified timeout.");
            return null;
        }
    }

    public String randomString(int length) {
        return RandomStringUtils.randomAlphabetic(length);
    }

    public String randomNumber(int length) {
        return RandomStringUtils.randomNumeric(length);
    }

    public String randomAlphanumeric(int lettersLength, int numbersLength) {
        String letters = RandomStringUtils.randomAlphabetic(lettersLength);
        String numbers = RandomStringUtils.randomNumeric(numbersLength);
        return letters + "@" + numbers;
    }

    public void switchToWindow(WebDriver driver, String windowHandle) {
        driver.switchTo().window(windowHandle);
    }

    public void captureScreenshot(WebDriver driver, String screenshotName) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(source, new File("./screenshots/" + screenshotName + ".png"));
    }

    public void assertElementDisplayed(WebElement element) {
        Assert.assertTrue("Element is not displayed", ElementUtils.isElementDisplayed(element));
        System.out.println(element);
    }

    public void assertTextEquals(WebElement element, Object expected) {
        String actualText = this.getText(element);
        String expectedText;

        if (expected instanceof WebElement) {
            expectedText = this.getText((WebElement) expected);
        } else if (expected instanceof String) {
            expectedText = (String) expected;
        } else {
            throw new IllegalArgumentException("Expected text should be either WebElement or String");
        }

        Assert.assertEquals("Text does not match", expectedText, actualText);
        System.out.println(actualText);
    }


    public void assertTitleEquals(String expectedTitle) {
        String actualTitle = driver.getTitle();
        assertEquals("Page title does not match", expectedTitle, actualTitle);
        System.out.println(actualTitle);
    }

    public void assertUrlEquals(String expectedUrl) {
        String actualUrl = driver.getCurrentUrl();
        assertEquals("URL does not match", expectedUrl, actualUrl);
        System.out.println(actualUrl);
    }

    public static class ElementUtils {
        public static boolean isElementDisplayed(WebElement element) {
            try {
                return element.isDisplayed();
            } catch (NoSuchElementException e) {
                return false;
            }
        }

        public static String getText(WebElement element) {
            return element.getText();
        }
    }
}
