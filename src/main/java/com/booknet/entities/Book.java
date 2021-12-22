package com.booknet.entities;

import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;

@Entity
public class Book {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "book_id")
    private int id;
	
	@Column(name = "title")
	@NotEmpty(message = "Book title can't be empty")
	private String title;
	
	@Column(name = "description")
	@NotEmpty(message = "description can't be empty")
	private String description;
	
	@Column(name = "price")
	@Positive(message = "Price can't be 0 or less")
	private float price;
	
	@Column(name = "stock")
	@NotEmpty(message = "stock can't be empty")
	private int stock;
	
	@Column(name = "image")
	private Blob image;
	
	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;
}
