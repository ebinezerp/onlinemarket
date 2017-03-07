package statge2.ecommerce.onlinemarketbackend.dao.imp;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import statge2.ecommerce.onlinemarketbackend.dao.CategoryDAO;
import statge2.ecommerce.onlinemarketbackend.dto.Category;
import statge2.ecommerce.onlinemarketbackend.dto.SubCategory;

@Transactional
@Repository("categoryDAO")
public class CategoryDAOImp implements CategoryDAO {
	
	@Autowired
	SessionFactory sessionFactory;

	@Override
	
	public boolean newCategory(Category category) {
		// TODO Auto-generated method stub
		System.out.println("entered into new category");
		Session s=sessionFactory.openSession();
	Transaction t=s.beginTransaction();
		s.save(category);
		t.commit();
			
		return true;
	}

	@Override
	public List<Category> allCategories() {
		// TODO Auto-generated method stub
		 System.out.println("entered in all categories");
		return sessionFactory.getCurrentSession().createQuery("FROM Category").getResultList();
	}
	
	@Override
	@Transactional
	public boolean deleteCategory(int id) {
		
		System.out.println("testing");
		try{
		 Query q= sessionFactory.getCurrentSession().createQuery("DELETE Category WHERE id = :ID");
		 q.setParameter("ID", id);
		 q.executeUpdate();
	 System.out.println("category deleted");
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	 return true;
		 
	}
	@Override
	public boolean updateCategory(Category category) {
		// TODO Auto-generated method stub
		try{
			sessionFactory.getCurrentSession().update(category);
			
		return true;
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			return false;
		}
		
		
		
		
	}

	@Override
	public Category getCategory(int id) {
		// TODO Auto-generatedmethod stub
		System.out.println("category");
		try{
		return sessionFactory.getCurrentSession().get(Category.class,Integer.valueOf(id));
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			return null;
		}
		
	}

}
