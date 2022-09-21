package com.qaprosoft.carina.demo.gui.webPages.common.componentsBase;

import com.qaprosoft.carina.demo.gui.webPages.base.BaseDemoblazePage;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

public abstract class FooterBase extends BaseDemoblazePage  {
    public FooterBase(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public abstract boolean getTextLabel();

    public abstract String getTextGetInTouch();

    public abstract String getTextAboutUs();
}

