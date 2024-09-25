package com.previnci.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.List;

public class AdminLogin extends BasePage {

    private static final String USERNAME_XPATH = "//div/input[@placeholder='Enter Username']";
    private static final String PASSWORD_XPATH = "//div/input[@placeholder='Enter Password']";
    private static final String LOGIN_BUTTON_XPATH = "//button[@type='button']";
    private static final String AFTER_LOGGED_IN_XPATH = "(//span[text()='Groups'])[2]";
    private static final String PAGE_LOGO_XPATH = "//a/img[@class='desktop-logo']";
    private static final String NAVBAR_MENUS_XPATH = "//previnci-nav/div[2]/nav/div/div/div[1]/ul/li";
    private final String userName = rb.getString("adminusername");
    private final String passWord = rb.getString("adminpassword");

    //div[@class="navContent"]/div/ul/li
    //ul[@class="pvt-nav-list"]/li
    //previnci-nav/div[2]/nav/div/div/div[1]/ul/li[2]
    public AdminLogin(WebDriver driver) {
        super(driver);
    }

    public void adminUsername() {
        WebElement usernametext = findElementByXpath(USERNAME_XPATH);
        writeText(usernametext, userName);
    }

    public void adminPassword() {
        WebElement passwordtext = findElementByXpath(PASSWORD_XPATH);
        writeText(passwordtext, passWord);
    }

    public void loginButton() {
        WebElement loginbutton = findElementByXpath(LOGIN_BUTTON_XPATH);
        click(loginbutton);
    }

    public WebElement loggedIn() {
        return findElementByXpath(AFTER_LOGGED_IN_XPATH);
    }

    public WebElement logoCheck() {
        return findElementByXpath(PAGE_LOGO_XPATH);
    }

    public void adminLoggedIn() {
        adminUsername();
        adminPassword();
        loginButton();
    }

    public void enterUsername(String username) {
        WebElement usernametext = findElementByXpath(USERNAME_XPATH);
        writeText(usernametext, username);
    }

    public void enterPassword(String password) {
        WebElement passwordtext = findElementByXpath(PASSWORD_XPATH);
        writeText(passwordtext, password);
    }

    // Excel Credential read code
    public void enterCredentialsFromExcel(String filePath, String sheetName) throws IOException {
        List<List<String>> credentials = readUserCredentialsFromExcel(filePath, sheetName);

        // Assuming the first row contains headers, so starting from the second row
        for (int i = 1; i < credentials.size(); i++) {
            List<String> rowData = credentials.get(i);
            String username = rowData.get(0);
            String password = rowData.get(1);

            // Enter username and password
            enterUsername(username);
            enterPassword(password);
            break; // Since you want to use only the first credential
        }
    }

    public void selectNavBarMenuByValue() {
        List<List<String>> tableData = printTableContents(driver, By.xpath("//tbody"), true);
        boolean valueFound = tableData.stream().flatMap(List::stream).anyMatch(cell -> cell.equals("Silicon Valley, Inc."));
        Assert.assertTrue("Table does not contain the expected value.", valueFound);

}}
