package com.qaprosoft.carina.demo.mobile.gui.pages.android;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.utils.mobile.IMobileUtils;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.BasketPageBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.MorePageBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.ProductPageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ProductPageBase.class)
public class ProductPage extends ProductPageBase implements IMobileUtils {


    @FindBy(xpath = "//android.widget.ImageView[@content-desc=\"Increase item quantity\"]")
    ExtendedWebElement plusBtn;

    @FindBy(xpath = "//android.widget.RelativeLayout[@content-desc=\"View cart\"]")
    ExtendedWebElement basketBtn;

    @FindBy(xpath = "//android.widget.Button[@content-desc=\"Tap to add product to cart\"]")
    ExtendedWebElement addToCartBtn;

    @FindBy(xpath = "//android.widget.Button[@content-desc=\"Closes review dialog\"]")
    ExtendedWebElement popUpContinueBtn;

    @FindBy(xpath = "//android.widget.ImageView[@index=\"%s\" and contains(@resource-id,\"star\")]")
    ExtendedWebElement starBtn;
    @FindBy(xpath = "//android.widget.ImageView[@content-desc=\"View menu\"]")
    ExtendedWebElement menuBtn;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isProductPageOpen() {
        return plusBtn.isElementPresent();
    }


    public void addProduct() {
        plusBtn.click();
        addToCartBtn.click();
        return ;
    }

    @Override
    public void deleteSeveralProducts(int title) {

    }

    @Override
    public BasketPageBase goToCart() {
        basketBtn.click();
        return initPage(getDriver(), BasketPageBase.class);
    }

    public void addSeveralProducts(int amount) {
        for (int i = 1; i < amount; i++) {
            plusBtn.click();
        }
    }
    @Override
    public void addToCart() {
        addToCartBtn.click();
    }

    @Override
    public MorePageBase openMorePage() {
        menuBtn.click();
        return initPage(getDriver(),MorePageBase.class);
    }

    @Override
    public boolean rateProduct() {

        return false;
    }

    public void rateProduct(String str) {
        for (int i = 0; i <= 4; i++) {
            if (starBtn.format(String.valueOf(i)).isElementPresent()) {
                starBtn.click();
                popUpContinueBtn.clickIfPresent();
            }
            menuBtn.click();
            return;

        }

    }
}
