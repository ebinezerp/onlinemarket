package statge2.ecommerce.onlinemarketbackend.dao.imp;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import statge2.ecommerce.onlinemarketbackend.dao.OrdersDAO;
import statge2.ecommerce.onlinemarketbackend.dto.Orders;

@Repository("ordersDAO")
@Transactional
public class OrdersDAOImp implements OrdersDAO {
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public boolean addOrder(Orders order) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().save(order);
			return true;
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			return false;
		}

		
	}

	@Override
	public boolean deleteOrder(Orders order) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().delete(order);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			return false;
		}
		
	}

	@Override
	public boolean updateOrder(Orders order) {
		try {
			sessionFactory.getCurrentSession().update(order);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			return false;
		}

	}

}
