package com.qaprosoft.carina.demo.mobile.gui.pages.common.utils;

import com.qaprosoft.carina.core.foundation.utils.R;

public class MobileUtils {
    public static boolean isIOS() {
        String platformName = R.CONFIG.get("capabilities.platformName");
        if (platformName.isEmpty() && platformName.length() == 0) {
            throw new RuntimeException("Cannot check platform because platformName capability is empty");
        }
        return platformName.equalsIgnoreCase("IOS");
    }
}
