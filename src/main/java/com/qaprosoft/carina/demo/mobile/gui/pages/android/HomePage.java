package com.qaprosoft.carina.demo.mobile.gui.pages.android;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.utils.mobile.IMobileUtils;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.locator.ExtendedFindBy;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.MyPhotoPageBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.BasketPageBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.HomePageBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.MorePageBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.ProductPageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = HomePageBase.class)
public class HomePage extends HomePageBase implements IMobileUtils {

    @FindBy(id = "com.saucelabs.mydemoapp.android:id/productTV")
    ExtendedWebElement catalog;
    @ExtendedFindBy(accessibilityId = "Displays number of items in your cart")
    ExtendedWebElement basketBtn;

    @FindBy(id = "com.saucelabs.mydemoapp.android:id/menuIV")
    ExtendedWebElement moreBtn;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isHomePageOpen() {
        return catalog.isElementPresent();
    }

    @Override
    public MorePageBase clickMoreBtn() {
        moreBtn.click();
        return initPage(getDriver(),MorePageBase.class);
    }

    @Override
    public BasketPageBase clickBasketBtn() {
        basketBtn.click();
        return new BasketPage(getDriver());
    }

    @Override
    public ProductPageBase clickProductImg(String a) {
        return null;
    }

    @Override
    public ProductPageBase clickProductByIndex(String a) {
        return null;
    }

    @Override
    public ProductPageBase clickRandomProduct(String title) {

        return initPage(getDriver(), ProductPageBase.class);
    }

}
