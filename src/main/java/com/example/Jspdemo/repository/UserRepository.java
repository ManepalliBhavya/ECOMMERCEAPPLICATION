package com.example.Jspdemo.repository;

/**
 * Importing all the packages whatever needed in this class
 */
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.Jspdemo.model.User;

/**
 * Spring Boot Repository, add this annotation before the class name.
 *
 * created Java Interface file opened, single query for getting user data by
 * email.
 */
@Repository
public interface UserRepository extends MongoRepository<User, String> {

	User findByEmail(String email);
}
