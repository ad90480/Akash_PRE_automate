//package com.previnci.pages;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.How;
//
//public class GroupSignUp extends CommonCode {
//
//    private final String usernameCreate = "Testing" + randomString(2) + randomNumber(3);
//    // Locators
//    @FindBy(how = How.XPATH, using = "//previnci-input[@formcontrolname=\"companyLegalName\"]/div/div")
//    private WebElement companyLegalName;
//    @FindBy(how = How.XPATH, using = "//input[@placeholder='Enter company DBA name']")
//    private WebElement companyDBAName;
//    @FindBy(how = How.XPATH, using = "//input[@placeholder='Enter street address']")
//    private WebElement streetAddress;
//    @FindBy(how = How.XPATH, using = "//input[@placeholder='Enter city']")
//    private WebElement city;
//    @FindBy(how = How.XPATH, using = "//input[@placeholder='Enter state name']")
//    private WebElement state;
//    @FindBy(how = How.XPATH, using = "//input[@placeholder='Enter ZipCode']")
//    private WebElement zipCode;
//    @FindBy(how = How.XPATH, using = "(//div[@class='input-wrraper'])[7]")
//    private WebElement phoneNo; // Use a descriptive variable name
//    @FindBy(how = How.XPATH, using = "//input[@placeholder='##-#######']")
//    private WebElement tin;
//    @FindBy(how = How.XPATH, using = "//button[contains(., 'Next')]")
//    private WebElement nextButton;
//    @FindBy(how = How.XPATH, using = "//input[@placeholder='Enter first name']")
//    private WebElement firstName;
//    @FindBy(how = How.XPATH, using = "//input[@placeholder='Enter last name']")
//    private WebElement lastName;
//    @FindBy(how = How.XPATH, using = "//input[@placeholder='Enter Last Four']")
//    private WebElement lastFour;
//    @FindBy(how = How.XPATH, using = "//input[@placeholder='Enter username']")
//    private WebElement username;
//    @FindBy(how = How.XPATH, using = "//input[@placeholder='Enter password']")
//    private WebElement password;
//    @FindBy(how = How.XPATH, using = "//input[@placeholder='Enter confirm password']")
//    private WebElement confirmPassword;
//    @FindBy(how = How.XPATH, using = "//button[contains(., 'Review')]")
//    private WebElement reviewButton;
//    @FindBy(how = How.XPATH, using = "//button[contains(., 'Submit')]")
//    private WebElement submitButton;
//
//    public GroupSignUp(WebDriver driver) {
//        super(driver);
//    }
//
//    public void enterCompanyLegalName(String legalName) {
//        writeText(companyLegalName, legalName);
//    }
//
//    public void enterCompanyDBAName(String dbaName) {
//        writeText(companyDBAName, dbaName);
//    }
//
//    public void enterStreetAddress(String address) {
//        writeText(streetAddress, address);
//    }
//
//    public void enterCity(String cityName) {
//        writeText(city, cityName);
//    }
//
//    public void enterState(String stateName) {
//        writeText(state, stateName);
//    }
//
//    public void enterZipCode(String zip) {
//        writeText(zipCode, zip);
//    }
//
//    public void enterPhone(String phone) {
//        writeText(phoneNo, phone);
//    }
//
//    public void enterEINorTIN() {
//        writeText(tin, randomNumber(9));
//    }
//
//    public void clickNextButton() {
//        click(nextButton);
//    }
//
//    public void enterFirstName() {
//        writeText(firstName, "Testing" + randomString(2));
//    }
//
//    public void enterLastName() {
//        writeText(lastName, "Create" + randomString(2));
//    }
//
//    public void enterLastFour() {
//        writeText(lastFour, randomNumber(2));
//    }
//
//    public void enterUsername() {
//        writeText(username, usernameCreate);
//    }
//
//    public void enterPassword() {
//        writeText(password, usernameCreate + "2024!");
//    }
//
//    public void enterConfirmPassword() {
//        writeText(confirmPassword, usernameCreate + "2024!");
//    }
//
//    public void clickReviewButton() {
//        click(reviewButton);
//    }
//
//    public void clickSubmitButton() {
//        click(submitButton);
//    }
//}
//
//
////url - https://mailosaur.com/app/login
////email - //input[@id="email"]
////username - pvtester@previnci.net
//// Continue//Submit - //button[@type="submit"]
////pass - //input[@id="password"]
////password - The 2022 test account!
////Previnci dev - //div/a[@data-testid="imqudfxx-2"]
////refresh - //button[@data-testid="refresh-messages"]
////subject name - (//div[@data-testid="address-0"]/p)[1]
////               (//p[text()='Welcome to the BeniComp Portal'])[1]
////               (//p[@data-testid='summary'])[1]
//// Complete registration - //a[text()='COMPLETE REGISTRATION']
//
//
////input[@placeholder="Enter company legal name"] --- //previnci-input[@formcontrolname="companyLegalName"]/div/div
////input[@placeholder="Enter company DBA name"] ---  (//previnci-input[@formcontrolname="value"]/div/div)[1]
////input[@placeholder="Enter street address"] ----  //previnci-input[@formcontrolname="line1"]/div/div
////input[@placeholder="Enter city"] ---  //previnci-input[@formcontrolname="city"]/div/div
////input[@placeholder="Enter state name"] --
////input[@placeholder="Enter ZipCode"] -- //previnci-input[@formcontrolname="postalCode"]/div/div
////(//div[@class="input-wrraper"])[7] -- (//previnci-input[@formcontrolname="value"]/div/div)[2]
////input[@placeholder="##-#######"] --  //previnci-input[@formcontrolname="companyTIN"]/div/div
////button[contains(., 'Next')]
////input[@placeholder="Enter first name"]
////input[@placeholder="Enter last name"]
////input[@placeholder="Enter Last Four"]
////input[@placeholder="Enter username"]
////input[@placeholder="Enter password"]
////input[@placeholder="Enter confirm password"]
////button[contains(., 'Review')]
////button[contains(., 'Submit')]
//// afet loggedin - https://dev.previnci.app/login