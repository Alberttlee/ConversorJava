package com.alberttlee.conversor.Enums;

public enum EnumCurrency {

    PESO("Mexican Peso (MXN)"),
    DOLAR("US Dollar (USD)"),
    EURO("Euro (EUR)"),
    LIBRA("British Pound (GBP)"),
    YEN("Japanese Yen (JPY)"),
    ARS("Argentine Peso (ARS)");

    private final String name;

    EnumCurrency(String nam) {
        this.name = nam;
    }

    public String getName() {
        return name;
    }
}
