package com.example.demo.web;

import com.example.demo.model.request.PageContentRequest;
import com.example.demo.model.request.PageRequest;
import com.example.demo.model.response.PageDto;
import com.example.demo.service.PageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/contents")
public class ContentsController {

    private final PageService pageService;

    @GetMapping("/pages")
    public List<PageDto> findPages(){
        return pageService.findAll();
    }

    @PostMapping("/pages")
    public PageDto createPage(@RequestBody PageRequest request){
        log.info("Creating page: {}", request);
        return pageService.create(request);
    }

    @GetMapping("/pages/{pageId}/content")
    public Object findPageContent(@PathVariable String pageId){
        return pageService.findPageContent(pageId);
    }

    @PostMapping("/pages/{pageId}/content")
    public Object updatePageContent(@PathVariable String pageId, @RequestBody PageContentRequest request){
        return pageService.saveContent(pageId, request);
    }


}
