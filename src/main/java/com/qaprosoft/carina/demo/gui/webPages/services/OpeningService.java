package com.qaprosoft.carina.demo.gui.webPages.services;

import com.qaprosoft.carina.core.foundation.webdriver.IDriverPool;
import com.qaprosoft.carina.demo.gui.webPages.HomePage;
import com.qaprosoft.carina.demo.gui.webPages.ProductPage;
import org.testng.Assert;

public class OpeningService implements IDriverPool {
    public ProductPage openProductByIndex() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isOpened(), "Home page is not opened");
        int index = (int) (Math.random() * 10);
        ProductPage productPage = homePage.productOpenedByIndex(index);
        Assert.assertTrue(productPage.isOpened(), "product isn't opened");
        return productPage.clickAddToCartButton();
    }

}
