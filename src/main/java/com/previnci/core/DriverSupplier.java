package com.previnci.core;

import com.previnci.constants.DriverType;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.function.Supplier;

public class DriverSupplier {

    private static final Map<DriverType, Supplier<WebDriver>> driverMap = new HashMap<>();

    // ChromeDriver Supplier
    private static final Supplier<WebDriver> chromeDriverSupplier = () -> {
        ChromeOptions options = new ChromeOptions();
        WebDriverManager.chromedriver().setup();
        options.addArguments("--start-maximized");
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-save-password");
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        options.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.IGNORE);
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        options.setExperimentalOption("prefs", prefs);
        return new ChromeDriver(options);
    };

    // FirefoxDriver Supplier
    private static final Supplier<WebDriver> firefoxDriverSupplier = () -> {
        FirefoxOptions options = new FirefoxOptions();
        WebDriverManager.firefoxdriver().setup();
        options.addArguments("--start-maximized"); // Start Firefox maximized
        options.addArguments("--ignore-certificate-errors"); // Similar to Chrome's behavior
        options.addArguments("--disable-dev-shm-usage"); // Useful in containerized environments
        options.addArguments("--no-sandbox"); // Useful in containerized environments
        options.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.IGNORE);
        options.addPreference("signon.rememberSignons", false);
        options.addPreference("signon.autofillForms", false);
        return new FirefoxDriver(options);
    };

    // EdgeDriver Supplier
    private static final Supplier<WebDriver> edgeDriverSupplier = () -> {
        EdgeOptions options = new EdgeOptions();
        WebDriverManager.edgedriver().setup();
        options.addArguments("--start-maximized"); // Start Edge maximized
        options.addArguments("--ignore-certificate-errors"); // Ignore certificate errors
        options.addArguments("--disable-dev-shm-usage"); // Useful in containerized environments
        options.addArguments("--no-sandbox"); // Useful in containerized environments
        options.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.IGNORE);
        // Preferences
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        options.setExperimentalOption("prefs", prefs);
        return new EdgeDriver(options);
    };

    static {
        driverMap.put(DriverType.CHROME, chromeDriverSupplier);
        driverMap.put(DriverType.FIREFOX, firefoxDriverSupplier);
        driverMap.put(DriverType.EDGE, edgeDriverSupplier);
    }

    ResourceBundle rb = ResourceBundle.getBundle("config");
    private final String browser = rb.getString("browser");
    private final String appUrl = rb.getString("appURL");
    private WebDriver driver;

    public WebDriver initializeDriver() {
        invokeApplication();
        return driver;
    }

    public void invokeApplication() {
        DriverType driverType;
        switch (browser.toLowerCase()) {
            case "chrome":
                driverType = DriverType.CHROME;
                break;
            case "firefox":
                driverType = DriverType.FIREFOX;
                break;
            case "edge":
                driverType = DriverType.EDGE;
                break;
            default:
                throw new WebDriverException("Unsupported browser type: " + browser);
        }

        driver = driverMap.get(driverType).get();
        driver.get(appUrl);
    }
}
