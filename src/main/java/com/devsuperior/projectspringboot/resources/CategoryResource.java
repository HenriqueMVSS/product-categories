package com.devsuperior.projectspringboot.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.projectspringboot.entities.Category;
import com.devsuperior.projectspringboot.repositories.CategoryRepository;

@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {
	
	@Autowired
	private CategoryRepository categoryRepository;

	@GetMapping
	public ResponseEntity<List<Category>> findAll() {
		List<Category> list = categoryRepository.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Category> findById(@PathVariable Long id) {
		Category cat = categoryRepository.findById(id);
		return ResponseEntity.ok().body(cat);
	}
}