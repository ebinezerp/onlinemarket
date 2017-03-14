package statge2.ecommerce.onlinemarketbackend.test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import statge2.ecommerce.onlinemarketbackend.dao.UsersDAO;
import statge2.ecommerce.onlinemarketbackend.dto.Address;
import statge2.ecommerce.onlinemarketbackend.dto.Users;

public class UsersTest {
	private static AnnotationConfigApplicationContext annotationConfigApplicationContext;
	private static UsersDAO usersDAO;
	Users users;
	Address address;
	
	@BeforeClass
	public static void init()
	{
		annotationConfigApplicationContext=new AnnotationConfigApplicationContext();
		annotationConfigApplicationContext.scan("statge2.ecommerce.onlinemarketbackend");
		annotationConfigApplicationContext.refresh();
		usersDAO=(UsersDAO)annotationConfigApplicationContext.getBean("usersDAO");
	}
	@Test
	public void testAddUser()
	{
		try{
			users=new Users();
			users.setUserName("ebinezer");
			users.setEmail("ebinezer.p87@gmail.com");
			users.setMobile("9494216610");
			users.setPassword("9494216610");
			users.setRole("customer");
			users.setIs_Active(true);
			List<Address> addresslist=new ArrayList<Address>();
		    address=new Address();
		    address.setHouseNo("87");
		    address.setStreet("ameerpet");
		    address.setCity("hyd");
		    address.setState("telangana");
		    address.setCountry("india");
		    address.setPin("5000038");
		    address.setUsers(users);
		   Address address1=new Address();
		    address1.setHouseNo("100");
		    address1.setStreet("shareen");
		    address1.setCity("kurnool");
		    address1.setState("Andhra pradesh");
		    address1.setCountry("india");
		    address1.setPin("518401");
		    address1.setUsers(users);
		    addresslist.add(address);
			addresslist.add(address1);
			users.setAddress(addresslist);
			assertEquals("sucess", true,usersDAO.addUsers(users));
		}catch(Exception e)
		{
		System.out.println(e);
		e.printStackTrace();
			
		}
		
		
	}

	
	/*@Test
	public void getUserTest()
	{
	users=usersDAO.getUser(0);
	System.out.println(users.getUserName());
	assertEquals("success","admin",users.getUserName());
		
	}*/
	
}
