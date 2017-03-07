package statge2.ecommerce.onlinemarketbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import statge2.ecommerce.onlinemarketbackend.dao.CategoryDAO;
import statge2.ecommerce.onlinemarketbackend.dao.SubCategoryDAO;
import statge2.ecommerce.onlinemarketbackend.dao.imp.CategoryDAOImp;
import statge2.ecommerce.onlinemarketbackend.dto.SubCategory;

public class SubCategoryTest {
	private static SubCategoryDAO subCategoryDAO;
	private static AnnotationConfigApplicationContext annotationConfigApplicationContext;
	private static CategoryDAO categoryDAO;
	SubCategory subCategory;
 @BeforeClass
 public static void init()
 {
	 annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
	 annotationConfigApplicationContext.scan("statge2.ecommerce.onlinemarketbackend");
	 annotationConfigApplicationContext.refresh();
	subCategoryDAO=(SubCategoryDAO) annotationConfigApplicationContext.getBean("subCategoryDAO");
	categoryDAO = (CategoryDAO) annotationConfigApplicationContext.getBean("categoryDAO");
	
 }
 @Test
public void testSubCategoryAdd()
{
subCategory=new SubCategory();
subCategory.setCategory(categoryDAO.getCategory(1));
subCategory.setSubCategoryName("Laptops");
assertEquals("sucess",true,subCategoryDAO.addSubcategory(subCategory));
}
}
