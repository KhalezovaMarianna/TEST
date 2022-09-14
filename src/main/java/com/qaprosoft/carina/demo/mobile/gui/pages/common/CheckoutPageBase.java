package com.qaprosoft.carina.demo.mobile.gui.pages.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.components.KeyboardBase;
import org.openqa.selenium.WebDriver;

public abstract class CheckoutPageBase extends AbstractPage {
    public CheckoutPageBase(WebDriver driver) {
        super(driver);
    }
    public abstract boolean isPageOpened();
    public abstract void clickPaymentBtn();
    public abstract boolean checkPaymentFailed();
public abstract void clickNameForm();
    public abstract KeyboardBase getKeyboard();
    public abstract void closeKeyboard();
    public abstract boolean fillZipForm(String zipCode);
}
