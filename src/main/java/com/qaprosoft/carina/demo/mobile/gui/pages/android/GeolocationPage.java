package com.qaprosoft.carina.demo.mobile.gui.pages.android;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.utils.mobile.IMobileUtils;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.locator.ExtendedFindBy;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.GeolocationPageBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.MorePageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = GeolocationPageBase.class)
public class GeolocationPage extends GeolocationPageBase implements IMobileUtils {
    @FindBy(id = "com.android.permissioncontroller:id/permission_deny_button")
    private ExtendedWebElement popUpBtn;

    @FindBy(id = "com.saucelabs.mydemoapp.android:id/locationTV")
    private ExtendedWebElement title;

    @ExtendedFindBy(accessibilityId = "View menu")
    private ExtendedWebElement backBtn;



    public GeolocationPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return title.isElementPresent()&&backBtn.isElementPresent();
    }

    @Override
    public MorePageBase clickBackBtn() {
        backBtn.click();
        return initPage(MorePageBase.class);
    }

    @Override
    public void closePopUp() {
        popUpBtn.click();
    }
}
