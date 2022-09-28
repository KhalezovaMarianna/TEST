package com.qaprosoft.carina.demo.web.gui.webPages.utils;


import com.qaprosoft.carina.core.foundation.utils.factory.ICustomTypePageFactory;
import com.qaprosoft.carina.core.foundation.webdriver.IDriverPool;
import com.qaprosoft.carina.demo.web.gui.webPages.pages.HomePage;
import com.qaprosoft.carina.demo.web.gui.webPages.pages.ProductPage;
import org.testng.Assert;

public class OpeningService implements IDriverPool, ICustomTypePageFactory {
    public ProductPage openProductByIndex() {
        HomePage homePage = initPage(getDriver(),HomePage.class);
        homePage.open();
        Assert.assertTrue(homePage.isOpened(), "Home page is not opened");
        int index = (int) (Math.random() * 10);
        ProductPage productPage = homePage.productOpenedByIndex(index);
        Assert.assertTrue(productPage.isOpened(), "product isn't opened");
        return  productPage.clickAddToCartButton();
    }

}
