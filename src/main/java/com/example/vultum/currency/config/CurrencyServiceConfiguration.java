package com.example.vultum.currency.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
public class CurrencyServiceConfiguration extends ExternalServiceConfiguration {
    @Value("${application.currencyService.baseCurrency}")
    private String baseCurrency;
    @Value("${application.currencyService.compareCurrency}")
    private String compareCurrency;

    public CurrencyServiceConfiguration(@Value("${application.currencyService.apiKey}") String apiKey,
                                        @Value("${application.currencyService.endpoint}") String endpoint) {
        super(apiKey, endpoint);
    }
}
