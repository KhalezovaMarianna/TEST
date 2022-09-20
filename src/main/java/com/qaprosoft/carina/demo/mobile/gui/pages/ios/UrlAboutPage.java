package com.qaprosoft.carina.demo.mobile.gui.pages.ios;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.locator.ExtendedFindBy;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.SortByPopUpPageBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.URLAboutPageBase;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = URLAboutPageBase.class)
public class UrlAboutPage extends URLAboutPageBase {

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`label == \"Address\"`]")
    private ExtendedWebElement url;

    @ExtendedFindBy(accessibilityId = "Accept All Cookies")
    private ExtendedWebElement acceptCookies;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeLink[`label == \"Home\"`][1]")
    private ExtendedWebElement title;

    public UrlAboutPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isCorrectUrlOpened() {
        if (url.getAttribute("value").contains("saucelabs.com")) {
            return true;
        } else return false;
    }

    @Override
    public boolean IsOpened() {
        acceptCookies.clickIfPresent();
        return title.isElementPresent();
    }


}
