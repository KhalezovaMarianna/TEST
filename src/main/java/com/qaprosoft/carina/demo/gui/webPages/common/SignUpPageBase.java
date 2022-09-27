package com.qaprosoft.carina.demo.gui.webPages.common;

import com.qaprosoft.carina.demo.gui.webPages.common.base.BaseDemoblazePage;
import org.openqa.selenium.WebDriver;

public abstract class SignUpPageBase extends BaseDemoblazePage  {
    public SignUpPageBase(WebDriver driver) {
        super(driver);
    }

    @Override
    public abstract boolean isOpened();

    public abstract HomePageBase clickCloseButton();

    public abstract void typeName(String email);

    public abstract void typePassword(String password);

    public abstract void clickSignUpBtn();
}
