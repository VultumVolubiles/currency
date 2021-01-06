package com.example.vultum.currency.config;

public abstract class ExternalServiceConfiguration {
    private final String apiKey;
    private final String endpoint;

    public ExternalServiceConfiguration(String apiKey, String endpoint) {
        this.apiKey = apiKey;
        this.endpoint = endpoint;
    }

    public String getEndpoint() {
        if (endpoint.endsWith("/"))
            return endpoint;
        else
            return endpoint + "/";
    }

    public String getApiKey() {
        return apiKey;
    }
}
