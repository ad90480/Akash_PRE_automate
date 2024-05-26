package com.previnci.pages;

import com.previnci.core.PageGenerator;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.ResourceBundle;

import static org.junit.Assert.assertEquals;

public class BasePage extends PageGenerator {

    private static final Duration DEFAULT_TIMEOUT = Duration.ofSeconds(20);
    private static final Duration POLLING_INTERVAL = Duration.ofSeconds(1);
    ResourceBundle rb = ResourceBundle.getBundle("config");

    public BasePage(WebDriver driver) {
        super(driver);
    }

    public static void highlightElement(WebDriver driver, WebElement element, String borderColor, String textColor) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('style', 'border: 8px solid " + borderColor + "; color: " + textColor + ";');", element);
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
        return createFluentWait(DEFAULT_TIMEOUT, POLLING_INTERVAL);
    }

    protected void clearText(WebElement element) {
        createDefaultFluentWait().until(ExpectedConditions.visibilityOf(element));
        element.clear();
    }

    public void scrollElementIntoView(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void click(WebElement element, boolean scrollIntoView) {
        try {
            createDefaultFluentWait().until(ExpectedConditions.elementToBeClickable(element));
            if (scrollIntoView) {
                scrollElementIntoView(element);
            }
            element.click();
        } catch (TimeoutException e) {
            System.out.println("Timeout waiting for element to be clickable: " + e.getMessage());
        } catch (WebDriverException e) {
            System.out.println("Element Not Clickable: " + e.getMessage());
        }
    }

    public void click(WebElement element) {
        click(element, true); // Default to scrolling into view
    }

    protected void writeText(WebElement element, String text) {
        writeText(element, text, false); // Default to not pressing Enter
    }

    protected void writeText(WebElement element, String text, boolean pressEnter) {
        if (StringUtils.isNotEmpty(text)) {
            clearText(element); // Clears the text field
            element.sendKeys(text); // Enters the provided text

            if (pressEnter) {
                element.sendKeys(Keys.ENTER); // Presses the Enter key if requested
            }
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
        String letters = RandomStringUtils.randomAlphabetic(length);
        return "New" + letters;
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

    public void dragAndDrop(WebElement source, WebElement target) {
        createDefaultFluentWait().until(ExpectedConditions.visibilityOf(source));
        createDefaultFluentWait().until(ExpectedConditions.visibilityOf(target));
        Actions actions = new Actions(driver);
        actions.dragAndDrop(source, target).build().perform();
    }

    public void hoverOverElement(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).build().perform();
    }

    protected void selectDropdownByText(WebElement dropdownElement, String visibleText) {
        createDefaultFluentWait().until(ExpectedConditions.visibilityOf(dropdownElement));
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByVisibleText(visibleText);
    }

    protected void selectDropdownByValue(WebElement dropdownElement, String value) {
        createDefaultFluentWait().until(ExpectedConditions.visibilityOf(dropdownElement));
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByValue(value);
    }

    protected void selectDropdownByIndex(WebElement dropdownElement, int index) {
        createDefaultFluentWait().until(ExpectedConditions.visibilityOf(dropdownElement));
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByIndex(index);
    }

    public void selectOptionFromDropdown(WebElement dropdown, WebElement option) {
        try {
            WebElement dropdownElement = createDefaultFluentWait().until(ExpectedConditions.elementToBeClickable(dropdown));
            dropdownElement.click(); // Click the dropdown to open it
            WebElement optionElement = createDefaultFluentWait().until(ExpectedConditions.visibilityOf(option));
            optionElement.click(); // Select the desired option
        } catch (TimeoutException e) {
            System.out.println("Timeout waiting for the dropdown or option to be clickable: " + e.getMessage());
        } catch (WebDriverException e) {
            System.out.println("Error interacting with the dropdown or option: " + e.getMessage());
        }
    }

    public void assertElementDisplayed(WebElement element) {
        createDefaultFluentWait().until(ExpectedConditions.elementToBeClickable(element));
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
//1.	highlightElement(WebDriver driver, WebElement element, String borderColor, String textColor)
//2.	printListAndSelect(List<WebElement> list, boolean selectOption)
//3.	createFluentWait(Duration timeout, Duration polling)
//4.	createDefaultFluentWait()
//5.	clearText(WebElement element)
//6.	scrollElementIntoView(WebElement element)
//7.	click(WebElement element, boolean scrollIntoView)
//8.	click(WebElement element)
//9.	writeText(WebElement element, String text)
//10.	writeText(WebElement element, String text, boolean pressEnter)
//11.	getText(WebElement element)
//12.	randomString(int length)
//13.	randomNumber(int length)
//14.	randomAlphanumeric(int lettersLength, int numbersLength)
//15.	switchToWindow(WebDriver driver, String windowHandle)
//16.	captureScreenshot(WebDriver driver, String screenshotName) throws IOException
//17.	dragAndDrop(WebElement source, WebElement target)
//18.	hoverOverElement(WebElement element)
//19.	selectDropdownByText(WebElement dropdownElement, String visibleText)
//20.	selectDropdownByValue(WebElement dropdownElement, String value)
//21.	selectDropdownByIndex(WebElement dropdownElement, int index)
//22.	assertElementDisplayed(WebElement element)
//23.	assertTextEquals(WebElement element, Object expected)
//24.	assertTitleEquals(String expectedTitle)
//25.	assertUrlEquals(String expectedUrl)


