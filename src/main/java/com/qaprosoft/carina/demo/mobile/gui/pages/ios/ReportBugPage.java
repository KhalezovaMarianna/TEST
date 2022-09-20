package com.qaprosoft.carina.demo.mobile.gui.pages.ios;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.locator.ExtendedFindBy;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.MorePageBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.ProductPageBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.ReportBugPageBase;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = ReportBugPageBase.class)
public class ReportBugPage extends ReportBugPageBase {

    @ExtendedFindBy(iosPredicate = "type == \"XCUIElementTypeTextField\"")
    private ExtendedWebElement emailForm;

    @ExtendedFindBy(iosPredicate = "value == \"Your Message\"")
    private ExtendedWebElement messageForm;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`label == \"Close\"`]")
    private ExtendedWebElement popUpCloseBtn;

    @ExtendedFindBy(accessibilityId = "testfairy-edit-screenshot")
    private ExtendedWebElement screenshotFill;

    @ExtendedFindBy(accessibilityId = "Send")
    private ExtendedWebElement sendBtn;

    @ExtendedFindBy(accessibilityId = "Cancel")
    private ExtendedWebElement backBtn;

    public ReportBugPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return messageForm.isElementPresent() && emailForm.isElementPresent() && screenshotFill.isElementPresent() && sendBtn.isElementPresent();
    }

    @Override
    public boolean fillEmailForm(String email) {
        emailForm.type(email);
        if (email.contains("@")) {
            return true;
        } else {
            return false;
        }

    }

    @Override
    public void sendMessage() {
        sendBtn.click();
    }

    @Override
    public void clickUser(String message) {
        messageForm.type(message);
    }

    @Override
    public boolean closePopUpMessage() {
        if (popUpCloseBtn.isElementPresent()) {
            popUpCloseBtn.clickIfPresent();
            return true;
        } else {
            return false;
        }

    }

    @Override
    public MorePageBase clickBackBtn() {
        backBtn.click();
        return initPage(MorePageBase.class);
    }

    @Override
    public String checkCorrectEmail() {
        return emailForm.getText();
    }

}
