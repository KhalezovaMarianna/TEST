package com.qaprosoft.carina.demo.web.gui.webPages.pages;


import com.qaprosoft.carina.core.foundation.utils.factory.ICustomTypePageFactory;
import com.qaprosoft.carina.core.foundation.utils.mobile.IMobileUtils;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.web.gui.webPages.components.Footer;
import com.qaprosoft.carina.demo.web.gui.webPages.components.Header;
import com.qaprosoft.carina.demo.web.gui.webPages.utils.ImageUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends AbstractPage implements ICustomTypePageFactory, IMobileUtils {

    @FindBy(xpath = "//*[@id=\"navbarExample\"]")
    private Header header;

    @FindBy(xpath = "//*[@id=\"footc\"]")
    private Footer footer;

    @FindBy(xpath = "//*[@id=\"tbodyid\"]//a")
    private ExtendedWebElement addToCartBtn;

    @FindBy(xpath = "//*[@id=\"imgp\"]/div/img")
    private ExtendedWebElement imageProduct;

    public ProductPage(WebDriver driver) {
        super(driver);
    }


    public boolean isOpened() {
        return addToCartBtn.isElementPresent();
    }

    public boolean checkImageIsDownload() {
        if (ImageUtils.colorOptions(getDriver(), imageProduct)) {
            return true;
        } else {
            return false;
        }
    }

    public Header getHeader() {
        return header;
    }


    public Footer getFooter() {
        return footer;
    }


    public ProductPage clickAddToCartButton() {
        addToCartBtn.click();
        return new ProductPage(getDriver());
    }

}
