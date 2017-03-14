package statge2.ecommerce.onlinemarketfrontend;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import statge2.ecommerce.onlinemarketbackend.dao.ProductDAO;
import statge2.ecommerce.onlinemarketbackend.dao.UsersDAO;
import statge2.ecommerce.onlinemarketbackend.dto.Cart;
import statge2.ecommerce.onlinemarketbackend.dto.Product;
import statge2.ecommerce.onlinemarketbackend.dto.Users;

@Controller
public class HomeController {
	@Autowired
	ProductDAO productDAO;
	@Autowired
	UsersDAO usersDAO;
	@Autowired
	HttpSession httpSession;

	// landing page url
	@RequestMapping({ "/", "/home", "/index" })
	public String index(Principal principal, ModelMap model,
			@RequestParam(value = "signupsuccess", required = false) String signupsuccess,
			@RequestParam(value = "order", required = false) String order) {
		// checking on signup
		if (signupsuccess != null) {
			model.addAttribute("success", true);
		}
		// checking on order
		if (order != null) {
			model.addAttribute("order", true);
		}

		// to get the user after login
		if (principal != null) {
			Users users = usersDAO.getUserNameByUserName(principal.getName());
			httpSession.setAttribute("user", users);
			httpSession.setAttribute("cart", users.getCart());
			if (users.getRole().equalsIgnoreCase("admin")) {
				return "redirect:/admin/index";
			} else {
				Cart cart = users.getCart();
				model.addAttribute("cartcount", cart.getQuantity());
				model.addAttribute("home", true);
				return "masterpage";
			}
		}
		model.addAttribute("home", true);
		return "masterpage";

	}

	// about us page
	@RequestMapping({ "/aboutus" })
	public ModelAndView aboutus() {
		System.out.println("entered aboutpage");
		ModelAndView mv = new ModelAndView("masterpage");
		mv.addObject("aboutus", true);
		return mv;
	}

	// products page
	@RequestMapping({ "/products" })
	public String products(@RequestParam(value = "added", required = false) String added, ModelMap model) {

		System.out.println("entered productpage");
		// ModelAndView mv=new ModelAndView("masterpage");
		if (added != null) {
			model.addAttribute("added", true);
			added = null;

		}
		model.addAttribute("products", true);
		return "masterpage";
	}

	// contact us page url
	@RequestMapping({ "/contactus" })
	public ModelAndView contactus() {
		System.out.println("entered cotactuspage");
		ModelAndView mv = new ModelAndView("masterpage");
		mv.addObject("contactus", true);
		return mv;
	}

	// url calling from ajax function
	@RequestMapping("/products/all")
	public @ResponseBody List<Product> productsall() {

		return productDAO.allProducts();
	}

	// login from the security
	@GetMapping("/login")
	public String login(@RequestParam(value = "error", required = false) String error, ModelMap model) {
		System.out.println(error);
		if (error != null) {
			model.addAttribute("error", "Authentication Failed - Invalid credentials!");
		}

		model.addAttribute("title", "Login");
		model.addAttribute("login", true);
		return "masterpage";
	}

	// view the product
	@RequestMapping("/getproduct/{id}")
	public String getProduct(@PathVariable Integer id, ModelMap model) {
		model.addAttribute("product", productDAO.get(id));
		model.addAttribute("productPage", true);
		return "masterpage";
	}

}
