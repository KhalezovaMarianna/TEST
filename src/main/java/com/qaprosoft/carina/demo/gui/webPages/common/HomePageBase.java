package com.qaprosoft.carina.demo.gui.webPages.common;

import com.qaprosoft.carina.core.foundation.utils.factory.ICustomTypePageFactory;
import com.qaprosoft.carina.demo.gui.webPages.base.BaseDemoblazePage;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

public abstract class HomePageBase extends BaseDemoblazePage implements ICustomTypePageFactory {
    public HomePageBase(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    @Override
    public abstract boolean isOpened();
    public abstract void clickRightArrowWindow();
    public abstract void clickLeftArrowWindow();
    public abstract boolean isImageShow(int index);
    public abstract ProductPageBase productOpenedByIndex(int index);
    public abstract String getUserName();
}
