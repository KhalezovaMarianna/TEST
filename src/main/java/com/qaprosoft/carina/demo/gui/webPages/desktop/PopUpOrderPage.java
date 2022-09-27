package com.qaprosoft.carina.demo.gui.webPages.desktop;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.gui.webPages.common.HomePageBase;
import com.qaprosoft.carina.demo.gui.webPages.common.PopUpOrderPageBase;
import com.qaprosoft.carina.demo.gui.webPages.common.componentsBase.FooterBase;
import com.qaprosoft.carina.demo.gui.webPages.common.componentsBase.HeaderBase;

import com.qaprosoft.carina.demo.gui.webPages.desktop.components.Footer;
import com.qaprosoft.carina.demo.gui.webPages.desktop.components.Header;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = PopUpOrderPageBase.class)
public class PopUpOrderPage extends PopUpOrderPageBase{
    @FindBy(xpath = "//*[@id=\"navbarExample\"]")
    private Header header;
    @FindBy(xpath = "//*[@id=\"footc\"]")
    private Footer footer;
    @FindBy(xpath = "/html/body/div[10]/div[7]/div/button")
    ExtendedWebElement okBtn;

    @FindBy(xpath = "//div[10]/h2")
    ExtendedWebElement title;

    public PopUpOrderPage(WebDriver driver) {
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
    public HomePageBase closePage() {
        okBtn.click();
        return initPage(getDriver(), HomePageBase.class);
    }
}
