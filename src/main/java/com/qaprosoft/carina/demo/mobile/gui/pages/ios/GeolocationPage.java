package com.qaprosoft.carina.demo.mobile.gui.pages.ios;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.utils.mobile.IMobileUtils;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.locator.ExtendedFindBy;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.GeolocationPageBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.MorePageBase;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = GeolocationPageBase.class)
public class GeolocationPage extends GeolocationPageBase implements IMobileUtils {

    @ExtendedFindBy(accessibilityId = "Don’t Allow")
    private ExtendedWebElement popUpGeolocationDoNotAllowBtn;

    @ExtendedFindBy(accessibilityId = "Geo Location")
    private ExtendedWebElement title;

    @ExtendedFindBy(accessibilityId = "Longitude")
    private ExtendedWebElement longitudeTitle;

    @ExtendedFindBy(accessibilityId = "Latitude")
    private ExtendedWebElement latitudeTitle;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeStaticText[`label == \"13.45143\"`]")
    private ExtendedWebElement longitudeNumber;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeStaticText[`label == \"52.50032\"`]")
    private ExtendedWebElement latitudeNumber;

    @ExtendedFindBy(accessibilityId = "BackButton Icons")
    private ExtendedWebElement backBtn;

    public GeolocationPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return latitudeNumber.isElementPresent() && latitudeTitle.getText().equals("Latitude") && longitudeNumber.isElementPresent() && longitudeTitle.getText().equals("Longitude") && title.isElementPresent();
    }

    @Override
    public MorePageBase clickBackBtn() {
        backBtn.click();
        return initPage(MorePageBase.class);
    }

    @Override
    public void closePopUp() {
        popUpGeolocationDoNotAllowBtn.clickIfPresent();
    }
}
