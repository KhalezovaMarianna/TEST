package com.qaprosoft.carina.demo.gui.webPages.androidWeb;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.gui.webPages.androidWeb.components.Footer;
import com.qaprosoft.carina.demo.gui.webPages.androidWeb.components.Header;
import com.qaprosoft.carina.demo.gui.webPages.common.HomePageBase;
import com.qaprosoft.carina.demo.gui.webPages.common.SignUpPageBase;
import com.qaprosoft.carina.demo.gui.webPages.common.componentsBase.FooterBase;
import com.qaprosoft.carina.demo.gui.webPages.common.componentsBase.HeaderBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = SignUpPageBase.class)
public class SignUpPage extends SignUpPageBase {
    @FindBy(xpath = "//*[@id=\"navbarExample\"]")
    private Header header;

    @FindBy(xpath = "//*[@id=\"footc\"]")
    private Footer footer;

    @FindBy(xpath = "//*[@id=\"signInModalLabel\"]")
    ExtendedWebElement signUpPage;

    @FindBy(xpath = "//*[@id=\"sign-username\"]")
    ExtendedWebElement usernameForm;

    @FindBy(xpath = "//*[@id=\"sign-password\"]")
    ExtendedWebElement passwordForm;

    @FindBy(xpath = "//*[@id=\"signInModal\"]/div/div/div[3]/button[2]")
    ExtendedWebElement signUpBtn;

    @FindBy(xpath = "//*[@id=\"signInModal\"]//div[1]/button")
    ExtendedWebElement closeBtn;

    public SignUpPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isOpened() {
        return signUpPage.isElementPresent();
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
    public HomePageBase clickCloseButton() {
        closeBtn.click();
        return initPage(getDriver(), HomePageBase.class);
    }

    @Override
    public void typeName(String email) {
        usernameForm.type(email);
    }

    @Override
    public void typePassword(String password) {
        passwordForm.type(password);
    }

    @Override
    public void clickSignUpBtn() {
        signUpBtn.click();
    }

}

