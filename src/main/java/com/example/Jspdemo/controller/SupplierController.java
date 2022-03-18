package com.example.Jspdemo.controller;

/**
 * Importing all the packages whatever needed in class
 * 
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.Jspdemo.model.Supplier;
import com.example.Jspdemo.repository.SupplierRepository;
import com.example.Jspdemo.service.SupplierService;

/**
 * Adding Spring MVC annotation before the class name.
 */
@Controller
public class SupplierController {

	/**
	 * Declare the previously created `CategoryRepository` after the class name.
	 */
	@Autowired
	SupplierRepository supplierRepository;

	@Autowired
	SupplierService supplierService;

	/**
	 * The request mapping annotation lets spring MVC know which controller class
	 * method to call. This annotation takes two parameters called path/value and
	 * method. This way we could map them based on path as well as HTTP methods like
	 * , GET, POST, PUT and DETELE.
	 */
	@RequestMapping(value = "/supplieradd", method = RequestMethod.GET)
	public String suppliersPage() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		return "supplierAdd";
	}

	@RequestMapping(value = "/supplieradd", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody Supplier supplierAdding(@RequestBody Supplier supplier) {

		System.out.println("supplier name: " + supplier.getSuppName());
		System.out.println("supplier city: " + supplier.getSuppCity());
		System.out.println("supplier phone: " + supplier.getSuppPhone());
		supplierRepository.save(supplier);
		return supplier;
	}

	/**
	 * model and view method for the supplierList page.
	 */
	@RequestMapping(value = "/supplierlist", method = RequestMethod.GET)
	public ModelAndView supplierList(ModelMap model) {
		List<Supplier> supplierList = new ArrayList<Supplier>();
		supplierList = supplierRepository.findAll();
		ModelAndView modelandview = new ModelAndView();
		modelandview.addObject("supplierList", supplierList);
		modelandview.setViewName("supplierList");
		return modelandview;
	}

	/**
	 * model and view method for the supplier search page.
	 */
	@RequestMapping("/indexSupplier")
	public ModelAndView viewHomePage(Model model, @Param("suppName") String suppName) {
		List<Supplier> listSuppliers = supplierService.listAll(suppName);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("indexSupplier");
		modelAndView.addObject("listSuppliers", listSuppliers);
		return modelAndView;

	}

	@RequestMapping(value = "supplierdelete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable("id") String id) {
		// System.out.println(id);
		supplierService.delete(id);
		return "redirect:/supplierlist";
	}

	// Handles the POST method.
	@PostMapping("/updateSupplier")
	public String updateSupplier(@ModelAttribute("supplier") Supplier supplier) {
		Optional<Supplier> supp = supplierService.findSupplier(supplier.getId());
		Supplier supplierUpdate = new Supplier();
		supplierUpdate = supp.get();
		supplierUpdate.setId(supplier.getId());
		supplierUpdate.setSuppName(supplier.getSuppName());
		supplierUpdate.setSuppCity(supplier.getSuppCity());
		supplierUpdate.setSuppPhone(supplier.getSuppPhone());
		supplierService.saveSupplier(supplierUpdate);
		return "redirect:/supplierlist";
	}

	/**
	 * model and view method for the update.
	 */
	@RequestMapping(value = "supplierupdate/{id}", method = RequestMethod.GET)
	public ModelAndView update(@PathVariable("id") String id, @ModelAttribute Supplier supplier) {
		Optional<Supplier> supplier1 = supplierRepository.getSupplierById(id);
		System.out.println(supplier1);
		ModelAndView modelview = new ModelAndView();
		modelview.addObject("supplier", supplier1);
		modelview.setViewName("updateSupplier");
		return modelview;

	}
}