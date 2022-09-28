package com.qaprosoft.carina.demo.web.gui.webPages.pages;


import com.qaprosoft.carina.core.foundation.utils.factory.ICustomTypePageFactory;
import com.qaprosoft.carina.core.foundation.utils.mobile.IMobileUtils;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.web.gui.webPages.components.Footer;
import com.qaprosoft.carina.demo.web.gui.webPages.components.Header;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ContactPage extends AbstractPage implements ICustomTypePageFactory, IMobileUtils {
    @FindBy(xpath = "//*[@id=\"navbarExample\"]")
    private Header header;

    @FindBy(xpath = "//*[@id=\"footc\"]")
    private Footer footer;

    @FindBy(xpath = "//*[@id=\"exampleModalLabel\"]")
    ExtendedWebElement newMessageForm;

    @FindBy(xpath = "//*[@id=\"exampleModal\"]/div/div/div[1]/button/span")
    ExtendedWebElement closeBtn;

    @FindBy(xpath = "//*[@id=\"recipient-email\"]")
    ExtendedWebElement emailForm;

    @FindBy(xpath = "//*[@id=\"recipient-name\"]")
    ExtendedWebElement nameForm;

    @FindBy(xpath = "//*[@id=\"message-text\"]")
    ExtendedWebElement messageForm;

    @FindBy(xpath = "//*[@id=\"exampleModal\"]//button[2]")
    ExtendedWebElement sendBtn;

    public ContactPage(WebDriver driver) {
        super(driver);
    }



    public boolean isOpened() {
        return newMessageForm.isElementPresent();
    }


    public Header getHeader() {
        return header;
    }


    public Footer getFooter() {
        return footer;
    }


    public HomePage closePage() {
        closeBtn.click();
        return new HomePage(getDriver());
    }


    public void typeName(String name) {
        nameForm.type(name);
    }


    public void typeEmail(String email) {
        emailForm.type(email);
    }


    public void typeMessage(String message) {
        messageForm.type(message);
    }


    public HomePage clickSendMessageButton() {
        sendBtn.click();
        return new HomePage(getDriver());
    }
}
