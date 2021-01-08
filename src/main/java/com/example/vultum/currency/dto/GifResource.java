package com.example.vultum.currency.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class GifResource {
    private String id;
    private String type;
    private String url;
    private String originalImageUrl;

    public GifResource(Map<String, Object> data) {
        if (data != null) {
            id = (String) data.get("id");
            type = (String) data.get("type");
            url = (String) data.get("url");

            Map<String, Object> images = (Map<String, Object>) data.get("images");
            Map<String, String> original = (Map<String, String>) images.get("original");
            originalImageUrl = original.get("url");
        }
    }
}
