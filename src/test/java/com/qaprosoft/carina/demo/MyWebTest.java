package com.qaprosoft.carina.demo;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;

import com.qaprosoft.carina.demo.gui.webPages.*;
import com.zebrunner.agent.core.annotation.TestLabel;
import org.checkerframework.checker.units.qual.A;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

public class MyWebTest extends AbstractTest {

    @Test()
    @MethodOwner(owner = "marianna_khalezova")
    @TestLabel(name = "feature", value = {"web", "regression"})
    public void testMenuButtonsWorkCorrectly() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isHomePageOpen(), "Home page is not opened");
        ContactPage contactPage = homePage.goToContactPage();
        Assert.assertTrue(contactPage.isContactPageOpen(), "Contact page isn't open");
        contactPage.closeContactPage();
        AboutUsPage aboutUsPage = homePage.goToAboutPage();
        Assert.assertTrue(aboutUsPage.isAboutPageOpen(), "About page isn't opened");
        aboutUsPage.closeAboutUsPage();
        CartPage cartPage = homePage.goToCartPage();
        Assert.assertTrue(cartPage.isCartPageOpen(), "Cart isn't present");
        cartPage.goToHome();
        LogInPage logInPage = homePage.goToLoginPage();
        Assert.assertTrue(logInPage.isLoginPageOpen(), "Login page isn't opened");
        logInPage.closeLoginPage();
        SignUpPage signUpPage = homePage.goToSignUpPage();
        Assert.assertTrue(signUpPage.isSignUpPageOpen(), "SignUp page isn't opened");
        signUpPage.closeSignUpPage();
        Assert.assertTrue(homePage.isHomePageOpen(), "home page isn't return");

    }

    @Test()
    @MethodOwner(owner = "marianna_khalezova")
    @TestLabel(name = "feature", value = {"web", "regression"})
    public void testSlidingWindow() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isHomePageOpen(), "Home page is not opened");
        homePage.clickSliderWindow();
        Assert.assertTrue(homePage.ImgChanged(), "Img isn't changed");
        homePage.clickLeftArrowWindow();
        Assert.assertTrue(homePage.ImgReturned(), "img isn't return");

    }

    @Test()
    @MethodOwner(owner = "marianna_khalezova")
    @TestLabel(name = "feature", value = {"web", "regression"})
    public void testAddProductOnTheCart() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isHomePageOpen(), "Home page is not opened");
        int amount = (int) (Math.random() * 10);
        ProductPage productPage = homePage.productOpened(amount);
        Assert.assertTrue(productPage.isProductPageOpen(), "product isn't opened");
        productPage.addToCart();
        CartPage cartPage = productPage.openCart();
        Assert.assertTrue(cartPage.isCartPageOpen(), "cart isn't opened");
        Assert.assertTrue(cartPage.comparisonTitleAmount(), "Product isn't added");


    }

    @Test()
    @MethodOwner(owner = "marianna_khalezova")
    @TestLabel(name = "feature", value = {"web", "regression"})
    public void RegistrationForm() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isHomePageOpen(), "Home page is not opened");
        SignUpPage signUpPage = homePage.goToSignUpPage();
        Assert.assertTrue(signUpPage.isSignUpPageOpen(),"sign Up page isn't open");
        signUpPage.signUp();
        Assert.assertEquals(getDriver().switchTo().alert().getText(),"This user already exist.","Sign up successful.");

    }
    @Test()
    @MethodOwner(owner = "marianna_khalezova")
    @TestLabel(name = "feature", value = {"web", "regression"})
    public void testLogIn() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isHomePageOpen(), "Home page is not opened");
        LogInPage logInPage = homePage.goToLoginPage();
        logInPage.login();
        Assert.assertTrue(homePage.userLogIn(),"user isn't login");


    }

}
