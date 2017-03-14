package statge2.ecommerce.onlinemarketbackend.dao.imp;

import javax.persistence.Query;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import statge2.ecommerce.onlinemarketbackend.dao.CartDAO;
import statge2.ecommerce.onlinemarketbackend.dto.Cart;
@Repository("cartDAO")
@Transactional
public class CartDAOImp implements CartDAO {
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public boolean addCart(Cart cart) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateCart(Cart cart) {
		
		try{
		System.out.println("cart id in update cart :::::::::::"+cart.getId());
		sessionFactory.getCurrentSession().update(cart);
		}catch(Exception e)
		{
			
		}
		return false;
	}

	@Override
	public boolean resetCart(int id) {
		// TODO Auto-generated method stub
		System.out.println("cart id"+id);
	Query q=	sessionFactory.getCurrentSession().createQuery("update Cart set grandTotal=:total, quantity=:quan where id=:id ");
	q.setParameter("total", 0.0f);
	q.setParameter("quan", 0);
	q.setParameter("id", id);
 int i=	q.executeUpdate();
 System.out.println("updated cart i value:::::::::::::::::"+i);
		return false;
	}
	

}
