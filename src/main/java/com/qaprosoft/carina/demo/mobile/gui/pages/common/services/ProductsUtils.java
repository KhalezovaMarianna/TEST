package com.qaprosoft.carina.demo.mobile.gui.pages.common.services;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.webdriver.IDriverPool;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.HomePageBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.ProductPageBase;
import org.testng.Assert;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

public class ProductsUtils extends AbstractTest implements IDriverPool {
    public ProductPageBase addOneProductToCart() {
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
        productPage.addSeveralProducts(1);
        productPage.addToCart();
        return productPage.initPage(getDriver(), ProductPageBase.class);
    }
    public ProductPageBase addSeveralProductToCart() {
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
        productPage.addSeveralProducts(12);
        productPage.addToCart();
        return productPage.initPage(getDriver(), ProductPageBase.class);
    }


}
