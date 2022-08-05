package com.qaprosoft.carina.demo.gui.webPages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.gui.webPages.base.BaseDemoblazePage;
import com.qaprosoft.carina.demo.gui.webPages.components.ProductContainer;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class ResultPage extends BaseDemoblazePage {

    @FindBy(xpath = "//*[@id=\"cat\"]")
    private ExtendedWebElement categories;
    @FindBy(xpath = "//*[@id=\"tbodyid\"]/div")
    private List<ProductContainer> resultProducts;

    public ResultPage(WebDriver driver) {
        super(driver);
    }

    public int getNumberOfProductFound() {
        return resultProducts.size();
    }

    public List<String> getResultProductTitles() {
        List<String> productTitles = new ArrayList<>();
        for (ProductContainer productContainer : resultProducts) {
            productTitles.add(productContainer.getProductName());
        }
        return productTitles;
    }

    public List<ProductContainer> getResultProducts() {
        System.out.println(resultProducts);
        return resultProducts;
    }

    @Override
    public boolean isOpened() {
        return categories.isElementPresent();
    }
}
