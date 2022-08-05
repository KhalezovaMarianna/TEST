package com.qaprosoft.carina.demo.gui.webPages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.gui.webPages.base.BaseDemoblazePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BaseDemoblazePage {

    @FindBy(xpath = "//*[@id=\"tbodyid\"]//a")
    ExtendedWebElement addToCartBtn;
    @FindBy(xpath = "//*[@id=\"cartur\"]")
    ExtendedWebElement cartBtn;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isOpened() {
        return addToCartBtn.isElementPresent();
    }

    public ProductPage addToCart() {
        addToCartBtn.click();
        return new ProductPage(getDriver());
    }

    public CartPage openCart() {
        cartBtn.click();
        return new CartPage(getDriver());
    }


}
