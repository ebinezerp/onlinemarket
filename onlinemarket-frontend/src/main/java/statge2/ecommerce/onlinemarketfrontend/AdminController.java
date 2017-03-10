package statge2.ecommerce.onlinemarketfrontend;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import statge2.ecommerce.onlinemarketbackend.dao.CategoryDAO;
import statge2.ecommerce.onlinemarketbackend.dao.ProductDAO;
import statge2.ecommerce.onlinemarketbackend.dto.Category;
import statge2.ecommerce.onlinemarketbackend.dto.Product;
import statge2.ecommerce.onlinemarketbackend.dto.Users;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	CategoryDAO categoryDAO;
	@Autowired
	ProductDAO productDAO;
	@Autowired
	HttpServletRequest request;

	@RequestMapping(value = { "/index" })
	public String adminlogin(ModelMap model) {
		model.addAttribute("admin",true);
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
		model.addAttribute("categorieslist", categoryDAO.allCategories());
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
		
		//System.out.println("category object::::::::::"+category);
		
		if(result.hasErrors())
		{
			System.out.println("entered add product errors");
			model.addAttribute("admin", true);
			model.addAttribute("newproduct", true);
			model.addAttribute("categorieslist", categoryDAO.allCategories());
			return "masterpage";
		}
		/*System.out.println(product.getImage().getOriginalFilename());
		System.out.println(request.getRealPath("assets//images//products//electronics"))*/;
		File file=new File(request.getRealPath("assets//images//products//electronics"));
		/*System.out.println(file.exists());*/
		if(!file.exists()){
			file.mkdirs();
		}
		File storagepath=new File(request.getRealPath("assets//images//products//electronics")+File.separator+product.getProductName()+".jpg");
		try{
		byte[] imagebytes=product.getImage().getBytes();
		System.out.println(imagebytes);
		BufferedOutputStream bufferedOutputStream=new BufferedOutputStream(new FileOutputStream(storagepath));
		bufferedOutputStream.write(imagebytes);
		bufferedOutputStream.close();
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		System.out.println(storagepath);
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
