package com.qaprosoft.carina.demo.mobile.gui.pages.ios;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.locator.ExtendedFindBy;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.HomePageBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.ReportBugPageBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.SortByPopUpPageBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.enums.SortBy;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = SortByPopUpPageBase.class)
public class SortByPopUpPage extends SortByPopUpPageBase {
    @ExtendedFindBy(accessibilityId = "Sort by:")
private ExtendedWebElement title;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`label == \"Name - Ascending\"`]")
    private ExtendedWebElement nameAscSort;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`label == \"Name - Descending\"`]")
    private ExtendedWebElement nameDescSort;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`label == \"Price - Ascending\"`]")
    private ExtendedWebElement priceAscSort;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`label == \"Price - Descending\"`]")
    private ExtendedWebElement priceDescSort;

    public SortByPopUpPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isTitlePresent() {
        return title.isElementPresent();
    }

    @Override
    public HomePageBase clickSortingMethodBtn(SortBy sort) {
        switch (sort) {
            case NAME_DESK:
                nameDescSort.click();
                break;
            case PRICE_ASC:
                priceAscSort.click();
                break;
            case PRICE_DESC:
                priceDescSort.click();
                break;
            default:
                nameAscSort.click();
        }
        return initPage(getDriver(), HomePageBase.class);
    }
}
