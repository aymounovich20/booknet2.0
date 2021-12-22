package com.vermeg.booknet.entities;

import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Commande {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "commande_id")
    private int id;
	
	@Column(name = "date_commande")
	private LocalDateTime date = LocalDateTime.now() ;
	
	@ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "commande_item", joinColumns = @JoinColumn(name = "commande_id"), inverseJoinColumns = @JoinColumn(name = "commande_item_id"))
	private Set<CommandeItems> books ;

}
