package com.qaprosoft.carina.demo.mobile;

import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.core.foundation.utils.mobile.IMobileUtils;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.*;
import com.zebrunner.agent.core.annotation.TestLabel;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MobileTests2 extends BaseTest implements IMobileUtils {
    @Test
    @MethodOwner(owner = "Marianna")
    @TestLabel(name = "feature", value = {"mobile", "regression"})
    public void testLogin() {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        Assert.assertTrue(homePage.isHomePageOpen());
        MorePageBase morePage = homePage.clickMoreBtn();
        Assert.assertTrue(morePage.isMorePageOpen());
        LoginPageBase loginPage = morePage.clickLoginBtn();
        Assert.assertTrue(loginPage.isLoginPageOpen());
//android
        loginPage.typeUsernameForm(R.TESTDATA.get("TEST_EMAIL"));
        loginPage.typePassword(R.TESTDATA.get("TEST_PASSWORD"));
        loginPage.clickLoginBtn();
//ios
//      loginPage.clickAutoBtn();
        Assert.assertTrue(homePage.isHomePageOpen());
    }

    @Test
    @MethodOwner(owner = "Marianna")
    @TestLabel(name = "feature", value = {"mobile", "regression"})
    public void testLoginNegative() {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        Assert.assertTrue(homePage.isHomePageOpen());
        MorePageBase morePage = homePage.clickMoreBtn();
        Assert.assertTrue(morePage.isMorePageOpen());
        LoginPageBase loginPage = morePage.clickLoginBtn();
        Assert.assertTrue(loginPage.isLoginPageOpen());
        loginPage.clickLoginBtn();
        Assert.assertTrue(loginPage.failedTextIsPresent());
        Assert.assertFalse(homePage.isHomePageOpen());
    }


    @Test
    @MethodOwner(owner = "Marianna")
    @TestLabel(name = "feature", value = {"mobile", "regression"})
    public void testLabelsIsPresent() {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        Assert.assertTrue(homePage.isHomePageOpen());
        homePage.scrollHomePage();
        Assert.assertTrue(homePage.lnLabelIsPresent());
//????????????????????????????????????????????????????????????????????????
    }

    @Test
    @MethodOwner(owner = "Marianna")
    @TestLabel(name = "feature", value = {"mobile", "regression"})
    public void checkCheckoutWithoutData() {

        ProductPageBase productPage = addOneProductToCart.addOneProductToCart();
        CartPageBase cartPage= productPage.goToCart();
        Assert.assertTrue(cartPage.checkOneProductOnCart());
        LoginPageBase loginPage =cartPage.clickProcessedToCheckoutBtn();
        Assert.assertTrue(loginPage.isLoginPageOpen());
        loginPage.fillAutoForms();
        CheckoutPageBase checkoutPage = loginPage.clickLoginBtnForCheckout();
        Assert.assertTrue(checkoutPage.isPageOpened());
        checkoutPage.clickPaymentBtn();
        Assert.assertTrue(checkoutPage.checkPaymentFailed());

    }




}
