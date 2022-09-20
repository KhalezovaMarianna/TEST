package com.qaprosoft.carina.demo.mobile.gui.pages.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class URLAboutPageBase extends AbstractPage {
    public URLAboutPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isCorrectUrlOpened();

    public abstract boolean IsPageOpen();
}
