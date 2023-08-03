package com.alberttlee.conversor.models;

import java.util.HashMap;


public class ModelCurrency implements Model{

    private final HashMap<String,Double> ratePeso = new HashMap<>();
    private final HashMap<String,Double> rateDollar = new HashMap<>();
    private final HashMap<String,Double> rateEuro = new HashMap<>();
    private final HashMap<String,Double> rateLibra = new HashMap<>();
    private final HashMap<String,Double> rateYen = new HashMap<>();
    private final HashMap<String,Double> rateArs = new HashMap<>();

    private String toCurrency;
    private String fromCurrency;
    private Double amount;

    public ModelCurrency() {

        ////Exchange rates for the Mexican Peso////
        this.ratePeso.put("Mexican Peso (MXN)", 1.0);
        this.ratePeso.put("US Dollar (USD)", 0.059);
        this.ratePeso.put("Euro (EUR)", 0.054);
        this.ratePeso.put("British Pound (GBP)", 0.046);
        this.ratePeso.put("Japanese Yen (JPY)", 8.42);
        this.ratePeso.put("Argentine Peso (ARS)", 16.29);

        ////exchange rates for the Dollar////
        this.rateDollar.put("Mexican Peso (MXN)", 17.02);
        this.rateDollar.put("US Dollar (USD)", 1.0);
        this.rateDollar.put("Euro (EUR)", 0.91);
        this.rateDollar.put("British Pound (GBP)", 0.79);
        this.rateDollar.put("Japanese Yen (JPY)", 143.42);
        this.rateDollar.put("Argentine Peso (ARS)", 277.37);

        ////Exchange rates for the Euro////
        this.rateEuro.put("Mexican Peso (MXN)", 18.62);
        this.rateEuro.put("US Dollar (USD)", 1.09);
        this.rateEuro.put("Euro (EUR)", 1.0);
        this.rateEuro.put("British Pound (GBP)", 0.86);
        this.rateEuro.put("Japanese Yen (JPY)", 156.85);
        this.rateEuro.put("Argentine Peso (ARS)", 303.35);

        ////Exchange rates for the British Pound////
        this.rateLibra.put("Mexican Peso (MXN)", 21.64);
        this.rateLibra.put("US Dollar (USD)", 1.27);
        this.rateLibra.put("Euro (EUR)", 1.16);
        this.rateLibra.put("British Pound (GBP)", 1.0);
        this.rateLibra.put("Japanese Yen (JPY)", 182.30);
        this.rateLibra.put("Argentine Peso (ARS)", 352.55);

        ////Exchange rates for the Yen////
        this.rateYen.put("Mexican Peso (MXN)", 0.12);
        this.rateYen.put("US Dollar (USD)", 0.0070);
        this.rateYen.put("Euro (EUR)", 0.0064);
        this.rateYen.put("British Pound (GBP)", 0.0055);
        this.rateYen.put("Japanese Yen (JPY)", 1.0);
        this.rateYen.put("Argentine Peso (ARS)", 1.93);

        ////Exchange rates for the Argeentine Peso////
        this.rateArs.put("Mexican Peso (MXN)", 0.61);
        this.rateArs.put("US Dollar (USD)", 0.0036);
        this.rateArs.put("Euro (EUR)", 0.0033);
        this.rateArs.put("British Pound (GBP)", 0.0028);
        this.rateArs.put("Japanese Yen (JPY)", 0.52);
        this.rateArs.put("Argentine Peso (ARS)", 1.0);

    }

    @Override
    public double convert() {
        double totalCurrency = 0;
        if (this.amount == null){
            this.amount = 0.0;
        }
        switch (fromCurrency){
            case "Mexican Peso (MXN)" -> totalCurrency = this.amount * ratePeso.get(toCurrency);
            case "US Dollar (USD)" -> totalCurrency = this.amount * rateDollar.get(toCurrency);
            case "Euro (EUR)" -> totalCurrency = this.amount * rateEuro.get(toCurrency);
            case "British Pound (GBP)" -> totalCurrency = this.amount * rateLibra.get(toCurrency);
            case "Japanese Yen (JPY)" -> totalCurrency = this.amount * rateYen.get(toCurrency);
            case "Argentine Peso (ARS)" -> totalCurrency = this.amount * rateArs.get(toCurrency);
            default -> throw new IllegalStateException("Unexpected value: " + toCurrency);
        }
        return totalCurrency;
    }

////Getters and Setter/////
    public String getToCurrency() {
        return toCurrency;
    }

    public void setToCurrency(String toCurrency) {
        this.toCurrency = toCurrency;
    }

    public void setFromCurrency(String fromCurrency) {
        this.fromCurrency = fromCurrency;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

}
