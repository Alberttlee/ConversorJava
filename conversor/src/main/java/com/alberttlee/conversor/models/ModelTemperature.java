package com.alberttlee.conversor.models;

public class ModelTemperature implements Model {

    private String toTemperature;
    private String fromTemperature;
    private double degrees;

    public ModelTemperature() {

    }

    @Override
    public double convert(){
        double totalDegrees = 0;
        switch (fromTemperature){
            case "Celcius (°C)" -> {
                switch (toTemperature){
                    case "Celcius (°C)"  -> totalDegrees = this.degrees;
                    case "Fahrenheit (°F)" -> totalDegrees = (this.degrees * 9/5) + 32;
                    case "Kelvin (K)" -> totalDegrees = this.degrees + 273.15;
                }
            }
            case "Fahrenheit (°F)" -> {
                switch (toTemperature) {
                    case "Celcius (°C)" -> totalDegrees = (this.degrees - 32) * 5/9;
                    case "Fahrenheit (°F)" -> totalDegrees = this.degrees;
                    case "Kelvin (K)" -> totalDegrees = (this.degrees -32) * 5/9 + 273.15;
                }
            }
            case "Kelvin (K)" -> {
                switch (toTemperature) {
                    case "Celcius (°C)" -> totalDegrees = this.degrees - 273.15;
                    case "Fahrenheit (°F)" -> totalDegrees = (this.degrees - 273.15) * 9/5 + 32;
                    case "Kelvin (K)" -> totalDegrees = this.degrees;
                }
            }
            default -> throw new IllegalStateException("Unexpected value: " + toTemperature);
        }
        return totalDegrees;
    }

    ///Getters and setters///
    public String getToTemperature() {
        return this.toTemperature;
    }

    public void setToTemperature(String toTemperature) {
        this.toTemperature = toTemperature;
    }

    public void setFromTemperature(String fromTemperature) {
        this.fromTemperature = fromTemperature;
    }

    public void setDegrees(Double degrees) {
        this.degrees = degrees;
    }

}
