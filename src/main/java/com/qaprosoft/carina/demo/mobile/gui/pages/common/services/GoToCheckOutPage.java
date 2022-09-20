package com.qaprosoft.carina.demo.mobile.gui.pages.common.services;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.webdriver.IDriverPool;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.*;
import org.testng.Assert;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

public class GoToCheckOutPage extends AbstractTest implements IDriverPool {
    public CheckoutPageBase goToCheckoutPageWithManyProducts() {
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
        double teoreticFinalCost = count * cartPage.costOfProduct();
        Assert.assertEquals(teoreticFinalCost, cartPage.endSumComparison(), "Sum isn't increase");
        LoginPageBase loginPage = cartPage.clickProcessedToCheckoutBtn();
        Assert.assertTrue(loginPage.isPageOpened());
        loginPage.clickUser();
        CheckoutPageBase checkoutPage = loginPage.clickLoginBtnForCheckout();
        Assert.assertTrue(checkoutPage.isPageOpened());
        return initPage(getDriver(), CheckoutPageBase.class);
    }
}
