package statge2.ecommerce.onlinemarketfrontend;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import statge2.ecommerce.onlinemarketbackend.dao.CartDAO;
import statge2.ecommerce.onlinemarketbackend.dao.CartItemDAO;
import statge2.ecommerce.onlinemarketbackend.dao.ProductDAO;
import statge2.ecommerce.onlinemarketbackend.dao.UsersDAO;
import statge2.ecommerce.onlinemarketbackend.dto.Cart;
import statge2.ecommerce.onlinemarketbackend.dto.CartItem;
import statge2.ecommerce.onlinemarketbackend.dto.Product;
import statge2.ecommerce.onlinemarketbackend.dto.Users;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	UsersDAO usersDAO;
	@Autowired
	CartItemDAO cartItemDAO;
	@Autowired
	ProductDAO productDAO;
	@Autowired
	CartDAO cartDAO;
	@Autowired
	HttpSession httpSession;
	
	
	@RequestMapping("/add/{id}/addcart")
	public String addToCart(Principal principal,@PathVariable Integer id,ModelMap model)
	{
	    if(principal!=null)
	    {
	     Users user= usersDAO.getUserNameByUserName(principal.getName());
	     
	  Cart cart=user.getCart();
	  Product product=productDAO.get(id);
	  CartItem cartItem=cartItemDAO.getExistingCartItemCount(id, cart.getId());
	  System.out.println("cartItem:::::::::::::::::::::::::::::"+cartItem);
	  if(cartItem!=null)
	  {
		  System.out.println(cartItem);
		  cartItem.setQuantity(cartItem.getQuantity()+1);
		  System.out.println("cartItems count:::::::::::::::::"+cartItem.getQuantity());
		  cartItem.setGrandTotal(cartItem.getGrandTotal()+product.getProductPrice());
		  
		  cart.setQuantity(cart.getQuantity()+1);
		  cart.setGrandTotal(cart.getGrandTotal()+product.getProductPrice());
		  
		  cartDAO.updateCart(cart);
		  cartItemDAO.updateCartItem(cartItem);
		  model.addAttribute("cartcount",cart.getQuantity());
		  
	  }else
	  {
		  cartItem=new CartItem();
		  cartItem.setQuantity(1);
		  cartItem.setGrandTotal(product.getProductPrice());
		  cartItem.setCart(cart);
		  cartItem.setProduct(product);
		  cartItemDAO.addCartItem(cartItem);
		  cart.setQuantity(cart.getQuantity()+1);
		  cart.setGrandTotal(cart.getGrandTotal()+product.getProductPrice());
		  cartDAO.updateCart(cart);
		  model.addAttribute("cartcount",cart.getQuantity());
	  }
	  Users user1=usersDAO.getUserNameByUserName(principal.getName());
	  httpSession.setAttribute("cart", user1.getCart());
	      
	    }
	   
		return "redirect:/products?added";
	}
	
	@RequestMapping("/cart")
	public String customerCart(Principal principal,ModelMap model)
	{
		if(principal!=null)
		{
			Users user=	usersDAO.getUserNameByUserName(principal.getName());
			Cart cart=user.getCart();
			model.addAttribute("cartdetails",true);
			model.addAttribute("cartItems", cartItemDAO.getAll(cart.getId()));
			model.addAttribute("cartcount",cart.getQuantity());
			
		}
		return "masterpage";
	}
	//deleting cart items
	@RequestMapping("/delete/{id}/cartItem")
	public String delectCartItem(@PathVariable Integer id,ModelMap model,Principal principal)
	
	{
		if(principal!=null)
		{
		CartItem cartItem=	cartItemDAO.getCartItem(id);
		
		
		  Users user=usersDAO.getUserNameByUserName(principal.getName());
		 Cart cart= user.getCart();
		 cart.setQuantity(cart.getQuantity()-cartItem.getQuantity());
		 cart.setGrandTotal(cart.getGrandTotal()-cartItem.getGrandTotal());
		 System.out.println();
		 cart.setId(cartItem.getCart().getId());
		 user.setCart(cart);
		 
		 System.out.println("deleting cart item");
		 cartDAO.updateCart(cart);
		 cartItemDAO.deleteCartItem(cartItem);
		 //usersDAO.updateUser(user);
		  model.addAttribute("cartItem", user.getCart().getQuantity());
		  
		}
	
		
		return "redirect:/customer/cart";
	}
	
	
	@RequestMapping("cart/deleteall")
	public String detleteAllCartItems(Principal principal)
	{
		if(principal!=null)
		{
			Users user=usersDAO.getUserNameByUserName(principal.getName());
		Cart cart=	user.getCart();
		
		cart.setQuantity(0);
		cart.setGrandTotal(0);
		cartDAO.updateCart(cart);
		cartItemDAO.deleteAll(cart.getId());
		return "redirect:/";
				
			
		}
		
		return "masterpage";
		
	}
	
	

}
