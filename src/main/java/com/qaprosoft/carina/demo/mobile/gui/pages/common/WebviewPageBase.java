package com.qaprosoft.carina.demo.mobile.gui.pages.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class WebviewPageBase extends AbstractPage {
    public WebviewPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isWebviewPageOpen();

    public abstract boolean checkIsCorrectURL();
}
