package com.automationpractice.bdd.page;

import com.automationpractice.bdd.selenium.BddSeleniumRunner;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

    @FindBy(id = "account")
    private WebElement account;

    public MainPage() {
        PageFactory.initElements(BddSeleniumRunner.driver, this);
    }

    public MainPage goToMainPage() {
        BddSeleniumRunner.driver.get("http://www.store.demoqa.com");
        return this;
    }

    public LoginPage navigateToLoginPage() {
        account.click();
        return new LoginPage();
    }
}
