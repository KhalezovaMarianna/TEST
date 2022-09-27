package com.qaprosoft.carina.demo.gui.webPages.androidWeb.components;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.gui.webPages.common.componentsBase.FooterBase;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = FooterBase.class)
public class Footer extends FooterBase {
    @FindBy(xpath = "//*[@id=\"fotcont\"]/div[1]//h4/b")
    ExtendedWebElement aboutUsText;

    @FindBy(xpath = "//*[@id=\"fotcont\"]/div[2]//h4/b")
    ExtendedWebElement getInTouchText;

    @FindBy(xpath = "//*[@id=\"fotcont\"]/div[3]//h4")
    ExtendedWebElement label;


    public Footer(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    @Override
    public String getTextAboutUs() {
        return aboutUsText.getText();
    }

    @Override
    public String getTextGetInTouch() {
        return getInTouchText.getText();
    }

    @Override
    public boolean checkTitleIsPresented() {
        return label.isElementPresent();
    }

}

