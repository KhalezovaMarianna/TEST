package com.qaprosoft.carina.demo.web;


import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.demo.web.gui.webPages.components.Footer;
import com.qaprosoft.carina.demo.web.gui.webPages.components.Header;
import com.qaprosoft.carina.demo.web.gui.webPages.pages.*;
import com.qaprosoft.carina.demo.web.gui.webPages.utils.MobileUtils;
import com.zebrunner.agent.core.annotation.TestLabel;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OtherTests extends BaseTest {

    @Test()
    @MethodOwner(owner = "marianna_khalezova")
    @TestLabel(name = "feature", value = {"web", "acceptance"})
    public void testMenuButtonsWorkCorrectly() {

        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Header header = homePage.getHeader();
        Assert.assertTrue(homePage.isOpened(), "Home page is not opened");
        ContactPage contactPage = header.goToContactPage();
        Assert.assertTrue(contactPage.isOpened(), "Contact page isn't open");
        contactPage.closePage();
        AboutUsPage aboutUsPage = header.goToAboutPage();
        Assert.assertTrue(aboutUsPage.isOpened(), "About page isn't opened");
        aboutUsPage.clickCloseButton();
        CartPage cartPage = header.openCart();
        Assert.assertTrue(cartPage.isOpened(), "Cart isn't present");
        cartPage.goToHome();
        LoginPage logInPage = header.goToLoginPage();
        Assert.assertTrue(logInPage.isOpened(), "Login page isn't opened");
        logInPage.clickCloseButton();
        SignUpPage signUpPage = header.goToSignUpPage();
        Assert.assertTrue(signUpPage.isOpened(), "SignUp page isn't opened");
        signUpPage.clickCloseButton();
        Assert.assertTrue(homePage.isOpened(), "home page isn't return");
    }

    @Test()
    @MethodOwner(owner = "marianna_khalezova")
    @TestLabel(name = "feature", value = {"web", "acceptance"})
    public void testSlidingWindow() {
        HomePage homePage = new HomePage(getDriver());
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
    public void testMessageCanBeSend() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Header header = homePage.getHeader();
        ContactPage contactPage = header.goToContactPage();
        Assert.assertTrue(contactPage.isOpened(), "contact page isn't open");
        contactPage.typeName(R.TESTDATA.get("TEST_NAME"));
        contactPage.typeEmail(R.TESTDATA.get("TEST_EMAIL"));
        contactPage.typeMessage(R.TESTDATA.get("TEST_MESSAGE"));
        contactPage.clickSendMessageButton();
        Assert.assertEquals(getDriver().switchTo().alert().getText(), "Thanks for the message!!", "Thanks for the message!!");
        getDriver().switchTo().alert().accept();
        Assert.assertTrue(homePage.isOpened(), "Message isn't send");
    }

    @Test()
    @MethodOwner(owner = "marianna_khalezova")
    @TestLabel(name = "feature", value = {"web", "acceptance"})
    public void testFooterIsFull() {
        String aboutUs = "About Us";
        String getInTouch = "Get in Touch";
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Footer footer = homePage.getFooter();
        Assert.assertEquals(footer.getTextAboutUs(), aboutUs, "about us isn't found");
        Assert.assertEquals(footer.getTextGetInTouch(), getInTouch, "get in touch isn't find");
        Assert.assertTrue(footer.checkTitleIsPresented(), "label isn't find");
    }


    @Test()
    @MethodOwner(owner = "marianna_khalezova")
    @TestLabel(name = "feature", value = {"web", "acceptance"})
    public void testCheckImageIsDownload() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isOpened(), "Home page is not opened");
        int index = (int) (Math.random() * 10);
        ProductPage productPage = homePage.productOpenedByIndex(index);
        Assert.assertTrue(productPage.isOpened(), "product isn't opened");
        Assert.assertTrue(productPage.checkImageIsDownload(), "Image isn't download");
    }


    @Test()
    @MethodOwner(owner = "marianna_khalezova")
    @TestLabel(name = "feature", value = {"web", "acceptance"})
    public void testCheckVideoIsDownload() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isOpened(), "Home page is not opened");
        Header header = homePage.getHeader();
        AboutUsPage aboutUsPage = header.goToAboutPage();
        Assert.assertTrue(aboutUsPage.isOpened(), "About us page isn't open");
        Assert.assertTrue(aboutUsPage.checkVideoIsDownload(), "Video isn't download");
    }

    @Test()
    @MethodOwner(owner = "marianna_khalezova")
    @TestLabel(name = "feature", value = {"web", "acceptance"})
    public void testNextAndPreviousBtnWork() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isOpened(), "Home page is not opened");
        homePage.clickNextButton();
        Assert.assertNotEquals(homePage.getNameOfFirstProduct(), "Nokia lumia 1520");
        homePage.clickPreviousBtn();
        Assert.assertEquals(homePage.getNameOfFirstProduct(), "Nokia lumia 1520", "First product isn't right");
    }
}
