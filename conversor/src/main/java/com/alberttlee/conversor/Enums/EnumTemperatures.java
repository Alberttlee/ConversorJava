package com.alberttlee.conversor.Enums;

public enum EnumTemperatures {
    CELSIUS("Celcius (°C)"),
    FAHRENHEIT("Fahrenheit (°F)"),
    KELVIN("Kelvin (K)");

    private final String name;

    EnumTemperatures(String nam) {
        this.name = nam;
    }

    public String getName() {
        return name;
    }
}
