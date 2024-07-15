package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.SQLRestriction;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.ZonedDateTime;
import java.util.UUID;

@Builder
@Entity
@Setter
@Getter
@Table( name = "page")
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@SQLRestriction("deleted_at IS NULL")
public class Page {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private UUID id;

    @Column
    private String title;

    @Column
    private String slug;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private ZonedDateTime createdAt = ZonedDateTime.now();

    @LastModifiedDate
    @Column
    private ZonedDateTime updatedAt;

    @Column
    private ZonedDateTime deletedAt;

    @OneToOne
    @JoinColumn(name = "content_id")
    private Content content;


    public boolean hasContent() {
        return content != null;
    }

}
