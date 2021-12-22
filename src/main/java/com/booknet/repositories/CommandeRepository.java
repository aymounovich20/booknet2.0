package com.booknet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.booknet.entities.Commande;

public interface CommandeRepository extends JpaRepository<Commande, Integer> {

}
