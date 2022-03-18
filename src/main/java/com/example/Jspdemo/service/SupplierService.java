package com.example.Jspdemo.service;

/**
 * Importing all the packages whatever needed in this class
 */
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Jspdemo.model.Supplier;
import com.example.Jspdemo.repository.SupplierRepository;

/**
 * Service Components are the class file which contains @Service annotation.
 * These class files are used to write business logic in a different layer,
 * separated from @Controller class file.
 */
@Service
public class SupplierService {
	/**
	 * Declare the supplier repository.
	 */
	@Autowired
	private SupplierRepository supplierRepository;

	//Generate parameterless constructor
	public SupplierService() {

	}
	
	//Generate parameterized constructor
	public SupplierService(SupplierRepository supplierRepository) {

		this.supplierRepository = supplierRepository;
	}

	/**
	 * Create a method to find the supplier by name.
	 */
	public List<Supplier> listAll(String suppName) {
		if (suppName != null) {

			return supplierRepository.search(suppName);

		}
		return supplierRepository.findAll();
	}
	
	/**
	 * Create a method to save the supplier.
	 */
	public Supplier saveSupplier(Supplier supplier) {
		return supplierRepository.save(supplier);
	}

	/**
	 * Create a method to saveall the suppliers.
	 */
	public Iterable<Supplier> saveAll(List<Supplier> suppliers) {
		return supplierRepository.saveAll(suppliers);
	}
	
	/**
	 * Create a method to delete the supplier by id.
	 */
	public void delete(String id) {
		supplierRepository.deleteById(id);
	}

	/**
	 * Create a method to find the supplier by id.
	 */
	public Optional<Supplier> findSupplier(String id) {
		return supplierRepository.findById(id);
	}
}