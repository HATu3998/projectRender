package com.example.RenderProject.repo;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.example.RenderProject.model.Authority;

public interface AuthorityRepository extends JpaRepository<Authority, String> {
	 @Query("SELECT a FROM Authority a WHERE a.username = :username")
	    List<Authority> findAllByUsername(@Param("username") String username);
}