package statge2.ecommerce.onlinemarketbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import statge2.ecommerce.onlinemarketbackend.dao.UsersDAO;
import statge2.ecommerce.onlinemarketbackend.dto.Users;

public class UsersTest {
	private static AnnotationConfigApplicationContext annotationConfigApplicationContext;
	private static UsersDAO usersDAO;
	Users users;
	
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
		users=new Users();
		users.setUserName("ebinezer");
		users.setPassword("adminpassword");
		users.setEmail("ebinezerp@rocketmail.com");
		users.setMobile("9494216610");
		assertEquals("sucess",true,usersDAO.addUsers(users));
	}

	
	/*@Test
	public void getUserTest()
	{
	users=usersDAO.getUser(0);
	System.out.println(users.getUserName());
	assertEquals("success","admin",users.getUserName());
		
	}*/
	
}
