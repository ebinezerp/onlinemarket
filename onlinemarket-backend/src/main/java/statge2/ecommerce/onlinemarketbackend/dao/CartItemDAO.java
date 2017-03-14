package statge2.ecommerce.onlinemarketbackend.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import statge2.ecommerce.onlinemarketbackend.dto.Cart;
import statge2.ecommerce.onlinemarketbackend.dto.CartItem;

@Component
public interface CartItemDAO {
	public boolean addCartItem(CartItem cartItem);
	public List<CartItem> getAll(int id);
    public boolean deleteCartItem(CartItem cartItem);
    public CartItem getCartItem(int id);
    public boolean deleteAll(int cart_id);
    public CartItem getExistingCartItemCount(int productId,int cart_id);
    public boolean updateCartItem(CartItem cartItem);
}
