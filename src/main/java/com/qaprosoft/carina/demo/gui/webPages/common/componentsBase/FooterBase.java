package com.qaprosoft.carina.demo.gui.webPages.common.componentsBase;

import com.qaprosoft.carina.core.foundation.utils.factory.ICustomTypePageFactory;
import com.qaprosoft.carina.core.foundation.utils.mobile.IMobileUtils;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

public abstract class FooterBase extends AbstractUIObject implements ICustomTypePageFactory, IMobileUtils {
    public FooterBase(WebDriver driver,SearchContext searchContext) {
        super(driver,searchContext);
    }


    public abstract String getTextGetInTouch();

    public abstract boolean checkTitleIsPresented();

    public abstract String getTextAboutUs();
}

