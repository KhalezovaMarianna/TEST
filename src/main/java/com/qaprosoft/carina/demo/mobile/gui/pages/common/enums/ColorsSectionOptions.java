package com.qaprosoft.carina.demo.mobile.gui.pages.common.enums;

public enum ColorsSectionOptions {
    RED("Red"),
    BLUE("Blue"),
    BLACK("Black"),
    GRAY("Gray");

    private String color;

    ColorsSectionOptions(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }
}
