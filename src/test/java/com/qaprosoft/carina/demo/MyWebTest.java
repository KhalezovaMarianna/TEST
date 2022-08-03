package com.qaprosoft.carina.demo;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.demo.gui.webPages.*;
import com.qaprosoft.carina.demo.gui.webPages.components.HeaderMenu;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MyWebTest extends AbstractTest {

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
        aboutUsPage.closePage();
        CartPage cartPage = headerMenu.goToCartPage();
        Assert.assertTrue(cartPage.isOpened(), "Cart isn't present");
        cartPage.goToHome();
        LogInPage logInPage = headerMenu.goToLoginPage();
        Assert.assertTrue(logInPage.isOpened(), "Login page isn't opened");
        logInPage.closePage();
        SignUpPage signUpPage = headerMenu.goToSignUpPage();
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
        Assert.assertTrue(homePage.isImgChanged(), "Img isn't changed");
        homePage.clickLeftArrowWindow();
        Assert.assertTrue(homePage.isImgChanged(), "Img isn't returned");

    }

    @Test()
    @MethodOwner(owner = "marianna_khalezova")
    public void testAddProductOnTheCart() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isOpened(), "Home page is not opened");
        int index = (int) (Math.random() * 10);
        ProductPage productPage = homePage.productOpenedByIndex(index);
        Assert.assertTrue(productPage.isOpened(), "product isn't opened");
        productPage.addToCart();
        HeaderMenu headerMenu = homePage.getHeader();
        CartPage cartPage = headerMenu.goToCartPage();
        Assert.assertTrue(cartPage.isOpened(), "cart isn't opened");
        Assert.assertTrue(cartPage.comparisonTitleAmount(), "Product isn't added");

    }

    @Test()
    @MethodOwner(owner = "marianna_khalezova")
    public void RegistrationForm() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isOpened(), "Home page is not opened");
        HeaderMenu headerMenu = homePage.getHeader();
        SignUpPage signUpPage = headerMenu.goToSignUpPage();
        Assert.assertTrue(signUpPage.isOpened(), "sign Up page isn't open");
        signUpPage.typeName(R.TESTDATA.get("TEST_EMAIL"));
        signUpPage.typePassword(R.TESTDATA.get("TEST_PASSWORD"));
        signUpPage.clickSignUpBtn();
        Assert.assertEquals(getDriver().switchTo().alert().getText(), "This user already exist.", "Sign up successful.");

    }

    @Test()
    @MethodOwner(owner = "marianna_khalezova")
    public void testLogIn() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isOpened(), "Home page is not opened");
        HeaderMenu headerMenu = homePage.getHeader();
        LogInPage logInPage = headerMenu.goToLoginPage();
        logInPage.typeUsername(R.TESTDATA.get("TEST_EMAIL"));
        logInPage.typePassword(R.TESTDATA.get("TEST_PASSWORD"));
        homePage = logInPage.clickLoginBtn();
        Assert.assertEquals(R.TESTDATA.get("TEST_EMAIL"), homePage.getUserName(), "User isn't true");
    }

}
