package statge2.ecommerce.onlinemarketbackend.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import statge2.ecommerce.onlinemarketbackend.dto.Category;
import statge2.ecommerce.onlinemarketbackend.dto.SubCategory;
@Component
public interface CategoryDAO {
	public boolean newCategory(Category category);
	public Category getCategory(int id);
	public List<Category> allCategories();
	public  boolean deleteCategory(int id);
	public boolean updateCategory(Category category);

}
