package com.qaprosoft.carina.demo.gui.webPages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends AbstractPage {

    @FindBy(xpath = "//*[@id=\"tbodyid\"]//a")
    ExtendedWebElement addToCartBtn;

    @FindBy(xpath = "//*[@id=\"cartur\"]")
    ExtendedWebElement cartBtn;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public boolean isProductPageOpen() {
        addToCartBtn.isElementPresent();
        return true;
    }

    public void addToCart() {
        addToCartBtn.click();
    }

    public CartPage openCart() {
        cartBtn.click();
        return new CartPage(getDriver());
    }


}
