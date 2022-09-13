package com.qaprosoft.carina.demo.mobile.gui.pages.ios;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.utils.mobile.IMobileUtils;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.locator.ExtendedFindBy;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.CartPageBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.LoginPageBase;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = CartPageBase.class)
public class CartPage extends CartPageBase implements IMobileUtils {

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeStaticText[`label CONTAINS \"$ \"`]")
    private ExtendedWebElement productCost;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`label == \"Remove Item\"`]")
    private ExtendedWebElement removeItemBtn;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`label == \"Go Shopping\"`]")
    private ExtendedWebElement goShoppingBtn;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeStaticText[`label CONTAINS \"$\"`]")
    private ExtendedWebElement finalSum;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeStaticText[`label == \"1\"`][1]")
    private ExtendedWebElement oneElement;

    @FindBy(id = "**/XCUIElementTypeStaticText[`label == \"My Cart\"`]")
    private ExtendedWebElement myCartText;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`label == \"Proceed To Checkout\"`]")
    private ExtendedWebElement proceedToCheckoutBtn;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isCartPageOpened() {
        return goShoppingBtn.isElementPresent() || myCartText.isElementPresent();
    }

//    @Override
//    public boolean oneProductInCart() {
//        return oneElement.isElementPresent();
//    }

    @Override
    public boolean isBasketEmpty() {
        return goShoppingBtn.isElementPresent();
    }

    @Override
    public Double costOfProduct() {
        double sum = Double.parseDouble(StringUtils.substring((productCost.format().getAttribute("value")), 1));
        return sum;
    }

    @Override
    public Double endSumComparison() {
        double reallyFinalSum = Double.parseDouble(StringUtils.substring((finalSum.format().getAttribute("value")), 1));
        return reallyFinalSum;
    }

    public void removeItemFromCart() {
        removeItemBtn.click();
        return;
    }

    public CartPageBase clickGoShoppingBtn() {
        goShoppingBtn.click();
        return initPage(getDriver(), CartPageBase.class);
    }

    @Override
    public CartPageBase goToCart() {
        return null;
    }

    @Override
    public boolean isCartEmpty() {
        goShoppingBtn.isElementPresent();
        return true;
    }

    @Override
    public boolean checkOneProductOnCart() {
        if (Integer.parseInt((oneElement.getAttribute("name"))) == 1) {
            return true;
        } else {
            return false;
        }
    }

        @Override
        public LoginPageBase clickProcessedToCheckoutBtn () {
        proceedToCheckoutBtn.click();
            return initPage(getDriver(),LoginPageBase.class);
        }
    }

