package com.example.Jspdemo.model;

/**
 * Importing all the packages whatever needed in class
 * 
 */
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @Document is an annotation provided by Spring data project. It is used to
 * identify a domain object, which is persisted to MongoDB. So you can
 * use it to map a Java class into a collection inside MongoDB.
 * 
 * or
 * 
 * @Document annotation at the class level implies this class will be treated as a MongoDB document and saved in its database.
 */
@Document
public class Category {
	/**
	 * The id attribute is for the internal use of the MongoDB, the @Id annotation
	 * on top of it informs Spring that this field will be used as the primary
	 * identifier.
	 * 
	 * And also Declaring the variable names with the Datatype of String for category data. 
	 */
	@Id
	private String id;
	private String catName;

	/**
	 * Generate default constructor
	 */
	public Category() {
	}

	/**
	 * Generate parameterized constructor with above fields.
	 */
	public Category(String id, String catName) {
		super();
		this.id = id;
		this.catName = catName;
	}

	/**
	 * Generate getters and setters for all above fields.
	 */
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCatName() {
		return catName;
	}

	public void setCatName(String catName) {
		this.catName = catName;
	}

	/**
	 * Generate toString method for all above fields
	 */
	@Override
	public String toString() {
		return "Category [id=" + id + ", catName=" + catName + "]";
	}
}