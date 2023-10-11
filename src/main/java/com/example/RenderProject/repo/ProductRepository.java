package com.example.RenderProject.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.RenderProject.model.CartItem;
import com.example.RenderProject.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

	List<Product> findByProductTop(boolean b);
    // Các phương thức tùy chỉnh cho truy vấn sản phẩm (nếu cần)

	List<Product> findByProductTopAndNameContaining(boolean b, String searchTerm);

	List<Product> findByNameContaining(String searchTerm);
	
}