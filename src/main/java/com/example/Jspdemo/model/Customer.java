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
public class Customer {
	/**
	 * The id attribute is for the internal use of the MongoDB, the @Id annotation
	 * on top of it informs Spring that this field will be used as the primary
	 * identifier.
	 * 
	 * And also Declare all required fields or variables for customer data.
	 */
	@Id
	private String cusId;
	private String cusName;
	private String cusPhone;
	private String cusCity;
	private String cusGender;
	private String cusPassword;

	/**
	 * Generate default constructor
	 */
	public Customer() {

	}

	/**
	 * Generate parameterized constructor with above fields.
	 */
	public Customer(String cusId, String cusName, String cusPhone, String cusCity, String cusGender,
			String cusPassword) {
		super();
		this.cusId = cusId;
		this.cusName = cusName;
		this.cusPhone = cusPhone;
		this.cusCity = cusCity;
		this.cusGender = cusGender;
		this.cusPassword = cusPassword;
	}

	/**
	 * Generate getters and setters for all above fields.
	 */
	public String getCusId() {
		return cusId;
	}

	public void setCusId(String cusId) {
		this.cusId = cusId;
	}

	public String getCusName() {
		return cusName;
	}

	public void setCusName(String cusName) {
		this.cusName = cusName;
	}

	public String getCusPhone() {
		return cusPhone;
	}

	public void setCusPhone(String cusPhone) {
		this.cusPhone = cusPhone;
	}

	public String getCusCity() {
		return cusCity;
	}

	public void setCusCity(String cusCity) {
		this.cusCity = cusCity;
	}

	public String getCusGender() {
		return cusGender;
	}

	public void setCusGender(String cusGender) {
		this.cusGender = cusGender;
	}

	public String getCusPassword() {
		return cusPassword;
	}

	public void setCusPassword(String cusPassword) {
		this.cusPassword = cusPassword;
	}

	/**
	 * Generate toString method for all above fields
	 */
	@Override
	public String toString() {
		return "Customer [cusId=" + cusId + ", cusName=" + cusName + ", cusPhone=" + cusPhone + ", cusCity=" + cusCity
				+ ", cusGender=" + cusGender + ", cusPassword=" + cusPassword + "]";
	}
}