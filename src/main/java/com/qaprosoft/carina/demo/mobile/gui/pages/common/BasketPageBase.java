package com.qaprosoft.carina.demo.mobile.gui.pages.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class BasketPageBase extends AbstractPage {
    public BasketPageBase(WebDriver driver) {
        super(driver);
    }
    public abstract Double costOfProduct();
    public abstract boolean isBasketPageOpened();
    public abstract boolean isBasketEmpty();
    public abstract boolean oneProductInCart();
    public abstract BasketPageBase clickGoShoppingBtn();
    public abstract BasketPageBase goToCart();
    public abstract Double endSumComparison();
    public abstract void removeItemFromCart();
    public abstract boolean isCartEmpty();
}
