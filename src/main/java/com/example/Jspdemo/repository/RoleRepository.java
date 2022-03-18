package com.example.Jspdemo.repository;

/**
 * Importing all the packages whatever needed in this class
 */
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.Jspdemo.model.Role;

/**
 * Spring Boot Repository, add this annotation before the class name. created
 * Java Interface file opened, single query for getting role data by role name.
 */
@Repository
public interface RoleRepository extends MongoRepository<Role, String> {
	Role findByRole(String role);

}
