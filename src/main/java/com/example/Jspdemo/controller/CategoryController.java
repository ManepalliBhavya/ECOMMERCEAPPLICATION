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

import com.example.Jspdemo.model.Category;
import com.example.Jspdemo.repository.CategoryRepository;
import com.example.Jspdemo.service.CategoryService;

/**
 * Adding Spring MVC annotation before the class name.
 */
@Controller
public class CategoryController {

	/**
	 * Declare the previously created `CategoryRepository` after the class name.
	 */
	@Autowired
	CategoryRepository categoryRepository;

	@Autowired
	CategoryService categoryService;

	/**
	 * The request mapping annotation lets spring MVC know which controller class
	 * method to call. This annotation takes two parameters called path/value and
	 * method. This way we could map them based on path as well as HTTP methods like
	 * , GET, POST, PUT and DETELE.
	 */
	@RequestMapping(value = "/categoryadd", method = RequestMethod.GET)
	public String categoriesPage() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		return "categoryAdd";
	}

	@RequestMapping(value = "/categoryadd", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody Category categoryAdding(@RequestBody Category category) {
		System.out.println("category name: " + category.getCatName());
		categoryRepository.save(category);
		return category;
	}

	/**
	 * model and view method for the categoryList page.
	 */
	@RequestMapping(value = "/categorylist", method = RequestMethod.GET)
	public ModelAndView categoryList(ModelMap model) {
		List<Category> categoryList = new ArrayList<Category>();
		categoryList = categoryRepository.findAll();
		ModelAndView modelandview = new ModelAndView();
		modelandview.addObject("categoryList", categoryList);
		modelandview.setViewName("categoryList");
		return modelandview;
	}

	/**
	 * model and view method for the categories search page.
	 */
	@RequestMapping("/indexCategory")
	public ModelAndView viewHomePage(Model model, @Param("catName") String catName) {
		List<Category> listCategories = categoryService.listAll(catName);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("indexCategory");
		modelAndView.addObject("listCategories", listCategories);
		return modelAndView;

	}

	@RequestMapping(value = "categorydelete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable("id") String id) {
		categoryService.delete(id);
		return "redirect:/categorylist";
	}

	// Handles the POST method.
	@PostMapping("/updateCategory")
	public String updateCategory(@ModelAttribute("category") Category category) {
		Optional<Category> cat = categoryService.findCategory(category.getId());
		Category catgeoryUpdate = new Category();
		catgeoryUpdate = cat.get();
		catgeoryUpdate.setId(category.getId());
		catgeoryUpdate.setCatName(category.getCatName());
		categoryService.saveCategory(catgeoryUpdate);
		return "redirect:/categorylist";
	}

	/**
	 * model and view method for the update.
	 */
	@RequestMapping(value = "categoryupdate/{id}", method = RequestMethod.GET)
	public ModelAndView update(@PathVariable("id") String id, @ModelAttribute Category category) {
		Optional<Category> category1 = categoryRepository.getCategoryById(id);
		System.out.println(category1);
		ModelAndView modelview = new ModelAndView();
		modelview.addObject("category", category1);
		modelview.setViewName("updateCategory");
		return modelview;

	}
}