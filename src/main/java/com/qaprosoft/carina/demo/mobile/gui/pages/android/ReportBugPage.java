package com.qaprosoft.carina.demo.mobile.gui.pages.android;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.utils.mobile.IMobileUtils;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.locator.ExtendedFindBy;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.ReportBugPageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;


@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ReportBugPageBase.class)
public class ReportBugPage extends ReportBugPageBase implements IMobileUtils {


    @FindBy(xpath = "//android.widget.EditText[@content-desc=\"Your message\"]")
    private ExtendedWebElement messageForm;

    @FindBy(xpath = "//android.widget.EditText[@content-desc=\"Your email\"]")
    private ExtendedWebElement emailForm;

    @ExtendedFindBy(accessibilityId = "Send")
    private ExtendedWebElement sendBtn;

    public ReportBugPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isReportBugPageOpened() {
        return emailForm.isElementPresent() && messageForm.isElementPresent();
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
