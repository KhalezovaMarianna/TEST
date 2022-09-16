package com.qaprosoft.carina.demo.mobile.gui.pages.ios;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.locator.ExtendedFindBy;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.MorePageBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.ReportBugPageBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.WebviewPageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = WebviewPageBase.class)
public class WebviewPage extends WebviewPageBase {

    @ExtendedFindBy(accessibilityId = "Webview")
    private ExtendedWebElement title;

    @ExtendedFindBy(accessibilityId = "BackButton Icons")
    private ExtendedWebElement backBtn;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeTextField")
    private ExtendedWebElement urlForm;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`label == \"Go To Site\"`]")
    private ExtendedWebElement goToSiteBtn;

    public WebviewPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isWebviewPageOpen() {
        if (title.isElementPresent() && goToSiteBtn.isElementPresent() && urlForm.isElementPresent()) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean checkIsCorrectURL(String url) {
        urlForm.type(url);
        String str = url.substring(0, 8);
        if (str.equals("https://")) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public MorePageBase clickBackBtn() {
        backBtn.click();
        return initPage(MorePageBase.class);
    }
}

