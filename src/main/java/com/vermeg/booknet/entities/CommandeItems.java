package com.vermeg.booknet.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Positive;

@Entity
public class CommandeItems {
	
	@Column(name = "commande_item_id")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name = "quantity")
	@Positive()
	private int qte;
	
	@ManyToOne
	@JoinColumn(name = "book_id")
	private Book book;
}
