package com.example.vultum.currency.service.client;

import com.example.vultum.currency.dto.CurrencyResource;
import feign.Param;
import feign.RequestLine;

public interface ExternalCurrencyServiceClient {

    @RequestLine("GET latest.json?app_id={api_id}")
    CurrencyResource latest(@Param("api_id")String apiKey);

    @RequestLine("GET latest.json?app_id={api_id}&base={base}")
    CurrencyResource latest(@Param("api_id")String apiKey, @Param("base")String base);

    @RequestLine("GET historical/{date}.json?app_id={api_id}&base={base}")
    CurrencyResource historical(@Param("api_id")String apiKey, @Param("date")String date);

    @RequestLine("GET historical/{date}.json?app_id={api_id}&base={base}")
    CurrencyResource historical(@Param("api_id")String apiKey, @Param("date")String date, @Param("base")String base);

}