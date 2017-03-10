package statge2.ecommerce.onlinemarketbackend.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

@Entity
public class Users implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Size(min=6,message="minimun of 6 characters")
	private String userName;
	@Size(min=6,message="minimun of 6 characters")
	private String password;
	@Column(unique=true)
	private String email;
	@Column(unique=true)
	@Size(min=10,max=10,message="minimun of 6 characters")
	private String mobile;
	private String role;
	private boolean is_Active;
	@OneToMany(cascade=CascadeType.ALL)
	private List<Address> address=new ArrayList<>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	/**
	 * @return the address
	 */
	public List<Address> getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(List<Address> address) {
		this.address = address;
	}

	/**
	 * @return the role
	 */
	public String getRole() {
		return role;
	}

	/**
	 * @param role the role to set
	 */
	public void setRole(String role) {
		this.role = role;
	}

	/**
	 * @return the is_Active
	 */
	public boolean isIs_Active() {
		return is_Active;
	}

	/**
	 * @param is_Active the is_Active to set
	 */
	public void setIs_Active(boolean is_Active) {
		this.is_Active = is_Active;
	}

	

}
