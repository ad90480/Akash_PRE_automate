package com.previnci.runners;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "com.previnci.stepdefinitions",
        plugin = {
                "pretty",
                "json:target/cucumber-reports/cucumber-report.json",
                "html:target/cucumber-reports/cucumber-report.html"
        },
        dryRun = false,
        monochrome = true,
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        tags = "@test6",
        stepNotifications = true
)
public class TestRunner {
}
