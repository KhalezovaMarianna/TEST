package com.qaprosoft.carina.demo.gui.webPages.utils;

import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.core.foundation.webdriver.IDriverPool;
import com.qaprosoft.carina.demo.gui.webPages.common.HomePageBase;
import com.qaprosoft.carina.demo.gui.webPages.common.LoginPageBase;
import com.qaprosoft.carina.demo.gui.webPages.common.SignUpPageBase;
import com.qaprosoft.carina.demo.gui.webPages.common.componentsBase.HeaderBase;

import com.qaprosoft.carina.demo.gui.webPages.iosWeb.HomePage;
import org.testng.Assert;

public class AuthenticationService implements IDriverPool {

    private final static String USERNAME = R.TESTDATA.get("TEST_EMAIL");

    private final static String PASSWORD = R.TESTDATA.get("TEST_PASSWORD");

    public void signUp() {
        HomePageBase homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isOpened(), "Home page is not opened");
        HeaderBase header = homePage.getHeader();
        SignUpPageBase signUpPage = header.goToSignUpPage();
        Assert.assertTrue(signUpPage.isOpened(), "sign Up page isn't open");
        signUpPage.typeName(USERNAME);
        signUpPage.typePassword(PASSWORD);
    }

    public HomePageBase login() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isOpened(), "Home page is not opened");
        HeaderBase header = homePage.getHeader();
        LoginPageBase logInPage = header.goToLoginPage();
        logInPage.typeUsername(USERNAME);
        logInPage.typePassword(PASSWORD);
        return logInPage.clickLoginBtn();

    }
}
