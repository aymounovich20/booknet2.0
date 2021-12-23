package com.vermeg.booknet.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

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
    public String addCategory(@RequestBody Category category) {
        //tsajel el obj category eli je en param fel BD
        try {
            this.categoryRepository.save(category);
            return "Category saved";
        } catch (Exception e) {
            return e.getMessage();
        }

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
    	return "category/listCategories";
    }
    
    
    @DeleteMapping("/deletecategory/{id}")
    void deleteCategory(@PathVariable int id)
    {
       categoryRepository.deleteById(id);
    }
    @PutMapping("/editCategory/{id}")
    public  String editCategory(@PathVariable int id,Model model)
    {
    model.addAttribute("category",categoryRepository.getById(id));
    return "category updated";
    }
}
