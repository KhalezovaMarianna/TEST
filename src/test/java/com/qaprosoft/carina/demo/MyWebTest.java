package com.qaprosoft.carina.demo;

import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.core.foundation.utils.tag.Priority;
import com.qaprosoft.carina.core.foundation.utils.tag.TestPriority;
import com.qaprosoft.carina.demo.gui.webPages.*;
import com.qaprosoft.carina.demo.gui.webPages.components.FooterMenu;
import com.qaprosoft.carina.demo.gui.webPages.components.HeaderMenu;
import com.zebrunner.agent.core.annotation.TestLabel;
import com.zebrunner.agent.core.annotation.TestRailCaseId;
import com.zebrunner.agent.core.annotation.XrayTestKey;
import com.zebrunner.agent.core.registrar.TestRail;
import com.zebrunner.agent.core.registrar.Xray;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class MyWebTest extends BaseTest {
    @BeforeSuite
    public void setUp() {
        Xray.setExecutionKey("ZBR-42");
    }
//    @BeforeSuite
//    public void setUp() {
//        TestRail.setSuiteId("S17");
//        TestRail.setRunName("Best run ever");
//        TestRail.setAssignee("Marianna");
//    }

    @Test()
    @XrayTestKey("QAL-61")
    @TestRailCaseId("C64")
    @MethodOwner(owner = "marianna_khalezova")
    @TestPriority(Priority.P1)
    @TestLabel(name = "feature", value = {"web", "acceptance"})
    public void testMenuButtonsWorkCorrectly() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        HeaderMenu headerMenu = homePage.getHeader();
        Assert.assertFalse(homePage.isOpened(), "Home page is not opened");
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

    @Test()
    @XrayTestKey("ZBR-10000")
    @XrayTestKey({"ZBR-10001", "ZBR-10002"})
    @TestRailCaseId("C60")
    @MethodOwner(owner = "marianna_khalezova")
    @TestPriority(Priority.P1)
    @TestLabel(name = "feature", value = {"web", "acceptance"})
    public void testSlidingWindow() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isOpened(), "Home page is not opened");
        homePage.clickRightArrowWindow();
        Assert.assertTrue(homePage.isImageShow(2), "Img isn't changed");
        homePage.clickLeftArrowWindow();
        Assert.assertTrue(homePage.isImageShow(1), "Img isn't returned");

    }

    @Test()
    @TestRailCaseId("C59")
    @XrayTestKey("ZBR-10000")
    @XrayTestKey({"ZBR-10001", "ZBR-10002"})
    @MethodOwner(owner = "marianna_khalezova")
    @TestPriority(Priority.P1)
    @TestLabel(name = "feature", value = {"web", "acceptance"})
    public void testAddProductOnTheCart() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isOpened(), "Home page is not opened");
        int index = (int) (Math.random() * 10);
        pause(2);
        ProductPage productPage = homePage.productOpenedByIndex(index);
        Assert.assertTrue(productPage.isOpened(), "product isn't opened");
        productPage.clickAddToCartButton();
        Assert.assertEquals(getDriver().switchTo().alert().getText(), "Product added", "product added successful.");
        getDriver().switchTo().alert().accept();
        HeaderMenu headerMenu = productPage.getHeader();
        CartPage cartPage = headerMenu.openCart();
        pause(5);
        Assert.assertEquals(cartPage.getCartTotal(), cartPage.getProductPrice(), "Product isn't true on cart");
        cartPage.deleteAllProducts();
        cartPage.goToHome();
        Assert.assertTrue(homePage.isOpened(), "home page isn't opened");

    }

    @Test()
    @TestRailCaseId("C62")
    @XrayTestKey("ZBR-10000")
    @XrayTestKey({"ZBR-10001", "ZBR-10002"})
    @MethodOwner(owner = "marianna_khalezova")
    @TestPriority(Priority.P1)
    @TestLabel(name = "feature", value = {"web", "acceptance"})
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
    @TestRailCaseId("C63")
    @XrayTestKey("ZBR-10000")
    @XrayTestKey({"ZBR-10001", "ZBR-10002"})
    @MethodOwner(owner = "marianna_khalezova")
    @TestPriority(Priority.P1)
    @TestLabel(name = "feature", value = {"web", "acceptance"})
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

