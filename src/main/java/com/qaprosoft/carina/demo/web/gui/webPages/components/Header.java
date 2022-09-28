package com.qaprosoft.carina.demo.web.gui.webPages.components;


import com.qaprosoft.carina.core.foundation.utils.factory.ICustomTypePageFactory;
import com.qaprosoft.carina.core.foundation.utils.mobile.IMobileUtils;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.qaprosoft.carina.demo.web.gui.webPages.pages.*;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class Header extends AbstractUIObject implements ICustomTypePageFactory, IMobileUtils {
    @FindBy(xpath = "//*[@id=\"navbarExample\"]/ul/li[2]/a")
    ExtendedWebElement contactBtn;

    @FindBy(xpath = "//*[@id=\"navbarExample\"]/ul/li[3]/a")
    ExtendedWebElement aboutUsBtn;

    @FindBy(xpath = "//*[@id=\"login2\"]")
    ExtendedWebElement loginBtn;

    @FindBy(xpath = "//*[@id=\"signin2\"]")
    ExtendedWebElement signUpBtn;

    @FindBy(xpath = "//*[@id=\"cartur\"]")
    ExtendedWebElement cartBtn;


    public Header(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }


    public CartPage openCart() {
        cartBtn.click();
        return new CartPage(getDriver());
    }


    public boolean headerIsPresented() {
        return signUpBtn.isElementPresent();
    }


    public AboutUsPage goToAboutPage() {
        aboutUsBtn.click();
        return new AboutUsPage(getDriver());
    }


    public ContactPage goToContactPage() {
        contactBtn.click();
        return new ContactPage(getDriver());
    }


    public LoginPage goToLoginPage() {
        loginBtn.click();
        return new LoginPage(getDriver());
    }


    public SignUpPage goToSignUpPage() {
        signUpBtn.click();
        return new SignUpPage(getDriver());
    }
}