package com.example.demo.web;

import com.example.demo.model.request.PageContentRequest;
import com.example.demo.model.request.PageRequest;
import com.example.demo.service.PageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/contents")
public class ContentsController {

    private final PageService pageService;

    @GetMapping("/pages")
    public Object findPages(){
        return pageService.findAll();
    }

    @GetMapping("/pages/{id}")
    public Object findPageContent(@PathVariable String id){
        return pageService.findPageContent(id);
    }

    @PostMapping("/pages")
    public Object createPage(@RequestBody PageRequest request){
        return pageService.create(request);
    }

    @PutMapping("/pages/{id}")
    public Object updatePageContent(@PathVariable String id, @RequestBody PageContentRequest request){
        return pageService.saveContent(id, request);
    }


}
