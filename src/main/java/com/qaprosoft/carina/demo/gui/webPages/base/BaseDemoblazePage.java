package com.qaprosoft.carina.demo.gui.webPages.base;

import com.qaprosoft.carina.core.foundation.utils.factory.ICustomTypePageFactory;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.qaprosoft.carina.demo.gui.webPages.common.componentsBase.FooterBase;
import com.qaprosoft.carina.demo.gui.webPages.common.componentsBase.HeaderBase;
import com.qaprosoft.carina.demo.gui.webPages.desktop.components.Footer;
import com.qaprosoft.carina.demo.gui.webPages.desktop.components.Header;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public abstract class BaseDemoblazePage extends AbstractUIObject implements ICustomTypePageFactory {
    @FindBy(xpath = "//*[@id=\"navbarExample\"]/ul")
    private Header header;
    @FindBy(xpath = "//*[@id=\"footc\"]")
    private Footer footer;

    public BaseDemoblazePage(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }
//    public Footer getFooter() {
//        return footer;
//    }
//
//        public Header getHeader() {
//        return header;
//    }
    public abstract HeaderBase getHeaderBase();

    public abstract FooterBase getFooterBase();

    public abstract boolean isOpened();
}
