package statge2.ecommerce.onlinemarketfrontend;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import statge2.ecommerce.onlinemarketbackend.dao.UsersDAO;
import statge2.ecommerce.onlinemarketbackend.dto.Address;
import statge2.ecommerce.onlinemarketbackend.dto.Users;

@Component
class HandlerClass 
{
	@Autowired
	UsersDAO usersDAO;
	
	public RegisterModel initFlow()
	{
		return new RegisterModel();
	}
	
	
	public void bindingUser(RegisterModel registerModel,Users users)
	{
		registerModel.setUsers(users);
	}
	public void bindingUserAddresss(RegisterModel registerModel,Address address)
	{
		registerModel.setUserAddress(address);
	}
	public void bindingBillingAddress(RegisterModel registerModel,Address address)
	{
		registerModel.setBillingAddress(address);
	}
	
	public String saveUser(RegisterModel registerModel)
	{
		Users users=registerModel.getUsers();
		Address userAddress=registerModel.getUserAddress();
		Address billingAddress=registerModel.getBillingAddress();
		billingAddress.setUser(users);
		userAddress.setUser(users);
		List<Address> addresslist=new ArrayList<Address>();
		addresslist.add(userAddress);
		addresslist.add(billingAddress);
		users.setAddress(addresslist);
		try{
		usersDAO.addUsers(users);
		return "success";
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			return "failure";
		}
	}
}

