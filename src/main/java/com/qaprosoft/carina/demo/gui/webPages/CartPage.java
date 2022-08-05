package com.qaprosoft.carina.demo.gui.webPages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.gui.webPages.base.BaseDemoblazePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BaseDemoblazePage {

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

    public void deleteProductByIndex(String index){
        deleteBtn.format(index).click();
    }
    public PlaceOrderPage clickPlaceOrderBtn(){
        placeOrderBtn.click();
        return new PlaceOrderPage(getDriver());
    }

    public boolean isCartEmpty(){
       return deleteBtn.isElementNotPresent(2);
    }

}
