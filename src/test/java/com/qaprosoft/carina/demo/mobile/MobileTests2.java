package com.qaprosoft.carina.demo.mobile;

import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.core.foundation.utils.mobile.IMobileUtils;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.*;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.enums.SortBy;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.utils.DataLoader;
import com.zebrunner.agent.core.annotation.TestLabel;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import java.util.SortedMap;

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
//        loginPage.typeUsernameForm(R.TESTDATA.get("TEST_EMAIL"));
//        loginPage.typePassword(R.TESTDATA.get("TEST_PASSWORD"));
//        loginPage.clickLoginBtn();
//ios
        loginPage.clickAutoBtn();
        Assert.assertTrue(homePage.isHomePageOpen());
    }

    @Test
    @MethodOwner(owner = "Marianna")
    @TestLabel(name = "feature", value = {"mobile", "regression"})
    public void testLoginNegative() {
        HomePageBase homePage = initPage(HomePageBase.class);
        Assert.assertTrue(homePage.isHomePageOpen());
        MorePageBase morePage = homePage.clickMoreBtn();
        Assert.assertTrue(morePage.isMorePageOpen());
        LoginPageBase loginPage = morePage.clickLoginBtn();
        Assert.assertTrue(loginPage.isLoginPageOpen());
        loginPage.clickLoginBtn();
        Assert.assertTrue(loginPage.isFailedTextIsPresent());
        Assert.assertFalse(homePage.isHomePageOpen());
    }


    @Test
    @MethodOwner(owner = "Marianna")
    @TestLabel(name = "feature", value = {"mobile", "regression"})
    public void testFooterSocialNetworks() {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        Assert.assertTrue(homePage.isHomePageOpen());
        Assert.assertTrue(homePage.isLinkedinLogoPresent());
        Assert.assertTrue(homePage.isTwitterLogoPresent());

    }

    @Test
    @MethodOwner(owner = "Marianna")
    @TestLabel(name = "feature", value = {"mobile", "regression"})
    public void checkCheckoutWithoutData() {

        ProductPageBase productPage = addOneProductToCart.addOneProductToCart();
        CartPageBase cartPage = productPage.goToCart();
        Assert.assertTrue(cartPage.checkOneProductOnCart());
        LoginPageBase loginPage = cartPage.clickProcessedToCheckoutBtn();
        Assert.assertTrue(loginPage.isLoginPageOpen(), "Login page isn't open");
        loginPage.clickUser();//clickUser
        CheckoutPageBase checkoutPage = loginPage.clickLoginBtnForCheckout();
        Assert.assertTrue(checkoutPage.isPageOpened(), "Checkout page isn't open");
        checkoutPage.clickPaymentBtn();
        Assert.assertTrue(checkoutPage.checkPaymentFailed());


    }

    @Test
    @MethodOwner(owner = "Marianna")
    @TestLabel(name = "feature", value = {"mobile", "regression"})
    public void checkCheckoutIsNotReal() {
        ProductPageBase productPage = addOneProductToCart.addOneProductToCart();
        CartPageBase cartPage = productPage.goToCart();
        Assert.assertTrue(cartPage.checkOneProductOnCart());
        LoginPageBase loginPage = cartPage.clickProcessedToCheckoutBtn();
        Assert.assertTrue(loginPage.isLoginPageOpen());
        loginPage.clickUser();
        CheckoutPageBase checkoutPage = loginPage.clickLoginBtnForCheckout();
        Assert.assertTrue(checkoutPage.isPageOpened());
        checkoutPage.clickNameForm();
        checkoutPage.closeKeyboard();
        Assert.assertFalse(checkoutPage.isPageOpened(), "Keyboard is closed");

    }

    @Test
    @MethodOwner(owner = "Marianna")
    @TestLabel(name = "feature", value = {"mobile", "regression"})
    public void testReportingABugIsWorking() {
        HomePageBase homePage = initPage(HomePageBase.class);
        MorePageBase morePage = homePage.clickMoreBtn();
        Assert.assertTrue(morePage.isMorePageOpen(), "more page isn't opened");
        ReportBugPageBase reportBugPageBase = morePage.clickReportBugBtn();
        Assert.assertTrue(reportBugPageBase.isReportBugPageOpened(), "reporting a bug isn't opened");
        Assert.assertTrue(reportBugPageBase.fillEmailForm(R.TESTDATA.get("TEST_EMAIL")), "email isn't correct");
        reportBugPageBase.clickUser(R.TESTDATA.get("TEST_MESSAGE"));
        reportBugPageBase.sendMessage();
        Assert.assertFalse(reportBugPageBase.closePopUpMessage());

    }

    @Test
    @MethodOwner(owner = "Marianna")
    @TestLabel(name = "feature", value = {"mobile", "regression"})
    public void reportingABugIsWorkingNegative() {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        MorePageBase morePage = homePage.clickMoreBtn();
        Assert.assertTrue(morePage.isMorePageOpen(), "more page isn't opened");
        ReportBugPageBase reportBugPageBase = morePage.clickReportBugBtn();
        Assert.assertTrue(reportBugPageBase.isReportBugPageOpened(), "reporting a bug isn't opened");
        Assert.assertFalse(reportBugPageBase.fillEmailForm(R.TESTDATA.get("TEST_INCORRECTEMAIL")), "email is correct");
        reportBugPageBase.clickUser(R.TESTDATA.get("TEST_MESSAGE"));
        reportBugPageBase.sendMessage();
        Assert.assertTrue(reportBugPageBase.closePopUpMessage());

    }

    @Test
    @MethodOwner(owner = "Marianna")
    @TestLabel(name = "feature", value = {"mobile", "regression"})
    public void checkIsCorrectZipCode() {
        CheckoutPageBase checkoutPage = goToCheckOutPage.goToCheckoutPageWithManyProducts();
        Assert.assertTrue(checkoutPage.fillZipForm(R.TESTDATA.get("TEST_ZIPCODE")), "zipcode isn't correct");
    }

