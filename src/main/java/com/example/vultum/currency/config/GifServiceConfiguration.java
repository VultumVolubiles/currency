package com.example.vultum.currency.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
public class GifServiceConfiguration extends ExternalServiceConfiguration{
    @Value("${application.gifService.increase-query:rich}")
    private String increaseQuery;
    @Value("${application.gifService.decrease-query:broke}")
    private String decreaseQuery;

    public GifServiceConfiguration(@Value("${application.gifService.apiKey}") String apiKey,
                                   @Value("${application.gifService.endpoint}") String endpoint) {
        super(apiKey, endpoint);
    }
}
