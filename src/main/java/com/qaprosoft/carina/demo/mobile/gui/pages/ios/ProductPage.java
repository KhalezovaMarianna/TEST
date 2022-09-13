package com.qaprosoft.carina.demo.mobile.gui.pages.ios;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.locator.ExtendedFindBy;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.CartPageBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.MorePageBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.ProductPageBase;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = ProductPageBase.class)
public class ProductPage extends ProductPageBase {


    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`label == \"AddPlus Icons\"`]")
    private ExtendedWebElement plusBtn;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`name == \"Cart-tab-item\"`]")
    private ExtendedWebElement basketBtn;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`label == \"Add To Cart\"`]")
    private ExtendedWebElement addToCartBtn;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`label == \"OK\"`]")
    private ExtendedWebElement popUpOkBtn;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`label == \"StarSelected Icons\"`][1]")
    private ExtendedWebElement firstStar;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`label == \"StarUnSelected Icons\"`][1]")
    private ExtendedWebElement starBtn;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`label == \"StarUnSelected Icons\"`]")
    private ExtendedWebElement finalStarBtn;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`name == \"ProductDetails-screen\"`]/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeButton")
    private ExtendedWebElement backBtn;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`name == \"More-tab-item\"`]")
    private ExtendedWebElement moreBtn;


    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeStaticText[`label CONTAINS \"1\"`]")
    private ExtendedWebElement amountProducts;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`label == \"SubtractMinus Icons\"`]")
    private ExtendedWebElement minusBtn;


    public ProductPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isProductPageOpen() {
        return addToCartBtn.isElementPresent();
    }


    public void addProduct() {
        plusBtn.click();
        addToCartBtn.click();
    }

    @Override
    public CartPageBase goToCart() {
        basketBtn.click();
        return initPage(getDriver(), CartPageBase.class);
    }

    public void deleteSeveralProducts(int count) {
        for (int i = 1; i < count; i++) {

            minusBtn.click();

        }
    }

    public void addSeveralProducts(int count) {
        for (int i = 1; i < count; i++) {

            plusBtn.click();

        }
    }


    public void addToCart() {

        addToCartBtn.click();
    }


    @Override
    public MorePageBase openMorePage() {
        moreBtn.click();
        return initPage(getDriver(), MorePageBase.class);
    }

    @Override
    public boolean rateProduct() {
        firstStar.click();
        popUpOkBtn.clickIfPresent();
        for (int i = 1; i <= 4; i++) {
            if (starBtn.isElementPresent()) {
                starBtn.click();
                popUpOkBtn.clickIfPresent();
            } else {
                finalStarBtn.click();
                popUpOkBtn.clickIfPresent();
                break;
            }

        }
        backBtn.click();
        return true;

    }


}
