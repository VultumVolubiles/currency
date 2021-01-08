package com.example.vultum.currency.service;

import com.example.vultum.currency.dto.GifSearchResource;
import feign.Param;
import feign.RequestLine;

public interface GifClient {

    @RequestLine("GET search?api_key={api_key}&q={q}&limit={limit}")
    GifSearchResource search(@Param("api_key")String api_key, @Param("q")String q, @Param("limit")int limit);

}
