package com.qaprosoft.carina.demo.mobile.gui.pages.ios;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.locator.ExtendedFindBy;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.ReportBugPageBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.WebviewPageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = WebviewPageBase.class)
public class WebviewPage extends WebviewPageBase {

    @ExtendedFindBy(accessibilityId = "Webview")
    private ExtendedWebElement title;

    @FindBy(xpath = "//XCUIElementTypeOther[@name=\"Webview-screen\"]/XCUIElementTypeOther[2]/XCUIElementTypeTextField")
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
