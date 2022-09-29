package com.qaprosoft.carina.demo.web.gui.webPages.pages;


import com.qaprosoft.carina.core.foundation.utils.factory.ICustomTypePageFactory;
import com.qaprosoft.carina.core.foundation.utils.mobile.IMobileUtils;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.web.gui.webPages.components.Footer;
import com.qaprosoft.carina.demo.web.gui.webPages.components.Header;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CartPage extends AbstractPage implements ICustomTypePageFactory, IMobileUtils {

    @FindBy(xpath = "//*[@id=\"navbarExample\"]")
    private Header header;

    @FindBy(xpath = "//*[@id=\"footc\"]")
    private Footer footer;

    @FindBy(xpath = "//*[@id=\"page-wrapper\"]")
    private ExtendedWebElement cartPage;

    @FindBy(xpath = "//*[@id=\"tbodyid\"]/tr[%S]/td[4]/a")
    private ExtendedWebElement deleteBtn;

    @FindBy(xpath = "//*[@id=\"navbarExample\"]/ul/li[1]/a")
    private ExtendedWebElement homeBtn;

    @FindBy(xpath = "//*[@id=\"totalp\"]")
    private ExtendedWebElement amountCart;

    @FindBy(xpath = "//*[@id=\"totalp\"]")
    private ExtendedWebElement totalPrice;

    @FindBy(xpath = "//*[@id=\"tbodyid\"]//td[3]")
    private ExtendedWebElement productCount;

    @FindBy(xpath = "//*[@id=\"page-wrapper\"]//button")
    private ExtendedWebElement placeOrderBtn;

    public CartPage(WebDriver driver) {
        super(driver);
    }


    public boolean isOpened() {
        return cartPage.isElementPresent();
    }

    public Header getHeader() {
        return header;
    }

    public Footer getFooter() {
        return footer;
    }

    public HomePage goToHome() {
        homeBtn.click();
        return new HomePage(getDriver());
    }

    public String getCartTotal() {
        return totalPrice.getText();
    }

    public String getProductPrice() {
        return productCount.getText();
    }

    public void deleteAllProducts() {
        while (deleteBtn.isElementPresent()) {
            deleteBtn.click();
        }
    }

    public void deleteProductByIndex(String index) {
        deleteBtn.format(index).click();
    }

    public boolean isCartEmpty() {
        return deleteBtn.isElementNotPresent(2);
    }

    public PlaceOrderPage clickPlaceOrderBtn() {
        placeOrderBtn.click();
        return new PlaceOrderPage(getDriver());
    }
}
