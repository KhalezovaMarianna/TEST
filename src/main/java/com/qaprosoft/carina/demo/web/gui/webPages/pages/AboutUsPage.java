package com.qaprosoft.carina.demo.web.gui.webPages.pages;


import com.qaprosoft.carina.core.foundation.utils.factory.ICustomTypePageFactory;
import com.qaprosoft.carina.core.foundation.utils.mobile.IMobileUtils;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.web.gui.webPages.components.Footer;
import com.qaprosoft.carina.demo.web.gui.webPages.components.Header;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class AboutUsPage extends AbstractPage implements ICustomTypePageFactory, IMobileUtils {
    @FindBy(xpath = "//*[@id=\"navbarExample\"]")
    private Header header;

    @FindBy(xpath = "//*[@id=\"footc\"]")
    private Footer footer;

    @FindBy(xpath = "//*[@id=\"videoModalLabel\"]")
    ExtendedWebElement aboutUsPage;

    @FindBy(xpath = "//*[@id=\"videoModal\"]/div/div/div/button")
    ExtendedWebElement closeBtn;

    public AboutUsPage(WebDriver driver) {
        super(driver);
    }



    public boolean isOpened() {
        return aboutUsPage.isElementPresent();
    }


    public Header getHeader() {
        return header;
    }


    public Footer getFooter() {
        return footer;
    }


    public HomePage clickCloseButton() {
        closeBtn.click();
        return new HomePage(getDriver());
    }
}
