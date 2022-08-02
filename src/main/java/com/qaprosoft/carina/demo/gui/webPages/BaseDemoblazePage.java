package com.qaprosoft.carina.demo.gui.webPages;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class BaseDemoblazePage extends AbstractPage {

    public BaseDemoblazePage(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isOpened();
}
