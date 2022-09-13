package com.qaprosoft.carina.demo.mobile.gui.pages.android;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.utils.mobile.IMobileUtils;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.CheckoutPageBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.HomePageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass =CheckoutPageBase.class)
public class CheckoutPage extends CheckoutPageBase implements IMobileUtils {

    @FindBy(id = "com.saucelabs.mydemoapp.android:id/checkoutTitleTV")
    private ExtendedWebElement checkoutLabel;

    @FindBy(id = "com.saucelabs.mydemoapp.android:id/paymentBtn")
    private ExtendedWebElement paymentBtn;

    @FindBy(id = "com.saucelabs.mydemoapp.android:id/fullNameErrorTV")
    private ExtendedWebElement nameErrorText;

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return checkoutLabel.isElementPresent();
    }

    @Override
    public void clickPaymentBtn() {
        paymentBtn.click();
    }

    @Override
    public boolean checkPaymentFailed() {
        if (nameErrorText.format().getText().equals("Please provide your full name.")) {
            System.out.println("ok");
            return true;
        } else {
            System.out.println("fail");
            return false;
        }
    }


}
