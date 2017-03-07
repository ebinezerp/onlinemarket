package statge2.ecommerce.onlinemarketbackend.test;

import static org.junit.Assert.assertEquals;

import java.util.Map;
import java.util.TreeMap;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import statge2.ecommerce.onlinemarketbackend.dao.ProductDAO;
import statge2.ecommerce.onlinemarketbackend.dto.Product;

public class ProductTest {
	private static AnnotationConfigApplicationContext annotationConfigApplicationContext;
	private static ProductDAO productDAO;
	Product product;
	@BeforeClass
	public static void init()
	{
		annotationConfigApplicationContext=new AnnotationConfigApplicationContext();
		annotationConfigApplicationContext.scan("statge2.ecommerce.onlinemarketbackend");
		annotationConfigApplicationContext.refresh();
		productDAO=(ProductDAO)annotationConfigApplicationContext.getBean("productDAO");
	}
	/*@Test
	public void addProductTest()
	{
		product=new Product();
		product.setProductName("LYF");
		product.setProductPrice(11000.00f);
		product.setStatus(true);
		product.setUrl("3.jpg");
		Map<String,String> productDetails=new TreeMap<String,String>();
		productDetails.put("warenty","1");
		//product.setProductDetails(productDetails);
		assertEquals("sucess",true,productDAO.addProduct(product));
	}
*/
	
	
	@Test
	public void updateProductTest()
	{
		Product product=productDAO.get(1);
		product.setProductName("ebinezer");
		assertEquals("sucess",true,productDAO.update(product));
	}
}
