package com.qaprosoft.carina.demo.gui.webPages.common;

import com.qaprosoft.carina.demo.gui.webPages.common.base.BaseDemoblazePage;
import org.openqa.selenium.WebDriver;

public abstract class ProductPageBase extends BaseDemoblazePage  {
    public ProductPageBase(WebDriver driver) {
        super(driver);
    }

    @Override
    public abstract boolean isOpened();
    public abstract ProductPageBase clickAddToCartButton();
}
