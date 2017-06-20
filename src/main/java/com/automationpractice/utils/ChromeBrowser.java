package com.automationpractice.utils;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeBrowser {

    public ChromeDriver create() {
        ChromeDriverManager.getInstance().setup();
        return new ChromeDriver();
    }
}