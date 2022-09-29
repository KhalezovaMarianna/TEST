package com.qaprosoft.carina.demo.web.gui.webPages.pages;


import com.qaprosoft.carina.core.foundation.utils.factory.ICustomTypePageFactory;
import com.qaprosoft.carina.core.foundation.utils.mobile.IMobileUtils;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.web.gui.webPages.components.Footer;
import com.qaprosoft.carina.demo.web.gui.webPages.components.Header;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class SignUpPage extends AbstractPage implements ICustomTypePageFactory, IMobileUtils {

    @FindBy(xpath = "//*[@id=\"navbarExample\"]")
    private Header header;

    @FindBy(xpath = "//*[@id=\"footc\"]")
    private Footer footer;

    @FindBy(xpath = "//*[@id=\"signInModalLabel\"]")
    private ExtendedWebElement signUpPage;

    @FindBy(xpath = "//*[@id=\"sign-username\"]")
    private ExtendedWebElement usernameForm;

    @FindBy(xpath = "//*[@id=\"sign-password\"]")
    private ExtendedWebElement passwordForm;

    @FindBy(xpath = "//*[@id=\"signInModal\"]/div/div/div[3]/button[2]")
    private ExtendedWebElement signUpBtn;

    @FindBy(xpath = "//*[@id=\"signInModal\"]//div[1]/button")
    private ExtendedWebElement closeBtn;

    public SignUpPage(WebDriver driver) {
        super(driver);
    }


    public boolean isOpened() {
        return signUpPage.isElementPresent();
    }

    public Header getHeader() {
        return header;
    }

    public Footer getFooter() {
        return footer;
    }

    public HomePage clickCloseButton() {
        closeBtn.click();
        return new HomePage(getDriver());
    }

    public void typeName(String email) {
        usernameForm.type(email);
    }

    public void typePassword(String password) {
        passwordForm.type(password);
    }

    public void clickSignUpBtn() {
        signUpBtn.click();
    }

}
