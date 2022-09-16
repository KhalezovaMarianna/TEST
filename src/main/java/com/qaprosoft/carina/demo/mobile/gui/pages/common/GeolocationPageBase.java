package com.qaprosoft.carina.demo.mobile.gui.pages.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class GeolocationPageBase extends AbstractPage {
    public GeolocationPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isPageOpened();

    public abstract MorePageBase clickBackBtn();

    public abstract void closePopUp();
}
