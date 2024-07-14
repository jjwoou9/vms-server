package com.example.demo.repository;

import com.example.demo.entity.WebComponent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WebComponentRepository extends JpaRepository<WebComponent, Long> {
}
