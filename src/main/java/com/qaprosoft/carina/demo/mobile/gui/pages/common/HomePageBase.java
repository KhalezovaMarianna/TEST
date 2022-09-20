package com.qaprosoft.carina.demo.mobile.gui.pages.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class HomePageBase extends AbstractPage {
    public HomePageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isOpened();

    public abstract SortByPopUpPageBase clickSortBtn();

    public abstract String getFirstSortedProduct();

    public abstract MorePageBase clickMoreBtn();

    public abstract CartPageBase clickBasketBtn();

    public abstract ProductPageBase clickProductImg(String a);

    public abstract ProductPageBase clickProductByIndex(String a);

    public abstract ProductPageBase clickRandomProduct(String title);
    public abstract boolean isLinkedinLogoPresent();
    public abstract boolean isTwitterLogoPresent();
}
