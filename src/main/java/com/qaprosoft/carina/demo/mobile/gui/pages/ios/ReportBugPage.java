package com.qaprosoft.carina.demo.mobile.gui.pages.ios;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.locator.ExtendedFindBy;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.ProductPageBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.ReportBugPageBase;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass =ReportBugPageBase.class)
public class ReportBugPage extends ReportBugPageBase {

    @ExtendedFindBy(iosPredicate = "type == \"XCUIElementTypeTextField\"")
    private ExtendedWebElement emailForm;

    @ExtendedFindBy(iosPredicate = "value == \"Your Message\"")
    private ExtendedWebElement messageForm;

    @ExtendedFindBy(accessibilityId = "Send")
    private ExtendedWebElement sendBtn;


    public ReportBugPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isReportBugPageOpened() {
        return messageForm.isElementPresent() && emailForm.isElementPresent();
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
    public void fillMessageForm(String message) {
        messageForm.type(message);
    }

}
