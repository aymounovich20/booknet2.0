package com.vermeg.booknet.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vermeg.booknet.entities.Book;
import com.vermeg.booknet.entities.Category;
import com.vermeg.booknet.repositories.CategoryRepository;

@Controller
@RequestMapping("/category/")
public class CategoryController {
	private CategoryRepository categoryRepository;

    @Autowired

    public CategoryController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;

    }

    @PostMapping(value = "add")
    public String addCategory(@Valid Category category, BindingResult result) {
		categoryRepository.save(category);
    	
    	return "redirect:list";
    }

//    @GetMapping(value = "list")
//    public List<Category> getAllCategories() {
//        //tsajel el obj category eli je en param fel BD
//        try {
//            return this.categoryRepository.findAll();
//            //f blast select*,,
//
//        } catch (Exception e ) {
//            return null;
//        }
//
//    }	
    @GetMapping(value = "list")
    public String categoryList(Model model) {
    	model.addAttribute("categories",categoryRepository.findAll());
    	model.addAttribute("category", new Category());
    	return "category/listCategories";
    }
    
	@GetMapping("delete/{id}")
	public String deleteBook(@PathVariable("id") int id, Model model) {
		Category category = categoryRepository.findById(id).get();
		categoryRepository.delete(category);
		return "redirect:../list";

	}
	
	@GetMapping("edit/{id}")
	public String edit(@PathVariable("id") int id, Model model) {
		Category category = categoryRepository.findById(id).get();
		model.addAttribute("category",category);
		return "category/updateCategory";
	}
	
	@PostMapping("edit")
	public String updateCat(@Valid Category category,BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "category/updateCategory";
		}
		categoryRepository.save(category);
		model.addAttribute("categories", categoryRepository.findAll());
		return "category/listCategories";
	}
}
