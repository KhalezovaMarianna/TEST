package com.qaprosoft.carina.demo.gui.webPages.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductContainer extends AbstractUIObject {

    @FindBy(xpath = ".//*[@id=\"tbodyid\"]//h4/a")
    private ExtendedWebElement productName;

    public ProductContainer(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public String getProductName() {
        return productName.getText();
    }

    @Override
    public String toString() {
        return "ProductContainer{" +
                "productName=" + productName.getText() +
                '}';
    }
}
