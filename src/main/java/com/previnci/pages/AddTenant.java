package com.previnci.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AddTenant extends BasePage{

    @FindBy(how = How.XPATH,using = "(//span[.='Tenants'])[1]")
    private WebElement tenantmodule;
    @FindBy(how = How.XPATH,using = "//previnci-buttons[@ng-reflect-label=\"Add Tenant\"]")
    private WebElement addtenantbutton;
    @FindBy(how = How.XPATH,using = "(//div//previnci-input//input)[1]")
    private WebElement orgname;
    @FindBy(how = How.XPATH,using = "(//div//previnci-input//input)[2]")
    private WebElement street;
    @FindBy(how = How.XPATH,using = "(//div//previnci-input//input)[3]")
    private WebElement city;
    @FindBy(how = How.XPATH,using = "(//div//previnci-input//input)[4]")
    private WebElement postalcode;
    @FindBy(how = How.XPATH,using = "(//previnci-select)[1]")
    private WebElement openstatedd;
    @FindBy(how = How.XPATH,using = "//a[.='Nevada']")
    private WebElement selectstate;
    @FindBy(how = How.XPATH,using = "(//previnci-select)[2]")
    private WebElement openorgtypedd;
    @FindBy(how = How.XPATH,using = "//a[.='TPA']")
    private WebElement selectorgtype;
    @FindBy(how = How.XPATH,using = "(//div//previnci-input//input)[8]")
    private WebElement phone;
    @FindBy(how = How.XPATH,using = "(//div//previnci-input//input)[9]")
    private WebElement taxid;
    @FindBy(how = How.XPATH,using = "(//div//previnci-input//input)[10]")
    private WebElement SICcode;

   /* @FindBy(how = How.XPATH,using = "//previnci-buttons[@ng-reflect-label=\"Submit\"]")
    private WebElement clicksubmitbutton;*/
    @FindBy(how = How.XPATH,using = "")
    private WebElement verifytoastmessage;

    public AddTenant(WebDriver driver) {
        super(driver);
    }
    public void tenantModule(){
        super.click(this.tenantmodule);
    }
    public void addTenantbutton(){
        super.click(this.addtenantbutton);
    }
    public void fillOrgname(String ON){
        super.writeText(this.orgname,ON);
    }
    public void fillStreet(String FS){
        super.writeText(this.street,FS);

    }
    public void fillCity(String FC){
        super.writeText(this.city,FC);

    }
    public void fillPostalcode(String FP){
        super.writeText(this.postalcode,FP);

    }
    public void selectState(){
        super.click(this.openstatedd);
        super.click(this.selectstate);

    }
    public void selectOrgtype(){
        super.click(this.openorgtypedd);
        super.click(this.selectorgtype);

    }
    public void fillPhone(String FP){
        super.writeText(this.phone,FP);

    }
    public void fillTaxid(String FT){
        super.writeText(this.taxid,FT);

    }
    public void fillSICcode(String FSIC){
        super.writeText(this.SICcode,FSIC);

    }
   /* public void clickSubmit(){
        super.click(this.clicksubmitbutton);

    }*/
    public void verifyToastmessage(){

    }
}