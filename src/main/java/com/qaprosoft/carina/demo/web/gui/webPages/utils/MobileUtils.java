package com.qaprosoft.carina.demo.web.gui.webPages.utils;

import com.qaprosoft.carina.core.foundation.utils.R;

public class MobileUtils {
    public static boolean isIOS() {
        String platformName = R.CONFIG.get("capabilities.platformName");
        if (platformName.isEmpty() && platformName.length() == 0) {
            throw new RuntimeException("Cannot check platform because platformName capability is empty");
        }
        return platformName.equalsIgnoreCase("IOS");
    }
    public static boolean isAndroid() {
        String platformName = R.CONFIG.get("capabilities.platformName");
        if (platformName.isEmpty() && platformName.length() == 0) {
            throw new RuntimeException("Cannot check platform because platformName capability is empty");
        }
        return platformName.equalsIgnoreCase("ANDROID");
    }
}
