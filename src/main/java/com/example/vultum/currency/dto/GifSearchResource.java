package com.example.vultum.currency.dto;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GifSearchResource {
    public final List<Map<String, Object>> data;

    public GifSearchResource(List<Map<String, Object>> data) {
        this.data = data;
    }

    public List<GifResource> get() {
        return data.stream().map(GifResource::new).collect(Collectors.toList());
    }
}
