package com.qaprosoft.carina.demo.gui.webPages.common;

import com.qaprosoft.carina.core.foundation.utils.factory.ICustomTypePageFactory;
import com.qaprosoft.carina.demo.gui.webPages.base.BaseDemoblazePage;
import com.qaprosoft.carina.demo.gui.webPages.desktop.components.ProductContainer;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

import java.util.List;

public abstract class ResultPageBase extends BaseDemoblazePage implements ICustomTypePageFactory {
    public ResultPageBase(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    @Override
    public abstract boolean isOpened();

    public abstract int getNumberOfProductFound();

    public abstract List<String> getResultProductTitles();

    public abstract List<ProductContainer> getResultProducts();
}
