package statge2.ecommerce.onlinemarketbackend.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

@Entity
public class Category {
	/*private fields*/
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Size(min=4,message="Min character 5")
	private String categoryName;
	/*@OneToMany
	private Collection<SubCategory> subCategory=new  ArrayList<SubCategory>();
	*/
	/*public Collection<SubCategory> getSubCategory() {
		return subCategory;
	}
	public void setSubCategory(Collection<SubCategory> subCategory) {
		this.subCategory = subCategory;
	}*/
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
 

}
