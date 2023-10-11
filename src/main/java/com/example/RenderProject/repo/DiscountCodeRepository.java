package com.example.RenderProject.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.RenderProject.model.DiscountCode;

public interface DiscountCodeRepository extends JpaRepository<DiscountCode, String> {
}
