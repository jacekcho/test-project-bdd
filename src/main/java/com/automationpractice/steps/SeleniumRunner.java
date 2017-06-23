package com.automationpractice.steps;

import com.automationpractice.utils.DriverFactory;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class SeleniumRunner {

    @Before
    public void executeBeforeScenario() {
        createDriver();
    }

    @After
    public void executeAfterScenario() {
        closeDriver();
    }

    private void createDriver() {
        new DriverFactory().createDriver();
    }

    private void closeDriver() {
        if (DriverFactory.getDriver() != null) {
            DriverFactory.getDriver().quit();
        }
    }
}
