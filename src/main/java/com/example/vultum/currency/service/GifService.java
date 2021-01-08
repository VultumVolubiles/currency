package com.example.vultum.currency.service;

import com.example.vultum.currency.config.GifServiceConfiguration;
import com.example.vultum.currency.dto.GifResource;
import com.example.vultum.currency.service.client.ExternalGifServiceClient;
import feign.Feign;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.okhttp.OkHttpClient;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GifService extends ExternalService<GifServiceConfiguration>{
    private final ExternalGifServiceClient client;

    public GifService(GifServiceConfiguration configuration) {
        super(configuration);
        client = Feign.builder()
                .client(new OkHttpClient())
                .encoder(new GsonEncoder())
                .decoder(new GsonDecoder())
                .target(ExternalGifServiceClient.class, configuration.getEndpoint());
    }

    @SneakyThrows
    public List<GifResource> search(String query, int limit){
        return client.search(configuration().getApiKey(), query, limit).get();
    }
}
