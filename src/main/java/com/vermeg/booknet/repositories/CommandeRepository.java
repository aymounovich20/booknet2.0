package com.vermeg.booknet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vermeg.booknet.entities.Commande;

public interface CommandeRepository extends JpaRepository<Commande, Integer> {

}
