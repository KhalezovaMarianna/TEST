package com.qaprosoft.carina.demo.mobile.gui.pages.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class PopUpResetPageBase extends AbstractPage {
    public PopUpResetPageBase(WebDriver driver) {
        super(driver);
    }
    public abstract MorePageBase clickResetBtn();
    public abstract boolean isOpened();
}
