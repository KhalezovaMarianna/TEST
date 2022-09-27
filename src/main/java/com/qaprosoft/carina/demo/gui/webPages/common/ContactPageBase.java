package com.qaprosoft.carina.demo.gui.webPages.common;

import com.qaprosoft.carina.demo.gui.webPages.common.base.BaseDemoblazePage;
import org.openqa.selenium.WebDriver;

public abstract class ContactPageBase extends BaseDemoblazePage  {
    public ContactPageBase(WebDriver driver) {
        super(driver);
    }

    @Override
    public abstract boolean isOpened();
    public abstract HomePageBase closePage();
    public abstract void typeName(String name);
    public abstract void typeEmail(String email);
    public abstract void typeMessage(String message);
    public abstract HomePageBase clickSendMessageButton();

}
