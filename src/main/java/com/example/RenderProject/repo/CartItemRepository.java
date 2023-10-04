package com.example.RenderProject.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.RenderProject.model.CartItem;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Long> {

	List<CartItem> findByUsername(String username);
    // Các phương thức tùy chỉnh cho truy vấn giỏ hàng (nếu cần)
}