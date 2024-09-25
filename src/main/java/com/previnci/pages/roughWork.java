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




//package com.previnci.pages;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.How;
//
//import java.io.IOException;
//import java.util.List;
//
//public class AdminLogin extends BasePage {
//
//    private final String userName = rb.getString("adminusername");
//    private final String passWord = rb.getString("adminpassword");
//    @FindBy(how = How.XPATH, using = "//div/input[@placeholder=\"Enter Username\"]")
//    private WebElement usernametext;
//    @FindBy(how = How.XPATH, using = "//div/input[@placeholder=\"Enter Password\"]")
//    private WebElement passwordtext;
//    @FindBy(how = How.XPATH, using = "//button[@type='button']")
//    private WebElement loginbuttotn;
//    @FindBy(how = How.XPATH, using = "(//span[text()=\"Groups\"])[2]")
//    private WebElement afterloggedin;
//    @FindBy(how = How.XPATH, using = "//a/img[@class=\"desktop-logo\"]")
//    private WebElement pageLogo;
//    @FindBy(how = How.CSS, using = "li[class=\"pvt-nav-item ng-star-inserted\"]")
//    private WebElement navBarMenus;
//
//
//    public AdminLogin(WebDriver driver) {
//        super(driver);
//    }
//
//    public void adminUsername() {
//        super.writeText(this.usernametext, userName);
//    }
//
//    public void adminPassword() {
//        super.writeText(this.passwordtext, passWord);
//    }
//
//    public void loginButton() {
//        super.click(this.loginbuttotn);
//    }
//
//    public WebElement loggedIn() {
//        return afterloggedin;
//    }
//
//    public WebElement logoCheck() {
//        return pageLogo;
//    }
//
//    public void adminLoggedIn() {
//        super.writeText(this.usernametext, userName);
//        super.writeText(this.passwordtext, passWord);
//        super.click(this.loginbuttotn);
//    }
//    public void enterUsername(String username) {
//        writeText(this.usernametext, username);
//    }
//
//    public void enterPassword(String password) {
//        writeText(this.passwordtext, password);
//    }
//
//
//
//    public void enterCredentialsFromExcel(String filePath, String sheetName) throws IOException, IOException {
//        List<List<String>> credentials = BasePage.readUserCredentialsFromExcel(filePath, sheetName);
//
//        // Assuming the first row contains headers, so starting from the second row
//        for (int i = 1; i < credentials.size(); i++) {
//            List<String> rowData = credentials.get(i);
//            String username = rowData.get(0);
//            String password = rowData.get(1);
//
//            // Enter username and password
//            enterUsername(username);
//            enterPassword(password);
//            break;
//        }
//    }
//}


// Example assertions
// Assert that the cell in the first row, first column contains the expected value
//String expectedValue = "Expected Value";
//String actualValue = tableData.get(0).get(0);
//        Assert.assertEquals(actualValue, expectedValue, "Cell value does not match expected value.");
//
//// Assert that the table contains a specific value somewhere
//boolean valueFound = tableData.stream().flatMap(List::stream).anyMatch(cell -> cell.equals("Specific Value"));
//        Assert.assertTrue(valueFound, "Table does not contain the expected value.");
//
//// Assert the number of rows
//int expectedRowCount = 5;
//int actualRowCount = tableData.size();
//        Assert.assertEquals(actualRowCount, expectedRowCount, "Row count does not match expected value.");
//
//// Assert the number of columns in the first row
//int expectedColumnCount = 3;
//int actualColumnCount = tableData.get(0).size();
//        Assert.assertEquals(actualColumnCount, expectedColumnCount, "Column count in the first row does not match expected value.");
