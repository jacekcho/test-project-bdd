package com.automationpractice.utils;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

public class DriverFactory {

    private static ChromeDriver driver;

    private static final int IMPLICITLY_WAIT = 15;

    public void createDriver() {
        ChromeDriverManager.getInstance().setup();
        driver = new ChromeDriver();
        driverSettings(driver);
    }

    public static ChromeDriver getDriver() {
        return driver;
    }

    private void driverSettings(ChromeDriver driver) {
        driver.manage().window().maximize();
        driver.setLogLevel(Level.INFO);
        driver.manage().timeouts().implicitlyWait(IMPLICITLY_WAIT, TimeUnit.SECONDS);
    }

}