package statge2.ecommerce.onlinemarketfrontend;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import statge2.ecommerce.onlinemarketbackend.dao.AddressDAO;
import statge2.ecommerce.onlinemarketbackend.dao.CartDAO;
import statge2.ecommerce.onlinemarketbackend.dao.CartItemDAO;
import statge2.ecommerce.onlinemarketbackend.dao.OrderItemsDAO;
import statge2.ecommerce.onlinemarketbackend.dao.OrdersDAO;
import statge2.ecommerce.onlinemarketbackend.dao.ProductDAO;
import statge2.ecommerce.onlinemarketbackend.dao.UsersDAO;
import statge2.ecommerce.onlinemarketbackend.dto.Address;
import statge2.ecommerce.onlinemarketbackend.dto.Cart;
import statge2.ecommerce.onlinemarketbackend.dto.CartItem;
import statge2.ecommerce.onlinemarketbackend.dto.OrderItems;
import statge2.ecommerce.onlinemarketbackend.dto.Orders;
import statge2.ecommerce.onlinemarketbackend.dto.Product;
import statge2.ecommerce.onlinemarketbackend.dto.Users;

@Component
public class HandlerCheckout {
	@Autowired
	UsersDAO usersDAO;
	@Autowired
	HttpSession httpSession;
	@Autowired
	AddressDAO addressDAO;
	@Autowired
	OrdersDAO ordersDAO;
	@Autowired
	OrderItemsDAO orderItemsDAO;
	@Autowired
	CartDAO cartDAO;
	@Autowired
	CartItemDAO cartItemDAO;
	@Autowired
	ProductDAO productDAO;
	List<Address> addresses;

	public Cart initFlow() {

		Cart cart = null;
		try {
			cart = (Cart) httpSession.getAttribute("cart");

		} catch (Exception e) {
			System.out.println(e);
		}
		// System.out.println("cart quantity at checkout
		// time"+cart.getQuantity());
		return cart;
	}

	public Address getUserAddress(Users user) {
		// getting user address
		addresses = addressDAO.getAddress(user);
		return addresses.get(0);

	}

	// updating user address
	public String updateUserAddress(Address useraddress) {
		try {
			addressDAO.updateAddress(useraddress);
			return "success";
		} catch (Exception e) {
			// TODO: handle exception
			return "failure";
		}

	}

	// getting billing address
	public Address getBillingAddress() {
		return addresses.get(1);
	}

	// placing order
	public String placeOrder(Users users, Address billingAddress) {
		// gettin cart form user
		Cart cart = users.getCart();
		// creating new order for every new order
		Orders order = new Orders();

		// ordered list
		List<Orders> orderslist = new ArrayList<>();
		// setting all details to order
		order.setAddress(billingAddress);
		order.setGrandTotal(cart.getGrandTotal());
		order.setItemsQuantity(cart.getQuantity());
		order.setUsers(users); // setting user to order
		// creating new order items for a order
		List<OrderItems> orderItemslist = new ArrayList<>();
		List<CartItem> cartItemslist = cart.getCartItems();
		for (CartItem cartItem : cartItemslist) {
			OrderItems orderItems = new OrderItems();
			orderItems.setOrders(order);
			orderItems.setProduct(cartItem.getProduct());
			Product product = cartItem.getProduct();
			product.setQuantity(product.getQuantity() - cartItem.getQuantity());
			productDAO.update(product);
			orderItems.setQantity(cartItem.getQuantity());
			orderItems.setTotalPrice(cartItem.getGrandTotal());
			orderItemslist.add(orderItems);

		}
		order.setOrderItems(orderItemslist);
		orderslist.add(order);
		users.setOrders(orderslist);
		ordersDAO.addOrder(order);
		cartItemDAO.deleteAll(cart.getId());
		cartDAO.resetCart(cart.getId());

		return "success";
	}
}
