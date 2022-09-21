package com.qaprosoft.carina.demo.web;

import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.core.foundation.utils.tag.Priority;
import com.qaprosoft.carina.core.foundation.utils.tag.TestPriority;
import com.qaprosoft.carina.demo.gui.webPages.common.*;
import com.qaprosoft.carina.demo.gui.webPages.common.componentsBase.FooterBase;
import com.qaprosoft.carina.demo.gui.webPages.common.componentsBase.HeaderBase;
import com.qaprosoft.carina.demo.gui.webPages.desktop.components.Footer;
import com.qaprosoft.carina.demo.gui.webPages.desktop.components.Header;
import com.qaprosoft.carina.demo.gui.webPages.iosWeb.HomePage;
import com.zebrunner.agent.core.annotation.TestLabel;
import com.zebrunner.agent.core.annotation.TestRailCaseId;
import com.zebrunner.agent.core.annotation.XrayTestKey;
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
        HomePageBase homePage = initPage(getDriver(),HomePageBase.class);
        homePage.open();
        HeaderBase header = homePage.getHeaderBase();
        Assert.assertFalse(homePage.isOpened(), "Home page is not opened");
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
    @XrayTestKey("ZBR-10000")
    @XrayTestKey({"ZBR-10001", "ZBR-10002"})
    @TestRailCaseId("C60")
    @MethodOwner(owner = "marianna_khalezova")
    @TestPriority(Priority.P1)
    @TestLabel(name = "feature", value = {"web", "acceptance"})
    public void testSlidingWindow() {
        HomePageBase homePage = initPage(getDriver(),HomePageBase.class);
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
        HomePageBase homePage = initPage(getDriver(),HomePageBase.class);
        homePage.open();
        Assert.assertTrue(homePage.isOpened(), "Home page is not opened");
        int index = (int) (Math.random() * 10);
        pause(2);
        ProductPageBase productPage = homePage.productOpenedByIndex(index);
        Assert.assertTrue(productPage.isOpened(), "product isn't opened");
        productPage.clickAddToCartButton();
        Assert.assertEquals(getDriver().switchTo().alert().getText(), "Product added", "product added successful.");
        getDriver().switchTo().alert().accept();
        HeaderBase header = productPage.getHeaderBase();
        CartPageBase cartPage = header.openCart();
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
        HomePageBase homePage = initPage(getDriver(),HomePageBase.class);
        homePage.open();
        Assert.assertTrue(homePage.isOpened(), "Home page is not opened");
        HeaderBase header = homePage.getHeaderBase();
        SignUpPageBase signUpPage = header.goToSignUpPage();
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
        HomePageBase homePage = initPage(getDriver(),HomePageBase.class);
        homePage.open();
        Assert.assertTrue(homePage.isOpened(), "Home page is not opened");
        HeaderBase header = homePage.getHeaderBase();
        LoginPageBase logInPage = header.goToLoginPage();
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
        HomePageBase homePage = initPage(getDriver(),HomePageBase.class);
        homePage.open();
        HeaderBase header = homePage.getHeaderBase();
        ContactPageBase contactPage = header.goToContactPage();
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
        HomePageBase homePage = initPage(getDriver(),HomePageBase.class);
        homePage.open();
        FooterBase footer = homePage.getFooterBase();
        Assert.assertEquals(footer.getTextAboutUs(), aboutUs,"about us isn't found");
        Assert.assertEquals(footer.getTextGetInTouch(), getInTouch, "get in touch isn't find");
        Assert.assertTrue(footer.getTextLabel(),"label isn't find");


    }

    @Test()
    @TestRailCaseId("C55")
    @XrayTestKey("ZBR-10000")
    @XrayTestKey({"ZBR-10001", "ZBR-10002"})
    @MethodOwner(owner = "marianna_khalezova")
    @TestPriority(Priority.P1)
    @TestLabel(name = "feature", value = {"web", "acceptance"})
    public void testPlacingOrderIsNotSuccessful() {
        ProductPageBase productPage = openingService.openProductByIndex();
        HeaderBase header = productPage.getHeaderBase();
        CartPageBase cartPage = header.openCart();
        Assert.assertTrue(cartPage.isOpened(), "cart isn't open");
        PlaceOrderPageBase placeOrderPage = cartPage.clickPlaceOrderBtn();
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
        HomePageBase homePage = new HomePage(getDriver());;
        homePage.open();
        Assert.assertTrue(homePage.isOpened(), "Home page is not opened");
        int index = (int) (Math.random() * 10);
        pause(2);
        ProductPageBase productPage = homePage.productOpenedByIndex(index);
        Assert.assertTrue(productPage.isOpened(), "product isn't opened");
        productPage.clickAddToCartButton();
        Assert.assertEquals(getDriver().switchTo().alert().getText(), "Product added", "product added successful.");
        getDriver().switchTo().alert().accept();
        HeaderBase header = productPage.getHeaderBase();
        CartPageBase cartPage = header.openCart();
        pause(5);
        Assert.assertEquals(cartPage.getCartTotal(), cartPage.getProductPrice(), "Product isn't true on cart");
        cartPage.deleteProductByIndex("1");
        cartPage.goToHome();
        Assert.assertTrue(homePage.isOpened(), "home page isn't opened");

    }


}
