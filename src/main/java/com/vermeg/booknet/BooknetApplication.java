package com.vermeg.booknet;

import java.io.File;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import com.vermeg.booknet.controllers.BookController;

@SpringBootApplication
public class BooknetApplication {

	public static void main(String[] args) {
		new File(BookController.uploadDirectory).mkdir();
		SpringApplication.run(BooknetApplication.class, args);
	}

}
