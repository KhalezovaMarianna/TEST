package com.qaprosoft.carina.demo.gui.webPages.desktop.components;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.utils.factory.ICustomTypePageFactory;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.gui.webPages.common.*;
import com.qaprosoft.carina.demo.gui.webPages.common.componentsBase.FooterBase;
import com.qaprosoft.carina.demo.gui.webPages.common.componentsBase.HeaderBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.AboutPageBase;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = HeaderBase.class)
public class Header extends HeaderBase implements ICustomTypePageFactory {
    @FindBy(xpath = "//*[@id=\"navbarExample\"]/ul/li[2]/a")
    ExtendedWebElement contactBtn;

    @FindBy(xpath = "//*[@id=\"navbarExample\"]/ul/li[3]/a")
    ExtendedWebElement aboutUsBtn;

    @FindBy(xpath = "//*[@id=\"login2\"]")
    ExtendedWebElement loginBtn;

    @FindBy(xpath = "//*[@id=\"signin2\"]")
    ExtendedWebElement signUpBtn;

    @FindBy(xpath = "//*[@id=\"cartur\"]")
    ExtendedWebElement cartBtn;

    public Header(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    @Override
    public HeaderBase getHeaderBase() {
        return getHeaderBase();
    }

    @Override
    public FooterBase getFooterBase() {
        return null;
    }

    @Override
    public boolean isOpened() {
        return false;
    }

//    public CartPageBase openCart() {
//        cartBtn.click();
//        return  initPage(getDriver(),CartPageBase.class);
//    }
//
//    public AboutUsPageBase goToAboutPage() {
//        aboutUsBtn.click();
//        return initPage(getDriver(),AboutUsPageBase.class);
//    }
//
//    public ContactPageBase goToContactPage() {
//        contactBtn.click();
//        return initPage(getDriver(),ContactPageBase.class);
//    }
//
//    public LoginPageBase goToLoginPage() {
//        loginBtn.click();
//        return initPage(getDriver(),LoginPageBase.class);
//    }
//
//    public SignUpPageBase goToSignUpPage() {
//        signUpBtn.click();
//        return initPage(getDriver(),SignUpPageBase.class);
//    }
}
