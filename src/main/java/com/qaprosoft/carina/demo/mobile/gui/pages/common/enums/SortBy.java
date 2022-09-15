package com.qaprosoft.carina.demo.mobile.gui.pages.common.enums;

public enum SortBy { NAME_ASC("Name-Ascending"),
    NAME_DESK("Name-Descending"),
    PRICE_ASC("Price-Ascending"),
    PRICE_DESC("Price-Descending");

    private String sort;

    SortBy(String sort) {
        this.sort = sort;
    }

    public String getSort() {
        return sort;
    }
}
