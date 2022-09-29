package com.qaprosoft.carina.demo.web.gui.webPages.pages;


import com.qaprosoft.carina.core.foundation.utils.factory.ICustomTypePageFactory;
import com.qaprosoft.carina.core.foundation.utils.mobile.IMobileUtils;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.web.gui.webPages.components.Footer;
import com.qaprosoft.carina.demo.web.gui.webPages.components.Header;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPage implements ICustomTypePageFactory, IMobileUtils {

    @FindBy(xpath = "//*[@id=\"navbarExample\"]")
    private Header header;

    @FindBy(xpath = "//*[@id=\"footc\"]")
    private Footer footer;

    @FindBy(xpath = "//*[@id=\"logInModalLabel\"]")
    private ExtendedWebElement loginPage;

    @FindBy(xpath = "//*[@id=\"logInModal\"]/div/div/div[1]/button")
    private ExtendedWebElement closeBtn;

    @FindBy(xpath = "//*[@id=\"loginusername\"]")
    private ExtendedWebElement usernameForm;

    @FindBy(xpath = "//*[@id=\"loginpassword\"]")
    private ExtendedWebElement passwordForm;

    @FindBy(xpath = "//*[@id=\"logInModal\"]//button[2]")
    private ExtendedWebElement loginBtn;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public boolean isOpened() {
        return loginPage.isElementPresent();
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

    public void typeUsername(String email) {
        usernameForm.type(email);
    }

    public void typePassword(String password) {
        passwordForm.type(password);
    }

    public HomePage clickLoginBtn() {
        loginBtn.click();
        return new HomePage(getDriver());
    }
}
