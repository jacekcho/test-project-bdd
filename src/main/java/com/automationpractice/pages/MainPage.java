package com.automationpractice.pages;

import com.automationpractice.utils.DriverFactory;
import com.automationpractice.utils.PropertiesManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

    @FindBy(id = "account")
    private WebElement account;

    public MainPage() {
        PageFactory.initElements(DriverFactory.getDriver(), this);
    }

    public MainPage goToMainPage() {
        DriverFactory.getDriver().get(PropertiesManager.getInstance().getDemoqaUrl());
        return this;
    }

    public LoginPage navigateToLoginPage() {
        account.click();
        return new LoginPage();
    }
}
