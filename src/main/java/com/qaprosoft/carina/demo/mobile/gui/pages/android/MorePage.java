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
    private ExtendedWebElement product;

    @FindBy(xpath = "//androidx.recyclerview.widget.RecyclerView//android.view.ViewGroup[7]/android.widget.TextView")
    private ExtendedWebElement resetBtn;

    @FindBy(xpath = "//androidx.recyclerview.widget.RecyclerView//android.view.ViewGroup[12]/android.widget.TextView")
    private ExtendedWebElement loginBtn;

    @FindBy(xpath = "//androidx.recyclerview.widget.RecyclerView[@content-desc=\"Recycler view for menu\"]/android.view.ViewGroup[9]")
    private ExtendedWebElement reportBugBtn;

    @FindBy(xpath = "//androidx.recyclerview.widget.RecyclerView[@content-desc=\"Recycler view for menu\"]/android.view.ViewGroup[2]")
    private ExtendedWebElement webviewBtn;

    @FindBy(xpath = "//androidx.recyclerview.widget.RecyclerView[@content-desc=\"Recycler view for menu\"]/android.view.ViewGroup[4]")
    private ExtendedWebElement geolocationBtn;

    public MorePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isOpened() {
        return product.isElementPresent();
    }

    @Override
    public CartPageBase openCart() {
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
        return initPage(getDriver(), LoginPageBase.class);
    }

    @Override
    public ReportBugPageBase clickReportBugBtn() {
        reportBugBtn.click();
        return initPage(getDriver(), ReportBugPageBase.class);
    }

    @Override
    public WebviewPageBase clickWebviewBtn() {
        webviewBtn.click();
        return initPage(getDriver(), WebviewPageBase.class);
    }

    @Override
    public GeolocationPageBase clickGeolocationBtn() {
        geolocationBtn.click();
        return initPage(GeolocationPageBase.class);
    }


}
