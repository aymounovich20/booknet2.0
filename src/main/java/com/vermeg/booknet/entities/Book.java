package com.vermeg.booknet.entities;

import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

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
	//@Size(message = "Price can't be 0 or less",min = 1)
	private float price;
	
	@Column(name = "stock")
	//@NotEmpty(message = "stock can't be empty")
	private int stock;
	
	@Column(name = "image")
	private String image;
	
	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;

	public Book() {
	
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
	
	
}
