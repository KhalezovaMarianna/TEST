package com.qaprosoft.carina.demo.gui.webPages.androidWeb;

import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.gui.webPages.androidWeb.components.Footer;
import com.qaprosoft.carina.demo.gui.webPages.androidWeb.components.Header;
import com.qaprosoft.carina.demo.gui.webPages.common.HomePageBase;
import com.qaprosoft.carina.demo.gui.webPages.common.ProductPageBase;
import com.qaprosoft.carina.demo.gui.webPages.common.componentsBase.FooterBase;
import com.qaprosoft.carina.demo.gui.webPages.common.componentsBase.HeaderBase;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = HomePageBase.class)
public class HomePage extends HomePageBase {
    @FindBy(xpath = "//*[@id=\"navbarExample\"]")
    private Header header;

    @FindBy(xpath = "//*[@id=\"footc\"]")
    private Footer footer;
    @FindBy(xpath = "//*[@id=\"cat\"]")
    ExtendedWebElement categories;

    @FindBy(css = ".list-group-item")
    ExtendedWebElement categoryNameTitle;

    @FindBy(xpath = "//*[@id=\"carouselExampleIndicators\"]/a[2]/span[1]")
    ExtendedWebElement rightArrow;

    @FindBy(xpath = "//*[@id=\"carouselExampleIndicators\"]/a[1]/span[1]")
    ExtendedWebElement leftArrow;

    @FindBy(xpath = "//*[@id=\"carouselExampleIndicators\"]/div/div[%s]/img")
    ExtendedWebElement slideImg;

    @FindBy(xpath = "//*[@id=\"tbodyid\"]/div[%S]/div/div/h4/a")
    ExtendedWebElement product;

    @FindBy(xpath = "//a[text()=\"Welcome %s\"]")
    ExtendedWebElement welcomeText;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isOpened() {
        return categoryNameTitle.isElementPresent();
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
    public void clickRightArrowWindow() {
        rightArrow.click();
    }

    @Override
    public void clickLeftArrowWindow() {
        leftArrow.click();
    }

    @Override
    public boolean isImageShow(int index) {
        return slideImg.format(index).isElementPresent();
    }

    @Override
    public ProductPageBase productOpenedByIndex(int index) {
        product.format(String.valueOf(index)).click();
        return initPage(getDriver(), ProductPageBase.class);
    }

    @Override
    public String getUserName() {
        return StringUtils.substringAfter(welcomeText.format(R.TESTDATA.get("TEST_EMAIL")).getText(), " ");
    }


}

