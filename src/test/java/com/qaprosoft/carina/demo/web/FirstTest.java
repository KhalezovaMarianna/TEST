package com.qaprosoft.carina.demo.web;

import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.core.foundation.utils.tag.Priority;
import com.qaprosoft.carina.core.foundation.utils.tag.TestPriority;
import com.qaprosoft.carina.demo.gui.webPages.common.*;
import com.qaprosoft.carina.demo.gui.webPages.common.componentsBase.HeaderBase;
import com.qaprosoft.carina.demo.gui.webPages.utils.MobileUtils;
import com.zebrunner.agent.core.annotation.TestLabel;
import com.zebrunner.agent.core.annotation.TestRailCaseId;
import com.zebrunner.agent.core.registrar.Zephyr;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class FirstTest extends BaseTest {
    //    @BeforeSuite
//    public void setUp() {
//        TestRail.setSuiteId("S17");
//        TestRail.setRunName("Best run ever");
//        TestRail.setAssignee("Marianna");
//    }
//@BeforeSuite
//public void setUp() {
//    Xray.setExecutionKey("QAL-60");
//}
    @BeforeSuite
    public void setUp() {
        Zephyr.setTestCycleKey("QAL-60");
        Zephyr.setJiraProjectKey("QAL");
    }

    @Test()
    @TestRailCaseId("C44")
    @MethodOwner(owner = "marianna_khalezova")
    @TestPriority(Priority.P1)
    @TestLabel(name = "feature", value = {"web", "acceptance"})
    public void testPlacingOrder() {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        Assert.assertTrue(homePage.isOpened(), "Home page is not opened");
        int index = (int) (Math.random() * 10);
        ProductPageBase productPage = homePage.productOpenedByIndex(index);
        Assert.assertTrue(productPage.isOpened(), "product isn't opened");
        productPage.clickAddToCartButton();
        HeaderBase header = productPage.getHeader();
        CartPageBase cartPage = header.openCart();
        Assert.assertTrue(cartPage.isOpened(), "cart isn't open");
        PlaceOrderPageBase placeOrderPage = cartPage.clickPlaceOrderBtn();
        placeOrderPage.filledNameForm(R.TESTDATA.get("TEST_NAME"));
        placeOrderPage.filledCartForm(R.TESTDATA.get("TEST_CARD"));
        PopUpOrderPageBase popUpOrderPage = placeOrderPage.clickSendOrderButton();
        Assert.assertTrue(popUpOrderPage.isOpened(), "Order isn't successful");
        popUpOrderPage.closePage();
        if (MobileUtils.isIOS()) {
            popUpOrderPage.isOpened();
        } else {
            Assert.assertFalse(homePage.isOpened(), "home page isn't open");
            header.openCart();
            Assert.assertTrue(cartPage.isCartEmpty(), "cart isn't empty");
        }
    }

}
