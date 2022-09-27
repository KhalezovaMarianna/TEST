package com.qaprosoft.carina.demo.gui.webPages.common;

import com.qaprosoft.carina.demo.gui.webPages.common.base.BaseDemoblazePage;

import org.openqa.selenium.WebDriver;

public abstract class ResultPageBase extends BaseDemoblazePage  {
    public ResultPageBase(WebDriver driver) {
        super(driver);
    }

    @Override
    public abstract boolean isOpened();

//    public abstract int getNumberOfProductFound();
//
//    public abstract List<String> getResultProductTitles();


}
