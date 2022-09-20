package com.qaprosoft.carina.demo.mobile.gui.pages.android;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.utils.mobile.IMobileUtils;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.CartPageBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.MorePageBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.ProductPageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ProductPageBase.class)
public class ProductPage extends ProductPageBase implements IMobileUtils {


    @FindBy(xpath = "//android.widget.ImageView[@content-desc=\"Increase item quantity\"]")
    private ExtendedWebElement plusBtn;


    @FindBy(xpath = "//android.widget.RelativeLayout[@content-desc=\"View cart\"]")
    private ExtendedWebElement basketBtn;

    @FindBy(xpath = "//android.widget.Button[@content-desc=\"Tap to add product to cart\"]")
    private ExtendedWebElement addToCartBtn;

    @FindBy(xpath = "//android.widget.Button[@content-desc=\"Closes review dialog\"]")
    private ExtendedWebElement popUpContinueBtn;

    @FindBy(xpath = "//android.widget.ImageView[@index=\"%s\" and contains(@resource-id,\"star\")]")
    private ExtendedWebElement starBtn;

    @FindBy(xpath = "//android.widget.ImageView[@content-desc=\"View menu\"]")
    private ExtendedWebElement menuBtn;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isOpened() {
        return plusBtn.isElementPresent();
    }


    public void addProduct() {
        plusBtn.click();
        addToCartBtn.click();
    }

    @Override
    public void deleteSeveralProducts(int title) {

    }

    @Override
    public CartPageBase goToCart() {
        basketBtn.click();
        return initPage(getDriver(), CartPageBase.class);
    }

    public void addSeveralProducts(int amount) {
        for (int i = 1; i < amount; i++) {
            plusBtn.click();
        }
    }

    @Override
    public boolean checkChosenColor(String color) {
        return false;
    }

    @Override
    public boolean checkImageDownloading() {
        return false;
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
        for (int i = 0; i <= 4 ; i++) {
            if (starBtn.format(String.valueOf(i)).isElementPresent()) {
                starBtn.click();
                popUpContinueBtn.clickIfPresent();
            }
            menuBtn.click();
            return;

        }

    }
}
