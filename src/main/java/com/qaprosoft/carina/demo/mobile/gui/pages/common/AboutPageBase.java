package com.qaprosoft.carina.demo.mobile.gui.pages.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class AboutPageBase extends AbstractPage {
    public AboutPageBase(WebDriver driver) {
        super(driver);
    }
    public abstract boolean isAboutPageOpen();
    public abstract HomePageBase clickBackBtn();
}
