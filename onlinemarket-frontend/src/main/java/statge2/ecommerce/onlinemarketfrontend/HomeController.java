package statge2.ecommerce.onlinemarketfrontend;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import statge2.ecommerce.onlinemarketbackend.dao.CategoryDAO;
import statge2.ecommerce.onlinemarketbackend.dao.ProductDAO;
import statge2.ecommerce.onlinemarketbackend.dto.Product;
import statge2.ecommerce.onlinemarketbackend.dto.Users;

@Controller
public class HomeController {
	@Autowired
	CategoryDAO categoryDAO;
	@Autowired
	ProductDAO productDAO;
	
	@RequestMapping({"/home","/"})
	public ModelAndView index(){
		System.out.println("entered");
		ModelAndView mv=new ModelAndView("masterpage","user",new Users());
	mv.addObject("pageName","home");
		return mv;
	}
	@RequestMapping("/aboutus")
	public ModelAndView aboutus()
	{
		ModelAndView mv=new ModelAndView("masterpage");
		
		mv.addObject("pageName","aboutus");
		return mv;
	}
	
	@RequestMapping("/products")
	public ModelAndView products()
	{
		ModelAndView mv=new ModelAndView("masterpage");
		mv.addObject("category",categoryDAO.allCategories());
		mv.addObject("table",true);
		mv.addObject("pageName","products");
		return mv;
	}
	@RequestMapping("/products/all")
	public @ResponseBody List<Product> productsall()
	{
		
		return productDAO.allProducts();
	}
	@RequestMapping("/getproduct/{id}")
	public ModelAndView getProduct(@PathVariable Integer id)
	{
		ModelAndView mv=new ModelAndView("masterpage");
		mv.addObject("category",categoryDAO.allCategories());
		mv.addObject("product",productDAO.get(id));
		mv.addObject("pageName","products");
		mv.addObject("subPageName","productpage");
		
		return mv;
	}
	
	
	@RequestMapping("/contactus")
	public ModelAndView contactus()
	{
		ModelAndView mv=new ModelAndView("masterpage");
		
		mv.addObject("pageName","contactus");
		return mv;
	}
	@RequestMapping("/Electronics")
	public ModelAndView electronics()
	{
		ModelAndView mv=new ModelAndView("masterpage");
		mv.addObject("category",categoryDAO.allCategories());
		mv.addObject("pageName","products");
		mv.addObject("subPageName","electronics");
		return mv;
	}
	@RequestMapping("/Articraft")
	public ModelAndView articraft()
	{
		ModelAndView mv=new ModelAndView("masterpage");
		mv.addObject("category",categoryDAO.allCategories());
		mv.addObject("pageName","products");
		mv.addObject("subPageName","articarft");
		return mv;
	}
	@RequestMapping("/Appliance")
	public ModelAndView appliances()
	{
		ModelAndView mv=new ModelAndView("masterpage");
		mv.addObject("category",categoryDAO.allCategories());
		mv.addObject("pageName","products");
		mv.addObject("subPageName","appliances");
		return mv;
	}
	@RequestMapping("/fashion")
	public ModelAndView fashion()
	{
		ModelAndView mv=new ModelAndView("masterpage");
		mv.addObject("category",categoryDAO.allCategories());
		mv.addObject("pageName","products");
		mv.addObject("subPageName","fashion");
		return mv;
	}
	@RequestMapping("/Books")
	public ModelAndView book()
	{
		ModelAndView mv=new ModelAndView("masterpage");
		mv.addObject("category",categoryDAO.allCategories());
		mv.addObject("pageName","products");
		mv.addObject("SubPageName","books");
		return mv;
	}
	@RequestMapping("/newproduct")
	public ModelAndView newproduct()
	{
		 ModelAndView mv=new ModelAndView("masterpage","product",new Product());
		 mv.addObject("pageName","newproductform");
		 return mv;
	}
	@RequestMapping("/addproduct")
	public String addprodcut(@Valid Product product,BindingResult result,ModelMap model )
	{
		if(result.hasErrors())
		{
			model.addAttribute("pageName", "newproductform");
			return "masterpage";
		}
		productDAO.addProduct(product);
		model.addAttribute("pageName", "sucess");
		return "masterpage";
	}

}
