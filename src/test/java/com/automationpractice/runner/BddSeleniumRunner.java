package com.automationpractice.runner;

import com.automationpractice.utils.ChromeBrowser;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class BddSeleniumRunner {

    @Before
    public void executeBeforeScenario() {
        createDriver();
    }

    @After
    public void executeAfterScenario() {
        closeDriver();
    }

    private void createDriver() {
        new ChromeBrowser().createDriver();
    }

    private void closeDriver() {
        if (ChromeBrowser.getDriver() != null) {
            ChromeBrowser.getDriver().quit();
        }
    }
}
