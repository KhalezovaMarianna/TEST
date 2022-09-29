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
import org.testng.Assert;

public class HomePage extends AbstractPage implements ICustomTypePageFactory, IMobileUtils {

    @FindBy(xpath = "//*[@id=\"navbarExample\"]")
    private Header header;
    @FindBy(xpath = "//*[@id=\"footc\"]")
    private Footer footer;

    @FindBy(xpath = "//*[@id=\"cat\"]")
    private ExtendedWebElement categories;

    @FindBy(xpath = "//*[@id=\"cat\"]")
    private ExtendedWebElement categoryNameTitle;

    @FindBy(xpath = "//*[@id=\"carouselExampleIndicators\"]/a[2]/span[1]")
    private ExtendedWebElement rightArrow;

    @FindBy(xpath = "//*[@id=\"carouselExampleIndicators\"]/a[1]/span[1]")
    private ExtendedWebElement leftArrow;

    @FindBy(xpath = "//*[@id=\"carouselExampleIndicators\"]/div/div[%s]/img")
    private ExtendedWebElement slideImg;

    @FindBy(xpath = "//*[@id=\"tbodyid\"]/div[%S]/div/div/h4/a")
    private ExtendedWebElement product;

    @FindBy(xpath = "//a[text()=\"Welcome %s\"]")
    private ExtendedWebElement welcomeText;

    @FindBy(xpath = "//*[@id=\"tbodyid\"]/div[1]/div/div//a")
    private ExtendedWebElement firstProduct;

    @FindBy(xpath = "//*[@id=\"frm\"]//li[2]")
    private ExtendedWebElement nextBtn;

    @FindBy(xpath = "//*[@id=\"frm\"]//li[1]")
    private ExtendedWebElement previousBtn;

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

    public void clickNextButton() {
        nextBtn.click();
    }

    public String getNameOfFirstProduct() {
        return firstProduct.getText();
    }

    public void clickPreviousBtn() {
        previousBtn.click();
    }


}

