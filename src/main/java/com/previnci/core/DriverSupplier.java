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

public class DriverSupplier {

    private static final Map<DriverType, Supplier<WebDriver>> driverMap = new HashMap<>();
    private static final Supplier<WebDriver> chromeDriverSupplier = () -> {
        ChromeOptions options = new ChromeOptions();
        WebDriverManager.chromedriver().clearDriverCache().setup();
        options.addArguments("--start-maximized");
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-save-password");
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        options.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.IGNORE);
        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        options.setExperimentalOption("prefs", prefs);
        return new ChromeDriver(options);
    };

    static {
        driverMap.put(DriverType.CHROME, chromeDriverSupplier);
    }

    private final String browser = System.getProperty("browser");
    ResourceBundle rb = ResourceBundle.getBundle("config");
    private final String appUrl = rb.getString("appURL");
    private WebDriver driver;

    public WebDriver initializeDriver() {
        invokeApplication();
        return driver;
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