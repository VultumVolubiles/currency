package com.example.vultum.currency.config;

public abstract class ExternalServiceConfiguration {
    private final String apiKey;
    private final String endpoint;

    public ExternalServiceConfiguration(String apiKey, String endpoint) {
        if (apiKey == null || apiKey.isEmpty())
            throw new IllegalArgumentException("apiKey of external service must be not null or empty!");
        if (endpoint == null || endpoint.isEmpty())
            throw new IllegalArgumentException("endpoint of external service must be not null or empty!");

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
