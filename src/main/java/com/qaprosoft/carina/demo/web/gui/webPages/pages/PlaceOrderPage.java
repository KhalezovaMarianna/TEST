package com.qaprosoft.carina.demo.web.gui.webPages.pages;


import com.qaprosoft.carina.core.foundation.utils.factory.ICustomTypePageFactory;
import com.qaprosoft.carina.core.foundation.utils.mobile.IMobileUtils;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.web.gui.webPages.components.Footer;
import com.qaprosoft.carina.demo.web.gui.webPages.components.Header;
import com.qaprosoft.carina.demo.web.gui.webPages.pages.PopUpOrderPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class PlaceOrderPage extends AbstractPage implements ICustomTypePageFactory, IMobileUtils {

    @FindBy(xpath = "//*[@id=\"navbarExample\"]")
    private Header header;

    @FindBy(xpath = "//*[@id=\"footc\"]")
    private Footer footer;

    @FindBy(xpath = "//*[@id=\"orderModalLabel\"]")
    private ExtendedWebElement title;

    @FindBy(xpath = "//*[@id=\"name\"]")
    private ExtendedWebElement nameForm;

    @FindBy(xpath = "//*[@id=\"card\"]")
    private ExtendedWebElement creditCardForm;

    @FindBy(xpath = "//*[@id=\"orderModal\"]//button[2]")
    private ExtendedWebElement purchaseBtn;

    public PlaceOrderPage(WebDriver driver) {
        super(driver);
    }


    public boolean isOpened() {
        return title.isElementPresent();
    }

    public Header getHeader() {
        return header;
    }

    public Footer getFooter() {
        return footer;
    }

    public void filledNameForm(String name) {
        nameForm.type(name);
    }

    public void filledCartForm(String number) {
        creditCardForm.type(number);
    }

    public void clickSendOrderWithEmptyForms() {
        purchaseBtn.click();
    }

    public PopUpOrderPage clickSendOrderButton() {
        purchaseBtn.click();
        return new PopUpOrderPage(getDriver());
    }
}
