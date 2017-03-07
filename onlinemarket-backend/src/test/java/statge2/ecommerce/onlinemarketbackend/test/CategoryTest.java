package statge2.ecommerce.onlinemarketbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import statge2.ecommerce.onlinemarketbackend.dao.CategoryDAO;
import statge2.ecommerce.onlinemarketbackend.dto.Category;

public class CategoryTest {
	private static AnnotationConfigApplicationContext annotationConfigApplicationContext;
	private static CategoryDAO categoryDAO;
	
	private Category category;
	/*private static SubCategoryDAO subCategoryDAO;
	private SubCategory subCategory;
*/
	@BeforeClass
	public static void init() {
		annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
		annotationConfigApplicationContext.scan("statge2.ecommerce.onlinemarketbackend");
		annotationConfigApplicationContext.refresh();
		categoryDAO = (CategoryDAO) annotationConfigApplicationContext.getBean("categoryDAO");
		/*subCategoryDAO = (SubCategoryDAO) annotationConfigApplicationContext.getBean("subCategoryDAO");*/

	}

@Test
	public void testAddCategory() {
	

	category=new Category();
	category.setCategoryName("Books");
	assertEquals("sucess",true,categoryDAO.newCategory(category));
		
	}
	/*@Test
	public void getCategory()
	{
		System.out.println(categoryDAO.getCategory(1).getCategoryName());
		assertEquals("sucess",true,categoryDAO.getCategory(1));
	}*/

}
