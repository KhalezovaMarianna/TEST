package com.qaprosoft.carina.demo;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.demo.gui.webPages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MyWebTest extends AbstractTest {

    @Test()
    @MethodOwner(owner = "marianna_khalezova")
    public void testMenuButtonsWorkCorrectly() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isOpened(), "Home page is not opened");
        ContactPage contactPage = homePage.goToContactPage();
        Assert.assertTrue(contactPage.isOpened(), "Contact page isn't open");
        contactPage.closeContactPage();
        AboutUsPage aboutUsPage = homePage.goToAboutPage();
        Assert.assertTrue(aboutUsPage.isOpened(), "About page isn't opened");
        aboutUsPage.closeAboutUsPage();
        CartPage cartPage = homePage.goToCartPage();
        Assert.assertTrue(cartPage.isOpened(), "Cart isn't present");
        cartPage.goToHome();
        LogInPage logInPage = homePage.goToLoginPage();
        Assert.assertTrue(logInPage.isOpened(), "Login page isn't opened");
        logInPage.closeLoginPage();
        SignUpPage signUpPage = homePage.goToSignUpPage();
        Assert.assertTrue(signUpPage.isOpened(), "SignUp page isn't opened");
        signUpPage.closeSignUpPage();
        Assert.assertTrue(homePage.isOpened(), "home page isn't return");

    }

    @Test()
    @MethodOwner(owner = "marianna_khalezova")
    public void testSlidingWindow() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isOpened(), "Home page is not opened");
        homePage.clickRightArrowWindow();
        Assert.assertTrue(homePage.imgChanged(), "Img isn't changed");
        homePage.clickLeftArrowWindow();
        Assert.assertFalse(homePage.imgChanged(), "Img isn't returned");

    }

    @Test()
    @MethodOwner(owner = "marianna_khalezova")
    public void testAddProductOnTheCart() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isOpened(), "Home page is not opened");
        int amount = (int) (Math.random() * 10);
        ProductPage productPage = homePage.productOpened(amount);
        Assert.assertTrue(productPage.isOpened(), "product isn't opened");
        productPage.addToCart();
        CartPage cartPage = productPage.openCart();
        Assert.assertTrue(cartPage.isOpened(), "cart isn't opened");
        Assert.assertTrue(cartPage.comparisonTitleAmount(), "Product isn't added");


    }

    @Test()
    @MethodOwner(owner = "marianna_khalezova")
    public void RegistrationForm() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isOpened(), "Home page is not opened");
        SignUpPage signUpPage = homePage.goToSignUpPage();
        Assert.assertTrue(signUpPage.isOpened(), "sign Up page isn't open");
        signUpPage.signUp();
        Assert.assertEquals(getDriver().switchTo().alert().getText(), "This user already exist.", "Sign up successful.");

    }

    @Test()
    @MethodOwner(owner = "marianna_khalezova")
    public void testLogIn() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isOpened(), "Home page is not opened");
        LogInPage logInPage = homePage.goToLoginPage();
        logInPage.login();
        Assert.assertTrue(homePage.userLogIn(), "user isn't login");


    }

}
