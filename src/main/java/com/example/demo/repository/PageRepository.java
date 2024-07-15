package com.example.demo.repository;

import com.example.demo.entity.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PageRepository extends JpaRepository<Page, UUID>{
}
