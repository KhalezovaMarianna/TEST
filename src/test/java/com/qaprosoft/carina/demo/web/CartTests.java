package com.qaprosoft.carina.demo.web;


import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.demo.web.gui.webPages.components.Header;
import com.qaprosoft.carina.demo.web.gui.webPages.pages.*;
import com.zebrunner.agent.core.annotation.TestLabel;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTests extends BaseTest {
    @Test()
    @MethodOwner(owner = "marianna_khalezova")
    @TestLabel(name = "feature", value = {"web", "acceptance"})
    public void testPlacingOrderNegative() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isOpened(), "Home page is not opened");
        int index = (int) (Math.random() * 10);
        ProductPage productPage = homePage.productOpenedByIndex(index);
        Assert.assertTrue(productPage.isOpened(), "product isn't opened");
        productPage.clickAddToCartButton();
        Header header = productPage.getHeader();
        Assert.assertEquals(getDriver().switchTo().alert().getText(), "Product added", "product added successful.");
        getDriver().switchTo().alert().accept();
        CartPage cartPage = header.openCart();
        Assert.assertTrue(cartPage.isOpened(), "cart isn't open");
        PlaceOrderPage placeOrderPage = cartPage.clickPlaceOrderBtn();
        placeOrderPage.clickSendOrderWithEmptyForms();
        Assert.assertEquals(getDriver().switchTo().alert().getText(), "Please fill out Name and Creditcard.", "Please fill out Name and Creditcard.");
        getDriver().switchTo().alert().accept();
        Assert.assertTrue(placeOrderPage.isOpened(), "order is successful");
    }

    @Test()
    @MethodOwner(owner = "marianna_khalezova")
    @TestLabel(name = "feature", value = {"web", "acceptance"})
    public void testPlacingOrder() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isOpened(), "Home page is not opened");
        int index = (int) (Math.random() * 10);
        ProductPage productPage = homePage.productOpenedByIndex(index);
        Assert.assertTrue(productPage.isOpened(), "product isn't opened");
        productPage.clickAddToCartButton();
        Header header = productPage.getHeader();
        Assert.assertEquals(getDriver().switchTo().alert().getText(), "Product added", "Product added");
        getDriver().switchTo().alert().accept();
        CartPage cartPage = header.openCart();
        Assert.assertTrue(cartPage.isOpened(), "cart isn't open");
        PlaceOrderPage placeOrderPage = cartPage.clickPlaceOrderBtn();
        placeOrderPage.filledNameForm(R.TESTDATA.get("TEST_NAME"));
        placeOrderPage.filledCartForm(R.TESTDATA.get("TEST_CARD"));
        PopUpOrderPage popUpOrderPage = placeOrderPage.clickSendOrderButton();
        Assert.assertTrue(popUpOrderPage.isOpened(), "Order isn't successful");
        popUpOrderPage.closePage();
        Assert.assertTrue(homePage.isOpened(), "home page isn't open");
        header.openCart();
        Assert.assertTrue(cartPage.isCartEmpty(), "cart isn't empty");
    }

    @Test()
    @MethodOwner(owner = "marianna_khalezova")
    @TestLabel(name = "feature", value = {"web", "acceptance"})
    public void testProductOnTheCart() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isOpened(), "Home page is not opened");
        int index = (int) (Math.random() * 10);
        pause(2);
        ProductPage productPage = homePage.productOpenedByIndex(index);
        Assert.assertTrue(productPage.isOpened(), "product isn't opened");
        productPage.clickAddToCartButton();
        Assert.assertEquals(getDriver().switchTo().alert().getText(), "Product added", "product added successful.");
        getDriver().switchTo().alert().accept();
        Header header = productPage.getHeader();
        CartPage cartPage = header.openCart();
        pause(5);
        Assert.assertEquals(cartPage.getCartTotal(), cartPage.getProductPrice(), "Product isn't true on cart");
        cartPage.deleteProductByIndex("1");
        cartPage.goToHome();
        Assert.assertTrue(homePage.isOpened(), "home page isn't opened");
    }

    @Test()
    @MethodOwner(owner = "marianna_khalezova")
    @TestLabel(name = "feature", value = {"web", "acceptance"})
    public void testAddProductOnTheCart() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isOpened(), "Home page is not opened");
        int index = (int) (Math.random() * 10);
        pause(2);
        ProductPage productPage = homePage.productOpenedByIndex(index);
        Assert.assertTrue(productPage.isOpened(), "product isn't opened");
        productPage.clickAddToCartButton();
        Assert.assertEquals(getDriver().switchTo().alert().getText(), "Product added", "product added successful.");
        getDriver().switchTo().alert().accept();
        Header header = productPage.getHeader();
        CartPage cartPage = header.openCart();
        pause(5);
        Assert.assertEquals(cartPage.getCartTotal(), cartPage.getProductPrice(), "Product isn't true on cart");
        cartPage.deleteAllProducts();
        Assert.assertTrue(cartPage.isCartEmpty(), "Cart isn't empty");
        cartPage.goToHome();
        Assert.assertTrue(homePage.isOpened(), "Home page isn't opened");
    }
}
