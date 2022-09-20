package com.qaprosoft.carina.demo.mobile;

import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.core.foundation.utils.mobile.IMobileUtils;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.*;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.enums.ColorsSectionOptions;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.enums.SortBy;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.utils.DataLoader;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.utils.MobileUtils;
import com.zebrunner.agent.core.annotation.TestLabel;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.security.SecureRandom;
import java.util.*;

public class MobileTests2 extends BaseTest implements IMobileUtils {
    @Test
    @MethodOwner(owner = "Marianna")
    @TestLabel(name = "feature", value = {"mobile", "regression"})
    public void testLogin() {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        Assert.assertTrue(homePage.isPageOpened());
        MorePageBase morePage = homePage.clickMoreBtn();
        Assert.assertTrue(morePage.isPageOpened());
        LoginPageBase loginPage = morePage.clickLoginBtn();
        Assert.assertTrue(loginPage.isPageOpened());
        if (MobileUtils.isIOS()) {
            loginPage.clickAutoBtn();
        } else {
            loginPage.typeUsernameForm(R.TESTDATA.get("TEST_EMAIL"));
            loginPage.typePassword(R.TESTDATA.get("TEST_PASSWORD"));
            loginPage.clickLoginBtn();

        }
        Assert.assertTrue(homePage.isPageOpened());
    }

    @Test
    @MethodOwner(owner = "Marianna")
    @TestLabel(name = "feature", value = {"mobile", "regression"})
    public void testLoginNegative() {
        HomePageBase homePage = initPage(HomePageBase.class);
        Assert.assertTrue(homePage.isPageOpened());
        MorePageBase morePage = homePage.clickMoreBtn();
        Assert.assertTrue(morePage.isPageOpened());
        LoginPageBase loginPage = morePage.clickLoginBtn();
        Assert.assertTrue(loginPage.isPageOpened());
        loginPage.clickLoginBtn();
        Assert.assertTrue(loginPage.isFailedTextIsPresent());
        Assert.assertFalse(homePage.isPageOpened());
    }


    @Test
    @MethodOwner(owner = "Marianna")
    @TestLabel(name = "feature", value = {"mobile", "regression"})
    public void testFooterSocialNetworks() {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        Assert.assertTrue(homePage.isPageOpened());
        Assert.assertTrue(homePage.isLinkedinLogoPresent());
        Assert.assertTrue(homePage.isTwitterLogoPresent());

    }

    @Test
    @MethodOwner(owner = "Marianna")
    @TestLabel(name = "feature", value = {"mobile", "regression"})
    public void testCheckCheckoutWithoutData() {
        List<String> products = new ArrayList<>();
        products.add("Sauce Lab Back Packs");
        products.add("Sauce Lab Bike Light");
        products.add("Sauce Lab Bolt T-Shirt");
        products.add("Sauce Lab Fleece T-Shirt");
        products.add("Sauce Lab Onesie");
        products.add("Test");
        var random = new SecureRandom();
        int randomIndex = random.nextInt(products.size());
        String title = String.valueOf(products.get(randomIndex));
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        ProductPageBase productPage = homePage.clickRandomProduct(title);
        productPage.addSeveralProducts(1);
        productPage.addToCart();
        CartPageBase cartPage = productPage.goToCart();
        Assert.assertTrue(cartPage.checkOneProductOnCart(), "In cart isn't one product");
        LoginPageBase loginPage = cartPage.clickProcessedToCheckoutBtn();
        Assert.assertTrue(loginPage.isPageOpened(), "Login page isn't open");
        loginPage.clickUser();
        CheckoutPageBase checkoutPage = loginPage.clickLoginBtnForCheckout();
        Assert.assertTrue(checkoutPage.isPageOpened(), "Checkout page isn't open");
        checkoutPage.clickPaymentBtn();
        Assert.assertTrue(checkoutPage.checkPaymentFailed(), "Payment is success");


    }

    @Test
    @MethodOwner(owner = "Marianna")
    @TestLabel(name = "feature", value = {"mobile", "regression"})
    public void testCheckCheckoutIsNotReal() {
        List<String> products = new ArrayList<>();
        products.add("Sauce Lab Back Packs");
        products.add("Sauce Lab Bike Light");
        products.add("Sauce Lab Bolt T-Shirt");
        products.add("Sauce Lab Fleece T-Shirt");
        products.add("Sauce Lab Onesie");
        products.add("Test");
        var random = new SecureRandom();
        int randomIndex = random.nextInt(products.size());
        String title = String.valueOf(products.get(randomIndex));
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        ProductPageBase productPage = homePage.clickRandomProduct(title);
        productPage.addSeveralProducts(1);
        productPage.addToCart();
        CartPageBase cartPage = productPage.goToCart();
        LoginPageBase loginPage = cartPage.clickProcessedToCheckoutBtn();
        Assert.assertTrue(loginPage.isPageOpened());
        loginPage.clickUser();
        CheckoutPageBase checkoutPage = loginPage.clickLoginBtnForCheckout();
        Assert.assertTrue(checkoutPage.isPageOpened(), "checkOut page isn't open");
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
        Assert.assertTrue(morePage.isPageOpened(), "more page isn't opened");
        ReportBugPageBase reportBugPageBase = morePage.clickReportBugBtn();
        Assert.assertTrue(reportBugPageBase.isPageOpened(), "reporting a bug isn't opened");
        Assert.assertTrue(reportBugPageBase.fillEmailForm(R.TESTDATA.get("TEST_EMAIL")), "email isn't correct");
        Assert.assertEquals(R.TESTDATA.get("TEST_EMAIL"), reportBugPageBase.checkCorrectEmail());
        reportBugPageBase.clickUser(R.TESTDATA.get("TEST_MESSAGE"));
        reportBugPageBase.sendMessage();
        Assert.assertFalse(reportBugPageBase.closePopUpMessage());

    }

