package com.example.Jspdemo.repository;

/**
 * Importing all the packages whatever needed in this class
 */
import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.Jspdemo.model.Supplier;

/**
 * By adding the annotation org.springframework.data.mongodb.repository.Query
 * repository finder methods you can specify a MongoDB JSON query string to use
 * instead of having the query derived from the method name.
 * 
 * Ex:Let’s create a repository to interact with Product from the database. In
 * repository package, create SupplierRepository interface that extends
 * MongoRepository.
 */
@Repository
public interface SupplierRepository extends MongoRepository<Supplier, String> {
	/**
	 * Now we can use MongoRepository’s methods: save(), findOne(), findById(),
	 * findAll(), count(), delete(), deleteById() ...
	 * 
	 * And We also define custom methods
	 */
	@Query("{suppName : ?0}")
	public List<Supplier> search(String suppName);

	public Optional<Supplier> getSupplierById(String id);
}