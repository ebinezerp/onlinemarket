package statge2.ecommerce.onlinemarketbackend.dao.imp;



import javax.persistence.Query;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import statge2.ecommerce.onlinemarketbackend.dao.AddressDAO;
import statge2.ecommerce.onlinemarketbackend.dto.Address;

public class AdressDAOImp implements AddressDAO {
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public boolean addAddress(Address address) {
		try {
			sessionFactory.getCurrentSession().persist(address);
			return true;
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
			return false;
		}

	}

	@Override
	public boolean updateAddress(Address address) 
	{
		try {
			sessionFactory.getCurrentSession().update(address);
			return true;
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean deleteAddress(int id) {
		try{
			Query q=sessionFactory.getCurrentSession().createQuery("DELETE Address where id=:ID");
			q.setParameter("ID", id);
			q.executeUpdate();
			
			
			return true;
			}catch(Exception e){
				System.out.println(e);
				e.printStackTrace();
				return false;
			}
	}

}
