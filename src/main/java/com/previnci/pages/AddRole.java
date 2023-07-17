package com.previnci.pages;

import net.bytebuddy.implementation.bind.annotation.Super;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AddRole extends BasePage {
    @FindBy(how = How.XPATH,using ="(//span[.='Roles'])[1]")
    private  WebElement clickrolemodule;
    @FindBy(how = How.XPATH,using ="//previnci-buttons[@label=\"Add Role\"]']")
    private  WebElement clickaddrolebutton;
    @FindBy(how = How.XPATH, using = "(//div/previnci-input//input[@type='text'])[1]")
    private WebElement rolename;
    @FindBy(how = How.XPATH, using = "(//div/previnci-input//input[@type='text'])[2]")
    private WebElement roledescription;

    public AddRole(WebDriver driver) {
        super(driver);
    }
    public void openrolemodule(){
        super.click(this.clickrolemodule);
    }
    public void addrolebutton(){
        super.click(this.clickaddrolebutton);
    }

    public void roleName(String rn) {
        super.writeText(this.rolename,rn);
    }

    public void roleDescription(String rd) {
        super.writeText(this.roledescription,rd);

    }
}
