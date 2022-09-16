package com.qaprosoft.carina.demo.mobile.gui.pages.ios;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.utils.mobile.IMobileUtils;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.locator.ExtendedFindBy;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.CheckoutPageBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.components.KeyboardBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.components.Keyboard;
import org.apache.logging.log4j.LogManager;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;


@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = CheckoutPageBase.class)
public class CheckoutPage extends CheckoutPageBase implements IMobileUtils {
    static final Logger LOGGER = LogManager.getLogger(CheckoutPage.class);

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`label == \"To Payment\"`]")
    private ExtendedWebElement paymentBtn;

    @ExtendedFindBy(accessibilityId = "Enter a shipping address")
    private ExtendedWebElement emptyPlace;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeTextField[`value == \"Rebecca Winter\"`]")
    private ExtendedWebElement nameForm;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeStaticText[`label == \"Validation Error!\"`]")
    private ExtendedWebElement failText;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeTextField[`value == \"89750\"`]")
    private ExtendedWebElement zipCodeForm;

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
        emptyPlace.click();
    }

    @Override
    public boolean fillZipForm(String zipCode) {//getText
        zipCodeForm.type(zipCode);
        List<String> splitZipCode = List.of(zipCode.split(""));
        if (splitZipCode.size() == 5) {
            return true;
        } else {
            return false;
        }
    }
}
