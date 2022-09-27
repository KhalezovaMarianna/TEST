package com.qaprosoft.carina.demo.web;

import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.demo.gui.webPages.common.*;
import com.qaprosoft.carina.demo.gui.webPages.common.componentsBase.FooterBase;
import com.qaprosoft.carina.demo.gui.webPages.common.componentsBase.HeaderBase;

import com.qaprosoft.carina.demo.gui.webPages.utils.MobileUtils;
import com.zebrunner.agent.core.annotation.TestLabel;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OtherTests extends BaseTest {

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

}
