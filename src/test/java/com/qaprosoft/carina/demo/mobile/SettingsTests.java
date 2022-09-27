package com.qaprosoft.carina.demo.mobile;

import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.core.foundation.utils.mobile.IMobileUtils;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.HomePageBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.MorePageBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.ReportBugPageBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.WebviewPageBase;
import com.zebrunner.agent.core.annotation.TestLabel;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SettingsTests extends BaseTest implements IMobileUtils {
    @Test
    @MethodOwner(owner = "Marianna")
    @TestLabel(name = "feature", value = {"mobile", "regression"})
    public void testReportingABugIsWorking() {
        HomePageBase homePage = initPage(HomePageBase.class);
        MorePageBase morePage = homePage.clickMoreBtn();
        Assert.assertTrue(morePage.isOpened(), "more page isn't opened");
        ReportBugPageBase reportBugPageBase = morePage.clickReportBugBtn();
        Assert.assertTrue(reportBugPageBase.isOpened(), "reporting a bug isn't opened");
        Assert.assertTrue(reportBugPageBase.fillEmailForm(R.TESTDATA.get("TEST_EMAIL")), "email isn't correct");
        Assert.assertEquals(R.TESTDATA.get("TEST_EMAIL"), reportBugPageBase.checkCorrectEmail());
        reportBugPageBase.clickUser(R.TESTDATA.get("TEST_MESSAGE"));
        reportBugPageBase.sendMessage();
        Assert.assertFalse(reportBugPageBase.closePopUpMessage());
    }


    @Test()
    @MethodOwner(owner = "Marianna")
    @TestLabel(name = "feature", value = {"mobile", "regression"})
    public void checkIsCorrectURLWebview() {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        Assert.assertTrue(homePage.isOpened(), "Home page isn't opened");
        MorePageBase morePageBase = homePage.clickMoreBtn();
        Assert.assertTrue(morePageBase.isOpened(), "Menu isn't opened");
        WebviewPageBase webviewPageBase = morePageBase.clickWebviewBtn();
        Assert.assertTrue(webviewPageBase.isOpened(), "Webview page isn't open");
        Assert.assertTrue(webviewPageBase.checkIsCorrectURL(R.TESTDATA.get("TEST_URL")), "URL isn't correct");
        Assert.assertEquals(R.TESTDATA.get("TEST_URL"), webviewPageBase.checkEqualURL(), "Data is correct");
    }

}
