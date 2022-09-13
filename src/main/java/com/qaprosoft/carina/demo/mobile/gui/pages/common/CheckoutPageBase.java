package com.qaprosoft.carina.demo.mobile.gui.pages.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class CheckoutPageBase extends AbstractPage {
    public CheckoutPageBase(WebDriver driver) {
        super(driver);
    }
    public abstract boolean isPageOpened();
    public abstract void clickPaymentBtn();
    public abstract boolean checkPaymentFailed();
}
