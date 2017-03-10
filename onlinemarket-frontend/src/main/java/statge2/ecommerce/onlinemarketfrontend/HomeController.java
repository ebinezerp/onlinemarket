package statge2.ecommerce.onlinemarketfrontend;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import statge2.ecommerce.onlinemarketbackend.dao.ProductDAO;
import statge2.ecommerce.onlinemarketbackend.dao.UsersDAO;
import statge2.ecommerce.onlinemarketbackend.dto.Product;
import statge2.ecommerce.onlinemarketbackend.dto.Users;
@Controller
public class HomeController
{
	@Autowired
	ProductDAO productDAO;
	@Autowired
	UsersDAO usersDAO;
	@RequestMapping({"/","/home","/index"})
	public String index(Principal principal,ModelMap model)
	{
		if(principal!=null)
		{
		 Users users= usersDAO.getUserNameByUserName(principal.getName());
		 if(users.getRole().equalsIgnoreCase("admin"))
		 {
		 return "redirect:/admin/index";
		 }else
		 {
			 model.addAttribute("home",true);
				return "masterpage";
		 }
		}
		model.addAttribute("home",true);
		return "masterpage";
		
		
		
	}
	@RequestMapping({"/aboutus"})
	public ModelAndView aboutus()
	{
		System.out.println("entered aboutpage");
		ModelAndView mv=new ModelAndView("masterpage");
		mv.addObject("aboutus", true);
		return mv;
	}
	@RequestMapping({"/products"})
	public ModelAndView products()
	{
		System.out.println("entered productpage");
		ModelAndView mv=new ModelAndView("masterpage");
		mv.addObject("products", true);
		return mv;
	}
	@RequestMapping({"/contactus"})
	public ModelAndView contactus()
	{
		System.out.println("entered cotactuspage");
		ModelAndView mv=new ModelAndView("masterpage");
		mv.addObject("contactus", true);
		return mv;
	}
	
	@RequestMapping("/products/all")
	public @ResponseBody List<Product> productsall()
	{
		
		return productDAO.allProducts();
	}
	@GetMapping("/login")
	public String login(@RequestParam(value = "error", required = false)String error, ModelMap model)
	{
		System.out.println(error);
		if(error!=null) {
			model.addAttribute("error","Authentication Failed - Invalid credentials!");
			}
			 
			model.addAttribute("title", "Login");
			model.addAttribute("login", true);
			return "masterpage";
	}
	
	
}
