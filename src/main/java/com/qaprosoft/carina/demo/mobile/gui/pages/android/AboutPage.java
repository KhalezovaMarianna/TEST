package com.qaprosoft.carina.demo.mobile.gui.pages.android;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.AboutPageBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.HomePageBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.URLAboutPageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = AboutPageBase.class)
public class AboutPage extends AboutPageBase {

    @FindBy(id = "com.saucelabs.mydemoapp.android:id/characterIV")
    private ExtendedWebElement aboutPicture;

    @FindBy(id = "com.saucelabs.mydemoapp.android:id/aboutTV")
    private ExtendedWebElement titleAbout;

    @FindBy(id = "com.saucelabs.mydemoapp.android:id/webTV")
    private ExtendedWebElement goToUrl;

    @FindBy(xpath = "//androidx.recyclerview.widget.RecyclerView[@content-desc=\"Recycler view for menu\"]/android.view.ViewGroup[1]/android.widget.TextView[2]")
    private ExtendedWebElement catalogBtn;

    public AboutPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isOpened() {
        if (aboutPicture.isElementPresent() && titleAbout.isElementPresent()) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public HomePageBase clickBackBtn() {
        catalogBtn.click();
        return initPage(getDriver(), HomePageBase.class);
    }

    @Override
    public URLAboutPageBase goToURL() {
        goToUrl.click();
        return initPage(getDriver(),URLAboutPageBase.class);
    }
}
