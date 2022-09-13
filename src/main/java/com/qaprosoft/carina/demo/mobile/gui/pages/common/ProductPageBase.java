package com.qaprosoft.carina.demo.mobile.gui.pages.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class ProductPageBase extends AbstractPage {

    public ProductPageBase(WebDriver driver) {
        super(driver);
    }
    public abstract boolean isProductPageOpen();
    public abstract void addProduct();
    public abstract void deleteSeveralProducts(int title);

    public abstract CartPageBase goToCart();

    public abstract boolean rateProduct();

    public abstract void addToCart();
    public abstract MorePageBase openMorePage();

    public abstract void addSeveralProducts(int i);
}
