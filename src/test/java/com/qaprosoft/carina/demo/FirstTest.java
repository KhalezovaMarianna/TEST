package com.qaprosoft.carina.demo;

import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.demo.gui.webPages.*;
import com.qaprosoft.carina.demo.gui.webPages.components.HeaderMenu;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FirstTest extends BaseTest{
    @Test()
    @MethodOwner(owner = "marianna_khalezova")
    public void testMenuButtonsWorkCorrectly() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        HeaderMenu headerMenu = homePage.getHeader();
        Assert.assertTrue(homePage.isOpened(), "Home page is not opened");
        ContactPage contactPage = headerMenu.goToContactPage();
        Assert.assertTrue(contactPage.isOpened(), "Contact page isn't open");
        contactPage.closePage();
        AboutUsPage aboutUsPage = headerMenu.goToAboutPage();
        Assert.assertTrue(aboutUsPage.isOpened(), "About page isn't opened");
        aboutUsPage.clickCloseButton();
        CartPage cartPage = headerMenu.openCart();
        Assert.assertTrue(cartPage.isOpened(), "Cart isn't present");
        cartPage.goToHome();
        LogInPage logInPage = headerMenu.goToLoginPage();
        Assert.assertTrue(logInPage.isOpened(), "Login page isn't opened");
        logInPage.clickCloseButton();
        SignUpPage signUpPage = headerMenu.goToSignUpPage();
        Assert.assertTrue(signUpPage.isOpened(), "SignUp page isn't opened");
        signUpPage.clickCloseButton();
        Assert.assertTrue(homePage.isOpened(), "home page isn't return");

    }

}
