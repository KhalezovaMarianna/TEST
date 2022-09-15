package com.qaprosoft.carina.demo.mobile.gui.pages.android;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.locator.ExtendedFindBy;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.HomePageBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.ReportBugPageBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.SortByPopUpPageBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.enums.SortBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = SortByPopUpPageBase.class)
public class SortByPopUpPage extends SortByPopUpPageBase {
    @FindBy(id = "com.saucelabs.mydemoapp.android:id/sortTV")
    private ExtendedWebElement title;

    @ExtendedFindBy(accessibilityId = "Ascending order by name")
    private ExtendedWebElement nameAscSort;

    @ExtendedFindBy(accessibilityId = "Descending order by name")
    private ExtendedWebElement nameDescSort;

    @ExtendedFindBy(accessibilityId = "Ascending order by price")
    private ExtendedWebElement priceAscSort;

    @ExtendedFindBy(accessibilityId = "Descending order by price")
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
