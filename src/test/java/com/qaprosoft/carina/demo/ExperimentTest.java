package com.qaprosoft.carina.demo;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.demo.gui.webPages.common.HomePageBase;
import com.zebrunner.agent.core.annotation.TestLabel;
import org.testng.annotations.Test;

public class ExperimentTest extends AbstractTest {
    @Test()
    @MethodOwner(owner = "marianna_khalezova")
    @TestLabel(name = "feature", value = {"web", "acceptance"})
    public void testSlidingWindow() {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();

    }
}