    @Test
    @MethodOwner(owner = "Marianna")
    @TestLabel(name = "feature", value = {"mobile", "regression"})
    public void testReportingABugIsWorkingNegative() {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        MorePageBase morePage = homePage.clickMoreBtn();
        Assert.assertTrue(morePage.isPageOpened(), "more page isn't opened");
        ReportBugPageBase reportBugPageBase = morePage.clickReportBugBtn();
        Assert.assertTrue(reportBugPageBase.isPageOpened(), "reporting a bug isn't opened");
        Assert.assertFalse(reportBugPageBase.fillEmailForm(R.TESTDATA.get("TEST_INCORRECTEMAIL")), "email is correct");
        reportBugPageBase.clickUser(R.TESTDATA.get("TEST_MESSAGE"));
        reportBugPageBase.sendMessage();
        Assert.assertTrue(reportBugPageBase.closePopUpMessage());

    }

    @Test
    @MethodOwner(owner = "Marianna")
    @TestLabel(name = "feature", value = {"mobile", "regression"})
    public void testCheckIsCorrectZipCode() {
        int count = 5;
        List<String> products = new ArrayList<>();
        products.add("Sauce Lab Back Packs");
        products.add("Sauce Lab Bike Light");
        products.add("Sauce Lab Bolt T-Shirt");
        products.add("Sauce Lab Fleece T-Shirt");
        products.add("Sauce Lab Onesie");
        products.add("Test");
        var random = new SecureRandom();
        int randomIndex = random.nextInt(products.size());
        String title = String.valueOf(products.get(randomIndex));
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        Assert.assertTrue(homePage.isPageOpened(), "HomePage isn't open");
        ProductPageBase productPage = homePage.clickRandomProduct(title);
        Assert.assertTrue(productPage.isPageOpened(), "Product isn't open");
        productPage.addSeveralProducts(count);
        productPage.addToCart();
        CartPageBase cartPage = productPage.goToCart();
        LoginPageBase loginPage = cartPage.clickProcessedToCheckoutBtn();
        Assert.assertTrue(loginPage.isPageOpened());
        loginPage.clickUser();
        CheckoutPageBase checkoutPage = loginPage.clickLoginBtnForCheckout();
        Assert.assertTrue(checkoutPage.isPageOpened());
        Assert.assertTrue(checkoutPage.fillZipForm(R.TESTDATA.get("TEST_ZIPCODE")), "zipcode isn't correct");
        Assert.assertEquals(R.TESTDATA.get("TEST_ZIPCODE"), checkoutPage.checkEqualZipcode(), "zipcode isn't correct");
    }

    @Test
    @MethodOwner(owner = "Marianna")
    @TestLabel(name = "feature", value = {"mobile", "regression"})
    public void testCheckLogoCounter() {
        int count = 5;
        List<String> products = new ArrayList<>();
        products.add("Sauce Lab Back Packs");
        products.add("Sauce Lab Bike Light");
        products.add("Sauce Lab Bolt T-Shirt");
        products.add("Sauce Lab Fleece T-Shirt");
        products.add("Sauce Lab Onesie");
        products.add("Test");
        var random = new SecureRandom();
        int randomIndex = random.nextInt(products.size());
        String title = String.valueOf(products.get(randomIndex));
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        Assert.assertTrue(homePage.isPageOpened(), "HomePage isn't open");
        ProductPageBase productPage = homePage.clickRandomProduct(title);
        Assert.assertTrue(productPage.isPageOpened(), "Product isn't open");
        productPage.addSeveralProducts(count);
        productPage.addToCart();
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
        Assert.assertTrue(homePage.isPageOpened(), "App Home page isn't opened.");
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
        Assert.assertTrue(homePage.isPageOpened(), "Home page isn't opened");
        MorePageBase morePageBase = homePage.clickMoreBtn();
        Assert.assertTrue(morePageBase.isPageOpened(), "Menu isn't opened");
        WebviewPageBase webviewPageBase = morePageBase.clickWebviewBtn();
        Assert.assertTrue(webviewPageBase.isPageOpened(), "Webview page isn't open");
        Assert.assertTrue(webviewPageBase.checkIsCorrectURL(R.TESTDATA.get("TEST_URL")), "URL isn't correct");
        Assert.assertEquals(R.TESTDATA.get("TEST_URL"), webviewPageBase.checkEqualURL(), "Data is correct");

    }

