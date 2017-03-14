package statge2.ecommerce.onlinemarketbackend.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import statge2.ecommerce.onlinemarketbackend.dao.AddressDAO;
import statge2.ecommerce.onlinemarketbackend.dao.CartDAO;
import statge2.ecommerce.onlinemarketbackend.dao.CartItemDAO;
import statge2.ecommerce.onlinemarketbackend.dao.OrderItemsDAO;
import statge2.ecommerce.onlinemarketbackend.dao.OrdersDAO;
import statge2.ecommerce.onlinemarketbackend.dao.UsersDAO;
import statge2.ecommerce.onlinemarketbackend.dto.Address;
import statge2.ecommerce.onlinemarketbackend.dto.Cart;
import statge2.ecommerce.onlinemarketbackend.dto.CartItem;
import statge2.ecommerce.onlinemarketbackend.dto.OrderItems;
import statge2.ecommerce.onlinemarketbackend.dto.Orders;
import statge2.ecommerce.onlinemarketbackend.dto.Users;

public class OrderItemsTest {
@Autowired
private static AnnotationConfigApplicationContext annotationConfigApplicationContext;
private static OrderItemsDAO orderItemsDAO;
private static OrdersDAO orderDAO;
private static CartDAO cartDAO;
private static CartItemDAO cartItemDAO;
private static UsersDAO userDAO;
private static AddressDAO addressDAO;
@BeforeClass
public static void init()
{
	 annotationConfigApplicationContext=new AnnotationConfigApplicationContext();
	 annotationConfigApplicationContext.scan("statge2.ecommerce.onlinemarketbackend");
	 annotationConfigApplicationContext.refresh();
	 orderItemsDAO=	(OrderItemsDAO) annotationConfigApplicationContext.getBean("orderItemsDAO");
	 orderDAO=	(OrdersDAO)annotationConfigApplicationContext.getBean("ordersDAO");
	 cartDAO=	(CartDAO)annotationConfigApplicationContext.getBean("cartDAO");
	 cartItemDAO=(CartItemDAO)annotationConfigApplicationContext.getBean("cartItemDAO");
	 userDAO=	(UsersDAO)annotationConfigApplicationContext.getBean("usersDAO");
	 addressDAO=	(AddressDAO)annotationConfigApplicationContext.getBean("addressDAO");
}

@Test
public void addOrderedItemTest()
{
	     Users user=userDAO.getUser(2);
	     Cart cart=user.getCart();
	     Orders order=new Orders();
	     List<Orders> orderslist=new ArrayList<>();
	   
	     
     List<Address> addresslist=addressDAO.getAddress(user);
     Address billingAddress=addresslist.get(1);
     order.setAddress(billingAddress);
	     order.setGrandTotal(cart.getGrandTotal());
	     order.setItemsQuantity(cart.getQuantity());
	     orderslist.add(order);
	     user.setOrders(orderslist);
	     order.setUsers(user);
	     //userDAO.updateUser(user);
	     
	     List<OrderItems> orderItemslist=new ArrayList<>();
	     List<CartItem> cartItemslist=cart.getCartItems();
	     for(CartItem cartItem:cartItemslist)
	     {
	    	 OrderItems orderItems=new OrderItems();
	    	 orderItems.setOrders(order);
	    	 orderItems.setProduct(cartItem.getProduct());
	    	 orderItems.setQantity(cartItem.getQuantity());
	    	 orderItems.setTotalPrice(cartItem.getGrandTotal());
	    	 //orderItemsDAO.addOrderedItem(orderItems);
	    	 orderItemslist.add(orderItems);
	     }
	     order.setOrderItems(orderItemslist);
	     
	     
	     orderDAO.addOrder(order);
	     cart.setQuantity(0);
	     cart.setGrandTotal(0);
	     cartDAO.updateCart(cart);
	     
	     
	     
	     
}
}