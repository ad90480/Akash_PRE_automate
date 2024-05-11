package com.previnci.core;

import org.openqa.selenium.WebDriver;

public class PageManager  {

    private static ThreadLocal<PageManager> INSTANCE = ThreadLocal.withInitial(PageManager::new);
    private PageGenerator pageGenerator;

    private PageManager() {
      }

    public static PageManager getInstance() {
        return INSTANCE.get();
    }

    public static void cleanUp() {
        INSTANCE.remove();
    }

    public void closeDriver() {
        if (pageGenerator != null && pageGenerator.driver != null) {
            pageGenerator.driver.quit();
        }
    }

    public void initialisePageGenerator() {
        WebDriver driver = new DriverSupplier().initializeDriver();
        this.pageGenerator = new PageGenerator(driver);
    }

    public PageGenerator getPageGenerator() {
        if (pageGenerator == null) {
            throw new IllegalStateException("PageGenerator is not initialized. Call initialisePageGenerator() first.");
        }
        return this.pageGenerator;
    }
}
