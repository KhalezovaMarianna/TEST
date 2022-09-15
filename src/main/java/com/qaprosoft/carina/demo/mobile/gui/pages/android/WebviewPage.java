package com.qaprosoft.carina.demo.mobile.gui.pages.android;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.ReportBugPageBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.WebviewPageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = WebviewPageBase.class)
public class WebviewPage extends WebviewPageBase {

    @FindBy(id = "com.saucelabs.mydemoapp.android:id/webViewTV")
    private ExtendedWebElement title;

    @FindBy(id = "com.saucelabs.mydemoapp.android:id/urlET")
    private ExtendedWebElement urlForm;

    public WebviewPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isWebviewPageOpen() {
        return title.isElementPresent();
    }

    @Override
    public boolean checkIsCorrectURL() {
        return false;
    }
}
