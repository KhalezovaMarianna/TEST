package com.qaprosoft.carina.demo.gui.webPages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.Iterator;
import java.util.Set;

public class SignUpPage extends AbstractPage {
    @FindBy (xpath = "//*[@id=\"signInModalLabel\"]")
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

    public boolean isSignUpPageOpen() {
        signUpPage.isElementPresent();
        return true;
    }
    public HomePage closeSignUpPage(){
        closeBtn.click();
        return new HomePage(getDriver());
    }
    public void typeName(String email) {
        usernameForm.type(email);
    }
    public void typePassword(String password) {
        passwordForm.type(password);
    }

    public void signUp(){
        String email = "test@mail.ru";
        String password = RandomStringUtils.randomAlphabetic(10);
        typeName(email);
        typePassword(password);
        signUpBtn.click();
    }
}
