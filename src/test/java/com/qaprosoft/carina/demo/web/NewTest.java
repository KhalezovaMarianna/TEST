
package com.qaprosoft.carina.demo.web;

import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.core.foundation.utils.tag.Priority;
import com.qaprosoft.carina.core.foundation.utils.tag.TestPriority;
import com.qaprosoft.carina.demo.gui.webPages.common.HomePageBase;
import com.qaprosoft.carina.demo.gui.webPages.iosWeb.HomePage;
import com.zebrunner.agent.core.annotation.TestLabel;
import org.testng.annotations.Test;

public class NewTest extends BaseTest {
    @Test()
    @MethodOwner(owner = "marianna_khalezova")
    @TestPriority(Priority.P1)
    @TestLabel(name = "feature", value = {"web", "acceptance"})
    public void test(){
        HomePage homePage = new HomePage(getDriver());
        homePage.open();

    }
}
