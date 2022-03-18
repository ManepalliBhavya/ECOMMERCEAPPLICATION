package com.example.Jspdemo.model;

/**
 * Importing all the packages whatever needed in class
 * 
 */
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @Document is an annotation provided by Spring data project. It is used to
 *           identify a domain object, which is persisted to MongoDB. So you can
 *           use it to map a Java class into a collection inside MongoDB.
 * 
 *           or
 * 
 * @Document annotation at the class level implies this class will be treated as
 *           a MongoDB document and saved in its database.
 */
@Document
public class Product {

	/**
	 * The id attribute is for the internal use of the MongoDB, the @Id annotation
	 * on top of it informs Spring that this field will be used as the primary
	 * identifier.
	 * 
	 * And also Declaring the variable names with the Datatype of String for product
	 * data.
	 */
	@Id
	private String id;
	private String proName;
	private String proDesc;
	private String price;
	private String image;
	private String fileName;
	private String filePath;
	private String fileType;
	private String fileSize;
	private String Gif;

	/**
	 * Generate default constructor
	 */
	public Product() {

	}

	/**
	 * Generate parameterized constructor with above fields.
	 */
	public Product(String id, String proName, String proDesc, String price, String image, String fileName,
			String filePath, String fileType, String fileSize, String gif) {
		super();
		this.id = id;
		this.proName = proName;
		this.proDesc = proDesc;
		this.price = price;
		this.image = image;
		this.fileName = fileName;
		this.filePath = filePath;
		this.fileType = fileType;
		this.fileSize = fileSize;
		Gif = gif;
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

	public String getProName() {
		return proName;
	}

	public void setProName(String proName) {
		this.proName = proName;
	}

	public String getProDesc() {
		return proDesc;
	}

	public void setProDesc(String proDesc) {
		this.proDesc = proDesc;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public String getFileSize() {
		return fileSize;
	}

	public void setFileSize(String fileSize) {
		this.fileSize = fileSize;
	}
	
	public String getGif() {
		return Gif;
	}

	public void setGif(String gif) {
		Gif = gif;
	}

	/**
	 * Generate toString method for all above fields
	 */
	@Override
	public String toString() {
		return "Product [id=" + id + ", proName=" + proName + ", proDesc=" + proDesc + ", price=" + price + ", image="
				+ image + ", fileName=" + fileName + ", filePath=" + filePath + ", fileType=" + fileType + ", fileSize="
				+ fileSize + ", Gif=" + Gif + "]";
	}
}