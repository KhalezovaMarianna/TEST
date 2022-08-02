package com.qaprosoft.carina.demo.gui.webPages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class AboutUsPage extends BaseDemoblazePage {

    @FindBy(xpath = "//*[@id=\"videoModalLabel\"]")
    ExtendedWebElement aboutUsPage;

    @FindBy(xpath = "//*[@id=\"videoModal\"]/div/div/div[1]/button/span")
    ExtendedWebElement closeBtn;

    public AboutUsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isOpened() {
        return aboutUsPage.isElementPresent();
    }

    public HomePage closeAboutUsPage() {
        closeBtn.click();
        return new HomePage(getDriver());
    }
}
