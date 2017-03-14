package statge2.ecommerce.onlinemarketbackend.dao.imp;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import statge2.ecommerce.onlinemarketbackend.dao.OrderItemsDAO;
import statge2.ecommerce.onlinemarketbackend.dto.OrderItems;
@Repository("orderItemsDAO")
@Transactional
public class OrderItemsDAOImp implements OrderItemsDAO {
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public boolean addOrderedItem(OrderItems orderItems) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().persist(orderItems);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			return false;
		}
		
	}

}
