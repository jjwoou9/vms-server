package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.Type;
import org.hibernate.type.SqlTypes;

@Entity
@Setter
@Getter
@Table( name = "web_component")
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class WebComponent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "jsonb")
    private String content;


    public WebComponent(String content) {
        this.content = content;
    }
}
