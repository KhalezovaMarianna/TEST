package com.qaprosoft.carina.demo.web;

import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.demo.gui.webPages.common.HomePageBase;
import com.qaprosoft.carina.demo.gui.webPages.common.LoginPageBase;
import com.qaprosoft.carina.demo.gui.webPages.common.SignUpPageBase;
import com.qaprosoft.carina.demo.gui.webPages.common.componentsBase.HeaderBase;
import com.zebrunner.agent.core.annotation.TestLabel;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AuthorizationTests extends BaseTest{
    @Test()
    @MethodOwner(owner = "marianna_khalezova")
    @TestLabel(name = "feature", value = {"web", "acceptance"})
    public void testRegistrationForm() {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        Assert.assertTrue(homePage.isOpened(), "Home page is not opened");
        HeaderBase header = homePage.getHeader();
        SignUpPageBase signUpPage = header.goToSignUpPage();
        Assert.assertTrue(signUpPage.isOpened(), "sign Up page isn't open");
        signUpPage.typeName(R.TESTDATA.get("TEST_EMAIL"));
        signUpPage.typePassword(R.TESTDATA.get("TEST_PASSWORD"));
        signUpPage.clickSignUpBtn();
        Assert.assertEquals(getDriver().switchTo().alert().getText(), "This user already exist.", "Sign up successful.");
    }


    @Test()
    @MethodOwner(owner = "marianna_khalezova")
    @TestLabel(name = "feature", value = {"web", "acceptance"})
    public void testLogIn() {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        Assert.assertTrue(homePage.isOpened(), "Home page is not opened");
        HeaderBase header = homePage.getHeader();
        LoginPageBase logInPage = header.goToLoginPage();
        logInPage.typeUsername(R.TESTDATA.get("TEST_EMAIL"));
        logInPage.typePassword(R.TESTDATA.get("TEST_PASSWORD"));
        homePage = logInPage.clickLoginBtn();
        Assert.assertEquals(R.TESTDATA.get("TEST_EMAIL"), homePage.getUserName(), "User isn't true");
    }
}
