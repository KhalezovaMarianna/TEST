package com.qaprosoft.carina.demo.gui.webPages.common;

import com.qaprosoft.carina.demo.gui.webPages.common.base.BaseDemoblazePage;
import org.openqa.selenium.WebDriver;

public abstract class LoginPageBase extends BaseDemoblazePage  {
    public LoginPageBase(WebDriver driver) {
        super(driver);
    }

    @Override
    public abstract boolean isOpened();
    public abstract HomePageBase clickCloseButton();
    public abstract void typeUsername(String email);
    public abstract void typePassword(String password);
    public abstract HomePageBase clickLoginBtn();
}