//    @Test()
//    @MethodOwner(owner = "marianna_khalezova")
//    @TestPriority(Priority.P1)
//    @TestLabel(name = "feature", value = {"web", "acceptance"})
//    public void testPlacingOrder() {
//        ProductPage productPage = openingService.openProductByIndex();
//        HeaderMenu headerMenu = productPage.getHeader();
//        CartPage cartPage = headerMenu.openCart();
//        Assert.assertTrue(cartPage.isOpened(), "cart isn't open");
//        PlaceOrderPage placeOrderPage = cartPage.clickPlaceOrderBtn();
//        placeOrderPage.filledNameForm(R.TESTDATA.get("TEST_NAME"));
//        placeOrderPage.filledCartForm(R.TESTDATA.get("TEST_CARD"));
//        PopUpOrderPage popUpOrderPage = placeOrderPage.clickSendOrderButton();
//        Assert.assertTrue(popUpOrderPage.isOpened(), "Order isn't successful");
//        HomePage homePage = popUpOrderPage.closePage();
//        Assert.assertTrue(homePage.isOpened(),"home page isn't open");
//        headerMenu.openCart();
//        Assert.assertTrue(cartPage.isCartEmpty(),"cart isn't empty");
//
//    }
    @Test()
    @TestRailCaseId("C56")
    @XrayTestKey("ZBR-10000")
    @XrayTestKey({"ZBR-10001", "ZBR-10002"})
    @MethodOwner(owner = "marianna_khalezova")
    @TestPriority(Priority.P1)
    @TestLabel(name = "feature", value = {"web", "acceptance"})
    public void testMessageCanBeSend(){
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        HeaderMenu headerMenu = homePage.getHeader();
        ContactPage contactPage = headerMenu.goToContactPage();
        Assert.assertTrue(contactPage.isOpened(),"contact page isn't open");
        contactPage.typeName(R.TESTDATA.get("TEST_NAME"));
        contactPage.typeEmail(R.TESTDATA.get("TEST_EMAIL"));
        contactPage.typeMessage(R.TESTDATA.get("TEST_MESSAGE"));
        contactPage.clickSendMessageButton();
        Assert.assertTrue(homePage.isOpened(),"Message isn't send");


    }

    @Test()
    @TestRailCaseId("C58")
    @XrayTestKey("ZBR-10000")
    @XrayTestKey({"ZBR-10001", "ZBR-10002"})
    @MethodOwner(owner = "marianna_khalezova")
    @TestPriority(Priority.P1)
    @TestLabel(name = "feature", value = {"web", "acceptance"})
    public void testFooterIsFull(){
        String aboutUs= "About Us";
        String getInTouch = "Get in Touch";
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        FooterMenu footerMenu = homePage.getFooter();
        Assert.assertEquals(footerMenu.getTextAboutUs(), aboutUs,"about us isn't found");
        Assert.assertEquals(footerMenu.getTextGetInTouch(), getInTouch, "get in touch isn't find");
        Assert.assertTrue(footerMenu.getTextLabel(),"label isn't find");


    }

    @Test()
    @TestRailCaseId("C55")
    @XrayTestKey("ZBR-10000")
    @XrayTestKey({"ZBR-10001", "ZBR-10002"})
    @MethodOwner(owner = "marianna_khalezova")
    @TestPriority(Priority.P1)
    @TestLabel(name = "feature", value = {"web", "acceptance"})
    public void testPlacingOrderIsNotSuccessful() {
        ProductPage productPage = openingService.openProductByIndex();
        HeaderMenu headerMenu = productPage.getHeader();
        CartPage cartPage = headerMenu.openCart();
        Assert.assertTrue(cartPage.isOpened(), "cart isn't open");
        PlaceOrderPage placeOrderPage = cartPage.clickPlaceOrderBtn();
        placeOrderPage.clickSendOrderWithEmptyForms();
        Assert.assertTrue(placeOrderPage.isOpened(),"order is successful");
    }
    @Test()
    @TestRailCaseId("")
    @XrayTestKey("ZBR-10000")
    @XrayTestKey({"ZBR-10001", "ZBR-10002"})
    @MethodOwner(owner = "marianna_khalezova")
    @TestPriority(Priority.P1)
    @TestLabel(name = "feature", value = {"web", "acceptance"})
    public void testProductOnTheCart() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isOpened(), "Home page is not opened");
        int index = (int) (Math.random() * 10);
        pause(2);
        ProductPage productPage = homePage.productOpenedByIndex(index);
        Assert.assertTrue(productPage.isOpened(), "product isn't opened");
        productPage.clickAddToCartButton();
        Assert.assertEquals(getDriver().switchTo().alert().getText(), "Product added", "product added successful.");
        getDriver().switchTo().alert().accept();
        HeaderMenu headerMenu = productPage.getHeader();
        CartPage cartPage = headerMenu.openCart();
        pause(5);
        Assert.assertEquals(cartPage.getCartTotal(), cartPage.getProductPrice(), "Product isn't true on cart");
        cartPage.deleteProductByIndex("1");
        cartPage.goToHome();
        Assert.assertTrue(homePage.isOpened(), "home page isn't opened");

    }


}
