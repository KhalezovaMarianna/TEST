package com.qaprosoft.carina.demo.gui.webPages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class LogInPage extends AbstractPage {
    @FindBy(xpath = "//*[@id=\"logInModalLabel\"]")
    ExtendedWebElement loginPage;
    @FindBy(xpath = "//*[@id=\"logInModal\"]/div/div/div[1]/button")
    ExtendedWebElement closeBtn;

    public LogInPage(WebDriver driver) {
        super(driver);
    }

    public boolean isLoginPageOpen(){
        loginPage.isElementPresent();
        return true;
    }

    public HomePage closeLoginPage(){
        closeBtn.click();
        return new HomePage(getDriver());
    }
}
