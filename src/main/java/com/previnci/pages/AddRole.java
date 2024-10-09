package com.previnci.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AddRole extends UtilityMethods {
    @FindBy(how = How.XPATH,using ="(//span[.='Roles'])[1]")
    private  WebElement clickrolemodule;
    @FindBy(how = How.XPATH,using ="//previnci-buttons[@label=\"Add Role\"]")
    private  WebElement clickaddrolebutton;
    @FindBy(how = How.XPATH, using = "(//div/previnci-input//input[@type='text'])[1]")
    private WebElement rolename;
    @FindBy(how = How.XPATH, using = "(//div/previnci-input//input[@type='text'])[2]")
    private WebElement roledescription;
    @FindBy(how = How.XPATH, using = "//div[text()=\"Provider Search\"]")
    private WebElement menuordersourcefirst;
    @FindBy(how = How.XPATH, using = "(//div[@class=\"cdk-drop-list drg-drp-list\"])[1]")
    private WebElement menuordertargetfirst;
    @FindBy(how = How.XPATH, using = "(//div/previnci-input//input[@type='text'])[2]")
    private WebElement menuordersourcesecond;
    @FindBy(how = How.XPATH, using = "(//div/previnci-input//input[@type='text'])[2]")
    private WebElement menuordertargetsecond;
    @FindBy(how = How.XPATH, using = "(//div/previnci-input//input[@type='text'])[2]")
    private WebElement menuordersourcethird;
    @FindBy(how = How.XPATH, using = "(//div/previnci-input//input[@type='text'])[2]")
    private WebElement menuordertargetthird;




    public AddRole(WebDriver driver) {
        super(driver);
    }
    public void openrolemodule(){
        super.click(this.clickrolemodule);
    }
    public void addrolebutton(){
        super.click(this.clickaddrolebutton);
    }

    public void roleName() {
        super.writeText(this.rolename,randomString(4));
    }

    public void roleDescription() {
        super.writeText(this.roledescription,randomString(5));

    }
    public void roleDragFirst() {
       super.dragAndDrop(menuordersourcefirst,menuordertargetfirst);
        System.out.println(menuordersourcefirst);
        System.out.println(menuordersourcesecond);
    }
}
