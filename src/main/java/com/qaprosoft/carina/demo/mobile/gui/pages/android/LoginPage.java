package com.qaprosoft.carina.demo.mobile.gui.pages.android;

import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.utils.mobile.IMobileUtils;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.locator.ExtendedFindBy;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.CheckoutPageBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.HomePageBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.LoginPageBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.MorePageBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.ios.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = LoginPageBase.class)
public class LoginPage extends LoginPageBase implements IMobileUtils {

    @FindBy(xpath = "//android.widget.Button[@content-desc=\"Tap to login with given credentials\"]")
    private ExtendedWebElement loginBtn;

    @FindBy(id = "com.saucelabs.mydemoapp.android:id/nameET")
    private ExtendedWebElement usernameForm;

    @FindBy(id = "com.saucelabs.mydemoapp.android:id/passwordET")
    private ExtendedWebElement passwordForm;

    @FindBy(id = "com.saucelabs.mydemoapp.android:id/nameErrorTV")
    private ExtendedWebElement failedNameText;

    @FindBy(id = "com.saucelabs.mydemoapp.android:id/username1TV")
    private ExtendedWebElement autoNameBtn;


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return usernameForm.isElementPresent();
    }

    @Override
    public HomePageBase clickLoginBtn() {
        loginBtn.click();
        return initPage(getDriver(), HomePageBase.class);
    }

    @Override
    public HomePage clickAutoBtn() {
        return null;
    }

    @Override
    public void typeUsernameForm(String email) {
        usernameForm.type(email);
    }

    @Override
    public void typePassword(String password) {
        passwordForm.type(password);

    }

    @Override
    public void clickUser() {
        autoNameBtn.click();
    }

    @Override
    public CheckoutPageBase clickLoginBtnForCheckout() {
        loginBtn.click();
        return initPage(getDriver(), CheckoutPageBase.class);
    }

    @Override
    public boolean isFailedTextIsPresent() {
        return failedNameText.isElementPresent();

    }


}
