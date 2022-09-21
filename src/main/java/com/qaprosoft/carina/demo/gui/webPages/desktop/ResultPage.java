package com.qaprosoft.carina.demo.gui.webPages.desktop;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.gui.webPages.common.ResultPageBase;
import com.qaprosoft.carina.demo.gui.webPages.common.componentsBase.FooterBase;
import com.qaprosoft.carina.demo.gui.webPages.common.componentsBase.HeaderBase;
import com.qaprosoft.carina.demo.gui.webPages.desktop.components.Footer;
import com.qaprosoft.carina.demo.gui.webPages.desktop.components.Header;
import com.qaprosoft.carina.demo.gui.webPages.desktop.components.ProductContainer;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = ResultPageBase.class)
public class ResultPage extends ResultPageBase {
    @FindBy(xpath = "//*[@id=\"navbarExample\"]/ul")
    private Header header;
    @FindBy(xpath = "//*[@id=\"footc\"]")
    private Footer footer;
    @FindBy(xpath = "//*[@id=\"cat\"]")
    private ExtendedWebElement categories;

    @FindBy(xpath = "//*[@id=\"tbodyid\"]/div")
    private List<ProductContainer> resultProducts;

    public ResultPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public HeaderBase getHeaderBase() {
        return header;
    }

    @Override
    public FooterBase getFooterBase() {
        return footer;
    }

    @Override
    public int getNumberOfProductFound() {
        return resultProducts.size();
    }

    @Override
    public List<String> getResultProductTitles() {
        List<String> productTitles = new ArrayList<>();
        for (ProductContainer productContainer : resultProducts) {
            productTitles.add(productContainer.getProductName());
        }
        return productTitles;
    }

    @Override
    public List<ProductContainer> getResultProducts() {
        System.out.println(resultProducts);
        return resultProducts;
    }

    @Override
    public boolean isOpened() {
        return categories.isElementPresent();
    }
}
