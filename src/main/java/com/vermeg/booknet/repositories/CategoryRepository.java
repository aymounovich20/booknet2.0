package com.vermeg.booknet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vermeg.booknet.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
	
}
