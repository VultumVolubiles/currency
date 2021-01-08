package com.example.vultum.currency.service;

import com.example.vultum.currency.config.GifServiceConfiguration;
import com.example.vultum.currency.dto.GifResource;
import com.example.vultum.currency.dto.GifSearchResource;
import com.example.vultum.currency.service.client.ExternalGifServiceClient;
import feign.Feign;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.okhttp.OkHttpClient;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GifService {
    private final GifServiceConfiguration configuration;
    private final ExternalGifServiceClient client;

    public GifService(GifServiceConfiguration configuration) {
        this.configuration = configuration;
        client = Feign.builder()
                .client(new OkHttpClient())
                .encoder(new GsonEncoder())
                .decoder(new GsonDecoder())
                .target(ExternalGifServiceClient.class, configuration.getEndpoint());
    }

    @SneakyThrows
    public List<GifResource> search(String query){
        GifSearchResource result = client.search(configuration.getApiKey(), query, 1);
        GifResource resource = new GifResource(result.data.get(0));
        return result.get();
    }
}
