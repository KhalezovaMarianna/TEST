package com.qaprosoft.carina.demo.mobile.gui.pages.ios;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.locator.ExtendedFindBy;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.MorePageBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.PopUpResetPageBase;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = PopUpResetPageBase.class)
public class PopUpResetPage extends PopUpResetPageBase {

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`label == \"RESET APP\"`]")
    private ExtendedWebElement resetBtn;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`label == \"CANCEL\"`]")
    private ExtendedWebElement continueBtn;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`label == \"OK\"`]")
    private ExtendedWebElement okBtn;

    public PopUpResetPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public MorePageBase clickResetBtn() {
        {
            resetBtn.click();
            okBtn.clickIfPresent();
        }
        return initPage(getDriver(), MorePageBase.class);
    }

    @Override
    public boolean isOpened() {

        return resetBtn.isElementPresent();
    }
}
