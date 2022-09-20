package com.qaprosoft.carina.demo.mobile.gui.pages.ios;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.utils.mobile.IMobileUtils;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.locator.ExtendedFindBy;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.AboutPageBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.HomePageBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.URLAboutPageBase;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = AboutPageBase.class)
public class AboutPage extends AboutPageBase implements IMobileUtils {

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`name == \"About-screen\"`]/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeButton")
    private ExtendedWebElement backBtn;
    @ExtendedFindBy(accessibilityId = "Robot Icons")
    private ExtendedWebElement aboutPicture;

    @ExtendedFindBy(accessibilityId = "About ")
    private ExtendedWebElement aboutTitle;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeStaticText[`label == \"Go to the saucelabs.com\"`]")
    private ExtendedWebElement urlAdressBtn;

    public AboutPage(WebDriver driver) {
        super(driver);
    }

    public HomePageBase clickBackBtn() {
        backBtn.click();
        return new HomePage(getDriver());

    }
    @Override
    public URLAboutPageBase goToURL() {
        urlAdressBtn.click();
        return initPage(URLAboutPageBase.class);
    }

    @Override
    public boolean isPageOpened() {

        if (aboutPicture.isElementPresent() && aboutTitle.isElementPresent()) {
            return true;
        } else {
            return false;
        }
    }

}
