package com.qaprosoft.carina.demo.gui.webPages.common.base;

import com.qaprosoft.carina.core.foundation.utils.factory.ICustomTypePageFactory;
import com.qaprosoft.carina.core.foundation.utils.mobile.IMobileUtils;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.qaprosoft.carina.demo.gui.webPages.common.componentsBase.FooterBase;
import com.qaprosoft.carina.demo.gui.webPages.common.componentsBase.HeaderBase;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public abstract class BaseDemoblazePage extends AbstractPage implements IMobileUtils {
    public BaseDemoblazePage(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isOpened();
    public abstract HeaderBase getHeader();
    public abstract FooterBase getFooter();
}
