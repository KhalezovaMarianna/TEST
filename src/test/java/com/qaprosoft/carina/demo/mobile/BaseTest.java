package com.qaprosoft.carina.demo.mobile;


import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.services.ProductsUtils;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.services.GoToCheckOutPage;

public class BaseTest implements IAbstractTest {

    protected ProductsUtils addOneProductToCart = new ProductsUtils();
    protected GoToCheckOutPage goToCheckOutPage = new GoToCheckOutPage();


}
