package com.qaprosoft.carina.demo.gui.webPages.components;

import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductContainer extends AbstractUIObject {

    @FindBy(xpath = "//*[@id=\"tbodyid\"]/div")
    private List<ProductContainer> resultProducts;

    public ProductContainer(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public List<ProductContainer> getResultProducts() {
        return resultProducts;
    }
}
