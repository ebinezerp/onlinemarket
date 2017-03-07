package statge2.ecommerce.onlinemarketbackend.dao;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.stereotype.Component;

import statge2.ecommerce.onlinemarketbackend.dto.Product;
@Component
public interface ProductDAO {
	 public boolean addProduct(Product product);
	 public List<Product> allProducts();
	 public Product get(int id);
	 public boolean update(Product product);
	 public boolean delete(int id);
	 
}
