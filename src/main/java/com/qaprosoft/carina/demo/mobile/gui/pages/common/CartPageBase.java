package com.qaprosoft.carina.demo.mobile.gui.pages.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class CartPageBase extends AbstractPage {
    public CartPageBase(WebDriver driver) {
        super(driver);
    }
    public abstract Double costOfProduct();
    public abstract boolean isOpened();
    public abstract boolean isBasketEmpty();
//    public abstract boolean oneProductInCart();
    public abstract CartPageBase clickGoShoppingBtn();
    public abstract CartPageBase goToCart();
    public abstract Double endSumComparison();
    public abstract void removeItemFromCart();
    public abstract boolean isCartEmpty();
    public abstract boolean checkOneProductOnCart();
    public abstract LoginPageBase clickProcessedToCheckoutBtn();
    public abstract boolean checkTotalCountEqualCountImage();
}
