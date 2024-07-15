package com.example.demo.service;

import com.example.demo.entity.Content;
import com.example.demo.model.request.PageContentRequest;
import com.example.demo.repository.ContentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ContentService {

    private final ContentRepository contentRepository;

    public Content insert(PageContentRequest request){
        var content = Content.builder()
                .html(request.html())
                .css(request.css())
                .components(request.components())
                .assets(request.assets())
                .styles(request.styles())
                .build();

        return contentRepository.save(content);
    }

    public void update(Content content, PageContentRequest request){
        content.setHtml(request.html());
        content.setCss(request.css());
        content.setComponents(request.components());
        content.setAssets(request.assets());
        content.setStyles(request.styles());
    }


}
