package com.example.RenderProject.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.RenderProject.model.Product;
import com.example.RenderProject.repo.ProductRepository;

import org.springframework.ui.Model;


@org.springframework.stereotype.Controller
public class Controller {
    @Autowired
    private ProductRepository productRepository;
    @GetMapping("/product")
    public String product(Model model, Principal principal, @RequestParam(value = "searchTerm", required = false) String searchTerm) {
        List<Product> topProducts;
        List<Product> regularProducts;

        if (searchTerm != null && !searchTerm.isEmpty()) {
            // Nếu có từ khóa tìm kiếm, thực hiện tìm kiếm sản phẩm
            topProducts = productRepository.findByProductTopAndNameContaining(true, searchTerm);
            regularProducts = productRepository.findByNameContaining(searchTerm);
        } else {
            // Nếu không có từ khóa tìm kiếm, hiển thị tất cả sản phẩm
            topProducts = productRepository.findByProductTop(true);
            regularProducts = productRepository.findAll();
        }

        model.addAttribute("topProducts", topProducts);
        model.addAttribute("regularProducts", regularProducts);

        if (principal != null) {
            model.addAttribute("usernamePrin", principal.getName());
        } else {
            model.addAttribute("usernamePrin", "");
        }

        return "product";
    }

	@GetMapping("/")
	public String index(Model model ,Principal principal) {
		 List<Product> products = productRepository.findAll();
		    model.addAttribute("products", products);
		    if (principal != null) {
	            model.addAttribute("usernamePrin", principal.getName());
	        } else {
	            model.addAttribute("usernamePrin", "");
	        }
		return "index";
	}
	@GetMapping("/showLoginPage")
	public String login() {
		return "login";
	}
	
	@GetMapping("/leaders")
	public String showLeader() {
		return "leaders";
	}
	
	@GetMapping("/errorLogin")
	public String errorLogin() {
		return "/errorLogin";
	}
}
