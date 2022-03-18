package com.example.Jspdemo.controller;

/**
 * Importing all the packages whatever needed in class
 * 
 */
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import java.nio.file.Paths;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;

import org.springframework.validation.annotation.Validated;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.example.Jspdemo.model.Product;
import com.example.Jspdemo.repository.ProductRepository;
import com.example.Jspdemo.service.ProductService;

/**
 * Adding Spring MVC annotation before the class name.
 */
@Controller
public class ProductController {

	public static String uploadDirectory = System.getProperty("user.dir") + "/uploads";

	/**
	 * Declare the previously created `ProductRepository` after the class name.
	 */
	@Autowired
	ProductRepository productRepository;

	@Autowired
	ProductService productService;

	/**
	 * The request mapping annotation lets spring MVC know which controller class
	 * method to call. This annotation takes two parameters called path/value and
	 * method. This way we could map them based on path as well as HTTP methods like
	 * , GET, POST, PUT and DETELE.
	 */
	@RequestMapping(value = "/productadd", method = RequestMethod.GET)
	public String productsPage() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		return "productAdd";
	}

	// Handles the POST method.
	@PostMapping("/productadd")
	public ModelAndView createProduct(@Validated Product product,
			@RequestParam("proName") final String name, @RequestParam("proDesc") final String prodesc,
			@RequestParam("price") final String price, final @RequestParam("file") MultipartFile file) {
		ModelAndView modelView=new ModelAndView();
		try {
			HttpHeaders headers = new HttpHeaders();
			if (product == null) {
				return null;
			}

			String fileName = file.getOriginalFilename();
			String filePath = Paths.get(uploadDirectory, fileName).toString();
			String fileType = file.getContentType();
			long size = file.getSize();
			String fileSize = String.valueOf(size);

			// Save the file locally
			BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(filePath)));
			stream.write(file.getBytes());
			stream.close();
			System.out.println(name);
			product.setProName(name);
			product.setProDesc(prodesc);
			product.setPrice(price);
			product.setFileName(fileName);
			product.setFilePath(filePath);
			product.setFileType(fileType);
			product.setFileSize(fileSize);
		

			boolean status = productService.saveUser(product);
			
			if (status) {
				modelView.setViewName("productAdd");
				headers.add("Product Saved With Image - ", fileName);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return modelView;
	}

	/**
	 * model and view method for the productList page.
	 */
	@RequestMapping(value = "/productlist", method = RequestMethod.GET)
	public ModelAndView productList(ModelMap model) {
		List<Product> productList = new ArrayList<Product>();
		productList = productService.listAll();
		ModelAndView modelandview = new ModelAndView();
		modelandview.addObject("productList", productList);
		modelandview.setViewName("productList");
		return modelandview;
	}

	/**
	 * model and view method for the productList search page.
	 */
	@RequestMapping(value = "/search")
	public ModelAndView viewHomePage(Model model, @Param("proName") String proName) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("search");
		if (proName != null) {
			List<Product> listProducts = productService.listAll(proName);
			modelAndView.addObject("listProducts", listProducts);
		}
		return modelAndView;

	}

	@RequestMapping(value = "productdelete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable("id") String id) {
		// System.out.println(id);
		productService.delete(id);
		return "redirect:/productlist";
	}

	// Handles the POST method.
	@PostMapping("/updateProduct")
	public String updateProduct(@ModelAttribute("product") Product product) {
		Optional<Product> prod = productService.findProduct(product.getId());
		Product productUpdate = new Product();
		productUpdate = prod.get();
		productUpdate.setId(product.getId());
		productUpdate.setPrice(product.getPrice());
		productUpdate.setProDesc(product.getProDesc());
		productUpdate.setProName(product.getProName());
		productService.saveProduct(productUpdate);
		return "redirect:/productlist";
	}

	/**
	 * model and view method for the updateProduct page that effects in productList
	 * page after doing update operation.
	 */
	@RequestMapping(value = "productupdate/{id}", method = RequestMethod.GET)
	public ModelAndView update(@PathVariable("id") String id, @ModelAttribute Product product) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Optional<Product> product1 = productRepository.getProductById(id);
		System.out.println(product1);
		ModelAndView modelview = new ModelAndView();
		modelview.addObject("product", product1);
		modelview.setViewName("updateProduct");
		return modelview;
	}
	
	/**
	 * model and view method for the productdetails.
	 */
	@RequestMapping(value = "/productdetails/{id}", method = RequestMethod.GET)
	public ModelAndView productdetails(ModelMap model,@PathVariable("id") String id) {
	Optional<Product> productList = productService.findProduct(id);
	Product product=new Product();
	product=productList.get();
	ModelAndView modelandview = new ModelAndView();
	modelandview.addObject("product", product);
	modelandview.setViewName("productDetails");
	return modelandview;
	}
	
	/**
	 * model and view method for the userProductList page.
	 */
	@RequestMapping(value = "/userproductlist", method = RequestMethod.GET)
	public ModelAndView userProductList(ModelMap model) {
		List<Product> productList = new ArrayList<Product>();
		productList = productService.listAll();
		ModelAndView modelandview = new ModelAndView();
		modelandview.addObject("productList", productList);
		modelandview.setViewName("userProductList");
		return modelandview;
	}
	
	@RequestMapping(value = "/welcomeOrderPage/{id}", method = RequestMethod.GET)
	public ModelAndView welcomeOrderPage(ModelMap model,@PathVariable("id") String id) {
	Optional<Product> productList = productService.findProduct(id);
	Product product1=new Product();
	product1=productList.get();
	ModelAndView modelandview = new ModelAndView();
	modelandview.addObject("product1", product1);
	modelandview.setViewName("welcomeOrderPage");
	return modelandview;
	}
}