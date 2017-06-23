package com.automationpractice;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@CucumberOptions(
        monochrome = true,
        plugin = {"pretty", "html:target/cucumber-reports"},
        features = "src/test/resources/features/",
        glue = "com.automationpractice.steps"
)
@RunWith(Cucumber.class)
public class TestRunner {
}