    @Test()
    @MethodOwner(owner = "Marianna")
    @TestLabel(name = "feature", value = {"mobile", "regression"})
    public void checkIsCorrectUI() {
        HomePageBase homePage = initPage(HomePageBase.class);
        Assert.assertTrue(homePage.isPageOpened());
        MorePageBase morePage = homePage.clickMoreBtn();
        AboutPageBase aboutPage = morePage.clickAboutBtn();
        Assert.assertTrue(aboutPage.isPageOpened(), "About page isn't download");
        aboutPage.clickBackBtn();
        WebviewPageBase webviewPage = morePage.clickWebviewBtn();
        Assert.assertTrue(webviewPage.isPageOpened(), "Webview page isn't opened");
        webviewPage.clickBackBtn();
        ReportBugPageBase reportBugPage = morePage.clickReportBugBtn();
        Assert.assertTrue(reportBugPage.isPageOpened(), "Report Bug Page isn't opened");
        reportBugPage.clickBackBtn();
        GeolocationPageBase geolocationPage = morePage.clickGeolocationBtn();
        geolocationPage.closePopUp();
        Assert.assertTrue(geolocationPage.isPageOpened(), "Geolocation Page isn't open");
        geolocationPage.clickBackBtn();
        LoginPageBase loginPage = morePage.clickLoginBtn();
        Assert.assertTrue(loginPage.isPageOpened(), "Login page isn't opened");

    }

    @Test()
    @MethodOwner(owner = "Marianna")
    @TestLabel(name = "feature", value = {"mobile", "regression"})
    public void testCheckOptionSections() {
        List<String> products = new ArrayList<>();
        products.add("Sauce Lab Back Packs");
        products.add("Sauce Lab Bike Light");
        products.add("Sauce Lab Bolt T-Shirt");
        products.add("Sauce Lab Fleece T-Shirt");
        products.add("Sauce Lab Onesie");
        products.add("Test");
        var random = new SecureRandom();
        int randomIndex = random.nextInt(products.size());
        String title = String.valueOf(products.get(randomIndex));
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        Assert.assertTrue(homePage.isPageOpened(), "HomePage isn't open");
        ProductPageBase productPage = homePage.clickRandomProduct(title);
        Assert.assertTrue(productPage.isPageOpened(), "Product isn't open");
        Assert.assertTrue(productPage.checkChosenColor(ColorsSectionOptions.BLACK.getColor()));
//        Assert.assertTrue(productPage.checkChosenColor(ColorsSectionOptions.GRAY.getColor()));
//        Assert.assertTrue(productPage.checkChosenColor(ColorsSectionOptions.RED.getColor()));
//        Assert.assertTrue(productPage.checkChosenColor(ColorsSectionOptions.BLUE.getColor()));

    }

    @Test()
    @MethodOwner(owner = "Marianna")
    @TestLabel(name = "feature", value = {"mobile", "regression"})
    public void testCheckAboutPageWork() {
        HomePageBase homePage = initPage(HomePageBase.class);
        Assert.assertTrue(homePage.isPageOpened());
        MorePageBase morePage = homePage.clickMoreBtn();
        AboutPageBase aboutPage = morePage.clickAboutBtn();
        Assert.assertTrue(aboutPage.isPageOpened(), "About page isn't download");
        URLAboutPageBase urlAboutPage = aboutPage.goToURL();
        Assert.assertTrue(urlAboutPage.isCorrectUrlOpened(), "open not correct adress");

    }

    @Test()
    @MethodOwner(owner = "Marianna")
    @TestLabel(name = "feature", value = {"mobile", "regression"})
    public void CheckAboutPageWork() {

        List<String> products = new ArrayList<>();
        products.add("Sauce Lab Back Packs");
        products.add("Sauce Lab Bike Light");
        products.add("Sauce Lab Bolt T-Shirt");
        products.add("Sauce Lab Fleece T-Shirt");
        products.add("Sauce Lab Onesie");
        products.add("Test");
        var random = new SecureRandom();
        int randomIndex = random.nextInt(products.size());
        String title = String.valueOf(products.get(randomIndex));
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        Assert.assertTrue(homePage.isPageOpened(), "HomePage isn't open");
        ProductPageBase productPage = homePage.clickRandomProduct(title);
        Assert.assertTrue(productPage.isPageOpened(), "Product isn't open");
        Assert.assertTrue(productPage.checkImageDownloading(), "image isn't download");
    }
}
