package com.example.Jspdemo.model;

/**
 * Importing all the packages whatever needed in class
 * 
 */
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 
 * To make this class a Spring Data document and assign to role collection
 */
@Document(collection = "role")
public class Role {

	/**
	 * The id attribute is for the internal use of the MongoDB, the @Id annotation
	 * on top of it informs Spring that this field will be used as the primary
	 * identifier.
	 * 
	 * And also Declare all required fields or variables for role data.
	 */
	@Id
	private String id;
	private String role;

	/**
	 * Generate getters and setters for all above fields.
	 */
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
}