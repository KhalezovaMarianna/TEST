package com.qaprosoft.carina.demo.mobile.gui.pages.android;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.utils.mobile.IMobileUtils;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.CartPageBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.LoginPageBase;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = CartPageBase.class)
public class CartPage extends CartPageBase implements IMobileUtils {

    @FindBy(id = "com.saucelabs.mydemoapp.android:id/shoppingBt")
    private ExtendedWebElement goShoppingBtn;

    @FindBy(id = "com.saucelabs.mydemoapp.android:id/productTV")
    private ExtendedWebElement myCartText;

    @FindBy(xpath = "//android.widget.TextView[@content-desc=\"Removes product from cart\"]")
    private ExtendedWebElement removeItemBtn;

    @FindBy(id = "com.saucelabs.mydemoapp.android:id/priceTV")
    private ExtendedWebElement productCost;

    @FindBy(id = "com.saucelabs.mydemoapp.android:id/itemsTV")
    private ExtendedWebElement totalCountOfProduct;

    @FindBy(id = "com.saucelabs.mydemoapp.android:id/cartTV")
    private ExtendedWebElement countOfProductImage;

    @FindBy(id = "com.saucelabs.mydemoapp.android:id/totalPriceTV")
    private ExtendedWebElement finalSum;

    @FindBy(id = "com.saucelabs.mydemoapp.android:id/noTV")
    private ExtendedWebElement countOfProduct;

    @FindBy(id = "com.saucelabs.mydemoapp.android:id/cartBt")
    private ExtendedWebElement proceedToCheckoutBtn;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public Double costOfProduct() {

        double sum = Double.parseDouble(StringUtils.substring((productCost.format().getAttribute("value")), 1));
        return sum;
    }

    //    @Override
//    public boolean oneProductInCart() {
//        return false;
//    }
    @Override
    public boolean isOpened() {
        return goShoppingBtn.isElementPresent() || myCartText.isElementPresent();
    }

    @Override
    public boolean isBasketEmpty() {
        return goShoppingBtn.isElementPresent();
    }

    @Override
    public CartPageBase clickGoShoppingBtn() {
        goShoppingBtn.click();
        return new CartPage(getDriver()) {
            @Override
            public boolean isOpened() {
                return false;
            }
        };
    }

    @Override
    public CartPageBase goToCart() {
        return initPage(getDriver(), CartPageBase.class);
    }

    @Override
    public Double endSumComparison() {
        double sum = Double.parseDouble(StringUtils.substring((finalSum.format("$39.96").getAttribute("value")), 1));
        return sum;
    }

    @Override
    public void removeItemFromCart() {
        clickGoShoppingBtn();
        return;
    }

    public boolean isCartEmpty() {
        goShoppingBtn.isElementPresent();
        return true;
    }

    @Override
    public boolean checkOneProductOnCart() {
        if (Integer.parseInt(((countOfProduct.format().getAttribute("value")))) == 1) {
            return true;
        } else
            return false;
    }

    @Override
    public LoginPageBase clickProcessedToCheckoutBtn() {
        proceedToCheckoutBtn.click();
        return initPage(getDriver(), LoginPageBase.class);
    }

    @Override
    public boolean checkTotalCountEqualCountImage() {
        String str = totalCountOfProduct.format().getText().replaceAll("\\d", "");
        if (countOfProductImage.format().getText().equals(str)) {
            return true;
        } else {
            return false;
        }

    }


}
