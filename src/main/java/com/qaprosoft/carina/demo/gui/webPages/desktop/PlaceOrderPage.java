package com.qaprosoft.carina.demo.gui.webPages.desktop;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.gui.webPages.base.BaseDemoblazePage;
import com.qaprosoft.carina.demo.gui.webPages.common.PlaceOrderPageBase;
import com.qaprosoft.carina.demo.gui.webPages.common.PopUpOrderPageBase;
import com.qaprosoft.carina.demo.gui.webPages.common.componentsBase.FooterBase;
import com.qaprosoft.carina.demo.gui.webPages.common.componentsBase.HeaderBase;
import com.qaprosoft.carina.demo.gui.webPages.desktop.components.Footer;
import com.qaprosoft.carina.demo.gui.webPages.desktop.components.Header;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = PlaceOrderPageBase.class)
public class PlaceOrderPage extends PlaceOrderPageBase {
    @FindBy(xpath = "//*[@id=\"navbarExample\"]/ul")
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
    public HeaderBase getHeaderBase() {
        return header;
    }

    @Override
    public FooterBase getFooterBase() {
        return footer;
    }


    @Override
    public boolean isOpened() {
        return title.isElementPresent();
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