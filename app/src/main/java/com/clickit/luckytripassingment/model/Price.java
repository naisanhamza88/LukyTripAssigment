package com.clickit.luckytripassingment.model;

import com.clickit.luckytripassingment.base.BaseEntity;
import com.google.gson.annotations.SerializedName;

public class Price extends BaseEntity {
    @SerializedName("currency")
    private final String currency;

    @SerializedName("price_value")
    private final double priceValue;

    public Price(String currency, double priceValue) {
        this.currency = currency;
        this.priceValue = priceValue;
    }

    public String getCurrency() {
        return currency;
    }

    public double getPriceValue() {
        return priceValue;
    }
}
