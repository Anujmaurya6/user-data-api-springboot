package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Spentity;

public interface Sprepo extends JpaRepository<Spentity, Integer> {
	boolean existsByName(String name);
	}


