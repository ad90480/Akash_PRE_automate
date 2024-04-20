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
        WebDriverManager.chromedriver().clearDriverCache().setup();
       // WebDriverManager.chromedriver().setup();  // Automatically downloads the latest ChromeDriver version
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
}