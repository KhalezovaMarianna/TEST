package com.qaprosoft.carina.demo.gui.webPages.common.componentsBase;

import com.qaprosoft.carina.core.foundation.utils.factory.ICustomTypePageFactory;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.qaprosoft.carina.demo.gui.webPages.base.BaseDemoblazePage;
import com.qaprosoft.carina.demo.gui.webPages.common.*;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

public abstract class HeaderBase extends BaseDemoblazePage {



    public HeaderBase(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public abstract SignUpPageBase goToSignUpPage();
    public abstract LoginPageBase goToLoginPage();
    public abstract ContactPageBase goToContactPage();
    public abstract AboutUsPageBase goToAboutPage();
    public abstract CartPageBase openCart();
}
