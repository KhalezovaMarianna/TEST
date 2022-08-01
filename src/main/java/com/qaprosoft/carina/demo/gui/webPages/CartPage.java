package com.qaprosoft.carina.demo.gui.webPages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CartPage extends AbstractPage {

    @FindBy(xpath = "//*[@id=\"page-wrapper\"]")
    ExtendedWebElement cartPage;

    @FindBy(xpath = "//*[@id=\"navbarExample\"]/ul/li[1]/a")
    ExtendedWebElement homeBtn;

    @FindBy(xpath = "//*[@id=\"totalp\"]")
    ExtendedWebElement amountCart;

    public CartPage(WebDriver driver) {
        super(driver);
    }
    public boolean isCartPageOpen(){
        cartPage.isElementPresent();
        return true;
    }

    public HomePage goToHome(){
        homeBtn.click();
        return new HomePage(getDriver());
    }

    public boolean comparisonTitleAmount(){
        double sum = Double.parseDouble(amountCart.format().getText());
        System.out.println(sum);
        if(sum>0){
        return true;
    }
        return false;
    }
}
