package com.qaprosoft.carina.demo.gui.webPages.common;

import com.qaprosoft.carina.demo.gui.webPages.common.base.BaseDemoblazePage;
import org.openqa.selenium.WebDriver;

public abstract class HomePageBase extends BaseDemoblazePage  {
    public HomePageBase(WebDriver driver) {
        super(driver);
    }

    @Override
    public abstract boolean isOpened();
    public abstract void clickRightArrowWindow();
    public abstract void clickLeftArrowWindow();
    public abstract boolean isImageShow(int index);
    public abstract ProductPageBase productOpenedByIndex(int index);
    public abstract String getUserName();
}
