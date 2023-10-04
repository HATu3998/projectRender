package com.example.RenderProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.RenderProject.model.CartItem;
import com.example.RenderProject.repo.CartItemRepository;

@RestController
@RequestMapping("/api/cart")
public class CartController {
    @Autowired
    private CartItemRepository cartItemRepository;

    @GetMapping("/{username}")
    public List<CartItem> getCartItemsByUsername(@PathVariable String username) {
        return cartItemRepository.findByUsername(username);
    }

    @PostMapping
    public ResponseEntity<CartItem> addToCart(@RequestBody CartItem cartItem) {
        // Kiểm tra và xử lý thêm vào giỏ hàng ở đây
        // Sau đó lưu vào cơ sở dữ liệu thông qua repository
        CartItem savedCartItem = cartItemRepository.save(cartItem);
        return ResponseEntity.ok(savedCartItem);
    }

    // Thêm các phương thức khác cho cập nhật giỏ hàng, xóa sản phẩm khỏi giỏ hàng, và thao tác giỏ hàng
}