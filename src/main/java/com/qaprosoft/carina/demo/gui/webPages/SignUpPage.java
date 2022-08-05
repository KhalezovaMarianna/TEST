package com.qaprosoft.carina.demo.gui.webPages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.gui.webPages.base.BaseDemoblazePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class SignUpPage extends BaseDemoblazePage {

    @FindBy(xpath = "//*[@id=\"signInModalLabel\"]")
    ExtendedWebElement signUpPage;

    @FindBy(xpath = "//*[@id=\"sign-username\"]")
    ExtendedWebElement usernameForm;

    @FindBy(xpath = "//*[@id=\"sign-password\"]")
    ExtendedWebElement passwordForm;

    @FindBy(xpath = "//*[@id=\"signInModal\"]/div/div/div[3]/button[2]")
    ExtendedWebElement signUpBtn;

    @FindBy(xpath = "//*[@id=\"signInModal\"]//div[1]/button")
    ExtendedWebElement closeBtn;

    public SignUpPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isOpened() {
        return signUpPage.isElementPresent();
    }

    public HomePage clickCloseButton() {
        closeBtn.click();
        return new HomePage(getDriver());
    }

    public void typeName(String email) {
        usernameForm.type(email);
    }

    public void typePassword(String password) {
        passwordForm.type(password);
    }

    public void clickSignUpBtn() {
        signUpBtn.click();
    }
}
