package com.qaprosoft.carina.demo.gui.webPages.androidWeb;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.gui.webPages.androidWeb.components.Footer;
import com.qaprosoft.carina.demo.gui.webPages.androidWeb.components.Header;
import com.qaprosoft.carina.demo.gui.webPages.common.CartPageBase;
import com.qaprosoft.carina.demo.gui.webPages.common.HomePageBase;
import com.qaprosoft.carina.demo.gui.webPages.common.PlaceOrderPageBase;
import com.qaprosoft.carina.demo.gui.webPages.common.componentsBase.FooterBase;
import com.qaprosoft.carina.demo.gui.webPages.common.componentsBase.HeaderBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = CartPageBase.class)
public class CartPage extends CartPageBase {
    @FindBy(xpath = "//*[@id=\"navbarExample\"]")
    private Header header;

    @FindBy(xpath = "//*[@id=\"footc\"]")
    private Footer footer;
    @FindBy(xpath = "//*[@id=\"page-wrapper\"]")
    ExtendedWebElement cartPage;

    @FindBy(xpath = "//*[@id=\"tbodyid\"]/tr[%S]/td[4]/a")
    ExtendedWebElement deleteBtn;

    @FindBy(xpath = "//*[@id=\"navbarExample\"]/ul/li[1]/a")
    ExtendedWebElement homeBtn;

    @FindBy(xpath = "//*[@id=\"totalp\"]")
    ExtendedWebElement amountCart;

    @FindBy(xpath = "//*[@id=\"totalp\"]")
    ExtendedWebElement totalPrice;

    @FindBy(xpath = "//*[@id=\"tbodyid\"]//td[3]")
    ExtendedWebElement productCount;

    @FindBy(xpath = "//*[@id=\"page-wrapper\"]//button")
    ExtendedWebElement placeOrderBtn;
    public CartPage(WebDriver driver) {
        super(driver);
    }



    @Override
    public boolean isOpened() {
        return cartPage.isElementPresent();
    }

    @Override
    public HeaderBase getHeader() {
        return header;
    }

    @Override
    public FooterBase getFooter() {
        return footer;
    }

    @Override
    public HomePageBase goToHome() {
        homeBtn.click();
        return initPage(getDriver(), HomePageBase.class);
    }

    @Override
    public String getCartTotal() {
        return totalPrice.getText();
    }

    @Override
    public String getProductPrice() {
        return productCount.getText();
    }

    @Override
    public void deleteAllProducts() {
        while (deleteBtn.isElementPresent()) {
            deleteBtn.click();
        }
    }

    @Override
    public void deleteProductByIndex(String index) {
        deleteBtn.format(index).click();
    }

    @Override
    public boolean isCartEmpty() {
        return deleteBtn.isElementNotPresent(2);
    }

    @Override
    public PlaceOrderPageBase clickPlaceOrderBtn() {
        placeOrderBtn.click();
        return initPage(getDriver(), PlaceOrderPageBase.class);
    }
}

