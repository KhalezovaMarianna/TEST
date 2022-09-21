package com.qaprosoft.carina.demo.gui.webPages.iosWeb;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.gui.webPages.common.ContactPageBase;
import com.qaprosoft.carina.demo.gui.webPages.common.HomePageBase;
import com.qaprosoft.carina.demo.gui.webPages.common.SignUpPageBase;
import com.qaprosoft.carina.demo.gui.webPages.common.componentsBase.FooterBase;
import com.qaprosoft.carina.demo.gui.webPages.common.componentsBase.HeaderBase;
import com.qaprosoft.carina.demo.gui.webPages.desktop.components.Footer;
import com.qaprosoft.carina.demo.gui.webPages.desktop.components.Header;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = ContactPageBase.class)
public class ContactPage extends ContactPageBase{
    @FindBy(xpath = "//*[@id=\"navbarExample\"]/ul")
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

    @Override
    public HeaderBase getHeaderBase() {
        return header;
    }

    @Override
    public FooterBase getFooterBase() {
        return footer;
    }

    @Override
    public boolean isOpened() {
        return newMessageForm.isElementPresent();
    }

    @Override
    public HomePageBase closePage() {
        closeBtn.click();
        return initPage(getDriver(),HomePageBase.class);
    }

    @Override
    public void typeName(String name) {
        nameForm.type(name);
    }

    @Override
    public void typeEmail(String email) {
        emailForm.type(email);
    }

    @Override
    public void typeMessage(String message) {
        messageForm.type(message);
    }

    @Override
    public HomePageBase clickSendMessageButton() {
        sendBtn.click();
        return initPage(getDriver(),HomePageBase.class);
    }
}
