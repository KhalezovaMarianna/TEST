package com.qaprosoft.carina.demo.gui.webPages.desktop;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.gui.webPages.base.BaseDemoblazePage;
import com.qaprosoft.carina.demo.gui.webPages.common.HomePageBase;
import com.qaprosoft.carina.demo.gui.webPages.common.LoginPageBase;
import com.qaprosoft.carina.demo.gui.webPages.common.componentsBase.FooterBase;
import com.qaprosoft.carina.demo.gui.webPages.common.componentsBase.HeaderBase;
import com.qaprosoft.carina.demo.gui.webPages.desktop.HomePage;
import com.qaprosoft.carina.demo.gui.webPages.desktop.components.Footer;
import com.qaprosoft.carina.demo.gui.webPages.desktop.components.Header;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = LoginPageBase.class)
public class LogInPage extends LoginPageBase {

    @FindBy(xpath = "//*[@id=\"navbarExample\"]/ul")
    private Header header;

    @FindBy(xpath = "//*[@id=\"footc\"]")
    private Footer footer;
    @FindBy(xpath = "//*[@id=\"logInModalLabel\"]")
    ExtendedWebElement loginPage;

    @FindBy(xpath = "//*[@id=\"logInModal\"]/div/div/div[1]/button")
    ExtendedWebElement closeBtn;

    @FindBy(xpath = "//*[@id=\"loginusername\"]")
    ExtendedWebElement usernameForm;

    @FindBy(xpath = "//*[@id=\"loginpassword\"]")
    ExtendedWebElement passwordForm;

    @FindBy(xpath = "//*[@id=\"logInModal\"]//button[2]")
    ExtendedWebElement loginBtn;

    public LogInPage(WebDriver driver) {
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

        return loginPage.isElementPresent();
    }

    @Override
    public HomePageBase clickCloseButton() {
        closeBtn.click();
        return initPage(getDriver(), HomePageBase.class);
    }

    @Override
    public void typeUsername(String email) {
        usernameForm.type(email);
    }

    @Override
    public void typePassword(String password) {
        passwordForm.type(password);
    }

    @Override
    public HomePageBase clickLoginBtn() {
        loginBtn.click();
        return initPage(getDriver(), HomePageBase.class);
    }
}
