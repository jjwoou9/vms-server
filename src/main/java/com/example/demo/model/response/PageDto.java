package com.example.demo.model.response;

import com.example.demo.entity.Page;
import lombok.*;

import java.time.ZonedDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class PageDto {

    private UUID id;
    private String title;
    private String slug;
    private ZonedDateTime createdAt;
    private ZonedDateTime updatedAt;

    protected PageDto(Page page){
        this.id = page.getId();
        this.title = page.getTitle();
        this.slug = page.getSlug();
        this.createdAt = page.getCreatedAt();
        this.updatedAt = page.getUpdatedAt();
    }

    public static PageDto from(Page page) {
        return new PageDto(page);
    }
}
