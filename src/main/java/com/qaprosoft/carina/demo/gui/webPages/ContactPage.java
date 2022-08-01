package com.qaprosoft.carina.demo.gui.webPages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ContactPage extends AbstractPage {
    @FindBy(xpath = "//*[@id=\"exampleModalLabel\"]")
    ExtendedWebElement newMessageForm;

    @FindBy(xpath = "//*[@id=\"exampleModal\"]/div/div/div[1]/button/span")
    ExtendedWebElement closeBtn;

    public ContactPage(WebDriver driver) {
        super(driver);
    }
    public boolean isContactPageOpen(){
        newMessageForm.isElementPresent();
        return true;
    }
    public HomePage closeContactPage(){
        closeBtn.click();
        return new HomePage(getDriver());
    }
}
