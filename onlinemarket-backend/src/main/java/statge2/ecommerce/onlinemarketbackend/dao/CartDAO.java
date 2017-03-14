package statge2.ecommerce.onlinemarketbackend.dao;

import org.springframework.stereotype.Component;

import statge2.ecommerce.onlinemarketbackend.dto.Cart;

@Component
public interface CartDAO {
	public boolean addCart(Cart cart);
	public boolean updateCart(Cart cart);
	public boolean resetCart(int id);
	
	

}
