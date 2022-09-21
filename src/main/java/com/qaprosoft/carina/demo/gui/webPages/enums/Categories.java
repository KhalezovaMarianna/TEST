package com.qaprosoft.carina.demo.gui.webPages.enums;

import com.qaprosoft.carina.demo.gui.webPages.desktop.HomePage;
import com.qaprosoft.carina.demo.gui.webPages.base.BaseDemoblazePage;

public enum Categories {
    PHONES("Phones", HomePage.class),
    LAPTOPS("Laptops", HomePage.class),
    MONITORS("Monitors", HomePage.class);
    private final String category;
    private final Class<? extends BaseDemoblazePage> pageClass;

    Categories(String category, Class<? extends BaseDemoblazePage> pageClass) {
        this.category = category;
        this.pageClass = pageClass;
    }
    public String getCategory() {
        return category;
    }
    public Class<? extends BaseDemoblazePage> getPageClass() {
        return pageClass;
    }
}
