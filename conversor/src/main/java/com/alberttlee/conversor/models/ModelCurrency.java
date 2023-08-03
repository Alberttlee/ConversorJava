package com.alberttlee.conversor.models;

import java.util.HashMap;


public class ModelCurrency implements Model{

    private final HashMap<String,Double> ratePeso = new HashMap<>();
    private final HashMap<String,Double> rateDollar = new HashMap<>();
    private final HashMap<String,Double> rateEuro = new HashMap<>();
    private final HashMap<String,Double> rateLibra = new HashMap<>();
    private final HashMap<String,Double> rateYen = new HashMap<>();
    private final HashMap<String,Double> rateWon = new HashMap<>();

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
        this.ratePeso.put("Korean Won (KRW)", 76.31);

        ////exchange rates for the Dollar////
        this.rateDollar.put("Mexican Peso (MXN)", 17.02);
        this.rateDollar.put("US Dollar (USD)", 1.0);
        this.rateDollar.put("Euro (EUR)", 0.91);
        this.rateDollar.put("British Pound (GBP)", 0.79);
        this.rateDollar.put("Japanese Yen (JPY)", 143.42);
        this.rateDollar.put("Korean Won (KRW)", 1298.26);

        ////Exchange rates for the Euro////
        this.rateEuro.put("Mexican Peso (MXN)", 18.62);
        this.rateEuro.put("US Dollar (USD)", 1.09);
        this.rateEuro.put("Euro (EUR)", 1.0);
        this.rateEuro.put("British Pound (GBP)", 0.86);
        this.rateEuro.put("Japanese Yen (JPY)", 156.85);
        this.rateEuro.put("Korean Won (KRW)", 1420.51);

        ////Exchange rates for the British Pound////
        this.rateLibra.put("Mexican Peso (MXN)", 21.64);
        this.rateLibra.put("US Dollar (USD)", 1.27);
        this.rateLibra.put("Euro (EUR)", 1.16);
        this.rateLibra.put("British Pound (GBP)", 1.0);
        this.rateLibra.put("Japanese Yen (JPY)", 182.30);
        this.rateLibra.put("Korean Won (KRW)", 1650.88);

        ////Exchange rates for the Yen////
        this.rateYen.put("Mexican Peso (MXN)", 0.12);
        this.rateYen.put("US Dollar (USD)", 0.0070);
        this.rateYen.put("Euro (EUR)", 0.0064);
        this.rateYen.put("British Pound (GBP)", 0.0055);
        this.rateYen.put("Japanese Yen (JPY)", 1.0);
        this.rateYen.put("Korean Won (KRW)", 9.06);

        ////Exchange rates for the Korean Won////
        this.rateWon.put("Mexican Peso (MXN)", 0.013);
        this.rateWon.put("US Dollar (USD)", 0.00077);
        this.rateWon.put("Euro (EUR)", 0.00070);
        this.rateWon.put("British Pound (GBP)", 0.00061);
        this.rateWon.put("Japanese Yen (JPY)", 0.11);
        this.rateWon.put("Korean Won (KRW)", 1.0);

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
            case "Korean Won (KRW)" -> totalCurrency = this.amount * rateWon.get(toCurrency);
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
