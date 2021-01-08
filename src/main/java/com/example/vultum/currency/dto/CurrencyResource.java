package com.example.vultum.currency.dto;

import lombok.Getter;

import java.util.Map;

@Getter
public class CurrencyResource {
    private Long timestamp;
    private String base;
    private Map<String, Double> rates;

    public Double getRate(String alias) {
        return rates.get(alias.toUpperCase());
    }

    public boolean hasRate(String alias) {
        return rates.containsKey(alias.toUpperCase());
    }
}
