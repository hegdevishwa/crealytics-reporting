package com.crealytics.reporting.entity;

public enum Site {
    desktop_web("desktop web"),

    mobile_web("mobile web"),

    android("android"),

    iOS("iOS");

    private final String value;

    private Site(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
