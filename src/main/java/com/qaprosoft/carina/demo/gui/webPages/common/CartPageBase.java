package com.qaprosoft.carina.demo.gui.webPages.common;

import com.qaprosoft.carina.core.foundation.utils.factory.ICustomTypePageFactory;
import com.qaprosoft.carina.demo.gui.webPages.base.BaseDemoblazePage;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

public abstract class CartPageBase extends BaseDemoblazePage implements ICustomTypePageFactory {
    public CartPageBase(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    @Override
    public abstract boolean isOpened();

    public abstract HomePageBase goToHome();
    public abstract String getCartTotal();
    public abstract String getProductPrice();
    public abstract void deleteAllProducts();
    public abstract void deleteProductByIndex(String index);
    public abstract boolean isCartEmpty();
    public abstract PlaceOrderPageBase clickPlaceOrderBtn();
}

