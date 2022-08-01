package com.qaprosoft.carina.demo;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;

import com.qaprosoft.carina.demo.gui.webPages.*;
import com.zebrunner.agent.core.annotation.TestLabel;
import org.checkerframework.checker.units.qual.A;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MyWebTest extends AbstractTest {

    @Test()
    @MethodOwner(owner = "qpsdemo")
    @TestLabel(name = "feature", value = {"web", "regression"})
    public void testMenuButtonsWorkCorrectly() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isHomePageOpen(), "Home page is not opened");
        ContactPage contactPage = homePage.goToContactPage();
        Assert.assertTrue(contactPage.isContactPageOpen(), "Contact page isn't open");
        contactPage.closeContactPage();
        AboutUsPage aboutUsPage = homePage.goToAboutPage();
        Assert.assertTrue(aboutUsPage.isAboutPageOpen(), "About page isn't open");
        aboutUsPage.closeAboutUsPage();
        CartPage cartPage = homePage.goToCartPage();
        Assert.assertTrue(cartPage.isCartPageOpen(), "Cart isn't present");
        cartPage.goToHome();
        LogInPage logInPage = homePage.goToLoginPage();
        Assert.assertTrue(logInPage.isLoginPageOpen(),"Login page isn't open");
        logInPage.closeLoginPage();
        SignUpPage signUpPage = homePage.goToSignUpPage();
        Assert.assertTrue(signUpPage.isSignUpPageOpen(),"SignUp page isn't open");
        signUpPage.closeSignUpPage();
        Assert.assertTrue(homePage.isHomePageOpen(),"home page isn't return");


    }
}
