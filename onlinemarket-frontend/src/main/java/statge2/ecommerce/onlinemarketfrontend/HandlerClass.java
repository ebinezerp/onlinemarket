package statge2.ecommerce.onlinemarketfrontend;



import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import statge2.ecommerce.onlinemarketbackend.dao.UsersDAO;
import statge2.ecommerce.onlinemarketbackend.dto.Address;
import statge2.ecommerce.onlinemarketbackend.dto.Users;

@Component
public class HandlerClass {
	Users users;
	Address userAddress;
	Address billingAddress;
	@Autowired
	UsersDAO usersDAO;
	/**
	 * @return the users
	 */
	public Users getUsers() {
		return users;
	}

	/**
	 * @param users the users to set
	 */
	public void setUsers(Users users) {
		this.users = users;
	}

	/**
	 * @return the userAddress
	 */
	public Address getUserAddress() {
		return userAddress;
	}

	/**
	 * @param userAddress the userAddress to set
	 */
	public void setUserAddress(Address userAddress) {
		this.userAddress = userAddress;
	}

	/**
	 * @return the billingAddress
	 */
	public Address getBillingAddress() {
		return billingAddress;
	}

	/**
	 * @param billingAddress the billingAddress to set
	 */
	public void setBillingAddress(Address billingAddress) {
		this.billingAddress = billingAddress;
	}

	HandlerClass()
	{
		System.out.println("hello handlercontroller");
		users=new Users();
		userAddress=new Address();
		billingAddress=new Address();
	}

	/**
	 * @return the user
	 */
	public Users getUser() {
		System.out.println("usser object is returning"+users);
		return users;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(Users user) {
		this.users = users;
	}

	/**
	 * @return the address
	 */

	
	public String validateUser(@Valid Users users,BindingResult result)
	{
		System.out.println(result.hasErrors());
		return "failure";
	    	
	}
	public String store(Users users,Address address)
	{
		System.out.println(users.isIs_Active());
		List<Address> list=new ArrayList<Address>();
		address.setUser(users);
		list.add(address);
		users.setAddress(list);
	 boolean result=	usersDAO.addUsers(users);
	 if(result)
	 {
		 return "success";
	 }
	 else{
		 return "failure";
	 }
	}
}
