package com.qaprosoft.carina.demo.mobile.gui.pages.android;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.utils.mobile.IMobileUtils;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.CheckoutPageBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.HomePageBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.components.KeyboardBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.components.Keyboard;
import io.appium.java_client.android.nativekey.AndroidKey;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = CheckoutPageBase.class)
public class CheckoutPage extends CheckoutPageBase implements IMobileUtils {
    static final Logger LOGGER = LogManager.getLogger(CheckoutPage.class);
    @FindBy(id = "com.saucelabs.mydemoapp.android:id/checkoutTitleTV")
    private ExtendedWebElement checkoutLabel;

    @FindBy(id = "com.saucelabs.mydemoapp.android:id/paymentBtn")
    private ExtendedWebElement paymentBtn;

    @FindBy(id = "com.saucelabs.mydemoapp.android:id/fullNameET")
    private ExtendedWebElement nameForm;

    @FindBy(id = "com.saucelabs.mydemoapp.android:id/zipET")
    private ExtendedWebElement zipCodeForm;


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

    @Override
    public void clickNameForm() {
        nameForm.click();
    }

    @Override
    public KeyboardBase getKeyboard() {
        Keyboard keyboard = new Keyboard(getDriver());
        keyboard.getKeys().stream().forEach(f -> LOGGER.info(f));
        return initPage(getDriver(), KeyboardBase.class);
    }

    @Override
    public void closeKeyboard() {
        getDriver().navigate().back();
    }

    @Override
    public boolean fillZipForm(String zipCode) {
        zipCodeForm.type(zipCode);
        List<String> splitZipCode = List.of(zipCode.split(""));
        if (splitZipCode.size() == 5) {
            return true;
        } else {
            return false;
        }
    }
}
