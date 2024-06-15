package org.oracle.one.utils;

public enum Currencies {

    USD("USD"),
    BRL("BRL"),
    ARS("ARS"),
    COP("COP"),
    EUR("EUR");

    private final String value;

    Currencies(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
