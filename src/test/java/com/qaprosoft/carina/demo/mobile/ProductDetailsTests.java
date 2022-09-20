package com.qaprosoft.carina.demo.mobile;

import com.qaprosoft.carina.core.foundation.utils.mobile.IMobileUtils;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.CartPageBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.HomePageBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.ProductPageBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.SortByPopUpPageBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.enums.ColorsSectionOptions;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.enums.SortBy;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.utils.DataLoader;
import com.qaprosoft.carina.demo.mobile.gui.pages.ios.HomePage;
import com.qaprosoft.carina.demo.mobile.gui.pages.ios.ProductPage;
import com.zebrunner.agent.core.annotation.TestLabel;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.security.SecureRandom;
import java.util.*;

public class ProductDetailsTests extends BaseTest implements IMobileUtils {
    @Test()
    @MethodOwner(owner = "Marianna")
    @TestLabel(name = "feature", value = {"mobile", "regression"})
    public void testImageDownload() {

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
        Assert.assertTrue(productPage.checkImageDownloading(), "image isn't download");
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
        Assert.assertTrue(homePage.isOpened(), "HomePage isn't open");
        ProductPageBase productPage = homePage.clickRandomProduct(title);
        Assert.assertTrue(productPage.isOpened(), "Product isn't open");
        Assert.assertTrue(productPage.checkChosenColor(ColorsSectionOptions.BLACK.getColor()));
        Assert.assertTrue(productPage.checkChosenColor(ColorsSectionOptions.GRAY.getColor()));
        Assert.assertTrue(productPage.checkChosenColor(ColorsSectionOptions.RED.getColor()));
        Assert.assertTrue(productPage.checkChosenColor(ColorsSectionOptions.BLUE.getColor()));

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
        Assert.assertTrue(homePage.isOpened(), "App Home page isn't opened.");
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


    @Test
    @MethodOwner(owner = "Marianna")
    @TestLabel(name = "feature", value = {"mobile", "regression"})
    public void testFooterSocialNetworks() {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        Assert.assertTrue(homePage.isOpened());
        Assert.assertTrue(homePage.isLinkedinLogoPresent());
        Assert.assertTrue(homePage.isTwitterLogoPresent());

    }
    @Test
    @MethodOwner(owner = "qpsdemo")
    @TestLabel(name = "feature", value = {"mobile", "regression"})
    public void testRateProduct() {
        HomePage homePage = new HomePage(getDriver());
        Assert.assertTrue(homePage.isPageOpened(), "HomePage isn't open");
        ProductPage productPage = homePage.clickProductImg("3");
        Assert.assertTrue(productPage.isPageOpened(), "right product isn't open");
        productPage.rateProduct();
        Assert.assertTrue(homePage.isPageOpened(), "rate isn't passed");

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
