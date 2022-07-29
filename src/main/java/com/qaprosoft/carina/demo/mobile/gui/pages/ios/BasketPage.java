package com.qaprosoft.carina.demo.mobile.gui.pages.ios;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.utils.mobile.IMobileUtils;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.locator.ExtendedFindBy;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.BasketPageBase;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = BasketPageBase.class)
public class BasketPage extends BasketPageBase implements IMobileUtils {

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeStaticText[`label CONTAINS \"$ \"`]")
    ExtendedWebElement productCost;
    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`label == \"Remove Item\"`]")
    ExtendedWebElement removeItemBtn;
    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`label == \"Go Shopping\"`]")
    ExtendedWebElement goShoppingBtn;
    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeStaticText[`label CONTAINS \"$\"`]")
    ExtendedWebElement finalSum;
    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeStaticText[`label == \"1\"`][1]")
    ExtendedWebElement oneElement;

    public BasketPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isBasketPageOpened() {
        return goShoppingBtn.isElementPresent();
    }
    @Override
    public boolean oneProductInCart() {
        return oneElement.isElementPresent();
    }

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

    public BasketPageBase clickGoShoppingBtn() {
        goShoppingBtn.click();
        return initPage(getDriver(), BasketPageBase.class);
    }

    @Override
    public BasketPageBase goToCart() {
        return null;
    }

    @Override
    public boolean isCartEmpty() {
        goShoppingBtn.isElementPresent();
        return true;
    }
}
