package com.qaprosoft.carina.demo.mobile;


import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.demo.gui.webPages.services.AuthenticationService;
import com.qaprosoft.carina.demo.gui.webPages.services.OpeningService;
import com.qaprosoft.carina.demo.mobile.gui.pages.services.AddOneProductToCart;
import com.qaprosoft.carina.demo.mobile.gui.pages.services.GoToCheckOutPage;

public class BaseTest implements IAbstractTest {

    protected AddOneProductToCart addOneProductToCart = new AddOneProductToCart();
    protected GoToCheckOutPage goToCheckOutPage = new GoToCheckOutPage();


}
