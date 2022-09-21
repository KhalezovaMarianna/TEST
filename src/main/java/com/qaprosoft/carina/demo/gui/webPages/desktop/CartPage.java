package com.qaprosoft.carina.demo.gui.webPages.desktop;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.gui.webPages.base.BaseDemoblazePage;
import com.qaprosoft.carina.demo.gui.webPages.common.HomePageBase;
import com.qaprosoft.carina.demo.gui.webPages.common.PlaceOrderPageBase;
import com.qaprosoft.carina.demo.gui.webPages.common.componentsBase.FooterBase;
import com.qaprosoft.carina.demo.gui.webPages.common.componentsBase.HeaderBase;
import com.qaprosoft.carina.demo.gui.webPages.desktop.components.Footer;
import com.qaprosoft.carina.demo.gui.webPages.desktop.components.Header;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.CartPageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = CartPageBase.class)
public class CartPage extends com.qaprosoft.carina.demo.gui.webPages.common.CartPageBase {
    @FindBy(xpath = "//*[@id=\"navbarExample\"]/ul")
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
    public HeaderBase getHeaderBase() {
        return header;
    }

    @Override
    public FooterBase getFooterBase() {
        return footer;
    }


    @Override
    public boolean isOpened() {
        return cartPage.isElementPresent();
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
    public PlaceOrderPageBase clickPlaceOrderBtn() {
        placeOrderBtn.click();
        return initPage(getDriver(),PlaceOrderPageBase.class);
    }

    @Override
    public boolean isCartEmpty() {
        return deleteBtn.isElementNotPresent(2);
    }

}
