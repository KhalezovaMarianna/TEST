package com.qaprosoft.carina.demo.mobile.gui.pages.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class LoginPageBase extends AbstractPage {
    public LoginPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isOpened();

    public abstract HomePageBase clickLoginBtn();

    public abstract HomePageBase clickAutoBtn();

    public abstract void typeUsernameForm(String email);

    public abstract boolean isFailedTextIsPresent();

    public abstract void typePassword(String password);

    public abstract void clickUser();

    public abstract CheckoutPageBase clickLoginBtnForCheckout();
}
