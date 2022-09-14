package com.qaprosoft.carina.demo.mobile.gui.pages.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class ReportBugPageBase extends AbstractPage {

    public ReportBugPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isReportBugPageOpened();

    public abstract boolean fillEmailForm(String email);

    public abstract void sendMessage();

    public abstract void fillMessageForm(String message);


}
