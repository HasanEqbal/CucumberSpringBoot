package com.cucumberspringboot.preference;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/",
        glue = {"com.cucumberspringboot.preference.stepDefinitions",
                "com.cucumberspringboot.preference.configuration"},
        dryRun = false,
        plugin = {"pretty", "html:target/cucumber-html-report.html",
                "json:target/cucumber.json",
                "rerun:target/cucumber-api-rerun.txt"
        })
public class CucumberIntegrationTest {
}

