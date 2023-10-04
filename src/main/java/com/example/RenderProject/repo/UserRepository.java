package com.example.RenderProject.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.RenderProject.model.User;

public interface UserRepository extends JpaRepository<User, String> {
}