package com.qaprosoft.carina.demo.mobile.gui.pages.android;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.utils.mobile.IMobileUtils;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.BasketPageBase;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = BasketPageBase.class)
public class BasketPage extends BasketPageBase implements IMobileUtils {

    @FindBy(id ="com.saucelabs.mydemoapp.android:id/shoppingBt")
    ExtendedWebElement goShoppingBtn;

    @FindBy(xpath= "//android.widget.TextView[@content-desc=\"Removes product from cart\"]")
    ExtendedWebElement removeItemBtn;
    @FindBy(id = "com.saucelabs.mydemoapp.android:id/priceTV")
    ExtendedWebElement productCost;

    @FindBy(id = "com.saucelabs.mydemoapp.android:id/totalPriceTV")
    ExtendedWebElement finalSum;

    public BasketPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public Double costOfProduct() {

        double sum = Double.parseDouble(StringUtils.substring((productCost.format().getAttribute("value")), 1));
        return sum;
    }
    @Override
    public boolean oneProductInCart() {
        return false;
    }
    @Override
    public boolean isBasketPageOpened() {
        return goShoppingBtn.isElementPresent();
    }

    @Override
    public boolean isBasketEmpty() {
        return goShoppingBtn.isElementPresent();
    }

    @Override
    public BasketPageBase clickGoShoppingBtn() {
       goShoppingBtn.click();
        return new BasketPage(getDriver()) {
            @Override
            public boolean isBasketPageOpened() {
                return false;
            }
        };
   }

    @Override
    public BasketPageBase goToCart() {
        return initPage(getDriver(),BasketPageBase.class);
    }

    @Override
    public Double endSumComparison() {
        double sum = Double.parseDouble(StringUtils.substring((finalSum.format("$39.96").getAttribute("value")), 1));
       return sum;
    }

    @Override
    public void removeItemFromCart() {
        clickGoShoppingBtn();
        return ;
    }
    public boolean isCartEmpty(){
        goShoppingBtn.isElementPresent();
        return true;
    }
}
