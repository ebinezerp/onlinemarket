package statge2.ecommerce.onlinemarketfrontend;

import java.io.Serializable;
import java.security.Principal;

import statge2.ecommerce.onlinemarketbackend.dto.Cart;
import statge2.ecommerce.onlinemarketbackend.dto.Users;

public class CheckoutModel implements  Serializable {
	
	Cart cart;
	public Cart getCart(Principal principal) {
		
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	public Users getUser() {
		return User;
	}
	public void setUser(Users user) {
		User = user;
	}
	Users User;
	

}
