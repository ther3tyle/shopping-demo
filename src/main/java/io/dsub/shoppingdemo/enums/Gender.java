package io.dsub.shoppingdemo.enums;

public enum Gender {
    MALE, FEMALE, UNKNOWN;

    public String toJson() {
        return name().toLowerCase();
    }
}
