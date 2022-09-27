package com.qaprosoft.carina.demo.testsPagesForWeb.components;

import com.qaprosoft.carina.core.foundation.utils.factory.ICustomTypePageFactory;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class Footer extends AbstractUIObject implements ICustomTypePageFactory {
    @FindBy(xpath = "//*[@id=\"fotcont\"]/div[1]//h4/b")
    ExtendedWebElement aboutUsText;

    @FindBy(xpath = "//*[@id=\"fotcont\"]/div[2]//h4/b")
    ExtendedWebElement getInTouchText;

    @FindBy(xpath = "//*[@id=\"fotcont\"]/div[3]//h4")
    ExtendedWebElement label;


    public Footer(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }


    public String getTextAboutUs() {
        return aboutUsText.getText();
    }


    public String getTextGetInTouch() {
        return getInTouchText.getText();
    }


    public boolean checkTitleIsPresented() {
        return label.isElementPresent();
    }

}