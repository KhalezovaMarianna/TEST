package com.qaprosoft.carina.demo.gui.webPages.androidWeb;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.gui.webPages.androidWeb.components.Footer;
import com.qaprosoft.carina.demo.gui.webPages.androidWeb.components.Header;
import com.qaprosoft.carina.demo.gui.webPages.common.PlaceOrderPageBase;
import com.qaprosoft.carina.demo.gui.webPages.common.PopUpOrderPageBase;
import com.qaprosoft.carina.demo.gui.webPages.common.componentsBase.FooterBase;
import com.qaprosoft.carina.demo.gui.webPages.common.componentsBase.HeaderBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = PlaceOrderPageBase.class)
public class PlaceOrderPage extends PlaceOrderPageBase{

    @FindBy(xpath = "//*[@id=\"navbarExample\"]")
    private Header header;
    @FindBy(xpath = "//*[@id=\"footc\"]")
    private Footer footer;
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

    @Override
    public HeaderBase getHeader() {
        return header;
    }

    @Override
    public FooterBase getFooter() {
        return footer;
    }

    @Override
    public void filledNameForm(String name) {
        nameForm.type(name);
    }

    @Override
    public void filledCartForm(String number) {
        creditCardForm.type(number);
    }

    @Override
    public void clickSendOrderWithEmptyForms() {
        purchaseBtn.click();
    }

    @Override
    public PopUpOrderPageBase clickSendOrderButton() {
        purchaseBtn.click();
        return initPage(getDriver(), PopUpOrderPageBase.class);
    }
}
