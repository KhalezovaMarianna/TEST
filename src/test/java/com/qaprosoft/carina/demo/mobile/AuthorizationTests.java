package com.qaprosoft.carina.demo.mobile;

import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.core.foundation.utils.mobile.IMobileUtils;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.HomePageBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.LoginPageBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.MorePageBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.utils.MobileUtils;
import com.zebrunner.agent.core.annotation.TestLabel;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AuthorizationTests extends BaseTest implements IMobileUtils {
    @Test
    @MethodOwner(owner = "Marianna")
    @TestLabel(name = "feature", value = {"mobile", "regression"})
    public void testLoginNegative() {
        HomePageBase homePage = initPage(HomePageBase.class);
        Assert.assertTrue(homePage.isOpened());
        MorePageBase morePage = homePage.clickMoreBtn();
        Assert.assertTrue(morePage.isOpened());
        LoginPageBase loginPage = morePage.clickLoginBtn();
        Assert.assertTrue(loginPage.isOpened());
        loginPage.clickLoginBtn();
        Assert.assertTrue(loginPage.isFailedTextIsPresent());
        Assert.assertFalse(homePage.isOpened());
    }

    @Test
    @MethodOwner(owner = "Marianna")
    @TestLabel(name = "feature", value = {"mobile", "regression"})
    public void testLogin() {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        Assert.assertTrue(homePage.isOpened());
        MorePageBase morePage = homePage.clickMoreBtn();
        Assert.assertTrue(morePage.isOpened());
        LoginPageBase loginPage = morePage.clickLoginBtn();
        Assert.assertTrue(loginPage.isOpened());
        if (MobileUtils.isIOS()) {
            loginPage.clickAutoBtn();
        } else {
            loginPage.typeUsernameForm(R.TESTDATA.get("TEST_EMAIL"));
            loginPage.typePassword(R.TESTDATA.get("TEST_PASSWORD"));
            loginPage.clickLoginBtn();
        }
        Assert.assertTrue(homePage.isOpened());
    }
}
