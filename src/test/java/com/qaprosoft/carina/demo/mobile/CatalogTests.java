package com.qaprosoft.carina.demo.mobile;

import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.core.foundation.utils.mobile.IMobileUtils;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.*;
import com.zebrunner.agent.core.annotation.TestLabel;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CatalogTests extends BaseTest implements IMobileUtils {
    @Test()
    @MethodOwner(owner = "Marianna")
    @TestLabel(name = "feature", value = {"mobile", "regression"})
    public void testCheckAboutPageWork() {
        HomePageBase homePage = initPage(HomePageBase.class);
        Assert.assertTrue(homePage.isOpened());
        MorePageBase morePage = homePage.clickMoreBtn();
        AboutPageBase aboutPage = morePage.clickAboutBtn();
        Assert.assertTrue(aboutPage.isOpened(), "About page isn't download");
        URLAboutPageBase urlAboutPage = aboutPage.goToURL();
        Assert.assertTrue(urlAboutPage.isCorrectUrlOpened(), "open not correct adress");

    }

    @Test()
    @MethodOwner(owner = "Marianna")
    @TestLabel(name = "feature", value = {"mobile", "regression"})
    public void checkIsCorrectUI() {
        HomePageBase homePage = initPage(HomePageBase.class);
        Assert.assertTrue(homePage.isOpened());
        MorePageBase morePage = homePage.clickMoreBtn();
        AboutPageBase aboutPage = morePage.clickAboutBtn();
        Assert.assertTrue(aboutPage.isOpened(), "About page isn't download");
        aboutPage.clickBackBtn();
        WebviewPageBase webviewPage = morePage.clickWebviewBtn();
        Assert.assertTrue(webviewPage.isOpened(), "Webview page isn't opened");
        webviewPage.clickBackBtn();
        ReportBugPageBase reportBugPage = morePage.clickReportBugBtn();
        Assert.assertTrue(reportBugPage.isOpened(), "Report Bug Page isn't opened");
        reportBugPage.clickBackBtn();
        GeolocationPageBase geolocationPage = morePage.clickGeolocationBtn();
        geolocationPage.closePopUp();
        Assert.assertTrue(geolocationPage.isOpened(), "Geolocation Page isn't open");
        geolocationPage.clickBackBtn();
        LoginPageBase loginPage = morePage.clickLoginBtn();
        Assert.assertTrue(loginPage.isOpened(), "Login page isn't opened");

    }

    @Test()
    @MethodOwner(owner = "Marianna")
    @TestLabel(name = "feature", value = {"mobile", "regression"})
    public void checkIsCorrectURLinWebview() {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        Assert.assertTrue(homePage.isOpened(), "Home page isn't opened");
        MorePageBase morePageBase = homePage.clickMoreBtn();
        Assert.assertTrue(morePageBase.isOpened(), "Menu isn't opened");
        WebviewPageBase webviewPageBase = morePageBase.clickWebviewBtn();
        Assert.assertTrue(webviewPageBase.isOpened(), "Webview page isn't open");
        Assert.assertTrue(webviewPageBase.checkIsCorrectURL(R.TESTDATA.get("TEST_URL")), "URL isn't correct");
        Assert.assertEquals(R.TESTDATA.get("TEST_URL"), webviewPageBase.checkEqualURL(), "Data is correct");

    }

    @Test
    @MethodOwner(owner = "Marianna")
    @TestLabel(name = "feature", value = {"mobile", "regression"})
    public void testReportingABugIsWorkingNegative() {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        MorePageBase morePage = homePage.clickMoreBtn();
        Assert.assertTrue(morePage.isOpened(), "more page isn't opened");
        ReportBugPageBase reportBugPageBase = morePage.clickReportBugBtn();
        Assert.assertTrue(reportBugPageBase.isOpened(), "reporting a bug isn't opened");
        Assert.assertFalse(reportBugPageBase.fillEmailForm(R.TESTDATA.get("TEST_INCORRECTEMAIL")), "email is correct");
        reportBugPageBase.clickUser(R.TESTDATA.get("TEST_MESSAGE"));
        reportBugPageBase.sendMessage();
        Assert.assertTrue(reportBugPageBase.closePopUpMessage());

    }

    @Test
    @MethodOwner(owner = "Marianna")
    @TestLabel(name = "feature", value = {"mobile", "regression"})
    public void testReportingABugIsWorking() {
        HomePageBase homePage = initPage(HomePageBase.class);
        MorePageBase morePage = homePage.clickMoreBtn();
        Assert.assertTrue(morePage.isOpened(), "more page isn't opened");
        ReportBugPageBase reportBugPageBase = morePage.clickReportBugBtn();
        Assert.assertTrue(reportBugPageBase.isOpened(), "reporting a bug isn't opened");
        Assert.assertTrue(reportBugPageBase.fillEmailForm(R.TESTDATA.get("TEST_EMAIL")), "email isn't correct");
        Assert.assertEquals(R.TESTDATA.get("TEST_EMAIL"), reportBugPageBase.checkCorrectEmail());
        reportBugPageBase.clickUser(R.TESTDATA.get("TEST_MESSAGE"));
        reportBugPageBase.sendMessage();
        Assert.assertFalse(reportBugPageBase.closePopUpMessage());

    }

    @Test
    @MethodOwner(owner = "qpsdemo")
    @TestLabel(name = "feature", value = {"mobile", "regression"})
    public void testOpenPages() {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        CartPageBase cartPage = homePage.clickBasketBtn();
        Assert.assertTrue(cartPage.isOpened(),
                "Page isn't opened");
        cartPage.clickGoShoppingBtn();
        Assert.assertTrue(homePage.isPageOpened(),
                "homePage isn't open");
        MorePageBase morePage = homePage.clickMoreBtn();
        Assert.assertTrue(morePage.isPageOpened(),
                "morePage isn't open");
        AboutPageBase aboutPage = morePage.clickAboutBtn();
        Assert.assertTrue(aboutPage.isPageOpened(),
                "aboutPage isn't open");
        aboutPage.clickBackBtn();
        Assert.assertFalse(homePage.isPageOpened(),
                "HOMEPage is not open");
        morePage.clickCatalogBtn();
        Assert.assertTrue(homePage.isPageOpened(),
                "Catalog isn't open");
        ProductPageBase productPage = homePage.clickProductImg("3");
        productPage.addProduct();
        Assert.assertFalse(homePage.isPageOpened(), "HomePage isn't open");
        morePage.clickCatalogBtn();
        homePage.clickProductByIndex("5");
        Assert.assertTrue(productPage.isPageOpened(), "something don't go");

    }

}
