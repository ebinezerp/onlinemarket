package statge2.ecommerce.onlinemarketbackend.dao;

import org.springframework.stereotype.Component;

import statge2.ecommerce.onlinemarketbackend.dto.Address;

@Component
public interface AddressDAO {
	boolean addAddress(Address address);
	boolean updateAddress(Address address);
	boolean deleteAddress(int id);
	

}
