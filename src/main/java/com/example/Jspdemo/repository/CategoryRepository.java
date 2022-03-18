package com.example.Jspdemo.repository;

/**
 * Importing all the packages whatever needed in this class
 */
import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.Jspdemo.model.Category;

/**
 * By adding the annotation org.springframework.data.mongodb.repository.Query
 * repository finder methods you can specify a MongoDB JSON query string to use
 * instead of having the query derived from the method name.
 * 
 * Ex:Let’s create a repository to interact with Product from the database. In
 * repository package, create CategoryRepository interface that extends
 * MongoRepository.
 */
@Repository
public interface CategoryRepository extends MongoRepository<Category, String> {
	/**
	 * Now we can use MongoRepository’s methods: save(), findOne(), findById(),
	 * findAll(), count(), delete(), deleteById() ...
	 * 
	 * And We also define custom methods
	 */
	// List<Category> findByNameContaining(String name);
	@Query("{catName : ?0}")
	public List<Category> search(String catName);

	public Optional<Category> getCategoryById(String id);
}