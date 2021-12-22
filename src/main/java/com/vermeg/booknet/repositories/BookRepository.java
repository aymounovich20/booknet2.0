package com.vermeg.booknet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vermeg.booknet.entities.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {

}
