//package com.previnci.pages;
//
//import com.previnci.core.PageGenerator;
//import org.apache.commons.io.FileUtils;
//import org.apache.commons.lang3.RandomStringUtils;
//import org.apache.commons.lang3.StringUtils;
//import org.junit.Assert;
//import org.openqa.selenium.*;
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.FluentWait;
//
//import java.io.File;
//import java.io.IOException;
//import java.time.Duration;
//import java.util.List;
//import java.util.ResourceBundle;
//
//import static org.junit.Assert.assertEquals;
//
//public class BasePage extends PageGenerator {
//
//    private static final Duration DEFAULT_TIMEOUT = Duration.ofSeconds(20);
//    ResourceBundle rb = ResourceBundle.getBundle("config");
//
//    public BasePage(WebDriver driver) {
//        super(driver);
//    }
//
//    //    public static void highlightElement(WebDriver driver, WebElement element) {
////        JavascriptExecutor js = (JavascriptExecutor) driver;
////        js.executeScript("arguments[0].setAttribute('style', 'border: 2px solid red;');", element);
////    }
//    public static void highlightElement(WebDriver driver, WebElement element, String borderColor, String textColor) {
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("arguments[0].setAttribute('style', 'border: 8px solid " + borderColor + "; color: " + textColor + ";');", element);
//    }
//
//    public WebElement printListAndSelect(List<WebElement> list, boolean selectOption) {
//        System.out.println("List Items:");
//        for (int i = 0; i < list.size(); i++) {
//            WebElement item = list.get(i);
//            System.out.println((i + 1) + ". " + item.getText());
//            if (selectOption && i == 0) { // Optionally select the first element
//                System.out.println("Selected: " + item.getText());
//                return item; // Return the selected element
//            }
//        }
//        return null; // Return null if no element is selected
//    }
//
//    protected FluentWait<WebDriver> createFluentWait(Duration timeout, Duration polling) {
//        return new FluentWait<>(driver).withTimeout(timeout).pollingEvery(polling).ignoring(NoSuchElementException.class);
//    }
//
//    protected FluentWait<WebDriver> createDefaultFluentWait() {
//        return createFluentWait(DEFAULT_TIMEOUT, Duration.ofSeconds(1));
//    }
//
//    protected void clearText(WebElement element) {
//        createDefaultFluentWait().until(ExpectedConditions.visibilityOf(element));
//        element.clear();
//    }
//
//    public void scrollElementIntoView(WebElement element) {
//        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
//    }
//
//    public void click(WebElement element, boolean scrollIntoView) {
//        try {
//            createDefaultFluentWait().until(ExpectedConditions.elementToBeClickable(element));
//            if (scrollIntoView) {
//                scrollElementIntoView(element);
//            }
//            element.click();
//        } catch (TimeoutException e) {
//            System.out.println("Timeout waiting for element to be clickable: " + e.getMessage());
//        } catch (WebDriverException e) {
//            System.out.println("Element Not Clickable: " + e.getMessage());
//        }
//    }
//
//    public void click(WebElement element) {
//        click(element, true); // Default to scrolling into view
//    }
//
//    //   protected void writeText(WebElement element, String text) {
////        if (StringUtils.isNotEmpty(text)) {
////            element.clear();
////            element.sendKeys(text);
////            driver.findElement(By.cssSelector("body")).click();
////        }
////    }
//    protected void writeText(WebElement element, String text) {
//        writeText(element, text, false);  // Default to not pressing Enter
//    }
//
//    // Overloaded writeText method with option to press Enter
//    protected void writeText(WebElement element, String text, boolean pressEnter) {
//        if (StringUtils.isNotEmpty(text)) {
//            clearText(element);  // Clears the text field
//            element.sendKeys(text);  // Enters the provided text
//
//            if (pressEnter) {
//                element.sendKeys(Keys.ENTER);  // Presses the Enter key if requested
//            }
//        }
//    }
//
//
//    protected String getText(WebElement element) {
//        try {
//            return createDefaultFluentWait().until(ExpectedConditions.visibilityOf(element)).getText();
//        } catch (TimeoutException e) {
//            System.out.println("Element is not visible within the specified timeout.");
//            return null;
//        }
//    }
//
//    public String randomString(int length) {
//        String letters = RandomStringUtils.randomAlphabetic(length);
//        return "New" + letters;
//    }
//
//    public String randomNumber(int length) {
//        return RandomStringUtils.randomNumeric(length);
//    }
//
//    public String randomAlphanumeric(int lettersLength, int numbersLength) {
//        String letters = RandomStringUtils.randomAlphabetic(lettersLength);
//        String numbers = RandomStringUtils.randomNumeric(numbersLength);
//        return letters + "@" + numbers;
//    }
//
//    public void switchToWindow(WebDriver driver, String windowHandle) {
//        driver.switchTo().window(windowHandle);
//    }
//
//    public void captureScreenshot(WebDriver driver, String screenshotName) throws IOException {
//        TakesScreenshot ts = (TakesScreenshot) driver;
//        File source = ts.getScreenshotAs(OutputType.FILE);
//        FileUtils.copyFile(source, new File("./screenshots/" + screenshotName + ".png"));
//    }
//
//    public void dragAndDrop(WebElement source, WebElement target) {
//        createDefaultFluentWait().until(ExpectedConditions.visibilityOf(source));
//        // Wait for the target element to be visible
//        createDefaultFluentWait().until(ExpectedConditions.visibilityOf(target));
//        Actions actions = new Actions(driver);
//        actions.dragAndDrop(source, target).build().perform();
//    }
//
//    public void hoverOverElement(WebElement element) {
//        Actions actions = new Actions(driver);
//        actions.moveToElement(element).build().perform();
//    }
//
//    protected void selectDropdownByText(WebElement dropdownElement, String visibleText) {
//        createDefaultFluentWait().until(ExpectedConditions.visibilityOf(dropdownElement));
//        Select dropdown = new Select(dropdownElement);
//        dropdown.selectByVisibleText(visibleText);
//    }
//
//    // Overloaded method to select dropdown value by value
//    protected void selectDropdownByValue(WebElement dropdownElement, String value) {
//        createDefaultFluentWait().until(ExpectedConditions.visibilityOf(dropdownElement));
//        Select dropdown = new Select(dropdownElement);
//        dropdown.selectByValue(value);
//    }
//
//    // Overloaded method to select dropdown value by index
//    protected void selectDropdownByIndex(WebElement dropdownElement, int index) {
//        createDefaultFluentWait().until(ExpectedConditions.visibilityOf(dropdownElement));
//        Select dropdown = new Select(dropdownElement);
//        dropdown.selectByIndex(index);
//    }
//
//    public void assertElementDisplayed(WebElement element) {
//        createDefaultFluentWait().until(ExpectedConditions.elementToBeClickable(element));
//        Assert.assertTrue("Element is not displayed", ElementUtils.isElementDisplayed(element));
//        System.out.println(element);
//    }
//
//    public void assertTextEquals(WebElement element, Object expected) {
//        String actualText = this.getText(element);
//        String expectedText;
//
//        if (expected instanceof WebElement) {
//            expectedText = this.getText((WebElement) expected);
//        } else if (expected instanceof String) {
//            expectedText = (String) expected;
//        } else {
//            throw new IllegalArgumentException("Expected text should be either WebElement or String");
//        }
//
//        Assert.assertEquals("Text does not match", expectedText, actualText);
//        System.out.println(actualText);
//    }
//
//
//    public void assertTitleEquals(String expectedTitle) {
//        String actualTitle = driver.getTitle();
//        assertEquals("Page title does not match", expectedTitle, actualTitle);
//        System.out.println(actualTitle);
//    }
//
//    public void assertUrlEquals(String expectedUrl) {
//        String actualUrl = driver.getCurrentUrl();
//        assertEquals("URL does not match", expectedUrl, actualUrl);
//        System.out.println(actualUrl);
//    }
//
//    public static class ElementUtils {
//        public static boolean isElementDisplayed(WebElement element) {
//            try {
//                return element.isDisplayed();
//            } catch (NoSuchElementException e) {
//                return false;
//            }
//        }
//
//        public static String getText(WebElement element) {
//            return element.getText();
//        }
//    }
//}