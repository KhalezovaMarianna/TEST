package com.qaprosoft.carina.demo.mobile.gui.pages.ios;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.utils.mobile.IMobileUtils;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.locator.ExtendedFindBy;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.*;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = MorePageBase.class)
public class MorePage extends MorePageBase implements IMobileUtils {

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`name == \"About-menu-item\"`]")
    private ExtendedWebElement aboutBtn;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`name == \"Cart-tab-item\"`]")
    private ExtendedWebElement openCart;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`name == \"Catalog-tab-item\"`]")
    private ExtendedWebElement catalogBtn;

    @ExtendedFindBy(accessibilityId = "Webview-menu-item")
    private ExtendedWebElement webviewBtn;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`name == \"Drawing-menu-item\"`]")
    private ExtendedWebElement drawingBtn;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`name == \"ResetAppState-menu-item\"`]")
    private ExtendedWebElement resetBtn;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`name == \"LogOut-menu-item\"`]")
    private ExtendedWebElement loginBtn;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[5]/XCUIElementTypeButton[1]")
    private ExtendedWebElement reportBugBtn;
    public MorePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isMorePageOpen() {
        return aboutBtn.isElementPresent();
    }

    @Override
    public CartPageBase openCart() {
        openCart.click();
        return initPage(getDriver(), CartPageBase.class);
    }

    @Override
    public PopUpResetPageBase resetApp() {
        resetBtn.click();
        return initPage(getDriver(), PopUpResetPageBase.class);
    }

    public AboutPage clickAboutBtn() {
        aboutBtn.click();
        return new AboutPage(getDriver());
    }

    public HomePage clickCatalogBtn() {
        catalogBtn.click();
        return new HomePage(getDriver());
    }

    @Override
    public LoginPageBase clickLoginBtn() {
        loginBtn.click();
        return initPage(getDriver(),LoginPageBase.class);
    }

    @Override
    public ReportBugPageBase clickReportBugBtn() {
        reportBugBtn.click();
        return initPage(getDriver(),ReportBugPageBase.class);
    }

    @Override
    public WebviewPageBase clickWebviewBtn() {
        webviewBtn.click();
        return initPage(getDriver(),WebviewPageBase.class);
    }
}
