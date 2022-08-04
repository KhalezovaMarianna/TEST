package com.qaprosoft.carina.demo.gui.webPages.base;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.qaprosoft.carina.demo.gui.webPages.components.HeaderMenu;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public abstract class BaseDemoblazePage extends AbstractPage {
    @FindBy(xpath = "//*[@id=\"narvbarx\"]")
    private HeaderMenu header;

    public BaseDemoblazePage(WebDriver driver) {
        super(driver);
    }


    public HeaderMenu getHeader() {
        return header;
    }

    public abstract boolean isOpened();
}
