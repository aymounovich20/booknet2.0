package com.booknet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.booknet.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {

}
