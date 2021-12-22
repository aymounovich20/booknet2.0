package com.booknet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.booknet.entities.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {

}
