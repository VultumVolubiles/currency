package com.example.vultum.currency.service;

import com.example.vultum.currency.config.CurrencyServiceConfiguration;
import com.example.vultum.currency.dto.CurrencyResource;
import com.example.vultum.currency.service.client.ExternalCurrencyServiceClient;
import feign.Feign;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.okhttp.OkHttpClient;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class CurrencyService extends ExternalService<CurrencyServiceConfiguration>{
    private final ExternalCurrencyServiceClient client;

    public CurrencyService(CurrencyServiceConfiguration configuration) {
        super(configuration);
        client = Feign.builder()
                .client(new OkHttpClient())
                .encoder(new GsonEncoder())
                .decoder(new GsonDecoder())
                .target(ExternalCurrencyServiceClient.class, configuration.getEndpoint());
    }

    public CurrencyResource latest(String base) {
        if (base == null)
            return client.latest(configuration().getApiKey());
        else
            return client.latest(configuration().getApiKey(), base.toUpperCase());
    }

    public CurrencyResource yesterday(String base) {
        String date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy.MM.dd"));
        if (base == null)
            return client.historical(configuration().getApiKey(), date);
        else
            return client.historical(configuration().getApiKey(), date, base.toUpperCase());
    }

    public int compareRate(CurrencyResource res1, CurrencyResource res2, String rate) {
        if (!(res1.hasRate(rate) && res2.hasRate(rate)))
            throw new IllegalArgumentException("Invalid currency");

        Double cur1 = res1.getRate(rate.toUpperCase());
        Double cur2 = res2.getRate(rate.toUpperCase());
        return Double.compare(cur1, cur2);
    }
}
