/*
package com.previnci.core;

import com.previnci.constants.DriverType;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.function.Supplier;

public class DriverSupplier  {

    ResourceBundle rb = ResourceBundle.getBundle("config");

    private final String browser = System.getProperty("browser");
    private final String appUrl = rb.getString("appURL");
    private static final Map<DriverType, Supplier<WebDriver>> driverMap = new HashMap<>();
    private WebDriver driver;

    public WebDriver initializeDriver() {
        invokeApplication();
        return driver;
    }

    private static final Supplier<WebDriver> chromeDriverSupplier = () -> {
        ChromeOptions options = new ChromeOptions();
        WebDriverManager.chromedriver().setup(); // Automatically downloads the latest ChromeDriver version
        options.addArguments("--start-maximized");
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--no-sandbox");
        options.setExperimentalOption("excludeSwitches",new String[]{"enable-automation"});
        options.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.IGNORE);
        return new ChromeDriver(options);
    };

    static {
        driverMap.put(DriverType.CHROME, chromeDriverSupplier); // Assuming DriverType.CHROME exists
    }

    public void invokeApplication() {
        DriverType driverType;
        if (browser.equals("chrome")) {
            driverType = DriverType.CHROME;
        } else {
            throw new WebDriverException("Unsupported browser type");
        }

        driver = driverMap.get(driverType).get();
        driver.get(appUrl);
    }
}*/
//(value = "@gui", order = 0)


//Base file
//package com.previnci.pages;
//
//import com.previnci.core.PageGenerator;
//import org.apache.commons.lang3.RandomStringUtils;
//import org.apache.commons.lang3.StringUtils;
//import org.openqa.selenium.*;
//import org.openqa.selenium.support.ui.ExpectedCondition;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.FluentWait;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//import java.time.Duration;
//import java.util.ResourceBundle;
//
//public class BasePage extends PageGenerator {
//
//    ResourceBundle rb = ResourceBundle.getBundle("config");
//
//    public BasePage(WebDriver driver) {
//        super(driver);
//    }
//
//    public FluentWait<WebDriver> waitUntil(Duration timeout, Duration polling) {
//        return new FluentWait<>(driver).withTimeout(timeout).pollingEvery(polling).ignoring(NoSuchElementException.class);
//    }
//
//    protected FluentWait<WebDriver> waitUntil() {
//        return waitUntil(20);
//    }
//
//    protected FluentWait<WebDriver> waitUntil(long seconds) {
//        return this.waitUntil(Duration.ofSeconds(seconds), Duration.ofSeconds(1));
//    }
//
////    protected boolean waitForPageToReload(long seconds) {
////        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
////        ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
////            @Override
////            public Boolean apply(WebDriver driver) {
////                try {
////                    JavascriptExecutor jsExecutor = null;
////                    jsExecutor = (JavascriptExecutor) driver;
////                    return ((Long) jsExecutor.executeScript("return jQuery.active") == 0);
////                } catch (Exception e) {
////                    return true;
////                }
////            }
////        };
////
////        // wait for JavaScript to load
////        ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
////            @Override
////            public Boolean apply(WebDriver driver) {
////                try {
////                    JavascriptExecutor jsExecutor = null;
////                    jsExecutor = (JavascriptExecutor) driver;
////                    return jsExecutor.executeScript("return document.readyState").toString().equals("complete");
////                } catch (Exception e) {
////                    return true;
////                }
////            }
////        };
////
////        return wait.until(jQueryLoad) && wait.until(jsLoad);
////    }
//protected boolean waitForPageToReload(long seconds) {
//    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
//
//    ExpectedCondition<Boolean> pageLoadCondition = driver -> {
//        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
//        // Wait for jQuery AJAX calls to finish and for document.readyState to be "complete"
//        return (Boolean) jsExecutor.executeScript("return (jQuery.active == 0) && (document.readyState == 'complete')");
//    };
//
//    return wait.until(pageLoadCondition);
//}
//
//    protected void clearText(WebElement element) {
//        waitUntil().until(ExpectedConditions.visibilityOf(element));
//        element.clear();
//    }
//
//    public void scrollElementIntoView(WebElement element) {
//        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
//    }
//
//    public void click(WebElement element) {
//        try {
//            waitUntil().until(ExpectedConditions.elementToBeClickable(element));
//            scrollElementIntoView(element); // Scroll element into view
//            element.click();
//        } catch (ElementClickInterceptedException e) {
//            System.out.println("Element Not Clickable: " + e.getMessage());
//            e.printStackTrace();
//        }
//    }
//
//    protected void writeText(WebElement element, String text) {
//        if (StringUtils.isEmpty(text)) {
//            return;
//        }
//        element.clear();
//        element.sendKeys(text);
//        super.driver.findElement((By.cssSelector("body"))).click();
//    }
//
//    protected String getText(WebElement element) {
//        try {
//            waitUntil().until(ExpectedConditions.visibilityOf(element));
//            return element.getText();
//        } catch (TimeoutException e) {
//            System.out.println("Element is not visible within the specified timeout.");
//            return null;
//        }
//    }
//
//    public String randomString(int length) {
//        String generatedString = RandomStringUtils.randomAlphabetic(length);
//        return generatedString;
//    }
//
//    public String randomNumber(int length) {
//        String generatedNumber = RandomStringUtils.randomNumeric(length);
//        return generatedNumber;
//    }
//
//    public String randomAlphanumeric(int lettersLength, int numbersLength) {
//        String st = RandomStringUtils.randomAlphabetic(lettersLength);
//        String num = RandomStringUtils.randomNumeric(numbersLength);
//        return (st + "@" + num);
//    }
//}






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

