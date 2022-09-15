package com.qaprosoft.carina.demo.mobile.gui.pages.android;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.utils.mobile.IMobileUtils;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.locator.ExtendedFindBy;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = HomePageBase.class)
public class HomePage extends HomePageBase implements IMobileUtils {

    @FindBy(id = "com.saucelabs.mydemoapp.android:id/productTV")
    private ExtendedWebElement catalog;

    @ExtendedFindBy(accessibilityId = "Displays number of items in your cart")
    private ExtendedWebElement basketBtn;

    @FindBy(xpath = "//android.widget.ImageView[@content-desc=\"Twitter\"]")
    private ExtendedWebElement twitterLabel;

    @FindBy(xpath = "//android.widget.ImageView[@content-desc=\"LinkedIn\"]")
    private ExtendedWebElement lnLabel;

    @FindBy(id = "com.saucelabs.mydemoapp.android:id/menuIV")
    private ExtendedWebElement moreBtn;

    @FindBy(xpath = "(//android.widget.TextView[@resource-id=\"com.saucelabs.mydemoapp.android:id/titleTV\"])[1]")
    private ExtendedWebElement firstSortedProduct;

    @ExtendedFindBy(accessibilityId = "Shows current sorting order and displays available sorting options")
    private ExtendedWebElement sortBtn;


    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean scrollHomePage() {
        twitterLabel.scrollTo();
        return twitterLabel.isElementPresent();
    }

    @Override
    public SortByPopUpPageBase clickSortBtn() {
        sortBtn.click();
        return initPage(getDriver(), SortByPopUpPageBase.class);
    }
    @Override
    public String getFirstSortedProduct() {
        return firstSortedProduct.getText();
    }
    @Override
    public boolean isHomePageOpen() {
        return catalog.isElementPresent();
    }

    @Override
    public MorePageBase clickMoreBtn() {
        moreBtn.click();
        return initPage(getDriver(), MorePageBase.class);
    }

    @Override
    public CartPageBase clickBasketBtn() {
        basketBtn.click();
        return new CartPage(getDriver());
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

    @Override
    public boolean lnLabelIsPresent() {
        return lnLabel.isElementPresent();
    }

}
