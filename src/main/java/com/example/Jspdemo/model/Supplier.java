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
public class Supplier {
	/**
	 * The id attribute is for the internal use of the MongoDB, the @Id annotation
	 * on top of it informs Spring that this field will be used as the primary
	 * identifier.
	 * 
	 * And also Declaring the variable names with the Datatype of String for category data. 
	 */
	@Id
	private String id;
	private String suppName;
	private String suppCity;
	private String suppPhone;
	
	/**
	 * Generate default constructor
	 */
	public Supplier() {
		
	}
	
	/**
	 * Generate parameterized constructor with above fields.
	 */
	public Supplier(String id, String suppName, String suppCity, String suppPhone) {
		super();
		this.id = id;
		this.suppName = suppName;
		this.suppCity = suppCity;
		this.suppPhone = suppPhone;
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

	public String getSuppName() {
		return suppName;
	}

	public void setSuppName(String suppName) {
		this.suppName = suppName;
	}

	public String getSuppCity() {
		return suppCity;
	}

	public void setSuppCity(String suppCity) {
		this.suppCity = suppCity;
	}

	public String getSuppPhone() {
		return suppPhone;
	}

	public void setSuppPhone(String suppPhone) {
		this.suppPhone = suppPhone;
	}

	/**
	 * Generate toString method for all above fields
	 */
	@Override
	public String toString() {
		return "Supplier [id=" + id + ", suppName=" + suppName + ", suppCity=" + suppCity + ", suppPhone=" + suppPhone
				+ "]";
	}
}