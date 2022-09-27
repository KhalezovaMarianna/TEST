package com.qaprosoft.carina.demo.web;

import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.core.foundation.utils.tag.Priority;
import com.qaprosoft.carina.core.foundation.utils.tag.TestPriority;
import com.qaprosoft.carina.core.foundation.webdriver.device.Device;
import com.qaprosoft.carina.demo.gui.webPages.common.*;
import com.qaprosoft.carina.demo.gui.webPages.common.componentsBase.FooterBase;
import com.qaprosoft.carina.demo.gui.webPages.common.componentsBase.HeaderBase;

import com.qaprosoft.carina.demo.gui.webPages.iosWeb.HomePage;
import com.qaprosoft.carina.demo.gui.webPages.utils.MobileUtils;
import com.zebrunner.agent.core.annotation.TestLabel;
import com.zebrunner.agent.core.annotation.TestRailCaseId;
import com.zebrunner.agent.core.annotation.XrayTestKey;
import com.zebrunner.agent.core.registrar.Xray;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class MyWebTest extends BaseTest {

    @Test()
    @MethodOwner(owner = "marianna_khalezova")
    @TestLabel(name = "feature", value = {"web", "acceptance"})
    public void testMenuButtonsWorkCorrectly() {

        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        HeaderBase header = homePage.getHeader();
        Assert.assertTrue(homePage.isOpened(), "Home page is not opened");
        ContactPageBase contactPage = header.goToContactPage();
        Assert.assertTrue(contactPage.isOpened(), "Contact page isn't open");
        contactPage.closePage();
        AboutUsPageBase aboutUsPage = header.goToAboutPage();
        Assert.assertTrue(aboutUsPage.isOpened(), "About page isn't opened");
        aboutUsPage.clickCloseButton();
        CartPageBase cartPage = header.openCart();
        Assert.assertTrue(cartPage.isOpened(), "Cart isn't present");
        cartPage.goToHome();
        LoginPageBase logInPage = header.goToLoginPage();
        Assert.assertTrue(logInPage.isOpened(), "Login page isn't opened");
        logInPage.clickCloseButton();
        SignUpPageBase signUpPage = header.goToSignUpPage();
        Assert.assertTrue(signUpPage.isOpened(), "SignUp page isn't opened");
        signUpPage.clickCloseButton();
        Assert.assertTrue(homePage.isOpened(), "home page isn't return");

    }

    @Test()
    @MethodOwner(owner = "marianna_khalezova")
    @TestLabel(name = "feature", value = {"web", "acceptance"})
    public void testSlidingWindow() {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        Assert.assertTrue(homePage.isOpened(), "Home page is not opened");
        homePage.clickRightArrowWindow();
        if (MobileUtils.isIOS()) {
            Assert.assertTrue(homePage.isImageShow(1));
        } else {
            Assert.assertTrue(homePage.isImageShow(2), "Img isn't changed");
            homePage.clickLeftArrowWindow();
            Assert.assertTrue(homePage.isImageShow(1), "Img isn't returned");
        }
    }

    @Test()
    @MethodOwner(owner = "marianna_khalezova")
    @TestLabel(name = "feature", value = {"web", "acceptance"})
    public void testAddProductOnTheCart() {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        Assert.assertTrue(homePage.isOpened(), "Home page is not opened");
        int index = (int) (Math.random() * 10);
        pause(2);
        ProductPageBase productPage = homePage.productOpenedByIndex(index);
        Assert.assertTrue(productPage.isOpened(), "product isn't opened");
        productPage.clickAddToCartButton();
        Assert.assertEquals(getDriver().switchTo().alert().getText(), "Product added", "product added successful.");
        getDriver().switchTo().alert().accept();
        HeaderBase header = productPage.getHeader();
        CartPageBase cartPage = header.openCart();
        pause(5);
        Assert.assertEquals(cartPage.getCartTotal(), cartPage.getProductPrice(), "Product isn't true on cart");
        cartPage.deleteAllProducts();
        Assert.assertTrue(cartPage.isCartEmpty(), "Cart isn't empty");
        cartPage.goToHome();
        Assert.assertTrue(homePage.isOpened(), "Home page isn't opened");

    }

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

    @Test()
    @MethodOwner(owner = "marianna_khalezova")
    @TestLabel(name = "feature", value = {"web", "acceptance"})
    public void testPlacingOrder() {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        Assert.assertTrue(homePage.isOpened(), "Home page is not opened");
        int index = (int) (Math.random() * 10);
        ProductPageBase productPage = homePage.productOpenedByIndex(index);
        Assert.assertTrue(productPage.isOpened(), "product isn't opened");
        productPage.clickAddToCartButton();
        HeaderBase header = productPage.getHeader();
        Assert.assertEquals(getDriver().switchTo().alert().getText(), "Product added", "Product added");
        getDriver().switchTo().alert().accept();
        CartPageBase cartPage = header.openCart();
        Assert.assertTrue(cartPage.isOpened(), "cart isn't open");
        PlaceOrderPageBase placeOrderPage = cartPage.clickPlaceOrderBtn();
        placeOrderPage.filledNameForm(R.TESTDATA.get("TEST_NAME"));
        placeOrderPage.filledCartForm(R.TESTDATA.get("TEST_CARD"));
        PopUpOrderPageBase popUpOrderPage = placeOrderPage.clickSendOrderButton();
        Assert.assertTrue(popUpOrderPage.isOpened(), "Order isn't successful");
        popUpOrderPage.closePage();
        Assert.assertTrue(homePage.isOpened(), "home page isn't open");
        header.openCart();
        Assert.assertTrue(cartPage.isCartEmpty(), "cart isn't empty");

    }

    @Test()
    @MethodOwner(owner = "marianna_khalezova")
    @TestLabel(name = "feature", value = {"web", "acceptance"})
    public void testMessageCanBeSend() {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        HeaderBase header = homePage.getHeader();
        ContactPageBase contactPage = header.goToContactPage();
        Assert.assertTrue(contactPage.isOpened(), "contact page isn't open");
        contactPage.typeName(R.TESTDATA.get("TEST_NAME"));
        contactPage.typeEmail(R.TESTDATA.get("TEST_EMAIL"));
        contactPage.typeMessage(R.TESTDATA.get("TEST_MESSAGE"));
        contactPage.clickSendMessageButton();
        if (MobileUtils.isAndroid()) {
            Assert.assertEquals(getDriver().switchTo().alert().getText(), "Thanks for the message!!", "Thanks for the message!!");
            getDriver().switchTo().alert().accept();
            Assert.assertTrue(homePage.isOpened(), "Message isn't send");
        } else {
            Assert.assertTrue(homePage.isOpened(), "Message isn't send");
        }


    }

    @Test()
    @MethodOwner(owner = "marianna_khalezova")
    @TestLabel(name = "feature", value = {"web", "acceptance"})
    public void testFooterIsFull() {
        String aboutUs = "About Us";
        String getInTouch = "Get in Touch";
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        FooterBase footer = homePage.getFooter();
        Assert.assertEquals(footer.getTextAboutUs(), aboutUs, "about us isn't found");
        Assert.assertEquals(footer.getTextGetInTouch(), getInTouch, "get in touch isn't find");
        Assert.assertTrue(footer.checkTitleIsPresented(), "label isn't find");


    }

    @Test()
    @MethodOwner(owner = "marianna_khalezova")
    @TestLabel(name = "feature", value = {"web", "acceptance"})
    public void testPlacingOrderIsNotSuccessful() {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        Assert.assertTrue(homePage.isOpened(), "Home page is not opened");
        int index = (int) (Math.random() * 10);
        ProductPageBase productPage = homePage.productOpenedByIndex(index);
        Assert.assertTrue(productPage.isOpened(), "product isn't opened");
        productPage.clickAddToCartButton();
        HeaderBase header = productPage.getHeader();
        Assert.assertEquals(getDriver().switchTo().alert().getText(), "Product added", "product added successful.");
        getDriver().switchTo().alert().accept();
        CartPageBase cartPage = header.openCart();
        Assert.assertTrue(cartPage.isOpened(), "cart isn't open");
        PlaceOrderPageBase placeOrderPage = cartPage.clickPlaceOrderBtn();
        placeOrderPage.clickSendOrderWithEmptyForms();
        Assert.assertEquals(getDriver().switchTo().alert().getText(), "Please fill out Name and Creditcard.", "Please fill out Name and Creditcard.");
        getDriver().switchTo().alert().accept();
        Assert.assertTrue(placeOrderPage.isOpened(), "order is successful");


    }

    @Test()
    @MethodOwner(owner = "marianna_khalezova")
    @TestLabel(name = "feature", value = {"web", "acceptance"})
    public void testProductOnTheCart() {
        HomePageBase homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isOpened(), "Home page is not opened");
        int index = (int) (Math.random() * 10);
        pause(2);
        ProductPageBase productPage = homePage.productOpenedByIndex(index);
        Assert.assertTrue(productPage.isOpened(), "product isn't opened");
        productPage.clickAddToCartButton();
        Assert.assertEquals(getDriver().switchTo().alert().getText(), "Product added", "product added successful.");
        getDriver().switchTo().alert().accept();
        HeaderBase header = productPage.getHeader();
        CartPageBase cartPage = header.openCart();
        pause(5);
        Assert.assertEquals(cartPage.getCartTotal(), cartPage.getProductPrice(), "Product isn't true on cart");
        cartPage.deleteProductByIndex("1");
        cartPage.goToHome();
        Assert.assertTrue(homePage.isOpened(), "home page isn't opened");

    }
}
