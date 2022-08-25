package com.qaprosoft.carina.demo.gui.webPages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.gui.webPages.base.BaseDemoblazePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class AboutUsPage extends BaseDemoblazePage {

    @FindBy(xpath = "//*[@id=\"videoModalLabel\"]")
    ExtendedWebElement aboutUsPage;

    @FindBy(xpath = "//*[@id=\"videoModal\"]//div/div[1]/button/span")
    ExtendedWebElement closeBtn;

    public AboutUsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isOpened() {
        return aboutUsPage.isElementPresent();
    }

    public HomePage clickCloseButton() {
        closeBtn.click();
        return new HomePage(getDriver());
    }
}
