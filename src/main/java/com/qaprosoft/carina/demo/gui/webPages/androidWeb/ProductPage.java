package com.qaprosoft.carina.demo.gui.webPages.androidWeb;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.gui.webPages.androidWeb.components.Footer;
import com.qaprosoft.carina.demo.gui.webPages.androidWeb.components.Header;
import com.qaprosoft.carina.demo.gui.webPages.common.ProductPageBase;
import com.qaprosoft.carina.demo.gui.webPages.common.componentsBase.FooterBase;
import com.qaprosoft.carina.demo.gui.webPages.common.componentsBase.HeaderBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ProductPageBase.class)
public class ProductPage extends ProductPageBase {

    @FindBy(xpath = "//*[@id=\"navbarExample\"]")
    private Header header;
    @FindBy(xpath = "//*[@id=\"footc\"]")
    private Footer footer;
    @FindBy(xpath = "//*[@id=\"tbodyid\"]//a")
    ExtendedWebElement addToCartBtn;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isOpened() {
        return addToCartBtn.isElementPresent();
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
    public ProductPageBase clickAddToCartButton() {
        addToCartBtn.click();
        return initPage(getDriver(), ProductPageBase.class);
    }

}
