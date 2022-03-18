package com.example.Jspdemo.model;

/**
 * Importing all the packages whatever needed in class
 * 
 */
import java.util.Set;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * To make this class a Spring Data document and assign to user collection
 */
@Document(collection = "user")
public class User {
	/**
	 * The id attribute is for the internal use of the MongoDB, the @Id annotation
	 * on top of it informs Spring that this field will be used as the primary
	 * identifier.
	 * 
	 * And also Declare all required fields or variables for user data.
	 */
	@Id
	private String id;
	private String email;
	private String password;
	private String username;
	private boolean enabled;
	private String city;
	private String phoneNo;

	@DBRef
	private Set<Role> roles;
	
	/**
	 * Generate default constructor
	 */
	public User() {
		
	}

	/**
	 * Generate parameterized constructor with above fields.
	 */
	public User(String id, String email, String password, String username, boolean enabled, String city, String phoneNo,
			Set<Role> roles) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.username = username;
		this.enabled = enabled;
		this.city = city;
		this.phoneNo = phoneNo;
		this.roles = roles;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	/**
	 * Generate toString method for all above fields
	 */
	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", password=" + password + ", username=" + username
				+ ", enabled=" + enabled + ", city=" + city + ", phoneNo=" + phoneNo + ", roles=" + roles + "]";
	}

}