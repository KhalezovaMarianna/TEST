package com.qaprosoft.carina.demo.mobile.gui.pages.components;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.CheckoutPageBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.components.KeyboardBase;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = KeyboardBase.class)
public class Keyboard extends KeyboardBase {

    @FindBy(xpath = "//XCUIElementTypeKey||//XCUIElementTypeButton")
    private List<ExtendedWebElement> keys;

    public Keyboard(WebDriver driver) {
        super(driver);
    }

    public List<ExtendedWebElement> getKeys() {
        return keys;
    }

}
