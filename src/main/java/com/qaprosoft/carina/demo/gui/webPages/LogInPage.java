package com.qaprosoft.carina.demo.gui.webPages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class LogInPage extends BaseDemoblazePage {
    @FindBy(xpath = "//*[@id=\"logInModalLabel\"]")
    ExtendedWebElement loginPage;
    @FindBy(xpath = "//*[@id=\"logInModal\"]/div/div/div[1]/button")
    ExtendedWebElement closeBtn;

    @FindBy(xpath = "//*[@id=\"loginusername\"]")
    ExtendedWebElement usernameForm;

    @FindBy(xpath = "//*[@id=\"loginpassword\"]")
    ExtendedWebElement passwordForm;

    @FindBy(xpath = "//*[@id=\"logInModal\"]//button[2]")
    ExtendedWebElement loginBtn;

    public LogInPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isOpened() {

        return loginPage.isElementPresent();
    }

    public HomePage closeLoginPage() {
        closeBtn.click();
        return new HomePage(getDriver());
    }

    public void typeUsername(String email) {
        usernameForm.type(email);
    }

    public void typePassword(String password) {
        passwordForm.type(password);
    }

    public HomePage login() {
        String email = "1234@mail.ru";
        String password = "12345";
        typeUsername(email);
        typePassword(password);
        loginBtn.click();
        return new HomePage(getDriver());
    }
}
