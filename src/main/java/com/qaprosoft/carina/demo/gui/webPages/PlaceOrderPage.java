package com.qaprosoft.carina.demo.gui.webPages;

import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.gui.webPages.base.BaseDemoblazePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class PlaceOrderPage extends BaseDemoblazePage {

    @FindBy(xpath = "//*[@id=\"orderModalLabel\"]")
    ExtendedWebElement title;

    @FindBy(xpath = "//*[@id=\"name\"]")
    ExtendedWebElement nameForm;

    @FindBy(xpath = "//*[@id=\"card\"]")
    ExtendedWebElement creditCardForm;

    @FindBy(xpath = "//*[@id=\"orderModal\"]//button[2]")
    ExtendedWebElement purchaseBtn;

    public PlaceOrderPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isOpened() {
        return title.isElementPresent();
    }

    public void fillingNameForm(String name) {
        nameForm.type(name);
    }

    public void fillingCartForm(String number) {
        creditCardForm.type(number);
    }

    public PopUpOrderPage sendOrder(){
        purchaseBtn.click();
        return new PopUpOrderPage(getDriver());
    }

}
