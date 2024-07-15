package com.example.demo.web;

import com.example.demo.entity.WebComponent;
import com.example.demo.model.request.WebComponentRequest;
import com.example.demo.repository.WebComponentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
@RequiredArgsConstructor
public class RenderController {

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

    //https://github.com/GrapesJS/grapesjs/discussions/3672
    @GetMapping("/pages/{id}")
    public String getPage(@PathVariable Long id, Model model) {
        var webComponent = webComponentRepository.findById(id).orElseThrow(() -> new RuntimeException("WebComponent not found"));
        model.addAttribute("pageContent", webComponent.getContent());
        return "page";
    }

//    @GetMapping("/render/{id}")
//    public String renderHtml(@PathVariable Long id, Model model)
//    {
//        try
//        {
//            var page = webComponentRepository.findById(id).orElseThrow(() -> new RuntimeException("WebComponent not found"));
//
//            String html = page.getContent().get("mycustom-html");
//            String css = page.getContent().get("mycustom-css");
//            String name = page.getName();
//
//            model.addAttribute("html", html);
//            model.addAttribute("css", css);
//            model.addAttribute("name", name);
//
//            return "render";
//        }
//        catch (Exception e)
//        {
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Page Not Found");
//        }
//    }

    @GetMapping("/components/{id}")
    public String getComponent(@PathVariable Long id, Model model) {
        var webComponent = webComponentRepository.findById(id).orElseThrow(() -> new RuntimeException("WebComponent not found"));
        model.addAttribute("pageContent", webComponent.getContent());
        return "component";
    }
}
