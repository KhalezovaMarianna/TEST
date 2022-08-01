package com.qaprosoft.carina.demo.gui.webPages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class SignUpPage extends AbstractPage {
    @FindBy (xpath = "//*[@id=\"signInModalLabel\"]")
    ExtendedWebElement signUpPage;

    @FindBy(xpath = "//*[@id=\"signInModal\"]//div[1]/button")
    ExtendedWebElement closeBtn;
    public SignUpPage(WebDriver driver) {
        super(driver);
    }

    public boolean isSignUpPageOpen() {
        signUpPage.isElementPresent();
        return true;
    }
    public HomePage closeSignUpPage(){
        closeBtn.click();
        return new HomePage(getDriver());
    }
}
