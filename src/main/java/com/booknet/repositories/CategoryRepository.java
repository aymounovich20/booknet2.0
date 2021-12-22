package com.booknet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.booknet.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
