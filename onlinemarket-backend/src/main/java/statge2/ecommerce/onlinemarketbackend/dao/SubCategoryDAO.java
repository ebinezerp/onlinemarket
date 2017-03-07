package statge2.ecommerce.onlinemarketbackend.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import statge2.ecommerce.onlinemarketbackend.dto.SubCategory;

@Component
public interface SubCategoryDAO {
	public boolean addSubcategory(SubCategory category);
	public SubCategory get(int id);
	public List<SubCategory> listAllSubCategory();

}
