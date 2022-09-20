package com.qaprosoft.carina.demo.mobile.gui.pages.ios;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.utils.mobile.IMobileUtils;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.locator.ExtendedFindBy;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.CheckoutPageBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.HomePageBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.LoginPageBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.PopUpResetPageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = LoginPageBase.class)
public class LoginPage extends LoginPageBase implements IMobileUtils {
    @ExtendedFindBy(iosPredicate = "type == \"XCUIElementTypeTextField\"")
    private ExtendedWebElement usernameForm;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeStaticText[`label == \"Login\"`][1]")
    private ExtendedWebElement title;

    @ExtendedFindBy(iosPredicate = "type == \"XCUIElementTypeSecureTextField\"")
    private ExtendedWebElement passwordForm;

    @ExtendedFindBy(iosPredicate = "label == \"Login\" AND name == \"Login\" AND type == \"XCUIElementTypeButton\"")
    private ExtendedWebElement loginBtn;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeStaticText[`label == \"bob@example.com\"`]")
    private ExtendedWebElement autoFillBtn;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeStaticText[`label == \"Username is required\"`]")
    private ExtendedWebElement popUpFailedNameForm;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isOpened() {
        return usernameForm.isElementPresent() && passwordForm.isElementPresent() && loginBtn.isElementPresent() && title.isElementPresent();
    }

    public HomePageBase clickAutoBtn() {
        autoFillBtn.click();
        loginBtn.click();
        return initPage(getDriver(), HomePageBase.class);
    }

    @Override
    public HomePageBase clickLoginBtn() {
        loginBtn.click();
        return initPage(getDriver(), HomePageBase.class);
    }

    @Override
    public void typeUsernameForm(String email) {
        usernameForm.type(email);
    }

    @Override
    public boolean isFailedTextIsPresent() {
        return popUpFailedNameForm.isElementPresent();
    }

    @Override
    public void typePassword(String password) {
        passwordForm.type(password);
    }

    @Override
    public void clickUser() {
        autoFillBtn.click();
    }

    @Override
    public CheckoutPageBase clickLoginBtnForCheckout() {
        loginBtn.click();
        return initPage(getDriver(), CheckoutPageBase.class);
    }


}

