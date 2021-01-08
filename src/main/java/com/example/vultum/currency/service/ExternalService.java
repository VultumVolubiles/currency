package com.example.vultum.currency.service;

import com.example.vultum.currency.config.ExternalServiceConfiguration;

public abstract class ExternalService <T extends ExternalServiceConfiguration> {
    private final T configuration;

    public ExternalService (T configuration) {
        this.configuration = configuration;
    }

    public T configuration() {
        return configuration;
    }
}
