package com.vermeg.booknet.controllers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.vermeg.booknet.entities.Book;
import com.vermeg.booknet.entities.Category;
import com.vermeg.booknet.repositories.BookRepository;
import com.vermeg.booknet.repositories.CategoryRepository;

@Controller
@RequestMapping(value = "/book/")
public class BookController {
	
	public static String uploadDirectory =
			System.getProperty("user.dir")+"/src/main/resources/static/uploads";
	@Autowired
	CategoryRepository cr;
	@Autowired
	BookRepository br;
	
	@GetMapping(value = "list")
	public String bookList(Model model) {
		if(br.findAll().isEmpty())
			model.addAttribute("books",null);
		else
			model.addAttribute("books", br.findAll());
		return "book/listBooks";
	}
	
	@GetMapping(value = "add")
	public String addBook(Model model) {
		model.addAttribute("categories", cr.findAll());
		model.addAttribute("book", new Book());
		return "book/addBook";
	}
	
	@PostMapping("add")
	public String addArticle(Model model,@Valid Book book, BindingResult result,
			@RequestParam(name = "categoryId", required = false) int p,
			@RequestParam("files") MultipartFile[] files) {
		if (result.hasErrors()) {
			model.addAttribute("categories",cr.findAll());
			return "book/addBook";
		}
		Optional<Category> category = cr.findById(p);
		///image
		StringBuilder fileName = new StringBuilder();
		MultipartFile file = files[0];
		Path fileNameAndPath = Paths.get(uploadDirectory,file.getOriginalFilename());
		fileName.append(file.getOriginalFilename());
		try {
		Files.write(fileNameAndPath, file.getBytes()); //upload
		} catch (IOException e) {
		e.printStackTrace();
		}
		book.setImage(fileName.toString());
		book.setCategory(category.get());
		br.save(book);
		return "redirect:list";
	}
	
	@GetMapping("delete/{id}")
	public String deleteBook(@PathVariable("id") int id, Model model) {
		Book book = br.findById(id).get();
		br.delete(book);
		return "redirect:../list";

	}
	
	@GetMapping("show/{id}")
	public String showBookDetails(@PathVariable("id") int id, Model model)
	{
	Book book = br.findById(id).get();
	
	model.addAttribute("book", book);
	return "book/showBook";
	}
	@GetMapping("edit/{id}")
	public String edit(@PathVariable("id") int id,Model model) {
		Book book = br.findById(id).get();
		model.addAttribute("book", book);
		model.addAttribute("categories", cr.findAll());
		model.addAttribute("idCategory", book.getCategory().getId());
		return"book/updateBook";
	}
	
	@PostMapping("edit")
	public String updateBook(Model model,@Valid Book book,
			@RequestParam(name = "categoryId", required = false) int p,
			@RequestParam("files") MultipartFile[] files) {

		Optional<Category> category = cr.findById(p);
		///image
		if(files.length!=0) {
			StringBuilder fileName = new StringBuilder();
			MultipartFile file = files[0];
			Path fileNameAndPath = Paths.get(uploadDirectory,file.getOriginalFilename());
			fileName.append(file.getOriginalFilename());
			try {
			Files.write(fileNameAndPath, file.getBytes()); //upload
			} catch (IOException e) {
			e.printStackTrace();
			}
			book.setImage(fileName.toString());
		}
		book.setCategory(category.get());
		br.save(book);
		model.addAttribute("books",br.findAll());
		return "book/listBooks";
	}
}
