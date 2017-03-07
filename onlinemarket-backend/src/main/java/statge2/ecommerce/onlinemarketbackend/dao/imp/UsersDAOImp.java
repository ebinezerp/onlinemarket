package statge2.ecommerce.onlinemarketbackend.dao.imp;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import statge2.ecommerce.onlinemarketbackend.dao.UsersDAO;
import statge2.ecommerce.onlinemarketbackend.dto.Users;
@Transactional
@Repository("usersDAO")
public class UsersDAOImp implements UsersDAO {
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public boolean addUsers(Users user) {
		try {
                sessionFactory.getCurrentSession().persist(user);
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}

	@Override
	public Users getUser(int id) {
		
		return sessionFactory.getCurrentSession().get(Users.class, Integer.valueOf(id));
	}

	@Override
	public boolean updateUser(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteUser(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}