//    @Test
//    @MethodOwner(owner = "Marianna")
//    @TestLabel(name = "feature", value = {"mobile", "regression"})
//    public void checkIsCorrectZipCodeNegative() {
//        CheckoutPageBase checkoutPage = goToCheckOutPage.goToCheckoutPageWithManyProducts();
//        Assert.assertFalse(checkoutPage.fillZipForm(R.TESTDATA.get("TEST_UNCORRECTZIPCODE")), "zipCode is correct");
//    }

    @Test
    @MethodOwner(owner = "Marianna")
    @TestLabel(name = "feature", value = {"mobile", "regression"})
    public void testCheckLogoCounter() {
        ProductPageBase productPage = addOneProductToCart.addSeveralProductToCart();
        CartPageBase cartPage = productPage.goToCart();
        Assert.assertTrue(cartPage.checkTotalCountEqualCountImage(), "The picture does not match the quantity");

    }

    @Test()
    @MethodOwner(owner = "Marianna")
    @TestLabel(name = "feature", value = {"mobile", "regression"})
    public void testSortProducts() {
        SortedMap<String, Double> productMap = DataLoader.getMapOfProducts();
        Collection<Double> prices = productMap.values();
        Double minPrice = prices
                .stream()
                .min(Comparator.comparingDouble(Double::doubleValue))
                .get();
        Double maxPrice = prices
                .stream()
                .max(Comparator.comparingDouble(Double::doubleValue))
                .get();
        String minPriceTitle = productMap.entrySet()
                .stream()
                .filter(entry -> minPrice.equals(entry.getValue()))
                .map(Map.Entry::getKey)
                .findFirst()
                .get();
        String maxPriceTitle = productMap.entrySet()
                .stream()
                .filter(entry -> maxPrice.equals(entry.getValue()))
                .map(Map.Entry::getKey)
                .findFirst()
                .get();
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        Assert.assertTrue(homePage.isHomePageOpen(), "App Home page isn't opened.");
        SortByPopUpPageBase sortByPopUp = homePage.clickSortBtn();
        Assert.assertTrue(sortByPopUp.isTitlePresent(), "Sort Pop-up page isn't opened.");
        homePage = sortByPopUp.clickSortingMethodBtn(SortBy.NAME_DESK);
        Assert.assertEquals(homePage.getFirstSortedProduct(), productMap.lastKey(), "Product sorting is wrong.");//getFirst ->other
        sortByPopUp = homePage.clickSortBtn();
        Assert.assertTrue(sortByPopUp.isTitlePresent(), "Sort Pop-up page isn't opened.");
        homePage = sortByPopUp.clickSortingMethodBtn(SortBy.PRICE_ASC);
        Assert.assertEquals(homePage.getFirstSortedProduct(), minPriceTitle, "Product sorting is wrong.");
        sortByPopUp = homePage.clickSortBtn();
        Assert.assertTrue(sortByPopUp.isTitlePresent(), "Sort Pop-up page isn't opened.");
        homePage = sortByPopUp.clickSortingMethodBtn(SortBy.PRICE_DESC);
        Assert.assertEquals(homePage.getFirstSortedProduct(), maxPriceTitle, "Product sorting is wrong.");

    }

    @Test()
    @MethodOwner(owner = "Marianna")
    @TestLabel(name = "feature", value = {"mobile", "regression"})
    public void checkIsCorrectURLinWebview() {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        Assert.assertTrue(homePage.isHomePageOpen(), "Home page isn't opened");
        MorePageBase morePageBase = homePage.clickMoreBtn();
        Assert.assertTrue(morePageBase.isMorePageOpen(), "Menu isn't opened");
        WebviewPageBase webviewPageBase = morePageBase.clickWebviewBtn();
        Assert.assertTrue(webviewPageBase.isWebviewPageOpen(), "Webview page isn't open");
        Assert.assertTrue(webviewPageBase.checkIsCorrectURL(R.TESTDATA.get("TEST_URL")), "URL isn't correct");

    }

    @Test()
    @MethodOwner(owner = "Marianna")
    @TestLabel(name = "feature", value = {"mobile", "regression"})
    public void checkIsCorrectUI() {
        HomePageBase homePage = initPage(HomePageBase.class);
        Assert.assertTrue(homePage.isHomePageOpen());
        MorePageBase morePage = homePage.clickMoreBtn();
        AboutPageBase aboutPage = morePage.clickAboutBtn();
        Assert.assertTrue(aboutPage.isAboutPageOpen(), "About page isn't download");
        aboutPage.clickBackBtn();
        WebviewPageBase webviewPage = morePage.clickWebviewBtn();
        Assert.assertTrue(webviewPage.isWebviewPageOpen(), "Webview page isn't opened");
        webviewPage.clickBackBtn();
        ReportBugPageBase reportBugPage = morePage.clickReportBugBtn();
        Assert.assertTrue(reportBugPage.isReportBugPageOpened());
        reportBugPage.clickBackBtn();
        GeolocationPageBase geolocationPage = morePage.clickGeolocationBtn();
        geolocationPage.closePopUp();
        Assert.assertTrue(geolocationPage.isPageOpened(),"Geolocation Page isn't open");
        geolocationPage.clickBackBtn();
        LoginPageBase loginPage = morePage.clickLoginBtn();
        Assert.assertTrue(loginPage.isLoginPageOpen(),"Login page isn't opened");

    }
}
