//package com.previnci.Util;
//
//import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.ExtentTest;
//import com.aventstack.extentreports.reporter.ExtentSparkReporter;
//import com.aventstack.extentreports.reporter.configuration.Theme;
//
//import java.util.ResourceBundle;
//
//public class ExtendReportManager {
//
//    public static ExtentReports extent;
//    public static ExtentTest test;
//
//    public static void getExtent() {
//        ResourceBundle rb = ResourceBundle.getBundle("config");
//        if (extent == null) {
//            ExtentSparkReporter sparkReporter = new ExtentSparkReporter("target/Extent-Spark-Report/SparkReport.html");
//            sparkReporter.config().setTheme(Theme.DARK);
//            sparkReporter.config().setReportName("Previnci Cucumber BDD Test Report");
//            sparkReporter.config().setDocumentTitle("Test Report");
//            sparkReporter.config().setTimeStampFormat("MM/dd/yyyy hh:mm:ss");
//
//            extent = new ExtentReports();
//            extent.attachReporter(sparkReporter);
//            extent.setSystemInfo("Operating System", System.getProperty("os.name"));
//            extent.setSystemInfo("Java Version", System.getProperty("java.version"));
//            extent.setSystemInfo("Browser Name", rb.getString("browser"));
//            extent.setSystemInfo("Application url", rb.getString("appURL"));
//            extent.setSystemInfo("Username", rb.getString("adminusername"));
//            extent.setSystemInfo("Password", rb.getString("adminpassword"));
//        }
//    }
//}


package com.previnci.Util;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.util.ResourceBundle;

public class ExtendReportManager {

    private static ExtentReports extent;
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

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

    // New method to log messages
    public static void logInfo(String message) {
        if (test.get() != null) {
            test.get().info(message);
        }
    }

//    public static void logError(String message) {
//        if (test.get() != null) {
//            test.get().fail(message);
//        } else {
//            System.err.println("ExtentTest is not initialized for logging error: " + message);
//        }
//    }
public static ExtentTest logError(String message) {
    if (test.get() != null) {
        return test.get().fail(message);  // Return the ExtentTest instance after logging the error
    }
    return null;  // In case test.get() is null, return null
}


    public static void createTest(String testName) {
        ExtentTest extentTest = extent.createTest(testName);
        test.set(extentTest);
    }

    public static void flush() {
        if (extent != null) {
            extent.flush();
        }
    }
}

