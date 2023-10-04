package com.example.RenderProject.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.RenderProject.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    // Các phương thức tùy chỉnh cho truy vấn sản phẩm (nếu cần)
}