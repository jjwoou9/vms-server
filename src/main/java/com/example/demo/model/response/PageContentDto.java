package com.example.demo.model.response;

import com.example.demo.entity.Page;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class PageContentDto extends PageDto{

    private String html;
    private String css;

    private String components;
    private String assets;
    private String styles;


    protected PageContentDto(Page page){
        super(page);
        var content = page.getContent();
        this.html = content.getHtml();
        this.css = content.getCss();
        this.components = content.getComponents();
        this.assets = content.getAssets();
        this.styles = content.getStyles();
    }

    public static PageContentDto from(Page page){
        return new PageContentDto(page);
    }

}
