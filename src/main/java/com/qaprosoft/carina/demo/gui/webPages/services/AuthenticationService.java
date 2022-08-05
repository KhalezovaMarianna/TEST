package com.qaprosoft.carina.demo.gui.webPages.services;

import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.core.foundation.webdriver.IDriverPool;
import com.qaprosoft.carina.demo.gui.webPages.HomePage;
import com.qaprosoft.carina.demo.gui.webPages.LogInPage;
import com.qaprosoft.carina.demo.gui.webPages.SignUpPage;
import com.qaprosoft.carina.demo.gui.webPages.components.HeaderMenu;
import org.testng.Assert;

public class AuthenticationService implements IDriverPool {

    private final static String USERNAME = R.TESTDATA.get("TEST_EMAIL");

    private final static String PASSWORD = R.TESTDATA.get("TEST_PASSWORD");

    public void signUp() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isOpened(), "Home page is not opened");
        HeaderMenu headerMenu = homePage.getHeader();
        SignUpPage signUpPage = headerMenu.goToSignUpPage();
        Assert.assertTrue(signUpPage.isOpened(), "sign Up page isn't open");
        signUpPage.typeName(USERNAME);
        signUpPage.typePassword(PASSWORD);
    }

    public HomePage login() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isOpened(), "Home page is not opened");
        HeaderMenu headerMenu = homePage.getHeader();
        LogInPage logInPage = headerMenu.goToLoginPage();
        logInPage.typeUsername(USERNAME);
        logInPage.typePassword(PASSWORD);
        return logInPage.clickLoginBtn();

    }
}
