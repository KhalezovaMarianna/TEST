package com.qaprosoft.carina.demo.mobile.gui.pages.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class WebviewPageBase extends AbstractPage {
    public WebviewPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isOpened();

    public abstract boolean checkIsCorrectURL(String url);

    public abstract MorePageBase clickBackBtn();

    public abstract String checkEqualURL();
}
