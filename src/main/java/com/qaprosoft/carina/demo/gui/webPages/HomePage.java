package com.qaprosoft.carina.demo.gui.webPages;

import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.gui.webPages.base.BaseDemoblazePage;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BaseDemoblazePage {

    @FindBy(xpath = "//*[@id=\"cat\"]")
    ExtendedWebElement categories;

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
        return categories.isElementPresent();
    }

    public void clickRightArrowWindow() {
        rightArrow.click();
    }

    public void clickLeftArrowWindow() {
        leftArrow.click();
    }

    public boolean showImage(int index) {
        return slideImg.format(index).isElementPresent();
    }

    public ProductPage productOpenedByIndex(int index) {
        product.format(String.valueOf(index)).click();
        return new ProductPage(getDriver());
    }

    public String getUserName() {
        return StringUtils.substringAfter(welcomeText.format(R.TESTDATA.get("TEST_EMAIL")).getText(), " ");
    }

    public ResultPage searchCategories() {
        categories.getText();
        return new ResultPage(getDriver());
    }
}


