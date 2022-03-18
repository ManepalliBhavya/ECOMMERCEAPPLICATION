package com.example.Jspdemo.service;

/**
 * Importing all the packages whatever needed in this class
 */
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Jspdemo.model.Category;
import com.example.Jspdemo.model.Product;
import com.example.Jspdemo.repository.CategoryRepository;
import com.example.Jspdemo.repository.ProductRepository;

/**
 * Service Components are the class file which contains @Service annotation.
 * These class files are used to write business logic in a different layer,
 * separated from @Controller class file.
 */
@Service
public class CategoryService {
	/**
	 * Declare the category repository.
	 */
	@Autowired
	private CategoryRepository categoryRepository;

	//Generate parameterless constructor
	public CategoryService() {

	}
	
	//Generate parameterized constructor
	public CategoryService(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}

	/**
	 * Create a method to find the category by name.
	 */
	public List<Category> listAll(String catName) {
		if (catName != null) {
			return categoryRepository.search(catName);
		}
		return categoryRepository.findAll();
	}

	/**
	 * Create a method to save the category.
	 */
	public Category saveCategory(Category category) {
		return categoryRepository.save(category);
	}

	/**
	 * Create a method to saveall the categories.
	 */
	public Iterable<Category> saveAll(List<Category> categories) {
		return categoryRepository.saveAll(categories);
	}

	/**
	 * Create a method to delete the category using by id.
	 */
	public void delete(String id) {
		categoryRepository.deleteById(id);
	}

	/**
	 * Create a method to find the category by id.
	 */
	public Optional<Category> findCategory(String id) {
		return categoryRepository.getCategoryById(id);
	}

}
