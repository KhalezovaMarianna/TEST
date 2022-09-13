package com.qaprosoft.carina.demo.mobile.gui.pages.ios;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.utils.mobile.IMobileUtils;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.locator.ExtendedFindBy;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.CheckoutPageBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.HomePageBase;
import org.openqa.selenium.WebDriver;
@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = CheckoutPageBase.class)
public class CheckoutPage extends CheckoutPageBase implements IMobileUtils {

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`label == \"To Payment\"`]")
    private ExtendedWebElement paymentBtn;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeStaticText[`label == \"Validation Error!\"`]")
    private ExtendedWebElement failText;

    @Override
    public boolean isPageOpened() {
        return paymentBtn.isElementPresent();
    }

    @Override
    public void clickPaymentBtn() {
        paymentBtn.click();

    }

    @Override
    public boolean checkPaymentFailed() {
        if (failText.format().getText().equals("Validation Error!")) {
            System.out.println("ok");
            return true;
        } else {
            System.out.println("fail");
            return false;
        }
    }
}
