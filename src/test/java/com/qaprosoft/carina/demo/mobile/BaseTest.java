package com.qaprosoft.carina.demo.mobile;


import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.services.AddOneProductToCart;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.services.GoToCheckOutPage;

public class BaseTest implements IAbstractTest {

    protected AddOneProductToCart addOneProductToCart = new AddOneProductToCart();
    protected GoToCheckOutPage goToCheckOutPage = new GoToCheckOutPage();


}
