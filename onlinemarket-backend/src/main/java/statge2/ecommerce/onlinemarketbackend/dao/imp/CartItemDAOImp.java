package statge2.ecommerce.onlinemarketbackend.dao.imp;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import statge2.ecommerce.onlinemarketbackend.dao.CartItemDAO;
import statge2.ecommerce.onlinemarketbackend.dto.CartItem;
@Repository("cartItemDAO")
@Transactional
public class CartItemDAOImp implements CartItemDAO{
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public boolean addCartItem(CartItem cartItem) {
		try{
		sessionFactory.getCurrentSession().save(cartItem);
		return true;
		}
		catch (Exception e) {
			// TODO: handle exceptionm
			System.out.println(e);
			return false;
		}
		
	}

	@Override
	public List<CartItem> getAll(int id) {
		return sessionFactory.getCurrentSession().createQuery("FROM CartItem where CART_ID=:id", CartItem.class).setParameter("id", id).getResultList();
		
	}

	@Override
	public boolean deleteCartItem(CartItem cartItem) {
		  
		try{
			sessionFactory.getCurrentSession().delete(cartItem);
			return true;
			
		}catch(Exception e)
		{
			System.out.println(e);
			return false;
		}
	}

	@Override
	public CartItem getCartItem(int id) {
		// TODO Auto-generated method stub
		
		return sessionFactory.getCurrentSession().get(CartItem.class, id);
	}

	@Override
	public boolean deleteAll(int cart_id) {
		try{
		// TODO Auto-generated method stub
		Query q=sessionFactory.getCurrentSession().createQuery("delete from CartItem where cart_id=:id");
		q.setParameter("id", cart_id);
		q.executeUpdate();
		return true;
		}catch(Exception e){
			System.out.println(e);
		return false;
		}
	}

	@Override
	public CartItem getExistingCartItemCount(int productId, int cart_id) {
		Query q=sessionFactory.getCurrentSession().createQuery("from CartItem where cart_id=:cartid and product_productId=:productid");
		q.setParameter("cartid", cart_id);
		q.setParameter("productid", productId);
		
		try{
		
		return (CartItem) q.getSingleResult();
		}catch(NoResultException nre)
		{
			return null;
		}
		
	}

	@Override
	public boolean updateCartItem(CartItem cartItem) {
		try {
			sessionFactory.getCurrentSession().update(cartItem);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			return false;
		}
		
	}

	

}
