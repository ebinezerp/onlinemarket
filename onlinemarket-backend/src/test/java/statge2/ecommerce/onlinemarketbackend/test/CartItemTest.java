package statge2.ecommerce.onlinemarketbackend.test;


import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import statge2.ecommerce.onlinemarketbackend.dao.CartDAO;
import statge2.ecommerce.onlinemarketbackend.dao.CartItemDAO;
import statge2.ecommerce.onlinemarketbackend.dao.ProductDAO;
import statge2.ecommerce.onlinemarketbackend.dao.UsersDAO;
import statge2.ecommerce.onlinemarketbackend.dto.Cart;
import statge2.ecommerce.onlinemarketbackend.dto.CartItem;
import statge2.ecommerce.onlinemarketbackend.dto.Product;
import statge2.ecommerce.onlinemarketbackend.dto.Users;

public class CartItemTest {

	 @Autowired 
	private static AnnotationConfigApplicationContext annotationConfigApplicationContext;
	private static CartItemDAO cartItemDAO;
	private static UsersDAO usersDAO;
	private static ProductDAO productDAO;
	private static CartDAO cartDAO;
	 CartItem cartItem;
	 
	 
	@BeforeClass
	public static void init()
	{
		annotationConfigApplicationContext=new AnnotationConfigApplicationContext();
		annotationConfigApplicationContext.scan("statge2.ecommerce.onlinemarketbackend");
		annotationConfigApplicationContext.refresh();
		cartItemDAO=(CartItemDAO)annotationConfigApplicationContext.getBean("cartItemDAO");
		usersDAO=(UsersDAO)annotationConfigApplicationContext.getBean("usersDAO");
		productDAO=(ProductDAO)annotationConfigApplicationContext.getBean("productDAO");
		cartDAO=(CartDAO)annotationConfigApplicationContext.getBean("cartDAO");
	}
	
	/*@Test
	public void testAddCartItem()
	{
		   Users users=       usersDAO.getUser(2);
		 Integer userid=  users.getId();
		Product product= productDAO.get(11);
		Cart cart=users.getCart();
		cartItem=new CartItem();
		cartItem.setCart(cart);
		cartItem.setProduct(product);
		cartItem.setQuantity(1);
		cartItem.setGrandTotal(cartItem.getQuantity()*product.getProductPrice());
		//cartItemDAO.addCartItem(cartItem);
		List<CartItem> cartitems=new ArrayList<>();
		cartitems.add(cartItem);
		cart.setCartItems(cartitems);
		cart.setGrandTotal(cartItem.getGrandTotal()+cart.getGrandTotal());
		assertEquals("sucess",true,cartItemDAO.addCartItem(cartItem));
		assertEquals("sucess",true,cartDAO.updateCart(cart));
		
		
		
		 
		   
		          
	}*/
	
	
/*	@Test
	public void getAllCartItemsTest()
	{
		   Users user=usersDAO.getUser(2);
		Cart cart=   user.getCart();
	List<CartItem> cartItems=	cartItemDAO.getAll(cart.getId());
	for(CartItem cartItem:cartItems)
	{
		System.out.println(cartItem.getProduct().getProductName());
	}
	}*/
	
	/*@Test
	public void deleteCartItemTest()
	{
	 CartItem cartItem=	cartItemDAO.getCartItem(7);
	 cartItemDAO.deleteCartItem(cartItem);
	}*/
	
	/*@Test
	public void deleteAllcartItemsTest()
	{
		Users user=  usersDAO.getUser(2);
	Cart cart=	user.getCart();
	assertEquals("success",true,cartItemDAO.deleteAll(cart.getId()));
	}*/
	
	@Test
	public void addingExsitItem()
	{
		Users user=usersDAO.getUser(2);
	Cart cart=	user.getCart();
	    int cartid=cart.getId();
	 Product product=productDAO.get(3);
	 int productId=product.getProductId();
	 CartItem cartItem=cartItemDAO.getExistingCartItemCount(productId, cartid);
	 System.out.println("cartItem object::::::::::::::::::::::"+cartItem);
	 if(cartItem!=null)
	 {
		 System.out.println("cartItem qantity:::"+cartItem.getQuantity());
		 cartItem.setQuantity(cartItem.getQuantity()+1);
		 System.out.println("after setting"+cartItem.getQuantity());
		 cartItem.setGrandTotal(cartItem.getGrandTotal()+product.getProductPrice());
		 cartItemDAO.updateCartItem(cartItem);
	 }else
	 {
		 cartItem=new CartItem();
		 cartItem.setCart(cart);
		 cartItem.setQuantity(1);
		 cartItem.setProduct(product);
		 cartItem.setGrandTotal(product.getProductPrice());
		 cartItemDAO.addCartItem(cartItem);
		 cart.setGrandTotal(cartItem.getGrandTotal()+product.getProductPrice());
		 cartDAO.updateCart(cart);
	 }
	
	}

}
