package com.qaprosoft.carina.demo.web.gui.webPages.pages;


import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.core.foundation.utils.factory.ICustomTypePageFactory;
import com.qaprosoft.carina.core.foundation.utils.mobile.IMobileUtils;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.web.gui.webPages.components.Footer;
import com.qaprosoft.carina.demo.web.gui.webPages.components.Header;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class HomePage extends AbstractPage implements ICustomTypePageFactory, IMobileUtils {
    @FindBy(xpath = "//*[@id=\"navbarExample\"]")
    private Header header;
    @FindBy(xpath = "//*[@id=\"footc\"]")
    private Footer footer;

    @FindBy(xpath = "//*[@id=\"cat\"]")
    ExtendedWebElement categories;

    @FindBy(xpath = "//*[@id=\"cat\"]")
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


    public boolean isOpened() {
        return categoryNameTitle.isElementPresent();
    }


    public Header getHeader() {
        return header;
    }


    public Footer getFooter() {
        return footer;
    }


    public void clickRightArrowWindow() {
        rightArrow.click();
    }


    public void clickLeftArrowWindow() {
        leftArrow.click();
    }


    public boolean isImageShow(int index) {
        return slideImg.format(index).isElementPresent();
    }


    public ProductPage productOpenedByIndex(int index) {
        product.format(String.valueOf(index)).click();
        return new ProductPage(getDriver());
    }


    public String getUserName() {
        return StringUtils.substringAfter(welcomeText.format(R.TESTDATA.get("TEST_EMAIL")).getText(), " ");
    }


}

