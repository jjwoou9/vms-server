package com.example.demo.web;

import com.example.demo.entity.WebComponent;
import com.example.demo.model.WebComponentRequest;
import com.example.demo.repository.WebComponentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
@RequiredArgsConstructor
public class ComponentController {

    private final WebComponentRepository webComponentRepository;

    @PostMapping("/api/pages")
    @ResponseBody
    public WebComponent savePage(@RequestBody WebComponentRequest request) {
        log.info("Saving page: {}", request.content());
        var webComponent = new WebComponent(request.content());
        var saved = webComponentRepository.save(webComponent);
        log.info("Saved page: {}", saved.getContent());
        return saved;
    }

    @GetMapping("/pages/{id}")
    public String getPage(@PathVariable Long id, Model model) {
        var webComponent = webComponentRepository.findById(id).orElseThrow(() -> new RuntimeException("WebComponent not found"));
        model.addAttribute("pageContent", webComponent.getContent());
        return "page";
    }
}
