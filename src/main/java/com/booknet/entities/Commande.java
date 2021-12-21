package com.booknet.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Commande {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "commande_id")
    private int id;

}
