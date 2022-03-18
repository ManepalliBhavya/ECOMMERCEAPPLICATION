package com.example.Jspdemo.repository;

/**
 * Importing all the packages whatever needed in this class
 */
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.Jspdemo.model.Customer;

/**
 * By adding the annotation org.springframework.data.mongodb.repository.
 * 
 * Ex:Let’s create a repository to interact with Product from the database.
 * In repository package, create CustomerRepository interface that extends MongoRepository.
 */
@Repository
public interface CustomerRepository extends MongoRepository<Customer, String> {

}
