package com.qaprosoft.carina.demo.gui.webPages.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class FooterMenu extends AbstractUIObject {

    @FindBy(xpath = "//*[@id=\"fotcont\"]/div[1]//h4/b")
    ExtendedWebElement aboutUsText;

    @FindBy(xpath = "//*[@id=\"fotcont\"]/div[2]//h4/b")
    ExtendedWebElement getInTouchText;

    @FindBy(xpath = "//*[@id=\"fotcont\"]/div[3]//h4")
    ExtendedWebElement label;

    public FooterMenu(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public boolean equalTextAboutUs() {
        String s = "About Us";
        return s.equals(aboutUsText.getText());
    }
    public boolean equalTextGetInTouch(){
        String s = "Get in Touch";
        return s.equals(getInTouchText.getText());
    }
    public  boolean equalTextLabel(){
        return label.isElementPresent();
    }

}
