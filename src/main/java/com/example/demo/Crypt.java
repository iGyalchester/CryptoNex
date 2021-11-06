package com.example.demo;

public class Crypt {

    private Market market;
    private Ticker ticker;
    private String rate_id;


    public Crypt() {
    }

    public Market getMarket() {
        return market;
    }

    public void setMarket(Market market) {
        this.market = market;
    }

    public Ticker getTicker() {
        return ticker;
    }

    public void setTicker(Ticker ticker) {
        this.ticker = ticker;
    }

    public String getRate_id() {
        return rate_id;
    }

    public void setRate_id(String rate_id) {
        this.rate_id = rate_id;
    }

    @Override
    public String toString() {
        return "Crypt{" +
                "market=" + market +
                ", ticker=" + ticker +
                ", rate_id='" + rate_id + '\'' +
                '}';
    }
}
