package com.qaprosoft.carina.demo.gui.webPages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.gui.webPages.base.BaseDemoblazePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class PopUpOrderPage extends BaseDemoblazePage {

    @FindBy(xpath = "/html/body/div[10]/div[7]/div/button")
    ExtendedWebElement okBtn;

    @FindBy(xpath = "//div[10]/h2")
    ExtendedWebElement title;

    public PopUpOrderPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isOpened() {
        return title.isElementPresent();
    }

    public HomePage closePage() {
        okBtn.click();
        return new HomePage(getDriver());
    }
}
