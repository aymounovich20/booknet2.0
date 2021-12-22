package com.vermeg.booknet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vermeg.booknet.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
