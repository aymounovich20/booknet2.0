package com.booknet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.booknet.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
