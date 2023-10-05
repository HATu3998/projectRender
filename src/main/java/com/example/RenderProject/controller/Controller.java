package com.example.RenderProject.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.RenderProject.model.Product;
import com.example.RenderProject.repo.ProductRepository;

import org.springframework.ui.Model;


@org.springframework.stereotype.Controller
public class Controller {
    @Autowired
    private ProductRepository productRepository;
    
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
