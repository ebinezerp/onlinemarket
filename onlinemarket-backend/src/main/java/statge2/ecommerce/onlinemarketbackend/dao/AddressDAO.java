package statge2.ecommerce.onlinemarketbackend.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import statge2.ecommerce.onlinemarketbackend.dto.Address;
import statge2.ecommerce.onlinemarketbackend.dto.Users;

@Component
public interface AddressDAO {
	boolean addAddress(Address address);
	boolean updateAddress(Address address);
	boolean deleteAddress(int id);
	public List<Address> getAddress(Users user);
	

}
