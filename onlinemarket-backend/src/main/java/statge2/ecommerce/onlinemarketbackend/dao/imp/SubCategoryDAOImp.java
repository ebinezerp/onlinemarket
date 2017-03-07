package statge2.ecommerce.onlinemarketbackend.dao.imp;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import statge2.ecommerce.onlinemarketbackend.dao.SubCategoryDAO;
import statge2.ecommerce.onlinemarketbackend.dto.SubCategory;
@Transactional
@Repository("subCategoryDAO")
public class SubCategoryDAOImp implements SubCategoryDAO {
 @Autowired
	SessionFactory sessionFactory;

 @Override
	public boolean addSubcategory(SubCategory subcategory) {
	 System.out.println("entered sub category");
		sessionFactory.getCurrentSession().persist(subcategory);
		return true;
	}

	@Override
	public SubCategory get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SubCategory> listAllSubCategory() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
