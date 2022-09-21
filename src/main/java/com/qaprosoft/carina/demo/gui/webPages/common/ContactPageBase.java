package com.qaprosoft.carina.demo.gui.webPages.common;

import com.qaprosoft.carina.core.foundation.utils.factory.ICustomTypePageFactory;
import com.qaprosoft.carina.demo.gui.webPages.base.BaseDemoblazePage;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

public abstract class ContactPageBase extends BaseDemoblazePage implements ICustomTypePageFactory {
    public ContactPageBase(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    @Override
    public abstract boolean isOpened();
    public abstract HomePageBase closePage();
    public abstract void typeName(String name);
    public abstract void typeEmail(String email);
    public abstract void typeMessage(String message);
    public abstract HomePageBase clickSendMessageButton();

}
