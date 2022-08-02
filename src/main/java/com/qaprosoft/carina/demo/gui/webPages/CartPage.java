package com.qaprosoft.carina.demo.gui.webPages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

public class CartPage extends BaseDemoblazePage {

    @FindBy(xpath = "//*[@id=\"page-wrapper\"]")
    ExtendedWebElement cartPage;

    @FindBy(xpath = "//*[@id=\"navbarExample\"]/ul/li[1]/a")
    ExtendedWebElement homeBtn;

    @FindBy(xpath = "//*[@id=\"totalp\"]")
    ExtendedWebElement amountCart;

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

    public boolean comparisonTitleAmount() {
        double sum = Double.parseDouble(amountCart.format().getText());
        if (sum > 0) {
            return true;
        }
        return false;
    }
}
