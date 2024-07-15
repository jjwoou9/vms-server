package com.example.demo.service;

import com.example.demo.entity.Page;
import com.example.demo.model.request.PageContentRequest;
import com.example.demo.model.request.PageRequest;
import com.example.demo.model.response.PageContentDto;
import com.example.demo.model.response.PageDto;
import com.example.demo.repository.PageRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class PageService {

    private final PageRepository pageRepository;
    private final ContentService contentService;

    private Page findById(String id){
        UUID uuid = UUID.fromString(id);
        return pageRepository.findById(uuid).orElseThrow(() -> new RuntimeException("Page not found"));
    }

    @Transactional
    public PageDto create(PageRequest request){
        var page = Page.builder()
                .title(request.title())
                .slug(request.slug())
                .build();

        return PageDto.from(pageRepository.save(page));
    }

    public List<PageDto> findAll(){
        return pageRepository.findAll().stream()
                .map(PageDto::from)
                .collect(Collectors.toList());
    }

    public PageContentDto findPageContent(String id) {
        var page = findById(id);
        return PageContentDto.from(page);
    }

    @Transactional
    public PageContentDto saveContent(String id, PageContentRequest request){
        var page = findById(id);
        if(page.hasContent()){
            //update
            var content = page.getContent();
            contentService.update(content, request);
            page.setUpdatedAt(ZonedDateTime.now());
        }else {
            //insert
            var content = contentService.insert(request);
            page.setContent(content);
        }
        return PageContentDto.from(page);
    }

}
