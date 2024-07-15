package com.example.demo.model.request;

public record PageContentRequest(
        String html,
        String css,
        String components,
        String assets,
        String styles
) {
}
