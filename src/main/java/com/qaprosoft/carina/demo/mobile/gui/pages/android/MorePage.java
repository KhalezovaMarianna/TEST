package com.qaprosoft.carina.demo.mobile.gui.pages.android;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.utils.mobile.IMobileUtils;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.locator.ExtendedFindBy;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.*;
import com.qaprosoft.carina.demo.mobile.gui.pages.ios.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;


@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = MorePageBase.class)
public class MorePage extends MorePageBase implements IMobileUtils {

    @ExtendedFindBy(accessibilityId = "Displays available colors of selected product")
    ExtendedWebElement product;

    @FindBy(xpath = "//androidx.recyclerview.widget.RecyclerView//android.view.ViewGroup[7]/android.widget.TextView")
    ExtendedWebElement resetBtn;

    @FindBy(xpath = "//androidx.recyclerview.widget.RecyclerView//android.view.ViewGroup[12]/android.widget.TextView")
    ExtendedWebElement loginBtn;

    public MorePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isMorePageOpen() {
        return product.isElementPresent();
    }

    @Override
    public BasketPageBase openCart() {
        return null;
    }

    @Override
    public PopUpResetPageBase resetApp() {
        return null;
    }

    @Override
    public AboutPageBase clickAboutBtn() {
        return null;
    }

    @Override
    public HomePageBase clickCatalogBtn() {
        return null;
    }

    @Override
    public LoginPageBase clickLoginBtn() {
        loginBtn.click();
        return initPage(getDriver(),LoginPage.class);
    }


}
