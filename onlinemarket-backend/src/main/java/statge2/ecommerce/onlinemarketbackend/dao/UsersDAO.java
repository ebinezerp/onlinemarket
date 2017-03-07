package statge2.ecommerce.onlinemarketbackend.dao;

import org.springframework.stereotype.Component;

import statge2.ecommerce.onlinemarketbackend.dto.Users;

@Component
public interface UsersDAO {
	public boolean addUsers(Users user);
	public Users getUser(int id);
	public boolean updateUser(int id);
	public boolean deleteUser(int id);
	

}
