package com.qaprosoft.carina.demo;

import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.demo.gui.webPages.*;
import com.qaprosoft.carina.demo.gui.webPages.components.FooterMenu;
import com.qaprosoft.carina.demo.gui.webPages.components.HeaderMenu;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MyWebTest extends BaseTest {

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
        Assert.assertTrue(homePage.showImage(2), "Img isn't changed");
        homePage.clickLeftArrowWindow();
        Assert.assertTrue(homePage.showImage(1), "Img isn't returned");

    }

    @Test()
    @MethodOwner(owner = "marianna_khalezova")
    public void testAddProductOnTheCart() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isOpened(), "Home page is not opened");
        int index = (int) (Math.random() * 10);
        pause(2);
        ProductPage productPage = homePage.productOpenedByIndex(index);
        Assert.assertTrue(productPage.isOpened(), "product isn't opened");
        productPage.addToCart();
        Assert.assertEquals(getDriver().switchTo().alert().getText(), "Product added", "product added successful.");
        getDriver().switchTo().alert().accept();
        CartPage cartPage = productPage.openCart();
        Assert.assertEquals(cartPage.getCartTotal(), cartPage.getProductPrice(), "Product isn't true on cart");
        cartPage.deleteAllProducts();
        cartPage.goToHome();
        Assert.assertTrue(homePage.isOpened(), "home page isn't opened");

    }

    @Test()
    @MethodOwner(owner = "marianna_khalezova")
    public void testRegistrationForm() {
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

    @Test()
    @MethodOwner(owner = "marianna_khalezova")
    public void testPlacingOrder() {
        ProductPage productPage = openingService.openProductByIndex();
        CartPage cartPage = productPage.openCart();
        Assert.assertTrue(cartPage.isOpened(), "cart isn't open");
        PlaceOrderPage placeOrderPage = cartPage.clickPlaceOrderBtn();
        placeOrderPage.fillingNameForm(R.TESTDATA.get("TEST_NAME"));
        placeOrderPage.fillingCartForm(R.TESTDATA.get("TEST_CARD"));
        PopUpOrderPage popUpOrderPage = placeOrderPage.sendOrder();
        Assert.assertTrue(popUpOrderPage.isOpened(), "Order isn't successful");
        HomePage homePage = popUpOrderPage.closePage();
        Assert.assertTrue(homePage.isOpened(),"home page isn't open");
        HeaderMenu headerMenu = homePage.getHeader();
        headerMenu.goToCartPage();
        Assert.assertTrue(cartPage.isCartEmpty(),"cart isn't empty");

    }
    @Test()
    @MethodOwner(owner = "marianna_khalezova")
    public void testMessageCanBeSend(){
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        HeaderMenu headerMenu = homePage.getHeader();
        ContactPage contactPage = headerMenu.goToContactPage();
        Assert.assertTrue(contactPage.isOpened(),"contact page isn't open");
        contactPage.typeName(R.TESTDATA.get("TEST_NAME"));
        contactPage.typeEmail(R.TESTDATA.get("TEST_EMAIL"));
        contactPage.typeMessage(R.TESTDATA.get("TEST_MESSAGE"));
        contactPage.sendMessage();
        Assert.assertTrue(homePage.isOpened(),"Message isn't send");


    }

    @Test()
    @MethodOwner(owner = "marianna_khalezova")
    public void testFooterIsFull(){
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        FooterMenu footerMenu = homePage.getFooter();
        Assert.assertTrue(footerMenu.equalTextAboutUs(),"about us isn't found");
        Assert.assertTrue(footerMenu.equalTextGetInTouch(),"get in touch isn't find");
        Assert.assertTrue((footerMenu.equalTextLabel()),"label isn't find");


    }

}
