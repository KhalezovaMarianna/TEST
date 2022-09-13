package com.qaprosoft.carina.demo.mobile;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.utils.mobile.IMobileUtils;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.*;
import com.qaprosoft.carina.demo.mobile.gui.pages.ios.HomePage;
import com.qaprosoft.carina.demo.mobile.gui.pages.ios.ProductPage;
import com.zebrunner.agent.core.annotation.TestLabel;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.security.SecureRandom;
import java.util.*;

public class TestsDemoMobileApp implements IAbstractTest, IMobileUtils {
    @Test
    @MethodOwner(owner = "qpsdemo")
    @TestLabel(name = "feature", value = {"mobile", "regression"})
    public void testOpenPages() {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        CartPageBase cartPage = homePage.clickBasketBtn();
        Assert.assertTrue(cartPage.isCartPageOpened(),
                "Page isn't opened");
        cartPage.clickGoShoppingBtn();
        Assert.assertTrue(homePage.isHomePageOpen(),
                "homePage isn't open");
        MorePageBase morePage = homePage.clickMoreBtn();
        Assert.assertTrue(morePage.isMorePageOpen(),
                "morePage isn't open");
        AboutPageBase aboutPage = morePage.clickAboutBtn();
        Assert.assertTrue(aboutPage.isAboutPageOpen(),
                "aboutPage isn't open");
        aboutPage.clickBackBtn();
        Assert.assertFalse(homePage.isHomePageOpen(),
                "HOMEPage is not open");
        morePage.clickCatalogBtn();
        Assert.assertTrue(homePage.isHomePageOpen(),
                "Catalog isn't open");
        ProductPageBase productPage = homePage.clickProductImg("3");
        productPage.addProduct();
        Assert.assertFalse(homePage.isHomePageOpen(), "HomePage isn't open");
        morePage.clickCatalogBtn();
        homePage.clickProductByIndex("5");
        Assert.assertTrue(productPage.isProductPageOpen(), "something don't go");

    }

    @Test
    @MethodOwner(owner = "qpsdemo")
    @TestLabel(name = "feature", value = {"mobile", "regression"})
    public void testRateProduct() {
        HomePage homePage = new HomePage(getDriver());
        Assert.assertTrue(homePage.isHomePageOpen(), "HomePage isn't open");
        ProductPage productPage = homePage.clickProductImg("3");
        Assert.assertTrue(productPage.isProductPageOpen(), "right product isn't open");
        productPage.rateProduct();
        Assert.assertTrue(homePage.isHomePageOpen(), "rate isn't passed");

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
        Assert.assertTrue(homePage.isHomePageOpen(), "HomePage isn't open");
        ProductPageBase productPage = homePage.clickRandomProduct(title);
        Assert.assertTrue(productPage.isProductPageOpen(), "Product isn't open");
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
        Assert.assertTrue(homePage.isHomePageOpen(), "HomePage isn't open");
        ProductPageBase productPage = homePage.clickRandomProduct(title);
        Assert.assertTrue(productPage.isProductPageOpen(), "Product isn't open");
        int amount = (int) (Math.random() * 10);
        productPage.addSeveralProducts(amount);
        productPage.addToCart();
        CartPageBase cartPage = productPage.goToCart();
        cartPage.removeItemFromCart();
        Assert.assertTrue(cartPage.isCartEmpty(), "Cart isn't empty");
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
        Assert.assertTrue(homePage.isHomePageOpen(), "HomePage isn't open");
        ProductPageBase productPage = homePage.clickRandomProduct(title);
        Assert.assertTrue(productPage.isProductPageOpen(), "ProductPage isn't Open");
        productPage.addToCart();
        MorePageBase morePage = productPage.openMorePage();
        PopUpResetPageBase resetPage = morePage.resetApp();
        resetPage.clickResetBtn();
        Assert.assertTrue(morePage.isMorePageOpen(), "morePage isn't open");
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
        Assert.assertTrue(homePage.isHomePageOpen(), "HomePage isn't open");
        ProductPageBase productPage = homePage.clickRandomProduct(title);
        Assert.assertTrue(productPage.isProductPageOpen(), "Product isn't open");
        int amount = (int) (Math.random() * 10);
        productPage.addSeveralProducts(amount);
        productPage.deleteSeveralProducts(amount);
        productPage.addToCart();
        CartPageBase cartPageBase = productPage.goToCart();
        Assert.assertTrue(cartPageBase.checkOneProductOnCart(), "cart hasn't one product");


    }

}

