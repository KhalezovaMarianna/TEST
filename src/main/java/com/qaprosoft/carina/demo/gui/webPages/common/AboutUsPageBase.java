package com.qaprosoft.carina.demo.gui.webPages.common;

import com.qaprosoft.carina.demo.gui.webPages.common.base.BaseDemoblazePage;
import org.openqa.selenium.WebDriver;

public abstract class AboutUsPageBase extends BaseDemoblazePage  {
    public AboutUsPageBase(WebDriver driver) {
        super(driver);
    }

    @Override
    public abstract boolean isOpened();
    public abstract HomePageBase clickCloseButton();
}
