package com.qaprosoft.carina.demo.mobile.gui.pages.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class MorePageBase extends AbstractPage {
    public MorePageBase(WebDriver driver) {
        super(driver);
    }
    public abstract boolean isMorePageOpen();
    public abstract CartPageBase openCart();
    public abstract PopUpResetPageBase resetApp();
    public abstract AboutPageBase clickAboutBtn();
    public abstract HomePageBase clickCatalogBtn();
    public abstract LoginPageBase clickLoginBtn();
}
