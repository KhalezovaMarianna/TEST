package com.qaprosoft.carina.demo.gui.webPages.common;

import com.qaprosoft.carina.core.foundation.utils.factory.ICustomTypePageFactory;
import com.qaprosoft.carina.demo.gui.webPages.base.BaseDemoblazePage;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

public abstract class SignUpPageBase extends BaseDemoblazePage implements ICustomTypePageFactory {
    public SignUpPageBase(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    @Override
    public abstract boolean isOpened();

    public abstract HomePageBase clickCloseButton();

    public abstract void typeName(String email);

    public abstract void typePassword(String password);

    public abstract void clickSignUpBtn();
}
