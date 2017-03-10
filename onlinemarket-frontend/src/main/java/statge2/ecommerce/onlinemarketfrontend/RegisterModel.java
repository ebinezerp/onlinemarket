package statge2.ecommerce.onlinemarketfrontend;

import java.io.Serializable;

import org.springframework.stereotype.Component;

import statge2.ecommerce.onlinemarketbackend.dto.Address;
import statge2.ecommerce.onlinemarketbackend.dto.Users;

@Component
public class RegisterModel implements Serializable {
	Users users;
	Address billingAddress;
	Address userAddress;

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public Address getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(Address billingAddress) {
		this.billingAddress = billingAddress;
	}

	public Address getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(Address userAddress) {
		this.userAddress = userAddress;
	}

}
