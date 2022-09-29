package com.qaprosoft.carina.demo.web.gui.webPages.pages;


import com.qaprosoft.carina.core.foundation.utils.factory.ICustomTypePageFactory;
import com.qaprosoft.carina.core.foundation.utils.mobile.IMobileUtils;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.web.gui.webPages.components.Footer;
import com.qaprosoft.carina.demo.web.gui.webPages.components.Header;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class PopUpOrderPage extends AbstractPage implements ICustomTypePageFactory, IMobileUtils {

    @FindBy(xpath = "//*[@id=\"navbarExample\"]")
    private Header header;

    @FindBy(xpath = "//*[@id=\"footc\"]")
    private Footer footer;

    @FindBy(xpath = "/html/body/div[10]/div[7]/div/button")
    private ExtendedWebElement okBtn;

    @FindBy(xpath = "//div[10]/h2")
    private ExtendedWebElement title;

    public PopUpOrderPage(WebDriver driver) {
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

    public HomePage closePage() {
        okBtn.click();
        return new HomePage(getDriver());
    }
}
