package com.qaprosoft.carina.demo.web.gui.webPages.utils;

import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.core.foundation.webdriver.IDriverPool;


import com.qaprosoft.carina.demo.web.gui.webPages.components.Header;
import com.qaprosoft.carina.demo.web.gui.webPages.pages.HomePage;
import com.qaprosoft.carina.demo.web.gui.webPages.pages.LoginPage;
import com.qaprosoft.carina.demo.web.gui.webPages.pages.SignUpPage;
import org.testng.Assert;

public class AuthenticationService implements IDriverPool {

    private final static String USERNAME = R.TESTDATA.get("TEST_EMAIL");

    private final static String PASSWORD = R.TESTDATA.get("TEST_PASSWORD");

    public void signUp() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isOpened(), "Home page is not opened");
        Header header = homePage.getHeader();
        SignUpPage signUpPage = header.goToSignUpPage();
        Assert.assertTrue(signUpPage.isOpened(), "sign Up page isn't open");
        signUpPage.typeName(USERNAME);
        signUpPage.typePassword(PASSWORD);
    }

    public HomePage login() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isOpened(), "Home page is not opened");
        Header header = homePage.getHeader();
        LoginPage logInPage = header.goToLoginPage();
        logInPage.typeUsername(USERNAME);
        logInPage.typePassword(PASSWORD);
        return logInPage.clickLoginBtn();

    }
}
