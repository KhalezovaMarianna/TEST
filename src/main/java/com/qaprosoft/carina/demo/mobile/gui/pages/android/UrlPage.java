package com.qaprosoft.carina.demo.mobile.gui.pages.android;

import com.qaprosoft.carina.core.foundation.utils.XmlFormatter;
import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.locator.ExtendedFindBy;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.ReportBugPageBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.URLAboutPageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import javax.xml.xpath.XPath;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = URLAboutPageBase.class)
public class UrlPage extends URLAboutPageBase {

    @ExtendedFindBy(accessibilityId = "Web View")
    private ExtendedWebElement title;

    @FindBy(id = "com.android.chrome:id/url_bar")
    private ExtendedWebElement url;

    public UrlPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isCorrectUrlOpened() {
        if (url.getText().contains("saucelabs.com")) {
            return true;
        } else return false;
    }

    @Override
    public boolean IsPageOpen() {
        return title.isElementPresent();
    }
}
