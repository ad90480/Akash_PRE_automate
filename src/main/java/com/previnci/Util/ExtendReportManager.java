package com.previnci.Util;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.util.ResourceBundle;

public class ExtendReportManager {

    public static ExtentReports extent;
    public static ExtentTest test;

    public static void getExtent() {
        ResourceBundle rb = ResourceBundle.getBundle("config");
        if (extent == null) {
            ExtentSparkReporter sparkReporter = new ExtentSparkReporter("target/Extent-Spark-Report/SparkReport.html");
            sparkReporter.config().setTheme(Theme.DARK);
            sparkReporter.config().setReportName("Previnci Cucumber BDD Test Report");
            sparkReporter.config().setDocumentTitle("Test Report");
            sparkReporter.config().setTimeStampFormat("MM/dd/yyyy hh:mm:ss");

            extent = new ExtentReports();
            extent.attachReporter(sparkReporter);
            extent.setSystemInfo("Operating System", System.getProperty("os.name"));
            extent.setSystemInfo("Java Version", System.getProperty("java.version"));
            extent.setSystemInfo("Browser Name", rb.getString("browser"));
            extent.setSystemInfo("Application url", rb.getString("appURL"));
            extent.setSystemInfo("Username", rb.getString("adminusername"));
            extent.setSystemInfo("Password", rb.getString("adminpassword"));
        }
    }
}
