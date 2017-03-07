package statge2.ecommerce.onlinemarketbackend.test;





import static org.junit.Assert.assertEquals;

import org.hibernate.SessionFactory;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import statge2.ecommerce.onlinemarketbackend.dao.CategoryDAO;
import statge2.ecommerce.onlinemarketbackend.dto.Category;

public class DeleteCategory {
	private static CategoryDAO categoryDAO;
	private static SessionFactory sessionFactory;
	private Category category;
	
	@BeforeClass
    public static void init()
    {
		 AnnotationConfigApplicationContext annotationConfigApplicationContext= new AnnotationConfigApplicationContext();
		 annotationConfigApplicationContext.scan("statge2.ecommerce.onlinemarketbackend");
		 annotationConfigApplicationContext.refresh();
		categoryDAO =(CategoryDAO) annotationConfigApplicationContext.getBean("categoryDAO");
    }
	
	 @Test
	 public void deleteCategoryTest()
	 {
		
		 assertEquals("sucess",true,categoryDAO.deleteCategory(6));
	 }

}
