package com.qaprosoft.carina.demo.gui.webPages.iosWeb;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.gui.webPages.common.ResultPageBase;
import com.qaprosoft.carina.demo.gui.webPages.common.componentsBase.FooterBase;
import com.qaprosoft.carina.demo.gui.webPages.common.componentsBase.HeaderBase;

import com.qaprosoft.carina.demo.gui.webPages.iosWeb.components.Footer;
import com.qaprosoft.carina.demo.gui.webPages.iosWeb.components.Header;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = ResultPageBase.class)
public class ResultPage extends ResultPageBase{
    @FindBy(xpath = "//*[@id=\"navbarExample\"]")
    private Header header;

    @FindBy(xpath = "//*[@id=\"footc\"]")
    private Footer footer;
    @FindBy(xpath = "//*[@id=\"cat\"]")
    private ExtendedWebElement categories;


    public ResultPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isOpened() {
        return categories.isElementPresent();
    }

    @Override
    public HeaderBase getHeader() {
        return header;
    }

    @Override
    public FooterBase getFooter() {
        return footer;
    }



}
