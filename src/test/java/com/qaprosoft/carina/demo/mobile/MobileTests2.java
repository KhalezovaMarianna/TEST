package com.qaprosoft.carina.demo.mobile;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.core.foundation.utils.mobile.IMobileUtils;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.HomePageBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.LoginPageBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.MorePageBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.ios.LoginPage;
import com.zebrunner.agent.core.annotation.TestLabel;
import org.joda.time.LocalDate;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MobileTests2 implements IAbstractTest, IMobileUtils {
    @Test
    @MethodOwner(owner = "Marianna")
    @TestLabel(name = "feature", value = {"mobile", "regression"})
    public void testLogin() {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        Assert.assertTrue(homePage.isHomePageOpen());
        MorePageBase morePage =homePage.clickMoreBtn();
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
        MorePageBase morePage =homePage.clickMoreBtn();
        Assert.assertTrue(morePage.isMorePageOpen());
        LoginPageBase loginPage = morePage.clickLoginBtn();
        Assert.assertTrue(loginPage.isLoginPageOpen());
        loginPage.clickLoginBtn();
        Assert.assertTrue(loginPage.failedTextIsPresent());
        Assert.assertFalse(homePage.isHomePageOpen());
    }
}
