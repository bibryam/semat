package com.ofbizian.semat.dom.domain;

public enum Concern {

    CUSTOMER,
    SOLUTION,
    ENDEAVOR;

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String iconName() {
        return getName();
    }

}
