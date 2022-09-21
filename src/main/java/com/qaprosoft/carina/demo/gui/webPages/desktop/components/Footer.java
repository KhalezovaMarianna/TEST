package com.qaprosoft.carina.demo.gui.webPages.desktop.components;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.gui.webPages.common.componentsBase.FooterBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.AboutPageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = FooterBase.class)
public class Footer extends FooterBase {

    @FindBy(xpath = "//*[@id=\"fotcont\"]/div[1]//h4/b")
    ExtendedWebElement aboutUsText;

    @FindBy(xpath = "//*[@id=\"fotcont\"]/div[2]//h4/b")
    ExtendedWebElement getInTouchText;

    @FindBy(xpath = "//*[@id=\"fotcont\"]/div[3]//h4")
    ExtendedWebElement label;

    public Footer(WebDriver driver) {
        super(driver);
    }


    public String getTextAboutUs() {
        return aboutUsText.getText();
    }

    public String getTextGetInTouch() {
        return getInTouchText.getText();
    }

    public boolean getTextLabel() {

        return label.isElementPresent();
    }


}
