package com.qaprosoft.carina.demo.gui.webPages.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.qaprosoft.carina.demo.gui.webPages.*;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class HeaderMenu extends AbstractUIObject {
    @FindBy(xpath = "//*[@id=\"navbarExample\"]/ul/li[2]/a")
    ExtendedWebElement contactBtn;

    @FindBy(xpath = "//*[@id=\"navbarExample\"]/ul/li[3]/a")
    ExtendedWebElement aboutUsBtn;

    @FindBy(xpath = "//*[@id=\"cartur\"]")
    ExtendedWebElement cartBtn;

    @FindBy(xpath = "//*[@id=\"login2\"]")
    ExtendedWebElement loginBtn;

    @FindBy(xpath = "//*[@id=\"signin2\"]")
    ExtendedWebElement signUpBtn;

    public HeaderMenu(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }


    public AboutUsPage goToAboutPage() {
        aboutUsBtn.click();
        return new AboutUsPage(getDriver());
    }

    public ContactPage goToContactPage() {
        contactBtn.click();
        return new ContactPage(getDriver());
    }
    public CartPage goToCartPage() {
        cartBtn.clickByJs();
        return new CartPage(getDriver());
    }

    public LogInPage goToLoginPage() {
        loginBtn.click();
        return new LogInPage(getDriver());
    }
    public SignUpPage goToSignUpPage() {
        signUpBtn.click();
        return new SignUpPage(getDriver());
    }
}
