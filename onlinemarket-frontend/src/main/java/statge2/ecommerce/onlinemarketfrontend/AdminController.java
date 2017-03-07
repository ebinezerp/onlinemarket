package statge2.ecommerce.onlinemarketfrontend;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import statge2.ecommerce.onlinemarketbackend.dao.CategoryDAO;
import statge2.ecommerce.onlinemarketbackend.dao.ProductDAO;
import statge2.ecommerce.onlinemarketbackend.dto.Category;
import statge2.ecommerce.onlinemarketbackend.dto.Product;
import statge2.ecommerce.onlinemarketbackend.dto.Users;

@Controller
public class AdminController {
	@Autowired
	CategoryDAO categoryDAO;
	@Autowired
	ProductDAO productDAO;

	@RequestMapping(value = { "/admin/login" })
	public String login(@Valid Users user, BindingResult result, ModelMap model) {
		if (user.getUserName().equals("admin")) {
			model.addAttribute("admin", true);
		}
		return "masterpage";
	}

	@RequestMapping("/category")
	public ModelAndView category() {
		ModelAndView mv = new ModelAndView("masterpage", "category", new Category());
		mv.addObject("admin", true);
		mv.addObject("categories", true);

		return mv;
	}
	@RequestMapping("/product")
	public ModelAndView product() {
		ModelAndView mv = new ModelAndView("masterpage", "category", new Product());
		mv.addObject("admin", true);
		mv.addObject("adminproducts", true);

		return mv;
	}

	@RequestMapping("/categories/all")
	public @ResponseBody List<Category> categoriesall() {

		return categoryDAO.allCategories();

	}
	@RequestMapping("/adminproducts/all")
	public @ResponseBody List<Product> productsall() {

		return productDAO.allProducts();

	}

	@RequestMapping("admin/{id}/editcategory")
	public String eidtcategory(@PathVariable Integer id,ModelMap model) {
		model.addAttribute("admin", true);
		model.addAttribute("editcategory", true);
		model.addAttribute("category", categoryDAO.getCategory(id));
		return "masterpage";
	}
	@RequestMapping("admin/{id}/editproduct")
	public String eidtproduct(@PathVariable Integer id,ModelMap model) {
		model.addAttribute("admin", true);
		model.addAttribute("editproduct", true);
		model.addAttribute("product", productDAO.get(id));
		return "masterpage";
	}

	@RequestMapping("admin/newcategory")
	public String newCategory(ModelMap model) {
		System.out.println("Entered new category");
		model.addAttribute("admin", true);
		model.addAttribute("newcategory", true);
		model.addAttribute("category", new Category());
		return "masterpage";
	}
	@RequestMapping("admin/newproduct")
	public String newProduct(ModelMap model) {
		System.out.println("Entered new category");
		model.addAttribute("admin", true);
		model.addAttribute("newproduct", true);
		model.addAttribute("product", new Product());
		return "masterpage";
	}
	@RequestMapping("admin/addcategory")
	public String addCategory(@Valid @ModelAttribute("category")Category category,BindingResult result,ModelMap model) {
		System.out.println("entered add cateogy");
		if(result.hasErrors())
		{
			System.out.println("entered add category errors");
			model.addAttribute("admin", true);
			model.addAttribute("newcategory", true);
			return "masterpage";
		}
		categoryDAO.newCategory(category);
		model.addAttribute("admin", true);
		model.addAttribute("categories", true);
		
		return "masterpage";
	}
	@RequestMapping("admin/addproduct")
	public String addProduct(@Valid @ModelAttribute("product")Product product,BindingResult result,ModelMap model) {
		System.out.println("entered add product");
		if(result.hasErrors())
		{
			System.out.println("entered add product errors");
			model.addAttribute("admin", true);
			model.addAttribute("newproduct", true);
			return "masterpage";
		}
		productDAO.addProduct(product);
		model.addAttribute("admin", true);
		model.addAttribute("adminproducts", true);
		
		return "masterpage";
	}
	@RequestMapping("/admin/{id}/updatecategory")
	public String updateCategory(@Valid @ModelAttribute("category")Category category,BindingResult result,ModelMap model) {
		System.out.println("entered add cateogy");
		if(result.hasErrors())
		{
			System.out.println("entered add category errors");
			model.addAttribute("admin", true);
			model.addAttribute("editcategory", true);
			return "masterpage";
		}
		categoryDAO.updateCategory(category);
		model.addAttribute("admin", true);
		model.addAttribute("categories", true);
		
		return "masterpage";
	}
	@RequestMapping("/admin/{id}/updateproduct")
	public String updateProduct(@Valid @ModelAttribute("product")Product product,BindingResult result,ModelMap model) {
		System.out.println(product.getProductName());
		if(result.hasErrors())
		{
			System.out.println("entered add category errors");
			model.addAttribute("admin", true);
			model.addAttribute("editproduct", true);
			return "masterpage";
		}
		try{
		productDAO.update(product);
		}catch(Exception e)
		{
			System.out.println("exception in controller:::::::::::::::"+e);
		}
		model.addAttribute("admin", true);
		model.addAttribute("adminproduct", true);
		
		return "masterpage";
	}
	@RequestMapping("/admin/{id}/deletecategory")
	public String deleteCategory(@PathVariable Integer id,ModelMap model) {
		
		categoryDAO.deleteCategory(id);
		model.addAttribute("admin", true);
		model.addAttribute("categories", true);
		
		return "masterpage";
	}
	@RequestMapping("/admin/{id}/deleteproduct")
	public String deleteProduct(@PathVariable Integer id,ModelMap model) {
	
		productDAO.delete(id);
		model.addAttribute("admin", true);
		model.addAttribute("adminproducts", true);
		
		return "masterpage";
	}
}
