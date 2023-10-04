package com.example.RenderProject.model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    @Column(name = "catagory")
    private String category;
    private BigDecimal price;
    private String imageUrl;
	public Product(String name, String category, BigDecimal price, String imageUrl) {
		super();
		this.name = name;
		this.category = category;
		this.price = price;
		this.imageUrl = imageUrl;
	}
	public Product(Long id, String name, String category, BigDecimal price, String imageUrl) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
		this.price = price;
		this.imageUrl = imageUrl;
	}
	public Product() {
		super();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

    // Constructors, getters, and setters
}

