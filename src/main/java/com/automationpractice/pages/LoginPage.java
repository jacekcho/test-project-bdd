package com.automationpractice.pages;

import com.automationpractice.utils.DriverFactory;
import com.automationpractice.utils.PropertiesManager;
import com.automationpractice.utils.TestHelper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertThat;

public class LoginPage {

    @FindBy(id = "wpadminbar")
    private WebElement adminBar;

    @FindBy(id = "log")
    private WebElement loginInput;

    @FindBy(id = "pwd")
    private WebElement passwordInput;

    @FindBy(id = "login")
    private WebElement logInSubmit;

    @FindBy(className = "myaccount")
    private WebElement myAccountInput;

    @FindBy(id = "account_logout")
    private WebElement logoutButton;

    @FindBy(className = "response")
    private WebElement invalidCredentialMessage;

    private final String LOGOUT_CONFIRMATION = "Please use the form below to login to your account";

    private final String INVALID_CREDENTIAL = "ERROR: Invalid login credentials";

    public LoginPage() {
        PageFactory.initElements(DriverFactory.getDriver(), this);
    }

    public LoginPage checkLoggedUserName(String userLogin) {
        assertThat(adminBar.getText(), containsString(userLogin));
        return this;
    }

    public LoginPage enterLogin(String login) {
        loginInput.sendKeys(login);
        return this;
    }

    public LoginPage enterPassword(String password) {
        passwordInput.sendKeys(password);
        return this;
    }

    public LoginPage submitLogIn() {
        logInSubmit.click();
        return this;
    }

    public LoginPage logInDefaultUser() {
        PropertiesManager properties = PropertiesManager.getInstance();
        enterLogin(properties.getLogin());
        enterPassword(properties.getPassword());
        submitLogIn();
        return this;
    }

    public LoginPage logOutUser() {
        logoutButton.click();
        return this;
    }

    public LoginPage getLogoutConfirmation() {
        TestHelper.waitForAjax();
        assertThat(myAccountInput.getText(), containsString(LOGOUT_CONFIRMATION));
        return this;
    }

    public LoginPage getInvalidCredentatialConfirmation() {
        TestHelper.waitForAjax();
        assertThat(invalidCredentialMessage.getText(), containsString(INVALID_CREDENTIAL));
        return this;
    }
}