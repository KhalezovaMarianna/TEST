package com.qaprosoft.carina.demo.mobile;

import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.core.foundation.utils.mobile.IMobileUtils;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.*;
import com.zebrunner.agent.core.annotation.TestLabel;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

public class CartTests extends BaseTest implements IMobileUtils {
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
        Assert.assertTrue(homePage.isOpened(), "HomePage isn't open");
        ProductPageBase productPage = homePage.clickRandomProduct(title);
        Assert.assertTrue(productPage.isOpened(), "Product isn't open");
        productPage.addSeveralProducts(count);
        productPage.addToCart();
        CartPageBase cartPage = productPage.goToCart();
        Assert.assertTrue(cartPage.checkTotalCountEqualCountImage(), "The picture does not match the quantity");
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
        Assert.assertTrue(homePage.isOpened(), "HomePage isn't open");
        ProductPageBase productPage = homePage.clickRandomProduct(title);
        Assert.assertTrue(productPage.isOpened(), "Product isn't open");
        productPage.addSeveralProducts(count);
        productPage.addToCart();
        CartPageBase cartPage = productPage.goToCart();
        LoginPageBase loginPage = cartPage.clickProcessedToCheckoutBtn();
        Assert.assertTrue(loginPage.isOpened());
        loginPage.clickUser();
        CheckoutPageBase checkoutPage = loginPage.clickLoginBtnForCheckout();
        Assert.assertTrue(checkoutPage.isOpened());
        Assert.assertTrue(checkoutPage.fillZipForm(R.TESTDATA.get("TEST_ZIPCODE")), "zipcode isn't correct");
        Assert.assertEquals(R.TESTDATA.get("TEST_ZIPCODE"), checkoutPage.checkEqualZipcode(), "zipcode isn't correct");
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
        Assert.assertTrue(loginPage.isOpened());
        loginPage.clickUser();
        CheckoutPageBase checkoutPage = loginPage.clickLoginBtnForCheckout();
        Assert.assertTrue(checkoutPage.isOpened(), "checkOut page isn't open");
        checkoutPage.clickNameForm();
        checkoutPage.closeKeyboard();
        Assert.assertFalse(checkoutPage.isOpened(), "Keyboard is closed");
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
        Assert.assertTrue(loginPage.isOpened(), "Login page isn't open");
        loginPage.clickUser();
        CheckoutPageBase checkoutPage = loginPage.clickLoginBtnForCheckout();
        Assert.assertTrue(checkoutPage.isOpened(), "Checkout page isn't open");
        checkoutPage.clickPaymentBtn();
        Assert.assertTrue(checkoutPage.checkPaymentFailed(), "Payment is success");
    }

    @Test
    @MethodOwner(owner = "qpsdemo")
    @TestLabel(name = "feature", value = {"mobile", "regression"})
    public void testAmountCartAdded() {
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
        int amount = (int) (Math.random() * 10);
        productPage.addSeveralProducts(amount);
        productPage.addToCart();
        CartPageBase cartPage = productPage.goToCart();
        double teoreticFinalCost = amount * cartPage.costOfProduct();
        Assert.assertEquals(teoreticFinalCost, cartPage.endSumComparison(), "Sum isn't increase");
    }


    @Test
    @MethodOwner(owner = "qpsdemo")
    @TestLabel(name = "feature", value = {"mobile", "regression"})
    public void testResetCartIcon() {
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
        Assert.assertTrue(productPage.isPageOpened(), "ProductPage isn't Open");
        productPage.addToCart();
        MorePageBase morePage = productPage.openMorePage();
        PopUpResetPageBase resetPage = morePage.resetApp();
        resetPage.clickResetBtn();
        Assert.assertTrue(morePage.isPageOpened(), "morePage isn't open");
        CartPageBase cartPage = morePage.openCart();
        Assert.assertTrue(cartPage.isBasketEmpty());
    }


    @Test
    @MethodOwner(owner = "qpsdemo")
    @TestLabel(name = "feature", value = {"mobile", "regression"})
    public void testCheckAmountCartAddedAndSubstracted() {
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
        int amount = (int) (Math.random() * 10);
        productPage.addSeveralProducts(amount);
        productPage.deleteSeveralProducts(amount);
        productPage.addToCart();
        CartPageBase cartPageBase = productPage.goToCart();
        Assert.assertTrue(cartPageBase.checkOneProductOnCart(), "cart hasn't one product");
    }

    @Test
    @MethodOwner(owner = "qpsdemo")
    @TestLabel(name = "feature", value = {"mobile", "regression"})
    public void testRemoveItemFromCart() {
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
        int amount = (int) (Math.random() * 10);
        productPage.addSeveralProducts(amount);
        productPage.addToCart();
        CartPageBase cartPage = productPage.goToCart();
        cartPage.removeItemFromCart();
        Assert.assertTrue(cartPage.isCartEmpty(), "Cart isn't empty");
    }
}
