package com.qaprosoft.carina.demo.gui.webPages.common;

import com.qaprosoft.carina.demo.gui.webPages.base.BaseDemoblazePage;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

public abstract class PlaceOrderPageBase extends BaseDemoblazePage {
    public PlaceOrderPageBase(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    @Override
    public abstract boolean isOpened();
    public abstract void filledNameForm(String name);
    public abstract void filledCartForm(String number);
    public abstract void clickSendOrderWithEmptyForms();
    public abstract PopUpOrderPageBase clickSendOrderButton();
}
