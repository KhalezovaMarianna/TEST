package com.qaprosoft.carina.demo.mobile.gui.pages.android;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.utils.mobile.IMobileUtils;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.GeolocationPageBase;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = GeolocationPageBase.class)
public class GeolocationPage extends GeolocationPageBase implements IMobileUtils {

    public GeolocationPage(WebDriver driver) {
        super(driver);
    }
}
