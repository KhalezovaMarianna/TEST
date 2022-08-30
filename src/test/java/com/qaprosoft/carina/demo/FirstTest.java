package com.qaprosoft.carina.demo;

import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.core.foundation.utils.tag.Priority;
import com.qaprosoft.carina.core.foundation.utils.tag.TestPriority;
import com.qaprosoft.carina.demo.gui.webPages.*;
import com.qaprosoft.carina.demo.gui.webPages.components.HeaderMenu;
import com.zebrunner.agent.core.annotation.TestLabel;
import com.zebrunner.agent.core.annotation.TestRailCaseId;
import com.zebrunner.agent.core.registrar.TestRail;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class FirstTest extends BaseTest{
    @BeforeSuite
    public void setUp() {
        TestRail.setSuiteId("S17");
        TestRail.setRunName("Best run ever");
        TestRail.setAssignee("Marianna");
    }
    @Test()
    @TestRailCaseId("C44")
    @MethodOwner(owner = "marianna_khalezova")
    @TestPriority(Priority.P1)
    @TestLabel(name = "feature", value = {"web", "acceptance"})
    public void testPlacingOrder() {
        ProductPage productPage = openingService.openProductByIndex();
        HeaderMenu headerMenu = productPage.getHeader();
        CartPage cartPage = headerMenu.openCart();
        Assert.assertTrue(cartPage.isOpened(), "cart isn't open");
        PlaceOrderPage placeOrderPage = cartPage.clickPlaceOrderBtn();
        placeOrderPage.filledNameForm(R.TESTDATA.get("TEST_NAME"));
        placeOrderPage.filledCartForm(R.TESTDATA.get("TEST_CARD"));
        PopUpOrderPage popUpOrderPage = placeOrderPage.clickSendOrderButton();
        Assert.assertTrue(popUpOrderPage.isOpened(), "Order isn't successful");
        HomePage homePage = popUpOrderPage.closePage();
        Assert.assertTrue(homePage.isOpened(),"home page isn't open");
        headerMenu.openCart();
        Assert.assertTrue(cartPage.isCartEmpty(),"cart isn't empty");

    }

}
