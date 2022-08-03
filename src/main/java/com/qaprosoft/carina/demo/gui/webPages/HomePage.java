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

    @FindBy(xpath = "//*[@id=\"navbarExample\"]/ul/li[2]/a")
    ExtendedWebElement contactBtn;

    @FindBy(xpath = "//*[@id=\"navbarExample\"]/ul/li[3]/a")
    ExtendedWebElement aboutUsBtn;

    @FindBy(xpath = "//*[@id=\"cartur\"]")
    ExtendedWebElement cartBtn;

    @FindBy(xpath = "//*[@id=\"login2\"]")
    ExtendedWebElement loginBtn;

    @FindBy(xpath = "//*[@id=\"signin2\"]")
    ExtendedWebElement signUpBtn;

    @FindBy(xpath = "//*[@id=\"carouselExampleIndicators\"]/a[2]/span[1]")
    ExtendedWebElement rightArrow;

    @FindBy(xpath = "//*[@id=\"carouselExampleIndicators\"]/a[1]/span[1]")
    ExtendedWebElement leftArrow;

    @FindBy(xpath = "///*[@id=\"carouselExampleIndicators\"]/div/div[1]/img")
    ExtendedWebElement firstSlideImg;

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

    public AboutUsPage goToAboutPage() {
        aboutUsBtn.click();
        return new AboutUsPage(getDriver());
    }

    public ContactPage goToContactPage() {
        contactBtn.click();
        return new ContactPage(getDriver());
    }

    public CartPage goToCartPage() {
        cartBtn.click();
        return new CartPage(getDriver());
    }

    public LogInPage goToLoginPage() {
        loginBtn.click();
        return new LogInPage(getDriver());
    }

    public SignUpPage goToSignUpPage() {
        signUpBtn.click();
        return new SignUpPage(getDriver());
    }

    public void clickRightArrowWindow() {
        rightArrow.click();
    }

    public void clickLeftArrowWindow() {
        leftArrow.click();
    }

    public boolean isImgChanged() {
        return firstSlideImg.isElementNotPresent(20);
    }

    public ProductPage productOpenedByIndex(int index) {
        product.format(String.valueOf(index)).click();
        return new ProductPage(getDriver());
    }

    public String getUserName() {
        return StringUtils.substring(welcomeText.format(R.TESTDATA.get("TEST_EMAIL")).getText(), 8);
    }
}


