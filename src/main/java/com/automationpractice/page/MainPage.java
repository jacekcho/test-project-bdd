package com.automationpractice.page;

import com.automationpractice.utils.ChromeBrowser;
import com.automationpractice.utils.PropertiesManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

    @FindBy(id = "account")
    private WebElement account;

    public MainPage() {
        PageFactory.initElements(ChromeBrowser.getDriver(), this);
    }

    public MainPage goToMainPage() {
        ChromeBrowser.getDriver().get(PropertiesManager.getInstance().getDemoqaUrl());
        return this;
    }

    public LoginPage navigateToLoginPage() {
        account.click();
        return new LoginPage();
    }
}
